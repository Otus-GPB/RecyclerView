package otus.gpb.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ChatRepository {

    private val chatListLD = MutableLiveData<List<ChatItem>>()
    private val chatList = mutableListOf<ChatItem>()
//    var countItem = 1

    fun generate(){
        chatList. add(
            ChatItem(
                1,
                R.drawable.img_1,
                "Pizza",
                "jija",
                "Yes, they are necessary",
                "11:38 AM",
                isVolume = false,
                isMark = false,
                isRead = true
            )
        )
        chatList. add(
            ChatItem(
                2,
                R.drawable.img_2,
                "Elon",
                ChatItem.NO_TITLE,
                "I love /r/Reddit!",
                "12:44 AM",
                isVolume = false,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                3,
                R.drawable.img_3,
                "Pasha",
                ChatItem.NO_TITLE,
                "How are u?",
                "Fri",
                isVolume = false,
                isMark = true,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                4,
                null,
                "Name",
                "Title",
                "Message",
                "Thu",
                isVolume = true,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                5,
                R.drawable.img_4,
                "Telegram Support",
                "Support",
                "Yes it happened",
                "Thu",
                isVolume = true,
                isMark = true,
                isRead = false)
        )
        chatList. add(
            ChatItem(
                6,
                R.drawable.img_5,
                "Karina",
                ChatItem.NO_TITLE,
                "Okay",
                "Wed",
                isVolume = true,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                7,
                R.drawable.img_6,
                "Marilyn",
                ChatItem.NO_TITLE,
                "Will it ever happen",
                "May 02",
                isVolume = true,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                8,
                R.drawable.img_1,
                "Pizza",
                "jija",
                "Yes, they are necessary",
                "11:38 AM",
                isVolume = false,
                isMark = false,
                isRead = true
            )
        )
        chatList. add(
            ChatItem(
                9,
                R.drawable.img_2,
                "Elon",
                ChatItem.NO_TITLE,
                "I love /r/Reddit!",
                "12:44 AM",
                isVolume = false,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                10,
                R.drawable.img_3,
                "Pasha",
                ChatItem.NO_TITLE,
                "How are u?",
                "Fri",
                isVolume = false,
                isMark = true,
                isRead = true)
        )

        /*chatList. add(
            ChatItem(
                11,
                null,
                "Name 11",
                "Title",
                "Message",
                "Thu",
                isVolume = true,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                12,
                R.drawable.img_4,
                "Telegram Support 12",
                "Support",
                "Yes it happened",
                "Thu",
                isVolume = true,
                isMark = true,
                isRead = false)
        )
        chatList. add(
            ChatItem(
                13,
                R.drawable.img_5,
                "Karina 13",
                ChatItem.NO_TITLE,
                "Okay",
                "Wed",
                isVolume = true,
                isMark = false,
                isRead = true)
        )
        chatList. add(
            ChatItem(
                14,
                R.drawable.img_6,
                "Marilyn 14" ,
                ChatItem.NO_TITLE,
                "Will it ever happen",
                "May 02",
                isVolume = true,
                isMark = false,
                isRead = true)
        )*/
        updateChatList()
    }

    fun getChatList(): LiveData<List<ChatItem>> {
        return chatListLD
    }
    fun deleteItem(chatItem: ChatItem){
        chatList.remove(chatItem)
        updateChatList()
    }

    private fun updateChatList(){
        chatListLD.value = chatList.toList()
    }
}