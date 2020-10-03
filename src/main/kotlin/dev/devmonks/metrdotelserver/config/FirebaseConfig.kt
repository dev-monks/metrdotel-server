package dev.devmonks.metrdotelserver.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Configuration
import java.io.IOException
import javax.annotation.PostConstruct

@Configuration
class FirebaseConfig {
    @PostConstruct
    @Throws(IOException::class)
    fun firebaseConnect() {
        val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl("https://metrdotel.firebaseio.com")
                .build()
        FirebaseApp.initializeApp(options)
    }
}
