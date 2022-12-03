package otus.gpb.recyclerview.model

import androidx.annotation.DrawableRes
import java.util.*

sealed class Chat(
    val id: Long,
    val isMuted: Boolean,
    val isScam: Boolean,
    val isOfficial: Boolean,
    val lastMessage: Message,
)
class SingleUser(
    id: Long,
    val user: User,
    isMuted: Boolean, isScam: Boolean, isOfficial: Boolean,
    lastMessage: Message
): Chat(id, isMuted, isScam, isOfficial, lastMessage)

class Dialogue(
    id: Long,
    @DrawableRes
    val pictureResourceId: Int,
    val name: String,
    isMuted: Boolean, isScam: Boolean, isOfficial: Boolean,
    lastMessage: Message
): Chat(id, isMuted, isScam, isOfficial, lastMessage)

data class User(
    val id: Long,
    val name: String,
    @DrawableRes
    val avatarResourceId: Int
)

data class Message(
    val sender: User,
    val sendTime: Date,
    val readStatus: ReadStatus,
    val text: String,
    val attachments: List<Attachment>
)

data class Attachment(
    @DrawableRes
    val resourceId: Int,
    val attachmentType: AttachmentType
)

enum class AttachmentType {
    IMAGE, GIF, VIDEO, FILE
}

enum class ReadStatus {
    SENT, READ, ERROR
}
