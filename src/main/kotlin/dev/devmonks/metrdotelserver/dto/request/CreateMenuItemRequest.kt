package dev.devmonks.metrdotelserver.dto.request

import dev.devmonks.metrdotelserver.model.MenuItem

class CreateMenuItemRequest(
        val restaurantId: String,
        var name: String,
        var picture: String,
        var price: Double,
        var description: String,
        var types: List<String>
) {
    fun toMenuItem(): MenuItem {
        return MenuItem(
                id = null,
                name = this.name,
                picture = this.picture,
                price = this.price,
                description = this.description,
                types = this.types
        )
    }
}