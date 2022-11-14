package otus.gpb.recyclerview.model

import java.time.LocalDateTime

data class Message(
    val time: LocalDateTime,
    val image: String? = null,
    val text: String? = null,
)
