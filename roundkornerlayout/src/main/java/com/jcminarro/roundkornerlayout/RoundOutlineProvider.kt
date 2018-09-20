package com.jcminarro.roundkornerlayout

import android.graphics.Outline
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.view.ViewOutlineProvider

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
internal class RoundOutlineProvider(private val cornersHolder: CornersHolder) :
        ViewOutlineProvider() {

    constructor(cornerRadius: Float) :
            this(CornersHolder(cornerRadius, cornerRadius, cornerRadius, cornerRadius))

    override fun getOutline(view: View, outline: Outline) {
        val rectF = RectF(0f, 0f, view.measuredWidth.toFloat(), view.measuredHeight.toFloat())
        val path = Path().apply {
            addRoundRectWithRoundCorners(rectF, cornersHolder)
            close()
        }
        outline.setConvexPath(path)
    }
}
