package otus.gpb.recyclerview.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.R
import otus.gpb.recyclerview.databinding.ChatItemBinding
import otus.gpb.recyclerview.model.Chat
import otus.gpb.recyclerview.model.GroupChat
import otus.gpb.recyclerview.model.UserChat

private const val USER_CHAT = 1
private const val GROUP_CHAT = 2

class ChatAdapter : ListAdapter<Chat, RecyclerView.ViewHolder>(ChatDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            USER_CHAT -> {
                UserChatViewHolder(
                    ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            GROUP_CHAT -> {
                GroupChatViewHolder(
                    ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserChatViewHolder -> {
                holder.bind(getItem(position) as UserChat)
            }
            is GroupChatViewHolder -> {
                holder.bind(getItem(position) as GroupChat)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is UserChat -> USER_CHAT
            is GroupChat -> GROUP_CHAT
        }
    }
}

class UserChatViewHolder(private val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(chat: UserChat) {
        val isReadSrc = if (chat.message.isRead) R.drawable.read else R.drawable.unread
        binding.apply {
            chat.avatar?.let { avatar.setImageResource(it) }
            title.text = chat.title
            chatUserName.visibility = View.GONE
            messageLayout.visibility = View.GONE
            message.text = chat.message.text
            verified.visibility = if (chat.isVerified) View.VISIBLE else View.GONE
            muted.visibility = if (chat.isMuted) View.VISIBLE else View.GONE
            scam.visibility = if (chat.isScam) View.VISIBLE else View.GONE
            readStatus.visibility = View.VISIBLE
            readStatus.setImageResource(isReadSrc)
            date.text = chat.message.date
            messageCount.visibility = View.GONE
        }
    }
}

class GroupChatViewHolder(private val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(chat: GroupChat) {
        val chatMessageLayout = chat.message.layout
        binding.apply {
            chat.avatar?.let { avatar.setImageResource(it) }
            title.text = chat.title
            chatUserName.visibility = View.VISIBLE
            chatUserName.text = chat.message.sender.name
            messageLayout.visibility = View.VISIBLE
            message.text = chat.message.text
            if (chatMessageLayout != null) {
                messageLayout.visibility = View.VISIBLE
                messageLayout.setImageResource(chatMessageLayout)
            } else {
                messageLayout.visibility = View.GONE
            }
            verified.visibility = if (chat.isVerified) View.VISIBLE else View.GONE
            muted.visibility = if (chat.isMuted) View.VISIBLE else View.GONE
            scam.visibility = if (chat.isScam) View.VISIBLE else View.GONE
            readStatus.visibility = View.GONE
            date.text = chat.message.date
            if (chat.unreadCount > 0) {
                messageCount.visibility = View.VISIBLE
                messageCount.text = chat.unreadCount.toString()
            } else {
                messageCount.visibility = View.GONE
            }
        }
    }
}

class ChatDiffUtil : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}