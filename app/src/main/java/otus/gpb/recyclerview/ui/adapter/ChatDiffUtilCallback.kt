package otus.gpb.recyclerview.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import otus.gpb.recyclerview.model.Chat

class ChatDiffUtilCallback: DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean = oldItem == newItem
}