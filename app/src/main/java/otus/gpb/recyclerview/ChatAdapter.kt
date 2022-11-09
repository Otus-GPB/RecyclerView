package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import otus.gpb.recyclerview.databinding.ChatRecyclerItemBinding

class ChatDiffUtilCallBack(private val oldList: List<Chat>, private val newList: List<Chat>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser == newUser
    }
}

class ChatAdapter :
    RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    var usersChat = listOf<Chat>()
        set(value) {
            val diffCallBack = ChatDiffUtilCallBack(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallBack)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // создает макет элемента списка
        val inflater = LayoutInflater.from(parent.context)
        val binding = ChatRecyclerItemBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // нужен для обновления элемента списка
        initChatList(holder)
    }

    override fun getItemCount(): Int = usersChat.size

    fun initChatList(holder: MyViewHolder) {
        val user = usersChat[holder.bindingAdapterPosition]
        with(holder.binding) {
            userName.text = user.userName
            msgTime.text = user.msgTime

            if (user.userDetails == null) {
                userDetails.visibility = View.INVISIBLE
            } else {
                userDetails.visibility = View.VISIBLE
                userDetails.text = user.userDetails
            }
            if (user.msgText == null) {
                msgText.visibility = View.INVISIBLE
            } else {
                msgText.visibility = View.VISIBLE
                msgText.text = user.msgText
            }
            if (user.msgGetCount == 0) {
                msgGetCount.visibility = View.GONE
            } else {
                msgGetCount.visibility = View.VISIBLE
                msgGetCount.text = user.msgGetCount.toString()
            }
            if (user.isVerifity) {
                icVerifity.visibility = View.VISIBLE
            } else {
                icVerifity.visibility = View.GONE
            }
            if (user.isNotVoice) {
                icVoice.visibility = View.VISIBLE
            } else {
                icVoice.visibility = View.GONE
            }
            if (user.isScam) {
                icScam.visibility = View.VISIBLE
            } else {
                icScam.visibility = View.GONE
            }
            if (user.msgImage == null) {
                msgImage.visibility = View.GONE
            } else {
                Glide.with(msgImage.context)
                    .load(user.msgImage)
                    .fitCenter()
                    .placeholder(R.drawable.ic_basemsg_photo)
                    .error(R.drawable.ic_basemsg_photo)
                    .into(msgImage)
            }
            Glide.with(avatar.context)
                .load(user.userAvatar)
                .circleCrop()
                .placeholder(R.drawable.ic_account_base)
                .error(R.drawable.ic_account_base)
                .into(avatar)
        }
    }

    class MyViewHolder(val binding: ChatRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
