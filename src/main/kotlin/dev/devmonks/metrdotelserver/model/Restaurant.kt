package dev.devmonks.metrdotelserver.model

import com.google.cloud.firestore.annotation.DocumentId
import org.springframework.cloud.gcp.data.firestore.Document
import java.time.LocalDateTime

@Document(collectionName = "users")
data class Restaurant(
        @DocumentId val id: String? = null,
        var amenities: List<Amenity>? = null,
        var type: PlaceType? = null,
        var coverImage: String? = null,
        val openingHours: Map<String, List<Map<String, String>>>? = null,
        var priceRange: Int? = null,
        var name: String? = null,
        var description: String?,
        var reviews: List<String>? = null,
        var menu: List<MenuItem>? = null,
        var orders: List<String>? = null,
        var reservations: List<String>? = null,
        var location: Location? = null
) {
    constructor(): this("", null, null, null, null, null, null, null, null, null, null, null, null)
}
