package otus.gpb.recyclerview.model

import java.util.*

data class Message(
    val time: Date,
    val image: Int? = null,
    val text: String? = null,
    val isRead: Boolean = false,
    val isMine: Boolean = false,
)
