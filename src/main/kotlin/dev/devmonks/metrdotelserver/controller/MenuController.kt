package dev.devmonks.metrdotelserver.controller


import dev.devmonks.metrdotelserver.dto.request.CreateMenuItemRequest
import dev.devmonks.metrdotelserver.dto.request.UpdateMenuItemRequest
import dev.devmonks.metrdotelserver.model.MenuItem
import dev.devmonks.metrdotelserver.service.MenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/menus")
class MenuController(@Autowired val menuService: MenuService) {
    @PostMapping("")
    fun createMenuItem(@RequestBody payload: CreateMenuItemRequest): Mono<Boolean> {
        return this.menuService.create(payload.toMenuItem(), payload.restaurantId)
    }

    @GetMapping("/restaurant/{restaurantId}")
    fun getAllMenuItemsForRestaurant(@PathVariable restaurantId: String): Flux<MenuItem> {
        return this.menuService.getAllForRestaurant(restaurantId)
    }

    @GetMapping("/{restaurantId}/{menuItemId}")
    fun getMenuItem(@PathVariable restaurantId: String, @PathVariable menuItemId: String): Mono<MenuItem> {
        return this.menuService.getMenuItem(restaurantId, menuItemId)
    }

    @PutMapping("/{restaurantId}/{menuItemId}")
    fun updateMenuItem(@PathVariable restaurantId: String, @PathVariable menuItemId: String, @RequestBody payload: UpdateMenuItemRequest): Mono<Boolean> {
        return this.menuService.updateMenuItem(restaurantId, menuItemId, payload.toMenuItem())
    }

    @DeleteMapping("/{restaurantId}/{menuItemId}")
    fun deleteMenuItem(@PathVariable restaurantId: String, @PathVariable menuItemId: String): Mono<Boolean> {
        return this.menuService.deleteMenuItem(restaurantId, menuItemId)
    }
}