package com.example.rottenfruitnotiserver

data class FCMNotificationRequestDto (
    val targetToken: String?,
    val title: String?,
    val body: String?
)