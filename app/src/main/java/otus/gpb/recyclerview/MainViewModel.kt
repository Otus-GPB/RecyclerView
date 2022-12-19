package otus.gpb.recyclerview

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val repository = ChatRepository()
    val chatList = repository.getChatList()

    fun deleteChatItem(chatItem: ChatItem){
        repository.deleteItem(chatItem)
    }
    fun generate(){
        return repository.generate()
    }
}