package com.jcminarro.roundkornerlayout

import android.content.res.TypedArray
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.view.View

internal fun View.updateOutlineProvider(cornersHolder: CornersHolder) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        outlineProvider = RoundOutlineProvider(cornersHolder)
    }
}

internal fun View.updateOutlineProvider(cornerRadius: Float) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        outlineProvider = RoundOutlineProvider(cornerRadius)
    }
}

internal fun Path.addRoundRectWithRoundCorners(rectF: RectF, cornersHolder: CornersHolder) {
    addRoundRectWithRoundCorners(
            rectF,
            cornersHolder.topLeftCornerRadius,
            cornersHolder.topRightCornerRadius,
            cornersHolder.bottomRightCornerRadius,
            cornersHolder.bottomLeftCornerRadius
    )
}

internal fun Path.addRoundRectWithRoundCorners(rectF: RectF,
                                               topLeftCornerRadius: Float,
                                               topRightCornerRadius: Float,
                                               bottomRightCornerRadius: Float,
                                               bottomLeftCornerRadius: Float) {
    addRoundRect(
            rectF,
            floatArrayOf(
                    topLeftCornerRadius,
                    topLeftCornerRadius,
                    topRightCornerRadius,
                    topRightCornerRadius,
                    bottomRightCornerRadius,
                    bottomRightCornerRadius,
                    bottomLeftCornerRadius,
                    bottomLeftCornerRadius
            ),
            Path.Direction.CW
    )
}

internal fun TypedArray.getCornerRadius(attrCornerRadius: Int,
                                        attrTopLeftCornerRadius: Int,
                                        attrTopRightCornerRadius: Int,
                                        attrBottomRightCornerRadius: Int,
                                        attrBottomLeftCornerRadius: Int
): CornersHolder {
    val cornerRadius = getDimension(attrCornerRadius, 0f)
    val topLeftCornerRadius = getDimension(attrTopLeftCornerRadius, cornerRadius)
    val topRightCornerRadius = getDimension(attrTopRightCornerRadius, cornerRadius)
    val bottomRightCornerRadius = getDimension(attrBottomRightCornerRadius, cornerRadius)
    val bottomLeftCornerRadius = getDimension(attrBottomLeftCornerRadius, cornerRadius)

    return CornersHolder(
            topLeftCornerRadius,
            topRightCornerRadius,
            bottomRightCornerRadius,
            bottomLeftCornerRadius
    )
}
