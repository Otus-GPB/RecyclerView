package otus.gpb.recyclerview.repository

import otus.gpb.recyclerview.R
import otus.gpb.recyclerview.model.Chat
import otus.gpb.recyclerview.model.Message
import java.util.*

class ChatRepository {
    fun generateChatList() = listOf(
        Chat(
            chatName = "Pizza",
            avatar = R.drawable.avatar_1,
            messageAuthor = "jija",
            lastMessage = Message(
                time = "11:38 AM",
                R.drawable.preview,
                "Yes, they are necessary",
                isIncoming = true
            ),
            isMuted = true
        ),
        Chat(
            chatName = "Elon",
            avatar = R.drawable.avatar_2,
            lastMessage = Message(
                time = "12:44 AM",
                text = "I love /r/Reddit!",
                isIncoming = true
            ),
            isMuted = true
        ),
        Chat(
            chatName = "Pasha",
            avatar = R.drawable.avatar_3,
            lastMessage = Message(
                time = "Fri",
                text = "How are u?",
                isIncoming = true
            ),
            isMuted = true,
            isVerified = true
        ),
        Chat(
            chatName = "Telegram Support",
            avatar = R.drawable.avatar_4,
            messageAuthor = "Support",
            lastMessage = Message(
                time = "Thu",
                text = "Yes it happened.",
                isIncoming = true
            ),
            unreadMessageCount = 1,
            isVerified = true
        ),
        Chat(
            chatName = "Karina",
            avatar = R.drawable.avatar_5,
            lastMessage = Message(
                time = "Wed",
                text = "Okay",
                isIncoming = false,
                isRead = false
            )
        ),
        Chat(
            chatName = "Marilyn",
            avatar = R.drawable.avatar_6,
            lastMessage = Message(
                time = "May 02",
                text = "Will it ever happen",
                isIncoming = false,
                isRead = true
            ),
            isScam = true
        ),
        Chat(
            chatName = "Pizza",
            avatar = R.drawable.avatar_1,
            messageAuthor = "jija",
            lastMessage = Message(
                time = "11:38 AM",
                R.drawable.preview,
                "Yes, they are necessary",
                isIncoming = true
            ),
            isMuted = true
        ),
        Chat(
            chatName = "Elon",
            avatar = R.drawable.avatar_2,
            lastMessage = Message(
                time = "12:44 AM",
                text = "I love /r/Reddit!",
                isIncoming = true
            ),
            isMuted = true
        ),
        Chat(
            chatName = "Pasha",
            avatar = R.drawable.avatar_3,
            lastMessage = Message(
                time = "Fri",
                text = "How are u?",
                isIncoming = true
            ),
            isMuted = true,
            isVerified = true
        ),
        Chat(
            chatName = "Telegram Support",
            avatar = R.drawable.avatar_4,
            messageAuthor = "Support",
            lastMessage = Message(
                time = "Thu",
                text = "Yes it happened.",
                isIncoming = true
            ),
            unreadMessageCount = 1,
            isVerified = true
        )

    )

}
