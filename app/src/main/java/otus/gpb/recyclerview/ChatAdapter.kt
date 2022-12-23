package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ChatAdapter : RecyclerView.Adapter<ChatViewHolder>() {

    private val chatList = mutableListOf<Chat>()

    fun createChatList(list: MutableList<Chat>){
        chatList.addAll(list)
        notifyItemRangeInserted(0, chatList.size - 1)
    }
    override fun getItemCount(): Int = chatList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder =
        ChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        )

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val currentItem = chatList[position]
        holder.createItem(currentItem)
    }



}
//внести потом обратно в класс
class ChatViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val userName = view.findViewById<TextView>(R.id.chat_title)
    private val chatDetails = view.findViewById<TextView>(R.id.chat_details)
    private val messageText = view.findViewById<TextView>(R.id.message_preview)
    private val messageTime = view.findViewById<TextView>(R.id.message_date)
    private val userPhoto = view.findViewById<ImageView>(R.id.chat_image)
    private val messagePhoto = view.findViewById<ImageView>(R.id.message_image_preview)
    private val isOfficial = view.findViewById<ImageView>(R.id.image_official)
    private val isMuted = view.findViewById<ImageView>(R.id.image_mute)
    private val isScam = view.findViewById<ImageView>(R.id.image_scam)
    private val isRead = view.findViewById<ImageView>(R.id.icon_read)
    private val newMessagesCount = view.findViewById<TextView>(R.id.messages_count)

    fun createItem(chat: Chat) {
        // постоянные поля
        userName.text = chat.userName
        messageText.text = chat.messageText
        messageTime.text = chat.messageTime
        userPhoto.setImageResource(chat.userPhoto) // добавить потом картинки

        // дополнительные иконки
        if (chat.isMuted) isMuted.visibility = View.VISIBLE else isMuted.visibility = View.GONE
        if (chat.isOfficial) isOfficial.visibility = View.VISIBLE else isOfficial.visibility = View.GONE
        if (chat.isScam) isScam.visibility = View.VISIBLE else isScam.visibility = View.GONE

        // информация о сообщении
        if (chat.userDetails != "") {
            chatDetails.visibility = View.VISIBLE
            chatDetails.text = chat.userDetails
        } else {
            chatDetails.visibility = View.GONE
        }

        if (chat.messagePhoto != 0) {
            messagePhoto.visibility = View.VISIBLE
            messagePhoto.setImageResource(chat.messagePhoto)
        } else {
            messagePhoto.visibility = View.GONE
        }

        if (chat.newMessageCount == 0) {
            newMessagesCount.visibility = View.GONE
        } else {
            newMessagesCount.text = chat.newMessageCount.toString()
        }

        if (chat.isRead) isRead.visibility = View.VISIBLE else isRead.visibility = View.GONE

    }

}
