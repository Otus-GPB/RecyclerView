package otus.gpb.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ChatRepository {

    private val chatListLD = MutableLiveData<List<ChatItem>>()
    private val chatList = mutableListOf<ChatItem>()

    init {
        initChat()
        updateChatList()
    }
    private fun initChat(){
        chatList. add(
            ChatItem(
                1,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                2,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                3,
                "Что-то",
                "Name",
                ChatItem.NO_TITLE,
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                4,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                5,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                6,
                "Что-то",
                "Name",
                ChatItem.NO_TITLE,
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                7,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                8,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                9,
                "Что-то",
                "Name",
                ChatItem.NO_TITLE,
                "Message",
                "00:00")
        )
        chatList. add(
            ChatItem(
                10,
                "Что-то",
                "Name",
                "Title",
                "Message",
                "00:00")
        )
    }

    fun getChatList(): LiveData<List<ChatItem>> {
        return chatListLD
    }

    private fun updateChatList(){
        chatListLD.value = chatList.toList()
    }
}