package otus.gpb.recyclerview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.lang.Float.max

abstract class SwipeToDeleteListener(context: Context) : ItemTouchHelper.Callback() {

    companion object {
        const val END_MARGIN_DP = 20f
        const val TEXT_TOP_MARGIN = 9f
        const val FONT_HEIGHT = 13f
    }

    private val clearPaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private val textPaint: Paint

    private val deleteBackground = ColorDrawable()
    private val backgroundColor = ContextCompat.getColor(context, R.color.blue)
    private val deleteDrawable = ContextCompat.getDrawable(context, R.drawable.ic_archive)
    private val deleteText = context.getString(R.string.archive)
    private val margin = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        END_MARGIN_DP,
        context.resources.displayMetrics
    )
    private val textTopMargin = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        TEXT_TOP_MARGIN,
        context.resources.displayMetrics
    )

    init {
        val typeface = ResourcesCompat.getFont(context, R.font.roboto_medium)

        textPaint = Paint().apply {
            color = context.getColor(R.color.white)
            style = Paint.Style.FILL
            textSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                FONT_HEIGHT,
                context.resources.displayMetrics
            )
            setTypeface(typeface)
        }
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) =
        makeMovementFlags(0, ItemTouchHelper.LEFT)

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = false

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
        val isCancelled = dX == 0f && !isCurrentlyActive

        if (isCancelled) {
            clearCanvas(
                c,
                itemView.right + dX,
                itemView.top.toFloat(),
                itemView.right.toFloat(),
                itemView.bottom.toFloat()
            )
            return
        }
        deleteBackground.color = backgroundColor
        deleteBackground.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
        deleteBackground.draw(c)

        deleteDrawable?.let {
            val textWidth = textPaint.measureText(deleteText)
            val textHeight = textPaint.textSize
            val iconWidth = max(textWidth, it.intrinsicWidth.toFloat())
            val iconHeight = it.intrinsicHeight + textTopMargin + textHeight
            val verticalMargin = (itemView.height - iconHeight) / 2

            val textLeft = itemView.right - margin - iconWidth + ((iconWidth - textWidth) / 2)
            val textTop = itemView.bottom - verticalMargin
            c.drawText(deleteText, textLeft, textTop, textPaint)

            val deleteIconTop = itemView.top + verticalMargin
            val deleteIconLeft = itemView.right - iconWidth - margin + ((iconWidth - it.intrinsicWidth) / 2)
            val deleteIconRight = deleteIconLeft + it.intrinsicWidth
            val deleteIconBottom = deleteIconTop + it.intrinsicHeight
            it.setBounds(deleteIconLeft.toInt(), deleteIconTop.toInt(), deleteIconRight.toInt(), deleteIconBottom.toInt())
            it.draw(c)
        }
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float) {
        c.drawRect(left, top, right, bottom, clearPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder) = 0.7f
}
