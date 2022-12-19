package otus.gpb.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

class ChatView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attr, defStyleAttr) {

    lateinit var icon: ImageView
    lateinit var name: TextView
    lateinit var message: TextView
    lateinit var time: TextView
    lateinit var mute: ImageView

    override fun onFinishInflate() {
        super.onFinishInflate()
        icon = findViewById(R.id.icon)
        name = findViewById(R.id.account_name_text_view)
        message = findViewById(R.id.message_text_view)
        time = findViewById(R.id.time_text_view)
        mute = findViewById(R.id.muted_image_view)
    }

    fun populate(chat: Chat) {

        Glide.with(this).load(chat.icon).into(icon)
        name.text = chat.name
        message.text = chat.message
        time.text = chat.time

        if (!chat.muted) {
            mute.visibility = View.GONE
        }

    }

}