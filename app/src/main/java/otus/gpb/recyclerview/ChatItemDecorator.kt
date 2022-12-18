package otus.gpb.recyclerview

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class ChatItemDecorator(
    private val drawable: Drawable
) : RecyclerView.ItemDecoration() {
    private val mBounds = Rect()

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        drawItems(canvas, parent)
    }

    private fun drawItems(canvas: Canvas, parent: RecyclerView) {
        val left = 0
        val right = parent.width

        for (i in 0 until (parent.childCount - 1).coerceAtLeast(0)) {
            val child = parent.getChildAt(i)
            parent.getDecoratedBoundsWithMargins(child, mBounds)
            val bottom = mBounds.bottom + child.translationY.roundToInt()
            val top = bottom - drawable.intrinsicHeight
            drawable.setBounds(left, top, right, bottom)
            drawable.draw(canvas)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect[0, 0, 0] = drawable.intrinsicHeight
    }
}