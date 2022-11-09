package otus.gpb.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var loaderChat: LoaderChat
    private lateinit var usersListener: UsersListener
    private lateinit var chatList: List<Chat>
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loaderChat = LoaderChat(this)
        chatAdapter = ChatAdapter()
        usersListener = {
            chatList = it
            chatAdapter.usersChat = chatList
        }
        loaderChat.addListener(usersListener)

        val chatLayoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = chatLayoutManager
            adapter = chatAdapter
            addItemDecoration(MyDecorator(chatList.size))
        }
        val swipeCallBack = SwipeToDeleteListener(this) { position ->
            val user = chatList[position]
            loaderChat.deleteUser(user)
        }
        val itemCallBack = ItemTouchHelper(swipeCallBack)
        itemCallBack.attachToRecyclerView(recyclerView)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && (
                            recyclerView.layoutManager
                                    as LinearLayoutManager
                            ).findLastCompletelyVisibleItemPosition() == chatList.size - 1
                ) {

                    loaderChat.copy()
                }
            }
        })
    }

    override fun onStop() {
        super.onStop()
        loaderChat.removeListener(usersListener)
    }
}
