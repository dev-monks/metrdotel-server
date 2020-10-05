package dev.devmonks.metrdotelserver.service.shared

import com.google.firebase.auth.FirebaseAuth
import org.springframework.stereotype.Service

@Service
class FirebaseService {
    fun getUserId(authHeader: String): String? {
        val token = this.resolveToken(authHeader)
        return FirebaseAuth.getInstance().verifyIdToken(token).uid
    }

    private fun resolveToken(authHeader: String?): String {
        return if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader.substring(7).trim { it <= ' ' }
        } else ""
    }
}