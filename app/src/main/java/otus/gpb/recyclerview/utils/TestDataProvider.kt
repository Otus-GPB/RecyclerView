package otus.gpb.recyclerview.utils

import otus.gpb.recyclerview.R
import otus.gpb.recyclerview.model.*
import java.util.*

class TestDataProvider {
    companion object {

        const val CURRENT_USER_ID = 111L

        private val r = Random()
        private val currentUser = User(
            id = CURRENT_USER_ID,
            name = "Test",
            avatarResourceId = R.drawable.ic_launcher_foreground
        )

        private val user1 = User(
            id = 123,
            name = "Elon",
            avatarResourceId = R.drawable.avatar1)
        private val user2 = User(
            id = 124,
            name = "Pasha",
            avatarResourceId = R.drawable.avatar2)
        private val user3 = User(
            id = 125,
            name = "Karina",
            avatarResourceId = R.drawable.avatar3)
        private val user4 = User(
            id = 126,
            name = "Marilyn",
            avatarResourceId = R.drawable.avatar4)

        private val user5 = User(
            id = 131,
            name = "jija",
            avatarResourceId = R.drawable.ic_mute
        )

        private val user6 = User(
            id = 132,
            name = "Support",
            avatarResourceId = R.drawable.support_logo
        )

        private val attachment1 = Attachment(R.drawable.chat_attachment, AttachmentType.IMAGE)

        private val message1 = Message(
            sender = user5,
            sendTime = DateHelper.duringLastDayExample,
            readStatus = ReadStatus.READ,
            text = "Yes, they are necessary",
            attachments = listOf(attachment1)
        )

        private val message2 = Message(
            sender = user1,
            sendTime = DateHelper.duringLastWeekExample,
            readStatus = ReadStatus.READ,
            text = "I love /r/Reddit!",
            attachments = listOf()
        )

        private val message3 = Message(
            sender = user2,
            sendTime = DateHelper.duringLastYearExample,
            readStatus = ReadStatus.READ,
            text = "How are you?",
            attachments = listOf()
        )

        private val message4 = Message(
            sender = user6,
            sendTime = DateHelper.somewhereInThePastExample,
            readStatus = ReadStatus.READ,
            text = "Yes it happened.",
            attachments = listOf()
        )

        private val message5 = Message(
            sender = currentUser,
            sendTime = DateHelper.duringLastDayExample,
            readStatus = ReadStatus.SENT,
            text = "Okay",
            attachments = listOf()
        )

        private val message6 = Message(
            sender = currentUser,
            sendTime = DateHelper.duringLastWeekExample,
            readStatus = ReadStatus.READ,
            text = "Will it ever happen",
            attachments = listOf()
        )

        fun chats(): List<Chat> {
            return listOf(
                Dialogue(
                    id = r.nextLong(),
                    pictureResourceId = R.drawable.chat_photo,
                    name = "Pizza",
                    isMuted = true, isScam = false, isOfficial = false,
                    lastMessage = message1
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user1,
                    isMuted = true, isScam = false, isOfficial = false,
                    lastMessage = message2
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user2,
                    isMuted = true, isScam = false, isOfficial = true,
                    lastMessage = message3
                ),
                Dialogue(
                    id = r.nextLong(),
                    pictureResourceId = R.drawable.support_logo,
                    name = "Telegram Support",
                    isMuted = false, isScam = false, isOfficial = true,
                    lastMessage = message4
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user3,
                    isMuted = false, isScam = false, isOfficial = false,
                    lastMessage = message5
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user4,
                    isMuted = false, isScam = true, isOfficial = false,
                    lastMessage = message6
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user4,
                    isMuted = false, isScam = true, isOfficial = false,
                    lastMessage = message6
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user4,
                    isMuted = false, isScam = true, isOfficial = false,
                    lastMessage = message6
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user4,
                    isMuted = false, isScam = true, isOfficial = false,
                    lastMessage = message6
                ),
                SingleUser(
                    id = r.nextLong(),
                    user = user4,
                    isMuted = false, isScam = true, isOfficial = false,
                    lastMessage = message6
                )
            )
        }
    }
}