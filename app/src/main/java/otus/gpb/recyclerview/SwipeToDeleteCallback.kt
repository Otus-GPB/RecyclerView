package otus.gpb.recyclerview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDeleteCallback internal
constructor(private val context: Context) : ItemTouchHelper.Callback() {

    private val BACKGROUND_COLOR ="#66A9E0"

    private val clearPaint : Paint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private val deleteBackground = ColorDrawable()
    private val backgroundColor = Color.parseColor(BACKGROUND_COLOR)
    private val archiveIcon = ContextCompat.getDrawable(context, R.drawable.archive_arrow_down)

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

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("Not yet implemented")
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
        val isCancelled = dX == 0f && !isCurrentlyActive

        if(isCancelled){
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
        itemView.bottom)
        deleteBackground.draw(c)

        archiveIcon?.let {
            val margin = (itemView.height - it.intrinsicHeight) / 2
            val deleteIconTop = itemView.top + margin
            val deleteIconLeft = itemView.right - it.intrinsicWidth - margin
            val deleteIconRight = itemView.right - margin
            val deleteIconBottom = itemView.bottom - margin
            it.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom)
            it.draw(c)
        }
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float){
        c.drawRect(left, top, right, bottom, clearPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.7f
    }
}