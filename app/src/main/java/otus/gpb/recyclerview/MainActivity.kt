package otus.gpb.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.model.generateItemList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // инициализация recycler
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ChatAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        adapter.populateItems(generateItemList())

        // декоратор
        recycler.addItemDecoration(
            ChatItemDecorator(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.chat_item_divider
                )!!
            )
        )

        // archive
        val swipeToArchiveCallback = object : ChatSwipeToArchiveCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.removeItem(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToArchiveCallback)
        itemTouchHelper.attachToRecyclerView(recycler)

        // pagination
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && (recycler.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == (recycler.layoutManager as LinearLayoutManager).itemCount - 1) {
                    adapter.addItems(generateItemList())
                }
            }
        })


    }
}