package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import otus.gpb.recyclerview.model.Chat

class ChatAdapter : RecyclerView.Adapter<ChatViewHolder>() {

    private val items: MutableList<Chat> = mutableListOf()

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun populateItems(list: MutableList<Chat>) {
        items.clear()
        items.addAll(list)
        notifyItemRangeInserted(0, items.size - 1)
    }

    fun addItems(list: MutableList<Chat>) {
        items.addAll(list)
        notifyItemRangeInserted(items.size - 1, list.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val content = items[holder.adapterPosition]
        holder.populate(content)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ChatViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val name = view.findViewById<TextView>(R.id.chat_name_tx)
    private val sender = view.findViewById<TextView>(R.id.sender_name_tx)
    private val message = view.findViewById<TextView>(R.id.message_text_tx)
    private val dateTime = view.findViewById<TextView>(R.id.message_date_tx)
    private val avatar = view.findViewById<ShapeableImageView>(R.id.avatar_im)
    private val messageImage = view.findViewById<ShapeableImageView>(R.id.message_img_im)
    private val verified = view.findViewById<ImageView>(R.id.verified_im)
    private val muted = view.findViewById<ImageView>(R.id.muted_im)
    private val scam = view.findViewById<ImageView>(R.id.scam_im)
    private val messageStatus = view.findViewById<ImageView>(R.id.message_status_im)
    private val countMessagesFrame = view.findViewById<FrameLayout>(R.id.message_count_ly)
    private val countMessages = view.findViewById<TextView>(R.id.message_count_tx)

    fun populate(chat: Chat) {
        name.text = chat.name
        if (chat.sender != "") {
            sender.visibility = View.VISIBLE
            sender.text = chat.sender
        } else {
            sender.visibility = View.GONE
        }
        message.text = chat.message
        dateTime.text = chat.dateTime
        avatar.setImageResource(chat.chatImage)
        if (chat.messageImage != 0) {
            messageImage.visibility = View.VISIBLE
            messageImage.setImageResource(chat.messageImage)
        } else {
            messageImage.visibility = View.GONE
        }
        if (!chat.isVerified) verified.visibility = View.GONE else verified.visibility = View.VISIBLE
        if (!chat.isMuted) muted.visibility = View.GONE else muted.visibility = View.VISIBLE
        if (!chat.isScam) scam.visibility = View.GONE else scam.visibility = View.VISIBLE
        when (chat.status) {
            2 -> messageStatus.setImageDrawable(
                ContextCompat.getDrawable(
                    view.context,
                    R.drawable.status2
                )
            )
            3 -> messageStatus.setImageDrawable(
                ContextCompat.getDrawable(
                    view.context,
                    R.drawable.status3
                )
            )
        }
        if (chat.countMessages > 0) {
            countMessages.text = if (chat.countMessages > 9) "9+" else chat.countMessages.toString()
        } else {
            countMessagesFrame.visibility = View.GONE
        }
    }

}