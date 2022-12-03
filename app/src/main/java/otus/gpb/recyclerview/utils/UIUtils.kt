package otus.gpb.recyclerview.utils

import android.content.Context
import android.util.TypedValue
import android.view.View

fun Boolean.visibility() = if (this) View.VISIBLE else View.GONE

fun Float.spToPx(context: Context) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    this, context.resources.displayMetrics)
fun Float.dpToPx(context: Context) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this, context.resources.displayMetrics)