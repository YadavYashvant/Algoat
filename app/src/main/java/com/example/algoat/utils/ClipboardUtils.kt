package com.example.algoat.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

fun getTextFromClipboard(context: Context): String {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData: ClipData? = clipboard.primaryClip
    return clipData?.getItemAt(0)?.text?.toString() ?: ""
}