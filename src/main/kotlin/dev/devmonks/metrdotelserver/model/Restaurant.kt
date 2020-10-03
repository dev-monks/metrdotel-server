package dev.devmonks.metrdotelserver.model

import com.google.cloud.firestore.annotation.DocumentId
import org.springframework.cloud.gcp.data.firestore.Document
import java.time.LocalDateTime

@Document(collectionName = "users")
data class Restaurant(@DocumentId val id: String, var amenities: List<Amenity>, var type: PlaceType, var coverImage: String, val openingHours: Map<String, LocalDateTime>, var priceRange: Int, var name: String, var description: String, var reviews: List<String>, var menu: List<MenuItem>, var order: List<String>, var reservations: List<String>, var location: Location)
