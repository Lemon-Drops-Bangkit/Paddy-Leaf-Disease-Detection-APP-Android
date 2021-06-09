package com.b21_cap0183.paddycare.core.utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    fun getCurrentDate(): String {
        val formatDate = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val date = Date()
        return formatDate.format(date)
    }
}