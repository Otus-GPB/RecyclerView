package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter


class ChatAdapter: ListAdapter<ChatItem, ChatHolder>(
    ChatItemDiffCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prewiew_message, parent, false )
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        val chatItem = getItem(position)

        holder.tvUserName.text = chatItem.userName
        holder.tvMessage.text = chatItem.message
        holder.tvTime.text = chatItem.time

        if(chatItem.title != ChatItem.NO_TITLE){
            holder.tvTitle.text = chatItem.title
        }else{
            holder.tvTitle.visibility = View.GONE
        }

        if(chatItem.isVolume){
            holder.imageViewVolume.visibility = View.GONE
        }else{
            holder.imageViewVolume.visibility = View.VISIBLE
        }

        if(!chatItem.isMark){
            holder.imageViewMark.visibility = View.GONE
        }else{
            holder.imageViewMark.visibility = View.VISIBLE
        }

        if(chatItem.isRead){
            holder.imageViewRead.visibility = View.GONE
        }else{
            holder.imageViewRead.visibility = View.VISIBLE
        }
        holder.imageViewUrl.setImageResource(chatItem.imageUrl ?: DEFAULT_URL)
    }

    companion object{
        const val DEFAULT_URL = R.drawable.img_4
    }
}