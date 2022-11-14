package otus.gpb.recyclerview.model

data class Conversation(
    val id: Long,
    val username: String,
    val userDetails: String? = null,
    val userAvatar: String? = null,
    val lastMessage: Message? = null,
    val newMessagesCount: Int = 0,
    val isVip: Boolean,
    val isMuted: Boolean,
    val isScam: Boolean,
)
