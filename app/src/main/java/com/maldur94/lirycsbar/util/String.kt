package com.maldur94.lirycsbar.util

fun String.inQuotationMarks(): String {
    val text = replace("\"", "")
    return "\"$text\""
}
