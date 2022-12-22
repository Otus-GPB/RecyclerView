package otus.gpb.recyclerview.model

import otus.gpb.recyclerview.R

object ChatUtils {
    private val userList = listOf(
        User(id = 1, name = "Pasha", avatar = R.drawable.user_1),
        User(id = 2, name = "Elon", avatar = R.drawable.user_2),
        User(id = 3, name = "Karina", avatar = R.drawable.user_3),
        User(id = 4, name = "Marilyn", avatar = R.drawable.user_4),
        User(id = 5, name = "jija", avatar = null),
        User(id = 6, name = "Support", avatar = null)
    )

    private val messageList = listOf(
        Message(text = "How are u?", date = "Fri", isRead = true, sender = userList[0]),
        Message(text = "I love /r/Reddit!", "12:44 AM", isRead = true, sender = userList[1]),
        Message(text = "Okay", date = "Wed", isRead = false, sender = userList[2]),
        Message(text = "Will it ever happen", date = "May 02", isRead = true, sender = userList[3]),
        Message(text = "Yes, ther are necessary", date = "11:38 AM", layout = R.drawable.message_layout,  isRead = true, sender = userList[4]),
        Message(text = "Yes it happened.", date = "Thu",  isRead = false, sender = userList[5])
    )

    private var id = 0
    val getChat = listOf(
        GroupChat(
            id = id++,
            title = "Pizza",
            avatar = R.drawable.group_avatar_1,
            isMuted = true,
            isVerified = false,
            isScam = false,
            message = messageList[4],
            unreadCount = 0
        ),
        UserChat(
            id = id++,
            isMuted = true,
            isVerified = false,
            isScam = false,
            user = userList[1],
            message = messageList[1]
        ),
        UserChat(
            id = id++,
            isMuted = true,
            isVerified = true,
            isScam = false,
            user = userList[0],
            message = messageList[0]
        ),
        GroupChat(
            id = id++,
            title = "Telegram Support",
            avatar = R.drawable.group_avatar_2,
            isMuted = false,
            isVerified = true,
            isScam = false,
            message = messageList[5],
            unreadCount = 1
        ),
        UserChat(
            id = id++,
            isMuted = false,
            isVerified = false,
            isScam = false,
            user = userList[2],
            message = messageList[2]
        ),
        UserChat(
            id = id++,
            isMuted = false,
            isVerified = false,
            isScam = true,
            user = userList[3],
            message = messageList[3]
        )
    )
}