package otus.gpb.recyclerview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class ChatSwipeToArchiveCallback internal constructor(private val context: Context) :
    ItemTouchHelper.Callback() {

    private val deleteBackground = ColorDrawable()
    private val archiveDrawable = ContextCompat.getDrawable(context, R.drawable.archive_icon)!!
    private val backgroundColor = Color.parseColor("#66A9E0")
    private val clearPaint = Paint().apply { xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, ItemTouchHelper.LEFT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
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
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val itemView = viewHolder.itemView
        val itemHeight: Int = itemView.height
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
        deleteBackground.setBounds(
            itemView.right + dX.toInt(),
            itemView.top,
            itemView.right,
            itemView.bottom
        )
        deleteBackground.draw(c)

        val intrinsicHeight = archiveDrawable.intrinsicHeight
        val intrinsicWidth = archiveDrawable.intrinsicWidth
        val archiveIconTop: Int = itemView.top + (itemHeight - intrinsicHeight) / 2
        val archiveIconMargin = (itemHeight - intrinsicHeight) / 2
        val archiveIconLeft: Int = itemView.right - archiveIconMargin - intrinsicWidth
        val archiveIconRight: Int = itemView.right - archiveIconMargin
        val archiveIconBottom = archiveIconTop + intrinsicHeight

        archiveDrawable.setBounds(
            archiveIconLeft,
            archiveIconTop,
            archiveIconRight,
            archiveIconBottom
        )
        archiveDrawable.draw(c)


    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float) {
        c.drawRect(left, top, right, bottom, clearPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.7f
    }
}