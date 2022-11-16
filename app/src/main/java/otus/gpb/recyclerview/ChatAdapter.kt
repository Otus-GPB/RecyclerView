package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter : ListAdapter<Chat, ChatItemViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.regular_item, parent, false)
        return ChatItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ChatItemViewHolder, position: Int) {
        val content = currentList[holder.adapterPosition]
        holder.populate(content)
    }
}

class ChatItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun populate(chat: Chat) {
        (itemView as ChatView).populate(chat)
    }
}

class DiffCallBack : ItemCallback<Chat>() {

    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}

