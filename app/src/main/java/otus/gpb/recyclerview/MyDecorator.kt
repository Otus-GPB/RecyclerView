package otus.gpb.recyclerview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyDecorator(private val sizelist: Int) :
    RecyclerView.ItemDecoration() {
    /***
     ****** This paints can draw background and barriers. You can change color
     */
/*    private val myPaintFill: Paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.rgb(204, 255, 255)
    }
    private val myPaintStroke: Paint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.rgb(255, 153, 51)
    }*/

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        with(outRect) {
            left = MARGIN_START
            right = MARGIN_START
            if (parent.getChildAdapterPosition(view) == 0) {
                top = MARGIN_TOP
                bottom = MARGIN_BOTTOM
            } else if (parent.getChildAdapterPosition(view) == sizelist - 1) {
                bottom = MARGIN_BOTTOM
            } else {
                bottom = MARGIN_BOTTOM
                top = MARGIN_TOP
            }
        }
    }

    /***
     ****** If you want to add background to all elements of the RecyclerView, use this method
     */
 /*   override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        (0 until parent.childCount).map {
            val childView = parent.getChildAt(it)

            val childLeft: Int = childView.left - 1
            val childTop: Int = childView.top + 1
            val childRight: Int = childView.right + 1
            val childBottom: Int = childView.bottom + 5

            c.drawRoundRect(
                childLeft.toFloat(),
                childTop.toFloat(),
                childRight.toFloat(),
                childBottom.toFloat(),
                15f,
                15f,
                myPaintFill
            )
            c.drawRoundRect(
                childLeft.toFloat(),
                childTop.toFloat(),
                childRight.toFloat(),
                childBottom.toFloat(),
                15f,
                15f,
                myPaintStroke
            )
        }
    }*/

    companion object {
        private const val MARGIN_TOP = 8
        private const val MARGIN_BOTTOM = 8
        private const val MARGIN_START = 10
    }
}
