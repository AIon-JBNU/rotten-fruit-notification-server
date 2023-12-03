package com.example.rottenfruitnotiserver

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.InputStream

@Configuration
class FCMConfig {
    @Bean
    fun firebaseMessaging(): FirebaseMessaging {
        val resource = ClassPathResource("firebase/capstone-project-406412-firebase-adminsdk-obpon-015a448923.json")

        val refreshToken = resource.inputStream

        var firebaseApp: FirebaseApp? = null
        val firebaseAppList = FirebaseApp.getApps()
        if (firebaseAppList != null && firebaseAppList.isNotEmpty()) {
            for (app in firebaseAppList) {
                if (app.name.equals(FirebaseApp.DEFAULT_APP_NAME)) {
                    firebaseApp = app
                }
            }
        } else {
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .build()
            firebaseApp = FirebaseApp.initializeApp(options)
        }
        return FirebaseMessaging.getInstance(firebaseApp)
    }
}