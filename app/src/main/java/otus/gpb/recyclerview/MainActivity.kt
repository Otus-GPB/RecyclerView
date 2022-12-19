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

    var isLastPage: Boolean = false
    var isLoading: Boolean = false

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
        val myLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        rvChatList.layoutManager = myLayoutManager
        rvChatList.addItemDecoration(
            ItemDecoration(
            ContextCompat.getDrawable(this, R.drawable.line)!!,
                false
            )
        )

        setupSwipeListener(rvChatList)

        rvChatList.addOnScrollListener(
            object : PaginationScrollListener(myLayoutManager) {

                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

                override fun loadMoreItems() {
                    isLoading = true
                    viewModel.generate()
                    isLoading = false
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