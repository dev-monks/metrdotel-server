package dev.devmonks.metrdotelserver

import com.google.cloud.firestore.Firestore
import dev.devmonks.metrdotelserver.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MetrdotelServerApplication

fun main(args: Array<String>) {
    runApplication<MetrdotelServerApplication>(*args)
}

