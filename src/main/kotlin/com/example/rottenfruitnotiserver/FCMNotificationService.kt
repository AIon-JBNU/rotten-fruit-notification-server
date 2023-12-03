package com.example.rottenfruitnotiserver

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingException
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FCMNotificationService @Autowired constructor(
    private val firebaseMessaging: FirebaseMessaging
) {

    fun sendNotification(requestDto: FCMNotificationRequestDto): String {
        if (requestDto.targetToken != null) {
            val notification = Notification.builder()
                .setTitle(requestDto.title)
                .setBody(requestDto.body)
                .build()

            val message = Message.builder()
                .setToken(requestDto.targetToken)
                .setNotification(notification)
                .build()

            try {
                firebaseMessaging.send(message)
                return "알림을 성공적으로 전송했습니다. targetToken=" + requestDto.targetToken
            } catch (exception: FirebaseMessagingException) {
                exception.printStackTrace()
                return "알림 보내기를 실패하였습니다. targetToken=" + requestDto.targetToken
            }
        } else {
            return "targetToken 이 존재하지 않습니다."
        }
    }
}