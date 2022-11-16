package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
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
        }
        conversationAdapter.submitList(repo.getItems())
    }
}
