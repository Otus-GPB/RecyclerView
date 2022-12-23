package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}
