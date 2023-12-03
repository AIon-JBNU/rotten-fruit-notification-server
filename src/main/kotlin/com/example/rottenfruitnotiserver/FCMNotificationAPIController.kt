package com.example.rottenfruitnotiserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/notification")
class FCMNotificationAPIController @Autowired constructor(
    private val fcmNotificationService: FCMNotificationService
) {
    @PostMapping
    fun sendNotification(@RequestBody requestDto: FCMNotificationRequestDto): String {
        return fcmNotificationService.sendNotification(requestDto)
    }
}