package com.jcminarro.roundkornerlayout

import android.graphics.Outline
import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.view.ViewOutlineProvider

internal class RoundOutlineProvider(private val cornerRadius: Float) : ViewOutlineProvider() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getOutline(view: View, outline: Outline) {
        val rect = Rect(0, 0, view.measuredWidth, view.measuredHeight)
        outline.setRoundRect(rect, cornerRadius)
    }
}