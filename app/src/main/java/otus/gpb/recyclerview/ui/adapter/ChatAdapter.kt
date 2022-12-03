package otus.gpb.recyclerview.ui.adapter

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.R
import otus.gpb.recyclerview.model.*
import otus.gpb.recyclerview.utils.DateHelper
import otus.gpb.recyclerview.utils.visibility

class ChatAdapter(
    private val currentUserId: Long
    ): ListAdapter<Chat, ChatViewHolder>(ChatDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(currentList[position], currentUserId)
    }
}

class ChatViewHolder(
    itemView: View
): RecyclerView.ViewHolder(itemView) {
    private var chatImage: ImageView
    private var chatTitle: TextView
    private var chatLastSender: TextView
    private var chatLastMessage: TextView
    private var chatAttachmentPreview: ImageView
    private var chatIconOfficial: ImageView
    private var chatIconMuted: ImageView
    private var chatIconScam: ImageView
    private var chatLastMessageTime: TextView
    private var chatReadMarker: ImageView
    private var chatMessagesCounter: TextView
    private var chatMessagesCounterBg: ImageView

    init {
        itemView.apply {
            chatImage = findViewById(R.id.chat_image)
            chatTitle = findViewById(R.id.chat_title)
            chatLastSender = findViewById(R.id.chat_last_sender)
            chatLastMessage = findViewById(R.id.chat_last_message)
            chatAttachmentPreview = findViewById(R.id.chat_attachment_preview)
            chatIconOfficial = findViewById(R.id.chat_icon_official)
            chatIconMuted = findViewById(R.id.chat_icon_muted)
            chatIconScam = findViewById(R.id.chat_icon_scam)
            chatLastMessageTime = findViewById(R.id.chat_last_message_time)
            chatReadMarker = findViewById(R.id.chat_read_marker)
            chatMessagesCounter = findViewById(R.id.chat_messages_counter)
            chatMessagesCounterBg = findViewById(R.id.chat_messages_counter_bg)
        }
    }

    fun bind(chat: Chat, currentUserId: Long) {
        // Т.к. RecyclerView в процессе работы переиспользует ViewHolder, выставляем оба состояния
        chatIconMuted.visibility = chat.isMuted.visibility()
        chatIconScam.visibility = chat.isScam.visibility()
        chatIconOfficial.visibility = chat.isOfficial.visibility()
        chatLastMessage.text = chat.lastMessage.text
        chatLastMessageTime.text = DateHelper.dateToText(chat.lastMessage.sendTime)
        chat.lastMessage.attachments.apply {
            if (isNotEmpty()) {
                forEach { a ->
                    if (a.attachmentType == AttachmentType.IMAGE) {
                        chatAttachmentPreview.visibility = View.VISIBLE
                        chatLastMessage.updateLayoutParams<ConstraintLayout.LayoutParams> {
                            marginStart = (8 * itemView.context.resources.displayMetrics.density).toInt()
                        }
                        chatAttachmentPreview.setImageResource(a.resourceId)
                        return@forEach
                    }
                }
            } else {
                chatAttachmentPreview.visibility = View.GONE
                chatLastMessage.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    marginStart = 0
                }
            }
        }
        chat.lastMessage.apply {
            if (sender.id == currentUserId) {
                chatReadMarker.visibility = View.VISIBLE
                when{
                    (readStatus == ReadStatus.SENT) -> chatReadMarker.setImageResource(R.drawable.ic_single_tick)
                    (readStatus == ReadStatus.READ) -> chatReadMarker.setImageResource(R.drawable.ic_double_tick)
                }
            } else {
                chatReadMarker.visibility = View.GONE
            }
        }
        chatMessagesCounter.text = "1"

        when (chat) {
            is SingleUser -> {
                chatTitle.text = chat.user.name
                chatImage.setImageResource(chat.user.avatarResourceId)
                chatLastSender.visibility = View.GONE
            }
            is Dialogue -> {
                chatTitle.text = chat.name
                chatImage.setImageResource(chat.pictureResourceId)
                if (chat.lastMessage.sender.id == currentUserId) {
                    chatLastSender.visibility = View.VISIBLE
                    chatLastSender.text = chat.lastMessage.sender.name
                } else { chatLastSender.visibility = View.GONE }
            }
        }
    }
}