package com.jcminarro.roundkornerlayout

import android.graphics.Canvas
import android.graphics.RectF

internal class CanvasRounder(private val cornersHolder: CornersHolder) {
    private val path = android.graphics.Path()
    private var rectF: RectF = RectF(0f, 0f, 0f, 0f)
    var topLeftCornerRadius: Float
        set(value) {
            cornersHolder.topLeftCornerRadius = value
            resetPath()
        }
        get() = cornersHolder.topLeftCornerRadius
    var topRightCornerRadius: Float
        set(value) {
            cornersHolder.topRightCornerRadius = value
            resetPath()
        }
        get() = cornersHolder.topRightCornerRadius
    var bottomRightCornerRadius: Float
        set(value) {
            cornersHolder.bottomRightCornerRadius = value
            resetPath()
        }
        get() = cornersHolder.bottomRightCornerRadius
    var bottomLeftCornerRadius: Float
        set(value) {
            cornersHolder.bottomLeftCornerRadius = value
            resetPath()
        }
        get() = cornersHolder.bottomLeftCornerRadius
    var cornerRadius: Float
        set(value) {
            cornersHolder.topLeftCornerRadius = value
            cornersHolder.topRightCornerRadius = value
            cornersHolder.bottomRightCornerRadius = value
            cornersHolder.bottomLeftCornerRadius = value
            resetPath()
        }
        get() {
            return if (topLeftCornerRadius == topRightCornerRadius
                    && topRightCornerRadius == bottomRightCornerRadius
                    && bottomRightCornerRadius == bottomLeftCornerRadius) {
                topLeftCornerRadius
            } else {
                Float.NaN
            }
        }

    fun round(canvas: Canvas, drawFunction: (Canvas) -> Unit) {
        val save = canvas.save()
        canvas.clipPath(path)
        drawFunction(canvas)
        canvas.restoreToCount(save)
    }

    fun updateSize(currentWidth: Int, currentHeight: Int) {
        rectF = android.graphics.RectF(0f, 0f, currentWidth.toFloat(), currentHeight.toFloat())
        resetPath()
    }

    private fun resetPath() {
        path.reset()
        path.addRoundRectWithRoundCorners(
                rectF,
                topLeftCornerRadius,
                topRightCornerRadius,
                bottomRightCornerRadius,
                bottomLeftCornerRadius
        )
        path.close()
    }
}
