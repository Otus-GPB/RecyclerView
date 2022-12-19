package otus.gpb.recyclerview

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class CustomDecoration(
    private val drawable: Drawable,
    private val needForLast: Boolean = true
) : RecyclerView.ItemDecoration() {

    private val mBounds = Rect()

    override fun onDraw(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        parent.children.forEach { view ->
            parent.getDecoratedBoundsWithMargins(view, mBounds)
            val left = 0
            val right = parent.width
            val bottom = mBounds.bottom + parent.translationY.roundToInt()
            val top = bottom - drawable.intrinsicHeight
            drawable.bounds = Rect(left, top, right, bottom)
            drawable.draw(c)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = drawable.intrinsicHeight;
    }
}