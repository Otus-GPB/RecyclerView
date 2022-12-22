package otus.gpb.recyclerview.model

import androidx.annotation.DrawableRes

sealed class Chat(
    val id: Int,
    val title: String,
    @DrawableRes val avatar: Int?,
    val isMuted: Boolean,
    val isVerified: Boolean,
    val isScam: Boolean,
)

class GroupChat(
    id: Int,
    title: String,
    @DrawableRes avatar: Int?,
    isMuted: Boolean,
    isVerified: Boolean,
    isScam: Boolean,
    val message: Message,
    val unreadCount: Int,
) : Chat(
    id = id,
    title = title,
    avatar = avatar,
    isMuted = isMuted,
    isVerified = isVerified,
    isScam = isScam,
)

class UserChat(
    id: Int,
    isMuted: Boolean,
    isVerified: Boolean,
    isScam: Boolean,
    val user: User,
    val message: Message,
) : Chat(
    id = id,
    title = user.name,
    avatar = user.avatar,
    isMuted = isMuted,
    isVerified = isVerified,
    isScam = isScam,
)

data class User(
    val id: Int,
    val name: String,
    @DrawableRes val avatar: Int?
)

data class Message(
    val text: String,
    val date: String,
    val sender: User,
    val isRead: Boolean,
    @DrawableRes val layout: Int? = null
)
