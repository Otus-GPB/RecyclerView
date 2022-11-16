package otus.gpb.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class ChatView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.constraintlayout.widget.ConstraintLayout(context, attr, defStyleAttr) {

    lateinit var ivAvatar: ShapeableImageView
    lateinit var tvTitle: TextView
    lateinit var tvAuthor: TextView
    lateinit var tvMessage: TextView
    lateinit var tvTime: TextView
    lateinit var ivOk: ImageView
    lateinit var ivFix: ImageView
    lateinit var ivMail: ImageView
    lateinit var ivMailBackground: ImageView

    override fun onFinishInflate() {
        super.onFinishInflate()
        ivAvatar = findViewById(R.id.iv_regular_item_avatar)
        tvTitle = findViewById(R.id.tv_regular_item_title)
        tvAuthor = findViewById(R.id.tv_regular_item_author)
        tvMessage = findViewById(R.id.tv_regular_item_message)
        tvTime = findViewById(R.id.tv_regular_item_time)
        ivOk = findViewById(R.id.iv_regular_item_ok)
        ivFix = findViewById(R.id.iv_regular_item_fix)
        ivMail = findViewById(R.id.iv_regular_item_mail_vector)
        ivMailBackground = findViewById(R.id.iv_regular_item_mail_background)
    }

    fun populate(chat: Chat) {
        val img = ResourcesCompat.getDrawable(resources, R.drawable.title_end_ok, null)
        Glide.with(this)
            .load("https://source.unsplash.com/random")
            .centerCrop()
            .placeholder(androidx.appcompat.R.drawable.abc_spinner_textfield_background_material)
            .into(ivAvatar)
        if (chat.isTitle) {
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, img, null)
        }
        tvTitle.text = chat.title
        tvAuthor.text = chat.author
        tvMessage.text = chat.message
        tvTime.text = chat.time
        when {
            chat.isFix -> ivFix.visibility = View.VISIBLE
            chat.isMail -> {
                ivMail.visibility = View.VISIBLE
                ivMailBackground.visibility = View.VISIBLE
            }

            chat.isOK -> ivOk.visibility = View.VISIBLE
        }
    }
}