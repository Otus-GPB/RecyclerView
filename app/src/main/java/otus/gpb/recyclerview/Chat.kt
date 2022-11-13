package otus.gpb.recyclerview

data class Chat(
    val nickname: String,
    val image: Int? = null,
    val isScam: Boolean = false,
    val isOfficial: Boolean = false,
    val isMuted: Boolean = false,
    val lastMessage: String? = null,
    val additionalInfo: String? = null,
    val dateTime: String? = null,
    val unreadCounter: Int = 0,
    val messageStatus: MessageStatus = MessageStatus.NONE
)

enum class MessageStatus {
    NONE,
    SENDED,
    READ
}
