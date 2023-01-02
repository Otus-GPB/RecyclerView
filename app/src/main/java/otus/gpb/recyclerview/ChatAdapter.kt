package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.databinding.ChatItemBinding

class ChatDiffCallback : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}

class ChatAdapter : ListAdapter<Chat, ChatViewHolder>(ChatDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(list: MutableList<Chat>) {
        val newList = currentList.toMutableList().apply { addAll(list) }
        submitList(newList)
    }

    fun deleteItem(position: Int) {
        val newList = currentList.toMutableList().apply { removeAt(position) }
        submitList(newList)
    }

}

class ChatViewHolder(private val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(chat: Chat) {
        binding.apply {
            //постоянные поля
            chatImage.setImageResource(chat.userPhoto)
            chatTitle.text = chat.userName
            messageDate.text = chat.messageTime
            messagePreview.text = chat.messageText

            //дополнительные иконки
            if (chat.isMuted) imageMute.visibility = View.VISIBLE else imageMute.visibility = View.GONE
            if (chat.isOfficial) imageOfficial.visibility = View.VISIBLE else imageOfficial.visibility = View.GONE
            if (chat.isScam) imageScam.visibility = View.VISIBLE else imageScam.visibility = View.GONE

            //информация о сообщении
            chatDetails.text = chat.userDetails
            chatDetails.visibility = if (chatDetails.text == "") View.GONE else View.VISIBLE
            messageImagePreview.setImageResource(chat.messagePhoto)
            messageImagePreview.visibility = if (chat.messagePhoto == 0) View.GONE else View.VISIBLE
            iconRead.visibility = if (chat.isRead) View.VISIBLE else View.GONE
            messageCount.text = chat.newMessageCount.toString()
            messageCount.visibility = if (chat.newMessageCount == 0) View.GONE else View.VISIBLE

        }
    }
}
