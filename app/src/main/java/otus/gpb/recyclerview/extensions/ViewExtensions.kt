package otus.gpb.recyclerview.extensions

import android.view.View

fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}
