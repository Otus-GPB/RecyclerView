package otus.gpb.recyclerview

import android.content.Context
import kotlin.random.Random

typealias UsersListener = (usersChat: List<Chat>) -> Unit

class LoaderChat(context: Context) {
    private val listeners = mutableSetOf<UsersListener>()
    private var users = mutableListOf<Chat>()
    private val userName = context.resources.getStringArray(R.array.user_names)
    private val userDetails = context.resources.getStringArray(R.array.user_details)
    private val userMessage = context.resources.getStringArray(R.array.user_message)
    private val timeMessage = context.resources.getStringArray(R.array.time_message)
    private val isBoolean = arrayOf(true, false)
    init {
        firstLoad()
        listeners.forEach { it.invoke(users) }
    }

    fun deleteUser(user: Chat) {
        val indexToDelete = users.indexOfFirst { it.id == user.id }
        if (indexToDelete != -1) {
            users = ArrayList(users)
            users.removeAt(indexToDelete)
            listeners.forEach { it.invoke(users) }
        }
    }

    fun copy() {
        users = ArrayList(users)
        (1..PAGING).map {
            val chat = users[it].copy(id = users.size + 1)
            users.add(chat)
        }
        listeners.forEach { it.invoke(users) }
    }

    fun addListener(listener: UsersListener) {
        listeners.add(listener)
        listener.invoke(users)
    }

    fun removeListener(listener: UsersListener) {
        listeners.remove(listener)
    }

    fun firstLoad() {
        (1..userName.size * 2).map {
            if (it % 2 == 0)
                users.add(
                    Chat(
                        id = it,
                        userName = userName[Random.nextInt(userName.size)],
                        userAvatar = imageRepos.shuffled()[Random.nextInt(imageRepos.size)],
                        userDetails = userDetails[Random.nextInt(userDetails.size)],
                        msgTime = timeMessage[Random.nextInt(timeMessage.size)],
                        msgGetCount = Random.nextInt(MAX_COUNT),
                        msgText = userMessage[Random.nextInt(userMessage.size)],
                        isVerifity = isBoolean[Random.nextInt(isBoolean.size)],
                        isDone = isBoolean[Random.nextInt(isBoolean.size)]
                    )
                )
            else users.add(
                Chat(
                    id = it,
                    userName = userName[Random.nextInt(0, userName.size)],
                    userAvatar = imageRepos.shuffled()[Random.nextInt(imageRepos.size)],
                    msgTime = timeMessage[Random.nextInt(timeMessage.size)],
                    msgGetCount = Random.nextInt(MAX_COUNT),
                    msgImage = imageRepos[Random.nextInt(imageRepos.size)],
                    msgText = userMessage[Random.nextInt(userMessage.size)],
                    isNotVoice = isBoolean[Random.nextInt(isBoolean.size)],
                    isScam = isBoolean[Random.nextInt(isBoolean.size)]
                )
            )
        }
    }

    companion object {
        private const val PAGING = 10
        private const val MAX_COUNT = 7

        private val imageRepos = listOf<String>(
            "https://images.unsplash.com/photo-1657214059233-5626b35eb349?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxzZWFyY2h8MXx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1517841905240-472988babdf9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1513682121497-80211f36a7d3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1532635241-17e820acc59f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fHBlb3BsZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        )
    }
}
