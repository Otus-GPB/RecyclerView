package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val chatAdapter = ChatAdapter()
        recyclerView.adapter = chatAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        chatAdapter.createChatList(generateRandomChatList())

        ContextCompat.getDrawable(this, R
            .drawable.divider)?.let { CustomChatDecorator(it) }
            ?.let { recyclerView.addItemDecoration(it) }

        val swipeToDeleteCallback = object : SwipeToDeleteListener(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                chatAdapter.deleteItem(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
