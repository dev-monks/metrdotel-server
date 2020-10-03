package dev.devmonks.metrdotelserver.model

import com.google.cloud.firestore.annotation.DocumentId
import org.springframework.cloud.gcp.data.firestore.Document
import java.time.LocalDateTime

data class Location(val name: String, val longitude: Double, val latitude: Double)

@Document(collectionName = "reviews")
data class Review(@DocumentId val id: String, val placeId: String, var comment: String, var rating: Int)

@Document(collectionName = "menuItem")
data class MenuItem(@DocumentId val id: String, var name: String, var picture: String, var price: Int, var description: String, var types: List<String>)

@Document(collectionName = "orders")
data class Order(@DocumentId val id: String, val placeId: String, var discount: Double, var waiterTip: Double, var dateTime: LocalDateTime, var items: Map<String, Int>)

@Document(collectionName = "reservation")
data class Reservation(@DocumentId val id: String, val placeId: String, val dateTime: LocalDateTime, val numberOfPeople: Int)