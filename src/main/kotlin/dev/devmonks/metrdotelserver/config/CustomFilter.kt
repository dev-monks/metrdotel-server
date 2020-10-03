package dev.devmonks.metrdotelserver.config

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono
import java.util.*

@Component
class CustomFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request
        val authorization = Objects.requireNonNull(request.headers["Authorization"])!![0]
        val token = resolveToken(authorization)
        return try {
            FirebaseAuth.getInstance().verifyIdToken(token)
            chain.filter(exchange)
        } catch (error: FirebaseAuthException) {
            val response: ServerHttpResponse = exchange.response
            response.statusCode = HttpStatus.UNAUTHORIZED
            response.setComplete()
        }
    }

    private fun resolveToken(authHeader: String?): String {
        return if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader.substring(7).trim { it <= ' ' }
        } else ""
    }
}
