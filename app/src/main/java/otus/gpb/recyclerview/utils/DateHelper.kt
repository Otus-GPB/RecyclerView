package otus.gpb.recyclerview.utils

import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    companion object {
        private const val DAY_MS = 86400000

        val duringLastDay = Date()
        val duringLastWeek = Date(duringLastDay.time - DAY_MS * 2)
        val somewhereInThePast = Date(duringLastDay.time - DAY_MS * 10)

        fun dateToText(date: Date): String {
            val currentDate = Date()
            val diff = currentDate.time - date.time
            val days = diff / 1000 / 60 / 60 / 24
            return when  {
                days == 0L -> SimpleDateFormat("hh:mm a", Locale.getDefault())
                    .format(date.time)
                days < 7 -> SimpleDateFormat("EEE", Locale.getDefault())
                    .format(date.time)
                else -> SimpleDateFormat("MMM dd", Locale.getDefault())
                    .format(date.time)
            }
        }
    }
}