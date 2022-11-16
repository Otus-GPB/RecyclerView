package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.databinding.LayoutConversationItemBinding
import otus.gpb.recyclerview.extensions.visible
import otus.gpb.recyclerview.model.Conversation
import java.text.SimpleDateFormat

class ConversationAdapter : ListAdapter<Conversation, ConversationAdapter.ConversationViewHolder>(DiffCallback) {
    private lateinit var layoutInflater: LayoutInflater

    private object DiffCallback : DiffUtil.ItemCallback<Conversation>() {
        override fun areItemsTheSame(oldItem: Conversation, newItem: Conversation) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Conversation, newItem: Conversation) =
            oldItem == newItem
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    class ConversationViewHolder(private val binding: LayoutConversationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val dateFormat = SimpleDateFormat("HH:mm")

        fun bind(item: Conversation) {
            with(binding) {
                textViewUsername.text = item.username
                textViewTime.text = item.lastMessage?.time?.let { dateFormat.format(it) }
                imageAvatar.setImageResource(item.userAvatar ?: 0)
                textViewCount.text = item.newMessagesCount.toString()
                textViewCount.visible(item.newMessagesCount > 0)
                textViewMessage.text = item.lastMessage?.text.orEmpty()
                textViewUserDetails.text = item.userDetails
                textViewUserDetails.visible(!item.userDetails.isNullOrBlank())
                imageMuted.visible(item.isMuted)
                imageScam.visible(item.isScam)
                imageRead.setImageResource(if (item.lastMessage?.isRead == true) R.drawable.ic_readed else R.drawable.ic_recieved)
                imageRead.visible(item.lastMessage?.isMine == true)
                imagePreview.visible(item.lastMessage?.image != null)
                imagePreview.setImageResource(item.lastMessage?.image ?: 0)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder =
        ConversationViewHolder(LayoutConversationItemBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        holder.bind(getItem(holder.adapterPosition))
    }

    fun removeItem(position: Int) {
        val items = currentList.toMutableList().apply {
            removeAt(position)
        }
       submitList(items)
    }

    fun addItems(items: List<Conversation>) {
        val list = currentList.toMutableList().apply {
            addAll(items)
        }
        submitList(list)
    }
}
