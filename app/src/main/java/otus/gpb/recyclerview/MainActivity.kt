package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var chatListAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.chatList.observe(this){
            chatListAdapter.submitList(it)
        }
        viewModel.generate()
    }

    private fun setupRecyclerView() {
        val rvChatList = findViewById<RecyclerView>(R.id.recyclerView)
        chatListAdapter = ChatAdapter()
        rvChatList.adapter = chatListAdapter
        rvChatList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        rvChatList.addItemDecoration(
            ItemDecoration(
            ContextCompat.getDrawable(this, R.drawable.line)!!,
                false
            )
        )

        setupSwipeListener(rvChatList)
        rvChatList.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 && (rvChatList.layoutManager as LinearLayoutManager)
                            .findLastCompletelyVisibleItemPosition() ==
                        (rvChatList.layoutManager as LinearLayoutManager).itemCount - 1
                    ) {
                        viewModel.generate()
                    }
                }
            }
        )
    }

    private fun setupSwipeListener(rvShopList: RecyclerView?) {
        val swipeToDeleteCallback = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = chatListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteChatItem(item)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

}