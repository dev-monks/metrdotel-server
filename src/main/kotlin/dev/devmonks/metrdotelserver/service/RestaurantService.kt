package dev.devmonks.metrdotelserver.service

import com.google.cloud.firestore.Firestore
import dev.devmonks.metrdotelserver.model.PlaceType
import dev.devmonks.metrdotelserver.model.Restaurant
import dev.devmonks.metrdotelserver.repository.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RestaurantService(@Autowired val restaurantRepository: RestaurantRepository, @Autowired val firestore: Firestore) {

    fun create(restaurant: Restaurant): Mono<Restaurant> {
        return this.restaurantRepository.save(restaurant)
    }

    fun get(): Flux<Restaurant> {
        return this.restaurantRepository.findAll()
    }

    fun getAllByPriceRange(priceRange: Int): Flux<Restaurant> {
        return this.restaurantRepository.findAllByPriceRange(priceRange)
    }

    fun getAllByType(type: PlaceType): Flux<Restaurant> {
        return this.restaurantRepository.findAllByType(type)
    }

    fun get(id: String): Mono<Restaurant> {
        return this.restaurantRepository.findById(id)
    }

    fun update(restaurant: Restaurant, id: String): Mono<Restaurant> {
        return this.restaurantRepository.save(restaurant)
    }

    fun delete(id: String): Mono<Boolean> {
        return this.restaurantRepository.deleteById(id).flatMap { Mono.just(true) }
    }

    fun getNewReference(): Mono<String> {
        return Mono.just(this.firestore.collection("restaurants").document().toString())
    }
}