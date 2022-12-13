package otus.gpb.recyclerview

import android.text.BoringLayout

data class Chat (
    val id: Long,
    val avatar: String,
    val name: String,
    val message: String,
    val date: String,
    val isVerified: Boolean,
    val isMute: Boolean,
    val description: String?,
    val isDone: Boolean
)