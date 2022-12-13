package otus.gpb.recyclerview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDeleteCallback internal constructor(private val context: Context) : ItemTouchHelper.Callback() {

    private val clearPaint: Paint = Paint().apply{
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }
    private val deleteBackground = ColorDrawable()
    private val backgroundColor = Color.parseColor("#66A9E0")

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
        val isCancelled = dX == 0F && isCurrentlyActive

        if (isCancelled){
            clearCanvas(c, itemView.right + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
            return
        }
        deleteBackground.color = backgroundColor
        deleteBackground.setBounds(
            itemView.right + dX.toInt(),
            itemView.top,
            itemView.right,
            itemView.bottom)
        deleteBackground.draw(c)
        val deleteDrawable = getDrawable(context, R.drawable.ic_baseline_archive_24)!!
        deleteDrawable.bounds = Rect(
            viewHolder.itemView.right - convertDpToPixel(
                context,
                32 + 22
            ),
            viewHolder.itemView.top + convertDpToPixel(context, 22),
            viewHolder.itemView.right - convertDpToPixel(context, 22),
            viewHolder.itemView.bottom - convertDpToPixel(context, 22)
        )
        deleteDrawable.draw(c)
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float){
        c.drawRect(left, top, right, bottom, clearPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.7f
    }
    private fun convertDpToPixel(context: Context, dp: Int) =
        (dp * context.resources.displayMetrics.density).toInt()

}