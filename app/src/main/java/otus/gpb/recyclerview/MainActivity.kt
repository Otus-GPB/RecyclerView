package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.model.Chat
import otus.gpb.recyclerview.repository.ChatRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val repository = ChatRepository()
        val chatList: MutableList<Chat> = repository.generateChatList().toMutableList()
        val chatAdapter = ChatAdapter()
        recyclerView.adapter = chatAdapter
        chatAdapter.submitList(chatList)


        val callback = object : SwipeToDeleteCallback(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                chatList.removeAt(viewHolder.adapterPosition)
                chatAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        val drawable = AppCompatResources.getDrawable(this,R.drawable.divider_draweble)
        if (drawable != null){
            recyclerView.addItemDecoration(CustomDecoration(drawable))
        }
        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val recyclerManager = recyclerView.layoutManager as LinearLayoutManager
                if (dy > 0 && (recyclerManager.findLastCompletelyVisibleItemPosition() == recyclerManager.itemCount - 1)){
                    val index = chatList.lastIndex + 1
                    chatList.addAll(repository.generateChatList())
                    chatAdapter.notifyDataSetChanged()


                }

            }
        })


    }
}