package com.example.palette

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

private var appContext : Context?= null


fun initClipBoard(context: Context){
    appContext = context.applicationContext
}


actual fun copyToClipboard(text: String) {
    val context = appContext ?: return
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("copied text", text)
    clipboard.setPrimaryClip(clip)
}

