package dev.devmonks.metrdotelserver.service


import com.google.cloud.firestore.Firestore
import dev.devmonks.metrdotelserver.model.MenuItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class MenuService(@Autowired val firestore: Firestore) {
    fun create(menuItem: MenuItem, restaurantId: String): Mono<Boolean> {
        TODO("Not yet implemented")
//        val path = "restaurants/$restaurantId/menuItems"
//        this.getNewReference(path).subscribe { id -> menuItem.id = id }
//        return this.firestore.collection(path).add(menuItem)
    }

    private fun getNewReference(path: String): Mono<String> {
        return Mono.just(this.firestore.collection(path).document().id)
    }

    fun getAllForRestaurant(restaurantId: String): Flux<MenuItem> {
        TODO("Not yet implemented")
    }

    fun getMenuItem(restaurantId: String, menuItemId: String): Mono<MenuItem> {
        TODO("Not yet implemented")
    }

    fun updateMenuItem(restaurantId: String, menuItemId: String, menuItem: MenuItem): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    fun deleteMenuItem(restaurantId: String, menuItemId: String): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}