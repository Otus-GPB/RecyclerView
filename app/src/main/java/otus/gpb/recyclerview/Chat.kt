package otus.gpb.recyclerview

import kotlin.random.Random

data class Chat (
    val id: Long,
    val userName: String,
    val userPhoto: Int,
    val userDetails: String = "",
    val messageTime: String,
    val messageText: String,
    val messagePhoto: Int,
    val newMessageCount: Int = 0,
    val isOfficial: Boolean = false,
    val isScam: Boolean = false,
    val isMuted: Boolean = false,
    val isRead: Boolean = false
)


val nameList = mutableListOf("Nastya", "Neko", "Anya", "Sasha", "Pasha", "Izumi", "L",
    "Kaneki", "Levi")

val photoList = mutableListOf(R.drawable.photo_1, R.drawable.photo_2, R.drawable.photo_3, R
    .drawable.photo_4, R.drawable.photo_5, R.drawable.photo_6)
val detailsList = mutableListOf("JiJi", "", "Support", "Code", "", "Id")
val timeList = mutableListOf("11:58 AM", "Fri", "12:12 PM", "Thu", "Wed", "April 01",
    "March 27")
val textList = mutableListOf("How are you?", "Where are you?", "I LOVE YOU", "Yes", "No",
    "Ok")
val previewPhotoList = mutableListOf<Int>(R.drawable.preview_1, 0, 0, 0)

class ChatList {

    private var ID = 0L
    fun generateRandomChatList(): MutableList<Chat> {
        val list = mutableListOf<Chat>()
        for (i in 1..10) {
            println(ID)
            val chat = Chat(
                id = ++ID,
                userName = nameList.random(),
                userDetails = detailsList.random(),
                userPhoto = photoList.random(),
                messageTime = timeList.random(),
                messageText = textList.random(),
                messagePhoto = previewPhotoList.random(),
                newMessageCount = Random.nextInt(9),
                isOfficial = Random.nextBoolean(),
                isMuted = Random.nextBoolean(),
                isRead = Random.nextBoolean(),
                isScam = Random.nextBoolean()
            )
            list.add(chat)
        }
        return list
    }
}