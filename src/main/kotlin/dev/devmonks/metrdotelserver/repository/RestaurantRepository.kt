package dev.devmonks.metrdotelserver.repository

import dev.devmonks.metrdotelserver.model.*
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface RestaurantRepository : FirestoreReactiveRepository<Restaurant> {
    fun findAllByPriceRange(priceRange: Int): Flux<Restaurant>
    fun findAllByType(type: PlaceType): Flux<Restaurant>
    fun findByReviewsContaining(reviewId: String): Mono<Restaurant>
}

interface ReservationRepository : FirestoreReactiveRepository<Reservation>
interface OrderRepository : FirestoreReactiveRepository<Order>
interface MenuItemRepository : FirestoreReactiveRepository<MenuItem>
interface ReviewRepository : FirestoreReactiveRepository<Review>
