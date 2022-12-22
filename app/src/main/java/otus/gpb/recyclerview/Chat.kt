package otus.gpb.recyclerview

import java.util.*

data class Chat (
    val userId: Long,
    val userName: String,
    val userPhoto: String,
    val userDetails: String? = null,
    val messageTime: Date,
    val messageText: String,
    val messagePhoto: String? = null,
    val newMessageCount: Int = 0,
    val isOfficial: Boolean = false,
    val isScam: Boolean = false,
    val isMuted: Boolean = false,
    val isRead: Boolean = false
)