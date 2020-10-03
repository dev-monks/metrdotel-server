package dev.devmonks.metrdotelserver.model

import com.google.cloud.firestore.annotation.DocumentId
import org.springframework.cloud.gcp.data.firestore.Document
import java.time.LocalDateTime

@Document(collectionName = "users")
data class Restaurant(
        @DocumentId val id: String?,
        var amenities: List<Amenity>,
        var type: PlaceType,
        var coverImage: String,
        val openingHours: Map<Day, List<Map<String, String>>>,
        var priceRange: Int,
        var name: String,
        var description: String,
        var reviews: List<String> = emptyList(),
        var menu: List<MenuItem> = emptyList(),
        var orders: List<String> = emptyList(),
        var reservations: List<String> = emptyList(),
        var location: Location
)
