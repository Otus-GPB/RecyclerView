package otus.gpb.recyclerview.ui.decoration

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.TypedValue
import androidx.annotation.ColorInt
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.recyclerview.R


abstract class SwipeToDismissCallback(
    @ColorInt
    bgColor: Int,
    @ColorInt
    messageColor: Int,
    context: Context
): ItemTouchHelper.Callback() {

    companion object {
        private val TEXT_SIZE_SP = 13f
        private val TEXT_MARGIN_TOP_DP = 9f
        private val TEXT_MARGIN_END_DP = 20f

        private val ICON_SIZE_DP = 22f
        private val ICON_MARGIN_TOP_DP = 18f
        private val ICON_MARGIN_FINISH_DP = 32f
    }

    fun Float.spToPx(context: Context) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
        this, context.resources.displayMetrics)
    fun Float.dpToPx(context: Context) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
        this, context.resources.displayMetrics)

    private val TEXT_SIZE_PX = TEXT_SIZE_SP.spToPx(context)
    private val TEXT_MARGIN_TOP_PX = TEXT_MARGIN_TOP_DP.dpToPx(context)
    private val TEXT_MARGIN_END_PX = TEXT_MARGIN_END_DP.dpToPx(context)

    private val ICON_SIZE_PX = ICON_SIZE_DP.dpToPx(context)
    private val ICON_MARGIN_TOP_PX = ICON_MARGIN_TOP_DP.dpToPx(context)
    private val ICON_MARGIN_FINISH_PX = ICON_MARGIN_FINISH_DP.dpToPx(context)

    private val BASELINE_MIN_MARGIN_PX = ICON_MARGIN_FINISH_PX + ICON_SIZE_PX / 2

    private val archiveText = context.resources.getString(R.string.archive)
    private val archiveIcon = ResourcesCompat.getDrawable(context.resources, R.drawable.ic_archive, null)

    private val clearPaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }
    private val paint = Paint().apply {
        color = bgColor
    }
    private val textBoundsRect = Rect()
    private val textPaint = Paint().apply{
        color = messageColor
        flags = Paint.ANTI_ALIAS_FLAG
        textSize = TEXT_SIZE_PX
        textAlign = Paint.Align.CENTER
        getTextBounds(archiveText, 0, archiveText.length, textBoundsRect)
    }
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, ItemTouchHelper.START)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        val itemView = viewHolder.itemView
        val isCanceled = dX == 0f && !isCurrentlyActive

        if (isCanceled) {
            clearCanvas(c, itemView.right + dX,
                itemView.top.toFloat(), itemView.right.toFloat(),
                itemView.bottom.toFloat())
            return
        }

        c.drawRect(itemView.right.toFloat(), itemView.top.toFloat(),
            itemView.right + dX, itemView.bottom + dY, paint)

        var textX = itemView.right.toFloat() + textBoundsRect.width() / 2 + TEXT_MARGIN_END_PX + dX
        val textY = itemView.top.toFloat() + ICON_MARGIN_TOP_PX + ICON_SIZE_PX + TEXT_MARGIN_TOP_PX + TEXT_SIZE_PX
        if (textX <= itemView.width - BASELINE_MIN_MARGIN_PX)
            textX = itemView.width - BASELINE_MIN_MARGIN_PX

        val iconLeft = textX - ICON_SIZE_PX / 2 ;
        val iconTop = itemView.top + ICON_MARGIN_TOP_PX;
        val iconRight = textX + ICON_SIZE_PX / 2;
        val iconBottom = itemView.top + ICON_MARGIN_TOP_PX + ICON_SIZE_PX;
        archiveIcon?.setBounds(iconLeft.toInt(), iconTop.toInt(), iconRight.toInt(),
            iconBottom.toInt()
        )
        archiveIcon?.draw(c)
        c.drawText(archiveText, textX, textY, textPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.9f
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float ) {
        c.drawRect(left, top, right, bottom, clearPaint)
    }
}