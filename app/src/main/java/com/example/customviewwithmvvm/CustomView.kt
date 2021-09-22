package com.example.customviewwithmvvm

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView : View {
    private var paint: Paint = Paint()
    private var circle_color: Int = Color.RED
    constructor(context: Context?) : super(context) {
        updatePaint()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setupAttributes(attrs)
        updatePaint()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setupAttributes(attrs)
        updatePaint()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        setupAttributes(attrs)
        updatePaint()
    }

    private fun updatePaint()
    {
        paint.apply {
            style = Paint.Style.FILL
            color = circle_color
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val cx = width/2
        val cy = height/2
        val r = width/2
        canvas.drawCircle(cx.toFloat(),cy.toFloat(),r.toFloat(),paint)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView,
            0, 0)
        try {
            circle_color = Color.parseColor(typedArray.getString(R.styleable.CustomView_circleColor))
        } catch (e: Exception) {
        }
        typedArray.recycle()
    }

    fun setCircleColor(cc: String)
    {
        circle_color = Color.parseColor(cc)
        updatePaint()
        invalidate()
    }
}