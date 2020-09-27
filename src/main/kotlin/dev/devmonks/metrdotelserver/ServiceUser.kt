package dev.devmonks.metrdotelserver

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import dev.devmonks.metrdotelserver.model.User
import org.springframework.stereotype.Service

@Service
class ServiceUser(val firestore: Firestore) {
    fun writeAndRead(): Unit {
        val user = User(name = "Suleiman", age = 24)
        val newUser: ApiFuture<DocumentReference>? = this.firestore.collection("users").add(user)
    }
}
