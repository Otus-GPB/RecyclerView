package otus.gpb.recyclerview

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.google.android.material.divider.MaterialDividerItemDecoration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)

        recycler.layoutManager = layoutManager
        recycler.addItemDecoration(createDivider(this, layoutManager))
        recycler.addOnScrollListener(createOnScrollListener())
        recycler.adapter = ChatAdapter(generateChat())
    }

    private fun createOnScrollListener(): OnScrollListener = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0 && (recyclerView.layoutManager as LinearLayoutManager)
                    .findLastCompletelyVisibleItemPosition() ==
                (recyclerView.layoutManager as LinearLayoutManager).itemCount - 3
            ) {
                (recyclerView.adapter as ChatAdapter).addItems(generateChat())
            }
        }
    }

    private fun createDivider(
        context: Context,
        layoutManager: LinearLayoutManager
    ): RecyclerView.ItemDecoration {
        val dividerItemDecoration = MaterialDividerItemDecoration(
            context,
            layoutManager.orientation
        )

        dividerItemDecoration.setDividerInsetStartResource(this, R.dimen.divider_offset)
        dividerItemDecoration.setDividerColorResource(this, R.color.light_grey)
        dividerItemDecoration.setDividerThicknessResource(this, R.dimen.divider_thickness)

        return dividerItemDecoration
    }

    private fun generateChat(): List<Chat> =
        listOf(
            Chat(
                nickname = "Pizza",
                image = R.drawable.ic_pizza,
                additionalInfo = "jija",
                lastMessage = "Yes, they are necessary",
                isMuted = true,
                dateTime = "11:38 AM"
            ),
            Chat(
                nickname = "Elon",
                lastMessage = "I love /r/Reddit!",
                isMuted = true,
                dateTime = "12:44 AM",
                image = R.drawable.ic_elon_avatar,
            ),
            Chat(
                nickname = "Pasha",
                lastMessage = "How are u?",
                isOfficial = true,
                isMuted = true,
                dateTime = "Fri",
                image = R.drawable.ic_pasha_avatar
            ),
            Chat(
                nickname = "Empty",
                lastMessage = "",
                dateTime = "Thu",
                messageStatus = MessageStatus.READ
            ),
            Chat(
                nickname = "Telegram Support",
                additionalInfo = "Support",
                lastMessage = "Yes it happened.",
                isOfficial = true,
                dateTime = "Thu",
                unreadCounter = 1,
                image = R.drawable.ic_tg_avatar
            ),
            Chat(
                nickname = "Karina",
                lastMessage = "Okay",
                dateTime = "Wed",
                messageStatus = MessageStatus.SENDED,
                image = R.drawable.ic_karina_avatar
            ),
            Chat(
                nickname = "Marilyn",
                isScam = true,
                lastMessage = "Will it ever happen",
                dateTime = "May 02",
                messageStatus = MessageStatus.READ,
                image = R.drawable.ic_marilyn_avatar
            ),
            Chat(
                nickname = "Empty",
                lastMessage = "",
                dateTime = "Wed",
                messageStatus = MessageStatus.NONE
            ),
            Chat(
                nickname = "Empty",
                lastMessage = "",
                dateTime = "Thu",
                messageStatus = MessageStatus.READ
            ),
            Chat(
                nickname = "Empty",
                lastMessage = "",
                dateTime = "Fri",
                messageStatus = MessageStatus.SENDED
            )
        )
}