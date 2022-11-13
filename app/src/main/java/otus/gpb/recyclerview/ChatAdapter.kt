package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val dataSet: List<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar: ImageView
        val title: TextView
        val additionalInfo: TextView
        val lastMessage: TextView
        val dateTime: TextView
        val isScam: ImageView
        val isOfficial: ImageView
        val isMuted: ImageView
        val sended: ImageView
        val unreadCounter: TextView

        init {
            avatar = view.findViewById(R.id.avatar)
            title = view.findViewById(R.id.title)
            additionalInfo = view.findViewById(R.id.additionalInfo)
            isScam = view.findViewById(R.id.scam)
            lastMessage = view.findViewById(R.id.lastMessage)
            dateTime = view.findViewById(R.id.dateTime)
            isOfficial = view.findViewById(R.id.trusted)
            isMuted = view.findViewById(R.id.muted)
            sended = view.findViewById(R.id.sended)
            unreadCounter = view.findViewById(R.id.count)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val element = dataSet[position]

            title.text = element.nickname
            lastMessage.text = element.lastMessage
            dateTime.text = element.dateTime

            avatar.setImageResource(element.image ?: R.drawable.ic_launcher_background)
            val additionalInfoValue = element.additionalInfo
            if (additionalInfoValue == null) {
                additionalInfo.text = ""
                additionalInfo.visibility = View.GONE
            } else {
                additionalInfo.text = additionalInfoValue
                additionalInfo.visibility = View.VISIBLE

            }

            isScam.visibility = checkAndSetVisibility (element.isScam)
            isOfficial.visibility = checkAndSetVisibility (element.isOfficial)
            isMuted.visibility = checkAndSetVisibility (element.isMuted)
            val unreadCounterValue = element.unreadCounter
            if (unreadCounterValue > 0) {
                unreadCounter.text = unreadCounterValue.toString()
                unreadCounter.visibility = View.VISIBLE
            } else {
                unreadCounter.text = ""
                unreadCounter.visibility = View.GONE
            }
            when (element.messageStatus) {
                MessageStatus.NONE -> sended.setImageDrawable(null)
                MessageStatus.SENDED -> sended.setImageResource(R.drawable.ic_sended)
                MessageStatus.READ -> sended.setImageResource(R.drawable.ic_read)
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size

    private fun checkAndSetVisibility(value: Boolean) =
        if (value) {
            View.VISIBLE
        } else {
            View.GONE
        }
}