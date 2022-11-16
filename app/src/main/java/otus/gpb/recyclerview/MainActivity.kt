package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.databinding.ActivityMainBinding
import otus.gpb.recyclerview.repository.ConversationRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val repo = ConversationRepository()
    private val conversationAdapter = ConversationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
    }

    private fun initRecycler() {
        with(binding.recyclerView) {
            adapter = conversationAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            ContextCompat.getDrawable(this@MainActivity, R.drawable.item_divider)?.let {
                addItemDecoration(CustomItemDecoration(it))
            }

            val swipeToDeleteCallback = object : SwipeToDeleteListener(this@MainActivity) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    conversationAdapter.removeItem(viewHolder.adapterPosition)
                }
            }

            ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(this)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 &&
                        (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                        == conversationAdapter.itemCount - 1
                    ) {
                        conversationAdapter.addItems(repo.getItems())
                    }
                }
            })
        }
        conversationAdapter.submitList(repo.getItems())
    }
}
