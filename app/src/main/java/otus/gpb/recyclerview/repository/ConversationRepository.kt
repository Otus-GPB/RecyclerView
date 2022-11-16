package otus.gpb.recyclerview.repository

import otus.gpb.recyclerview.R
import otus.gpb.recyclerview.model.Conversation
import otus.gpb.recyclerview.model.Message
import java.util.*

class ConversationRepository {
    private val items = mutableListOf(
        Conversation(
            id = 1L,
            username = "Pizza",
            userDetails = "jija",
            userAvatar = R.drawable.avatar_1,
            lastMessage = Message(
                time = Date(System.currentTimeMillis()),
                image = R.drawable.preview,
                text = "Yes, they are necessary",
                isRead = false,
                isMine = false
            ),
            newMessagesCount = 3,
            isVip = false,
            isMuted = true,
            isScam = false
        ),
        Conversation(
            id = 2L,
            username = "Elon",
            userDetails = null,
            userAvatar = R.drawable.avatar_2,
            lastMessage = Message(
                time = Date(System.currentTimeMillis()),
                image = null,
                text = "I love /r/Reddit!",
                isRead = false,
                isMine = false
            ),
            newMessagesCount = 0,
            isVip = false,
            isMuted = true,
            isScam = false
        ),
        Conversation(
            id = 3L,
            username = "Pasha",
            userDetails = null,
            userAvatar = R.drawable.avatar_3,
            lastMessage = Message(
                time = Date(System.currentTimeMillis()),
                image = null,
                text = "How are u?",
                isRead = false,
                isMine = false
            ),
            newMessagesCount = 0,
            isVip = true,
            isMuted = true,
            isScam = false
        ),
        Conversation(
            id = 4L,
            username = "Telegram Support",
            userDetails = "Support",
            userAvatar = R.drawable.avatar_4,
            lastMessage = Message(
                time = Date(System.currentTimeMillis()),
                image = null,
                text = "Yes it happened.",
                isRead = false,
                isMine = false
            ),
            newMessagesCount = 5,
            isVip = true,
            isMuted = false,
            isScam = false
        ),
        Conversation(
            id = 4L,
            username = "Karina",
            userDetails = null,
            userAvatar = R.drawable.avatar_5,
            lastMessage = Message(
                time = Date(System.currentTimeMillis()),
                image = null,
                text = "Okay",
                isRead = false,
                isMine = true
            ),
            newMessagesCount = 1,
            isVip = false,
            isMuted = false,
            isScam = false
        ),
        Conversation(
            id = 5L,
            username = "Marilyn",
            userDetails = null,
            userAvatar = R.drawable.avatar_5,
            lastMessage = Message(
                time = Date(System.currentTimeMillis()),
                image = null,
                text = "Will it ever happened",
                isRead = true,
                isMine = true
            ),
            newMessagesCount = 1,
            isVip = false,
            isMuted = false,
            isScam = true
        ),
    )

    fun getItems(): List<Conversation> = items
}
