package com.o9tech.heartratemonitor.ui.theme.Screens.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout
import com.o9tech.heartratemonitor.R

class HeartMaskLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    // Load your PNG heart mask. It should be a white shape on transparent background.
    private val maskBitmap: Bitmap by lazy {
        BitmapFactory.decodeResource(resources, R.drawable.love)
    }

    // Set up a paint with DST_IN mode to keep only pixels that are in both the view and mask.
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }
    init {
        setLayerType(LAYER_TYPE_SOFTWARE,null)
    }

    override fun dispatchDraw(canvas: Canvas) {
        // Draw children into an offscreen layer.
        val saveCount = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)
        super.dispatchDraw(canvas)
        // Draw the mask over the children. The DST_IN mode applies the alpha from the mask.
        canvas.drawBitmap(
            maskBitmap,
            null,
            RectF(0f, 0f, width.toFloat(), height.toFloat()),
            paint
        )
        canvas.restoreToCount(saveCount)
    }
}