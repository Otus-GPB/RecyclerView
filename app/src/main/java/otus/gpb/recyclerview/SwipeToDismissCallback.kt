package otus.gpb.recyclerview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

private const val NO_DRAG = 0

abstract class SwipeToDismissCallback(context: Context) :
    ItemTouchHelper.SimpleCallback(NO_DRAG, ItemTouchHelper.LEFT) {

    private val icon: Drawable?
    private val bgColor: Int
    private val backgroundDrawable: ColorDrawable
    private val resetPaint: Paint
    private val textPaint: Paint
    private val archiveText: String

    init {
        icon = ContextCompat.getDrawable(context, R.drawable.ic_baseline_archive_24)
        bgColor = context.getColor(R.color.blue)
        backgroundDrawable = ColorDrawable()
        resetPaint = Paint().apply { xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) }
        textPaint = Paint().apply {
            color = Color.WHITE
            textSize = 40f
            isAntiAlias = true
        }
        archiveText = context.getString(R.string.archive)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        with(viewHolder) {
            val itemHeight = itemView.bottom - itemView.top
            val isCanceled = dX == 0f && !isCurrentlyActive

            if (isCanceled) {
                c.drawRect(
                    itemView.right + dX,
                    itemView.top.toFloat(),
                    itemView.right.toFloat(),
                    itemView.bottom.toFloat(),
                    resetPaint
                )
                return
            }

            backgroundDrawable.color = bgColor
            backgroundDrawable.setBounds(
                itemView.right + dX.toInt(),
                itemView.top,
                itemView.right,
                itemView.bottom
            )
            backgroundDrawable.draw(c)

            val deleteIconTop = itemView.top - 16 + (itemHeight - icon?.intrinsicHeight!!) / 2
            val deleteIconMargin = (itemHeight - icon.intrinsicHeight) / 2
            val deleteIconLeft = itemView.right - deleteIconMargin - icon.intrinsicWidth
            val deleteIconRight = itemView.right - deleteIconMargin
            val deleteIconBottom = deleteIconTop + icon.intrinsicHeight

            icon.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom)
            icon.draw(c)

            c.drawText(archiveText, deleteIconLeft.toFloat() - 24f, deleteIconBottom + 40f , textPaint)

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false
}