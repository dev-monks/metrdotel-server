package dev.devmonks.metrdotelserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val serviceUser: ServiceUser) {
    @GetMapping(path = ["/user"])
    fun createUser(): String {
        this.serviceUser.writeAndRead()
        return "Ok"
    }
}
