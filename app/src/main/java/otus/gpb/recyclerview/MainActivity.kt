package otus.gpb.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.model.Chat
import otus.gpb.recyclerview.ui.adapter.ChatAdapter
import otus.gpb.recyclerview.ui.decoration.ChatItemDecoration
import otus.gpb.recyclerview.ui.decoration.SwipeToDismissCallback
import otus.gpb.recyclerview.utils.TestDataProvider

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var chatAdapter: ChatAdapter

    private var chats = TestDataProvider.chats()//.plus(DummyDataProvider.chats())
    private val onScrollListener = object: RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val lastVisiblePos = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
           // пагинация на каждые 10 позиций
            if (dy > 0 &&
                (lastVisiblePos % 10 == 0 && lastVisiblePos >= chatAdapter.currentList.size - 20) ||
                                chatAdapter.currentList.size <= 10) {
                addChats()
            }
        }
    }


    fun addChats() {
        val newChats = chatAdapter.currentList.plus(TestDataProvider.chats())
        chatAdapter.submitList(newChats)
        Log.d(TAG, "Added chats. Got ${chatAdapter.itemCount}")
    }
    fun removeChat(position: Int) {
        val newChats = ArrayList<Chat>()
        newChats.addAll(chatAdapter.currentList)
        newChats.removeAt(position)
        chatAdapter.submitList(newChats)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatList = findViewById<RecyclerView>(R.id.recyclerView)
        chatAdapter = ChatAdapter(TestDataProvider.CURRENT_USER_ID)
        chatAdapter.submitList(chats)
        val chatDecoration = ChatItemDecoration(this.getColor(R.color.alto))

        val chatSwipeToDismissCallback = object : SwipeToDismissCallback(
            bgColor = ContextCompat.getColor(this@MainActivity, R.color.lightHavelockBlue),
            messageColor = Color.WHITE,
            context = this@MainActivity
        ) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                removeChat(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(chatSwipeToDismissCallback)
        itemTouchHelper.attachToRecyclerView(chatList)

        chatList.addItemDecoration(chatDecoration)
        chatList.layoutManager = LinearLayoutManager(this)
        chatList.adapter = chatAdapter
        chatList.addOnScrollListener(onScrollListener)
    }
}