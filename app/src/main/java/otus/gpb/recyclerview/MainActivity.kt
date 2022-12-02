package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ChatAdapter()

        adapter.submitList(Generator.generate())

        recycler.addItemDecoration(
            TelegramItemDecoration(this, TelegramItemDecoration.VERTICAL, 20, 0)
        )

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        val swipeToDeleteCallback = object : SwipeToDeleteCallBack(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val currentList = adapter.currentList.toMutableList()
                currentList.removeAt(viewHolder.adapterPosition)
                adapter.submitList(currentList)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recycler)

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                super.onScrolled(recyclerView, dx, dy)

                val tempLayout = recycler.layoutManager as LinearLayoutManager
                if (dy >= 0 && tempLayout.findLastVisibleItemPosition() >= tempLayout.itemCount - 1) {

                    val newItemsMain = mutableListOf<Chat>()
                    newItemsMain.addAll(adapter.currentList)
                    newItemsMain.addAll(Generator.generate2())
                    adapter.submitList(newItemsMain)
                }
            }
        })
    }
}