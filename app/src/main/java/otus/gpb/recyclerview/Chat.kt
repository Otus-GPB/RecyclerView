package otus.gpb.recyclerview

data class Chat(
    val id: Long,
    val title: String,
    val imgAuthor: String = "https://source.unsplash.com/random",
    val isTitle: Boolean = false,
    val author: String,
    val message: String,
    val avatar: String,
    var isSilent: Boolean = false,
    var isMail: Boolean,
    var isFix: Boolean,
    var isOK: Boolean = false,
    val time: String,
)
