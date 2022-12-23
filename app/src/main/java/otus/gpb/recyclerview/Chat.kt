package otus.gpb.recyclerview

import java.util.*



data class Chat (
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

val nameList = mutableListOf<String>("Nastya", "Neko", "Anya", "Sasha", "Pasha", "Izumi", "L",
    "Kaneki", "Levi")

val photoList = mutableListOf<Int>(R.drawable.photo_1)
val detailsList = mutableListOf<String>("JiJi", "Support", "Code", "Id")
val timeList = mutableListOf<String>("11:58 AM", "Fri", "12:12 PM", "Thu", "Wed", "April 01",
    "March 27")
val textList = mutableListOf<String>("How are you?", "Where are you?", "I LOVE YOU", "Yes", "No",
    "Ok")
val previewPhotoList = mutableListOf<Int>(R.drawable.preview_1)

fun generateRandomChatItem() : Chat {
    val name = nameList.random()
    val photo = photoList.random()
    val details = detailsList.random()
    val date = timeList.random()
    val text = textList.random()
    val previewPhoto = previewPhotoList.random()
    val num = (0..100).random()
    if (num % 2 == 0) {
        return Chat(name, photo, details, date, text, 0, 0, false, false,
            false, true)
    } else if (num % 3 == 0) {
        return Chat(name, photo, "", date, text, previewPhoto, (1..5).random(), true, false,
            true, true)
    } else {
        return Chat(name, photo, "", date, text, previewPhoto, 0, false, true,
            false, false)
    }
}

fun generateRandomChatList() : MutableList<Chat> {
    val list = mutableListOf<Chat>()
    for (i in (0..9)){
        list.add(generateRandomChatItem())
    }
    return list
}