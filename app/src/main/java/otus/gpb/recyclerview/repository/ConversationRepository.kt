package otus.gpb.recyclerview.repository

import otus.gpb.recyclerview.R
import otus.gpb.recyclerview.model.Conversation
import otus.gpb.recyclerview.model.Message
import java.util.*
import kotlin.random.Random

class ConversationRepository {
    private val names = listOf(
        "Dmitry",
        "Pasha",
        "Andrew",
        "Sonya",
        "Julia",
        "Svetlana",
        "Vadim",
        "Nikolay",
        "Ivan",
        "Tim",
        "Albert",
        "Lena",
        "Mila",
        "Ksenia",
        "Telegram Support"
    )
    private val details = listOf("", "Support", "Friend")
    private val texts = listOf(
        "Yes, they are necessary",
        "I love /r/Reddit!",
        "How are u?",
        "Yes it happened.",
        "Will it ever happened",
        "Okay",
        "Nope",
        "I hope"
    )
    private val avatars =
        listOf(R.drawable.avatar_1, R.drawable.avatar_2, R.drawable.avatar_3, R.drawable.avatar_4, R.drawable.avatar_5)
    private val previews = listOf(null, R.drawable.preview)
    private var lastId = 0L

    fun getItems(): List<Conversation> = generateNextConversations()

    private fun generateNextConversations(): List<Conversation> {
        return (1..10).map {
            Conversation(
                id = ++lastId,
                username = names.random(),
                userDetails = details.random(),
                userAvatar = avatars.random(),
                Message(
                    time = Date(System.currentTimeMillis()),
                    image = previews.random(),
                    text = texts.random(),
                    isRead = Random.nextBoolean(),
                    isMine = Random.nextBoolean()
                ),
                newMessagesCount = Random.nextInt(4),
                isVip = Random.nextBoolean(),
                isMuted = Random.nextBoolean(),
                isScam = Random.nextBoolean()
            )
        }
    }
}
