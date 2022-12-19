package otus.gpb.recyclerview.model

import java.util.Date
import java.util.UUID

data class Chat(
    val id: String = UUID.randomUUID().toString(),
    val chatName: String,
    val avatar: Int,
    val messageAuthor: String? = null,
    val lastMessage: Message,
    val unreadMessageCount: Int = 0,
    val isVerified: Boolean = false,
    val isMuted: Boolean = false,
    val isScam: Boolean = false

)

data class Message(
    val time: String,
    val image: Int? = null,
    val text: String,
    val isIncoming: Boolean = false,
    val isRead: Boolean = false
    )