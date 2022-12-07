package otus.gpb.recyclerview

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val repository = ChatRepository()
    val chatList = repository.getChatList()
}