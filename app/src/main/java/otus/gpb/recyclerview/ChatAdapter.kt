package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatAdapter: ListAdapter<Chat, ChatViewHolder>(ChatDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val content = getItem(position)
        holder.populate(content)
    }
}

class ChatViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private var userPic = view.findViewById<ImageView>(R.id.user_pic)
    private var userName = view.findViewById<TextView>(R.id.user_name)
    private var message = view.findViewById<TextView>(R.id.message)
    private var date = view.findViewById<TextView>(R.id.date)


    fun populate(chat: Chat) {
        userName.text = chat.name
        message.text = chat.message
        date.text = chat.dateTime

        Glide.with(view)
            .load(chat.picture)
            .placeholder(R.drawable.ava_pic)
            .into(userPic)
    }
}