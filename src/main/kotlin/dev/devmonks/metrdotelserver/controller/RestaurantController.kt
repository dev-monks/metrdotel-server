package dev.devmonks.metrdotelserver.controller

import dev.devmonks.metrdotelserver.dto.request.CreateRestaurantRequest
import dev.devmonks.metrdotelserver.dto.request.UpdateRestaurantRequest
import dev.devmonks.metrdotelserver.model.PlaceType
import dev.devmonks.metrdotelserver.model.Restaurant
import dev.devmonks.metrdotelserver.service.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/restaurants")
class RestaurantController(@Autowired val restaurantService: RestaurantService) {
    @PostMapping("")
    fun createRestaurant(@RequestBody payload: CreateRestaurantRequest): Mono<Restaurant> {
        return Mono.just(payload)
                .map { data -> data.toRestaurant() }
                .flatMap { restaurant -> this.restaurantService.create(restaurant) }
    }

    @GetMapping("")
    fun getAllRestaurants(): Flux<Restaurant> {
        return this.restaurantService.get()
    }

    @GetMapping("/price-range/{priceRange}")
    fun getRestaurantsByPriceRange(@PathVariable priceRange: Int): Flux<Restaurant> {
        return this.restaurantService.getAllByPriceRange(priceRange)
    }

    @GetMapping("/type/{type}")
    fun getRestaurantsByType(@PathVariable type: String): Flux<Restaurant> {
        return this.restaurantService.getAllByType(PlaceType.fromString(type))
    }

    @GetMapping("/{id}")
    fun getRestaurant(@PathVariable id: String): Mono<Restaurant> {
        return this.restaurantService.get(id)
    }

    @PutMapping("/{id}")
    fun updateRestaurant(@RequestBody payload: UpdateRestaurantRequest, @PathVariable id: String): Mono<Restaurant> {
        payload.id = id
        return this.restaurantService.update(payload.toRestaurant(), id)
    }

    @DeleteMapping("/{id}")
    fun deleteRestaurant(@PathVariable id: String): Mono<Boolean> {
        return this.restaurantService.delete(id)
    }
}