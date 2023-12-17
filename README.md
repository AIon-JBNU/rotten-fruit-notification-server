# AIon-JBNU 캡스톤 프로젝트 데모 서버

## 사용 라이브러리
- Spring Boot
- Firebase-Admin

## 설명
해당 서버는 /api/notification 주소로 POST로 알림 전송 요청이 오면 같이 온 targetToken에 해당하는 유저에게 Firebase-Admin 라이브러리를 통해 알림을 전송합니다.

POST 요청을 받을 때 사용해야 하는 데이터 구조는 다음과 같습니다.
````kotlin
data class FCMNotificationRequestDto (
    val targetToken: String?,
    val title: String?,
    val body: String?
)
````

FCMNotificationAPIController에서는 실제로 요청이 들어오는 부분의 코드입니다. Service로 관련 처리를 넘깁니다.

FCMNotificationService에서는 실제 알림 전송 처리를 합니다. Message를 만들어 FirebaseMessaging 클래스를 이용해 알림을 전송합니다.

FCMConfig에서 Firebase 관련 설정을 합니다.
