package otus.gpb.recyclerview

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
/*
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
        return Chat(name, photo, details, date, text, 0, 0, true, false,
            false, true)
    } else if (num % 3 == 0) {
        return Chat(name, photo, "", date, text, previewPhoto, (1..5).random(), true, false,
            true, true)
    } else {
        return Chat(name, photo, "", date, text, previewPhoto, 0, false, true,
            false, false)
    }
}
*/
fun generateRandomChatList() : MutableList<Chat> {
    val list = mutableListOf<Chat>()
    list.add(Chat("Nastya", R.drawable.photo_1, "JiJi", "11:58 AM", "How are you?", R.drawable
        .preview_1, 0, false, false, false, true ))
    list.add(Chat("Neko", R.drawable.photo_2, "", "Thu", "Where are you?", 0, 1, true,
        false, false, true ))
    list.add(Chat("Pasha", R.drawable.photo_3, "", "Fri", "))", 0, 1, true,
        false, false, false ))
    list.add(Chat("Telegram", R.drawable.photo_4, "Support", "Thu", "No", 0, 0, false,
        false, true, false ))
    list.add(Chat("Anna", R.drawable.photo_5, "", "13:45 PM", "Ok", 0, 4, false,
        false, true, false ))
    list.add(Chat("Sasha", R.drawable.photo_6, "Jon", "02 May", "Hi!", 0, 1, false,
        true, false, false ))
    list.add(Chat("Family", R.drawable.photo_2, "", "Fri", "Call me", 0, 7, true,
        false, true, true ))
    list.add(Chat("Gintama", R.drawable.photo_3, "", "17:34 PM", "Bye", 0, 0, false,
        false, true, false ))
    list.add(Chat("Loren", R.drawable.photo_1, "Fifi", "04:20 AM", "Where are you?", 0, 0, false,
        false, true, true ))
    list.add(Chat("TelegramOfficial", R.drawable.photo_4, "", "Mon", "I LOVE YOU", 0, 0, false,
        true, false, false ))
    return list
}