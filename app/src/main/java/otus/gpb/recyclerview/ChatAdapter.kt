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
    private var author = view.findViewById<TextView>(R.id.name)
    private var message = view.findViewById<TextView>(R.id.message)
    private var date = view.findViewById<TextView>(R.id.date)
    private var avatar = view.findViewById<ImageView>(R.id.avatar)
    private var verified = view.findViewById<ImageView>(R.id.verified)
    private var mute = view.findViewById<ImageView>(R.id.mute)
    private var done = view.findViewById<ImageView>(R.id.done)
    private var description = view.findViewById<TextView>(R.id.description)

    fun populate(chat: Chat) {
        author.text = chat.name
        message.text = chat.message
        date.text = chat.date

        Glide.with(view)
            .load(chat.avatar)
            .error(R.drawable.person)
            .into(avatar)

        if (chat.isVerified) {
            verified.visibility = View.VISIBLE
        } else {
            verified.visibility = View.GONE
        }

        if (chat.isMute) {
            mute.visibility = View.VISIBLE
        } else {
            mute.visibility = View.GONE
        }

        if (chat.isDone) {
            done.visibility = View.VISIBLE
        } else {
            done.visibility = View.GONE
        }

        if (chat.description.isNullOrEmpty()) {
            description.visibility = View.GONE
        } else {
            description.visibility = View.VISIBLE
            description.text = chat.description
        }
    }
}