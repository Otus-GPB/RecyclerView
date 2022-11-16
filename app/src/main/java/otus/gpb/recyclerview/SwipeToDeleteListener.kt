package otus.gpb.recyclerview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDeleteListener(context: Context) : ItemTouchHelper.Callback() {

    private val clearPaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private val deleteBackground = ColorDrawable()
    private val backgroundColor = ContextCompat.getColor(context, R.color.blue)
    private val deleteDrawable = ContextCompat.getDrawable(context, R.drawable.ic_archive)

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
            val margin = (itemView.height - it.intrinsicHeight) / 2
            val deleteIconTop = itemView.top + margin
            val deleteIconLeft = itemView.right - it.intrinsicWidth - margin
            val deleteIconRight = itemView.right - margin
            val deleteIconBottom = itemView.bottom - margin
            it.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom)
            it.draw(c)
        }
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float) {
        c.drawRect(left, top, right, bottom, clearPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder) = 0.7f
}
