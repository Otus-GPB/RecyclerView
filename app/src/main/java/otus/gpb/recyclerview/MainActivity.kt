package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
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
    }

    private fun setupRecyclerView() {
        val rvChatList = findViewById<RecyclerView>(R.id.recyclerView)
        chatListAdapter = ChatAdapter()
        rvChatList.adapter = chatListAdapter

    }
}