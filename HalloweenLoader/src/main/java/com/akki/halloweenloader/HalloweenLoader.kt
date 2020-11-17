package com.akki.halloweenloader

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.BounceInterpolator


class HalloweenLoader : View {

    private var mRadius: Float = 0f
    private var mLoaderInnerColor: Int = 0
    private var mLoaderInnerColorSecondLayer: Int = 0
    private var mLoaderInnerColorThirdLayer: Int = 0
    private var mLoaderInnerFourthColor: Int = 0
    private var mLoaderInnerFifthColor: Int = 0
    private var mStrokeWidth: Int = 0
    private lateinit var mPaint1: Paint
    private lateinit var mPaint2: Paint
    private lateinit var mPaint3: Paint
    private lateinit var mPaint4: Paint
    private lateinit var mPaint5: Paint
    private val mDefaultPadding = 10f
    private var mAnimationDuration = 2000
    private var mDefaultSpace = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val attributes: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.HalloweenLoader)
        try {
            mRadius =
                attributes.getFloat(
                    R.styleable.HalloweenLoader_halloween_loader_radius,
                    400f
                )
            mAnimationDuration = attributes.getInteger(
                R.styleable.HalloweenLoader_halloween_loader_animation_duration,
                3000
            )

            mLoaderInnerColor =
                attributes.getColor(
                    R.styleable.HalloweenLoader_halloween_loader_inner_most_color,
                    Color.parseColor("#fcf6a8")
                )

            mLoaderInnerColorSecondLayer =
                attributes.getColor(
                    R.styleable.HalloweenLoader_halloween_loader_second_layer_color,
                    Color.parseColor("#f8c154")
                )

            mLoaderInnerColorThirdLayer =
                attributes.getColor(
                    R.styleable.HalloweenLoader_halloween_loader_third_layer_color,
                    Color.parseColor("#f37a51")
                )

            mLoaderInnerFourthColor =
                attributes.getColor(
                    R.styleable.HalloweenLoader_halloween_loader_fourth_layer_color,
                    Color.parseColor("#7d1a4e")
                )

            mLoaderInnerFifthColor =
                attributes.getColor(
                    R.styleable.HalloweenLoader_halloween_loader_fifth_layer_color,
                    Color.parseColor("#50305b")
                )

            mStrokeWidth =
                attributes.getDimensionPixelSize(
                    R.styleable.HalloweenLoader_halloween_loader_stroke,
                    50
                )

            init()
        } finally {
            attributes.recycle()
        }

    }

    private fun init() {
        mPaint1 = Paint()
        mPaint1.color = mLoaderInnerColor
        mPaint1.style = Paint.Style.FILL
        mPaint1.strokeWidth = mStrokeWidth.toFloat()

        mPaint2 = Paint()
        mPaint2.color = mLoaderInnerColorSecondLayer
        mPaint2.style = Paint.Style.FILL
        mPaint2.strokeWidth = mStrokeWidth.toFloat()

        mPaint3 = Paint()
        mPaint3.color = mLoaderInnerColorThirdLayer
        mPaint3.style = Paint.Style.FILL
        mPaint3.strokeWidth = mStrokeWidth.toFloat()

        mPaint4 = Paint()
        mPaint4.color = mLoaderInnerFourthColor
        mPaint4.style = Paint.Style.FILL
        mPaint4.strokeWidth = mStrokeWidth.toFloat()

        mPaint5 = Paint()
        mPaint5.color = mLoaderInnerFifthColor
        mPaint5.style = Paint.Style.FILL
        mPaint5.strokeWidth = mStrokeWidth.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()
        mDefaultSpace = ((mDefaultPadding) + (width * 2 / 5).toInt()).toInt()

        val center_x: Float
        val center_y: Float

        center_x = width / 2
        center_y = height / 2

        canvas?.drawCircle(center_x, center_y, mRadius - mDefaultSpace * 1 / 5, mPaint5)
        canvas?.drawCircle(
            center_x,
            center_y,
            mRadius - (mDefaultSpace * 2 / 5),
            mPaint4
        )
        canvas?.drawCircle(
            center_x,
            center_y,
            mRadius - (mDefaultSpace * 3 / 5),
            mPaint3
        )
        canvas?.drawCircle(
            center_x,
            center_y,
            mRadius - (mDefaultSpace * 4 / 5),
            mPaint2
        )
        canvas?.drawCircle(center_x, center_y, mRadius - (mDefaultSpace), mPaint1)
        // showProgress()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        setMeasuredDimension(
            measureDimension(desiredWidth, widthMeasureSpec),
            measureDimension(desiredHeight, heightMeasureSpec)
        )

    }

    private fun measureDimension(desiredSize: Int, measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = desiredSize
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize)
            }
        }
        if (result < desiredSize) {
            Log.e("PencilLoader", "The view is too small, the content might get cut")
        }
        return result
    }

    fun showProgress() {
        val va = ValueAnimator.ofFloat(0f, mRadius)
        val mDuration = mAnimationDuration

        va.duration = mDuration.toLong()
        va.addUpdateListener {
            mRadius = it.animatedValue as Float
            invalidate()
        }

        va.interpolator = BounceInterpolator()
        va.repeatCount = Animation.INFINITE
        va.start()
    }

    fun hideProgress() {
        if (visibility == VISIBLE) {
            visibility = GONE
        }

    }
}