package com.jcminarro.roundkornerlayout

import android.graphics.Canvas

class RoundKornerFrameLayout
    @JvmOverloads constructor(context: android.content.Context, attrs: android.util.AttributeSet? = null, defStyleAttr: Int = 0) :
        android.widget.FrameLayout(context, attrs, defStyleAttr) {
    private val path = android.graphics.Path()
    private var cornerRadius = DEFAULT_CORNER_RADIUS

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.RoundKornerFrameLayout, 0, 0)
        try {
            cornerRadius = array.getDimension(R.styleable.RoundKornerFrameLayout_corner_radius, DEFAULT_CORNER_RADIUS)
        } finally {
            array.recycle()
        }
    }

    override fun onSizeChanged(currentWidth: Int, currentHeight: Int, oldWidth: Int, oldheight: Int) {
        super.onSizeChanged(currentWidth, currentHeight, oldWidth, oldheight)
        path.reset()
        val rectF = android.graphics.RectF(0f, 0f, currentWidth.toFloat(), currentHeight.toFloat())
        path.addRoundRect(rectF, cornerRadius, cornerRadius, android.graphics.Path.Direction.CW)
        path.close()

    }

    override fun draw(canvas: Canvas) {
        if (cornerRadius != DEFAULT_CORNER_RADIUS) {
            val save = canvas.save()
            canvas.clipPath(path)
            super.draw(canvas)
            canvas.restoreToCount(save)
        } else {
            super.draw(canvas)
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        if (cornerRadius != DEFAULT_CORNER_RADIUS) {
            val save = canvas.save()
            canvas.clipPath(path)
            super.dispatchDraw(canvas)
            canvas.restoreToCount(save)
        } else {
            super.dispatchDraw(canvas)
        }
    }

    companion object {

        val DEFAULT_CORNER_RADIUS = 0f
    }
}