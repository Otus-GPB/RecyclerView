package otus.gpb.recyclerview.ui.decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ChatItemDecoration(
    separatorColor: Int
): RecyclerView.ItemDecoration() {
    private val paint: Paint = Paint().apply {
        color = separatorColor
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            c.drawLine((view.width * 0.2).toFloat(), view.bottom.toFloat(),
                view.width.toFloat(), view.bottom.toFloat(), paint)
        }
    }
}