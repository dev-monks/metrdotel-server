package dev.devmonks.metrdotelserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MetrdotelServerApplication

fun main(args: Array<String>) {
    runApplication<MetrdotelServerApplication>(*args)
}
