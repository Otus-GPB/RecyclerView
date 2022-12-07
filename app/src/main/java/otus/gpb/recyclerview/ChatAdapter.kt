package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import java.lang.RuntimeException


class ChatAdapter: ListAdapter<ChatItem, ChatHolder>(
    ChatItemDiffCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val layoutId = when(viewType){
            WITH_TITLE -> R.layout.item_prewiew_title
            WITHOUT_TITLE -> R.layout.item_preview
            else -> throw RuntimeException("Unknown type $viewType")
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false )

        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        val chatItem = getItem(position)

        holder.tvUserName.text = chatItem.userName
        holder.tvMessage.text = chatItem.message
        holder.tvTime.text = chatItem.time
        if(chatItem.title != ChatItem.NO_TITLE){
            holder.tvTitle.text = chatItem.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).title == ChatItem.NO_TITLE){
            WITHOUT_TITLE
        }else{
            WITH_TITLE
        }
    }
    companion object{
        const val WITH_TITLE = 0
        const val WITHOUT_TITLE = 5
    }
}