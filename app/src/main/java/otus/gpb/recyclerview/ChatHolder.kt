package otus.gpb.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvUserName = view.findViewById<TextView>(R.id.textViewName)
    val tvTitle = view.findViewById<TextView>(R.id.textViewTitle)
    val tvMessage = view.findViewById<TextView>(R.id.textViewMessage)
    val tvTime = view.findViewById<TextView>(R.id.textViewTime)
    val imageViewUrl = view.findViewById<ImageView>(R.id.imageView)
    val imageViewVolume = view.findViewById<ImageView>(R.id.imageView_audio)
    val imageViewMark = view.findViewById<ImageView>(R.id.imageView_mark)
    val imageViewRead = view.findViewById<TextView>(R.id.imageView_unread)
}