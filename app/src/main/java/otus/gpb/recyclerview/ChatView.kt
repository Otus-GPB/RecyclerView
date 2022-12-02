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
    lateinit var ivSilent: ImageView

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
        ivSilent = findViewById(R.id.iv_regular_silent)
    }

    fun populate(chat: Chat) {
        val imgOk = ResourcesCompat.getDrawable(resources, R.drawable.title_end_ok, null)
        val imgSilent = ResourcesCompat.getDrawable(resources, R.drawable.silent, null)
        Glide.with(this)
            .load(chat.imgAuthor)
            .centerCrop()
            .placeholder(androidx.appcompat.R.drawable.abc_spinner_textfield_background_material)
            .into(ivAvatar)
        if (chat.isTitle && chat.isSilent) {
            tvTitle.compoundDrawablePadding = 8
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, imgOk, null)
            ivSilent.visibility = View.VISIBLE

        } else if (chat.isTitle) {
            tvTitle.compoundDrawablePadding = 8
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, imgOk, null)
        } else if (chat.isSilent) {
            tvTitle.compoundDrawablePadding = 8
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, imgSilent, null)
        }
        tvTitle.text = chat.title
        tvAuthor.text = chat.author
        tvMessage.text = chat.message
        tvTime.text = chat.time
        if (chat.isFix) ivFix.visibility = View.VISIBLE
        if (chat.isMail) {
            ivMail.visibility = View.VISIBLE
            ivMailBackground.visibility = View.VISIBLE
        }
        if (chat.isOK) ivOk.visibility = View.VISIBLE
    }
}