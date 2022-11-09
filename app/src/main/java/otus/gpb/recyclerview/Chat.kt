package otus.gpb.recyclerview
interface DataForRecyclerChat

data class Chat(
    val id: Int,
    var userName: String,
    val userDetails: String? = null,
    val userAvatar: String,
    val msgTime: String,
    val msgGetCount: Int = 0,
    val msgImage: String? = null,
    val msgText: String? = null,
    val isVerifity: Boolean = false,
    val isNotVoice: Boolean = false,
    val isScam: Boolean = false,
    val isDone: Boolean = false
) : DataForRecyclerChat
