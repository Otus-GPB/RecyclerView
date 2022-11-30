package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter : RecyclerView.Adapter<ChatViewHolder>() {

    private val items: MutableList<Chat> = ListGenerator().generate().toMutableList()

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_item, parent, false)
        return ChatViewHolder(view as ChatView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val content = items[holder.adapterPosition]
        holder.populate(content)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ChatViewHolder(private val view: ChatView) : RecyclerView.ViewHolder(view) {

    fun populate(chat: Chat) {
        view.populate(chat)
    }
}


