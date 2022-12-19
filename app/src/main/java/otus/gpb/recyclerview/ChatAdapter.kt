package otus.gpb.recyclerview

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginStart
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.model.Chat

class ChatAdapter() : ListAdapter<Chat, ChatAdapter.ChatViewHolder>(ChatDiffCallback) {
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var chatName: TextView = itemView.findViewById(R.id.chat_name)
        private var avatarImageView: ImageView = itemView.findViewById(R.id.avatar)
        private var verifiedImageView: ImageView = itemView.findViewById(R.id.verified_icon)
        private var muteImageView: ImageView = itemView.findViewById(R.id.mute_icon)
        private var scamImageView: ImageView = itemView.findViewById(R.id.scam_icon)
        private var messageStatusImageView: ImageView = itemView.findViewById(R.id.send_message_status_icon)
        private var dateTextView: TextView = itemView.findViewById(R.id.date_time)
        private var messageAuthorTextView: TextView = itemView.findViewById(R.id.message_author)
        private var previewImageView: ImageView = itemView.findViewById(R.id.preview_image)
        private var messageTextView: TextView = itemView.findViewById(R.id.message_text)
        private var messageCountTextView: TextView = itemView.findViewById(R.id.count_text)

        fun bind(chat: Chat){
            chatName.text = chat.chatName
            avatarImageView.setImageResource(chat.avatar)
            if (!chat.isVerified){
                verifiedImageView.visibility = View.GONE
            }
            if (!chat.isScam){
                scamImageView.visibility = View.GONE
            }
            if (!chat.isMuted){
                muteImageView.visibility = View.GONE
            }
            if(chat.unreadMessageCount == 0){
                messageCountTextView.visibility = View.GONE
            } else{
                messageCountTextView.text = chat.unreadMessageCount.toString()
            }
            if (chat.messageAuthor != null){
                messageAuthorTextView.text = chat.messageAuthor
            }else{
                messageAuthorTextView.visibility = View.GONE
            }
            messageTextView.text = chat.lastMessage.text
            if (chat.lastMessage.image != null){
                previewImageView.setImageResource(chat.lastMessage.image)
            } else{
                previewImageView.visibility = View.GONE
            }
            dateTextView.text = chat.lastMessage.time
            if (!chat.lastMessage.isIncoming){
                if (chat.lastMessage.isRead){
                    messageStatusImageView.setImageResource(R.drawable.read)
                }else{
                    messageStatusImageView.setImageResource(R.drawable.send)
                }
            }

        }



    }
    object ChatDiffCallback : DiffUtil.ItemCallback<Chat>() {
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = getItem(position)
        holder.bind(chat)
    }
}


