package com.jcminarro.roundkornerlayout

import android.graphics.Canvas

class CanvasRounder(val cornerRadius: Float) {
    private val path = android.graphics.Path()
    private val updateSizeFunction: (width: Float, height: Float) -> Unit
    private val roundFunction: (canvas: Canvas, drawFunction: (Canvas) -> Unit) -> Unit

    init {
        if (cornerRadius == NO_CORNER_RADIUS) {
            updateSizeFunction = { _, _ -> }
            roundFunction = {canvas, drawFunction -> drawFunction(canvas) }
        } else {
            updateSizeFunction = { width, height ->
                path.reset()
                val rectF = android.graphics.RectF(0f, 0f, width, height)
                path.addRoundRect(rectF, cornerRadius, cornerRadius, android.graphics.Path.Direction.CW)
                path.close()
            }
            roundFunction = {canvas, drawFunction ->
                val save = canvas.save()
                canvas.clipPath(path)
                drawFunction(canvas)
                canvas.restoreToCount(save)
            }
        }
    }

    fun round(canvas: Canvas, drawFunction: (Canvas) -> Unit) = roundFunction(canvas, drawFunction)

    fun updateSize(currentWidth: Int, currentHeight: Int) =
            updateSizeFunction(currentWidth.toFloat(), currentHeight.toFloat())

    companion object {
        const val NO_CORNER_RADIUS = 0f
    }
}