package otus.gpb.recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDeleteCallBack internal constructor(private val context: Context) :
    ItemTouchHelper.Callback() {

    private val clearPaint: Paint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }
    private val deleteBackground = ColorDrawable()
    private val backgroundColor = context.getColor(R.color.malibu)
    private val archiveColor = context.getColor(R.color.white)
    private val archiveIcon = context.getDrawable(R.drawable.archiv)
    private val archiveText = context.getText(R.string.archive)

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT)

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
        archiveIcon?.bounds = Rect(
            viewHolder.itemView.right - convertDpToPixel(
                context,
                32 + 22
            ),
            viewHolder.itemView.top + convertDpToPixel(context, 18),
            viewHolder.itemView.right - convertDpToPixel(context, 32),
            viewHolder.itemView.bottom - convertDpToPixel(context, 40)
        )
        archiveIcon?.draw(c)

        val paintText = Paint()
        paintText.color = archiveColor
        paintText.textSize = convertDpToPixel(context, 13).toFloat()
        c.drawText(
            archiveText.toString(),
            viewHolder.itemView.right.toFloat() - convertDpToPixel(context, 44 + 20),
            viewHolder.itemView.top.toFloat() + convertDpToPixel(context, 70),
            paintText
        )
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.7f
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float) {
        c.drawRect(left, top, right, bottom, clearPaint)
    }

    private fun convertDpToPixel(context: Context, dp: Int) =
        (dp * context.resources.displayMetrics.density).toInt()
}