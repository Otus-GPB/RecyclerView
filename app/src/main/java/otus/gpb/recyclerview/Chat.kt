package otus.gpb.recyclerview

data class Chat (
    val uid: Long,
    val picture: String,
    val name: String,
    val message: String,
    val dateTime: String,
    val isMuted: Boolean,
)