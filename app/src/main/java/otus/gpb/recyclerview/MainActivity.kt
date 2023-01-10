package otus.gpb.recyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.divider.MaterialDividerItemDecoration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ChatAdapter()
        val item = ChatItem()

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        adapter.submitList(item.chatItem())
        recycler.addItemDecoration(createDivider(this, LinearLayoutManager(this)))

        val swipeToDeleteCallback: SwipeToDeleteCallback = object: SwipeToDeleteCallback(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                item.remove(viewHolder.adapterPosition)
                adapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recycler)

        recycler.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0 && (recycler.layoutManager as LinearLayoutManager)
                        .findLastCompletelyVisibleItemPosition() == (recycler.layoutManager
                            as LinearLayoutManager).itemCount - 1) {
                    item.addAll(item.chatItem())
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    fun createDivider(
        context: Context, layoutManager: LinearLayoutManager
    ): RecyclerView.ItemDecoration {
        val dividerItemDecoration = MaterialDividerItemDecoration(context, layoutManager.orientation
        )
        dividerItemDecoration.setDividerInsetStartResource(this, R.dimen.divider_offset)
        dividerItemDecoration.setDividerColorResource(this, R.color.light_grey)
        dividerItemDecoration.setDividerThicknessResource(this, R.dimen.divider_thickness)

        return dividerItemDecoration
    }
}