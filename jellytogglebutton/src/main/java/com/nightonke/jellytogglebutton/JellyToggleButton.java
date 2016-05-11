package com.nightonke.jellytogglebutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;

/**
 * Created by Weiping on 2016/5/10.
 */
public class JellyToggleButton extends CompoundButton {

    private static final int DEFAULT_LEFT_BACKGROUND_COLOR = Color.parseColor("#1E59AF");
    private static final int DEFAULT_RIGHT_BACKGROUND_COLOR = Color.parseColor("#1E59AF");
    private static final int DEFAULT_LEFT_THUMB_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_RIGHT_THUMB_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_LEFT_TEXT_COLOR = Color.parseColor("#4085EE");
    private static final int DEFAULT_RIGHT_TEXT_COLOR = Color.parseColor("#4085EE");
    private static final Typeface DEFAULT_LEFT_TEXT_TYPEFACE = Typeface.DEFAULT;
    private static final Typeface DEFAULT_RIGHT_TEXT_TYPEFACE = Typeface.DEFAULT;
    private static final String DEFAULT_LEFT_TEXT = null;
    private static final String DEFAULT_RIGHT_TEXT = null;
    private static final int DEFAULT_LEFT_TEXT_SIZE = 15;
    private static final int DEFAULT_RIGHT_TEXT_SIZE = 15;
    private static final int DEFAULT_DURATION = 500;

    private static final float DEFAULT_TEXT_MARGIN_LEFT_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_RIGHT_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_TOP_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_BOTTOM_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_CENTER_DP = 5;

    private static final float DEFAULT_THUMB_RADIUS_DP = 15;
    private static final float DEFAULT_BACKGROUND_RADIUS_DP = 10;

    private static final float DEFAULT_BEZIER_CONTROL_VALUE = 0.551915024494f;
    private static final float DEFAULT_BEZIER_SCALE_RATIO_VALUE = 0.45f;

    private static final ColorChangeType DEFAULT_COLOR_CHANGE_TYPE = ColorChangeType.RGB;
    private static final Jelly DEFAULT_JELLY = Jelly.PASSIVE_DAMPING_TAIL;

    private int mLeftBackgroundColor = DEFAULT_LEFT_BACKGROUND_COLOR;
    private int mRightBackgroundColor = DEFAULT_RIGHT_BACKGROUND_COLOR;
    private int mLeftThumbColor = DEFAULT_LEFT_THUMB_COLOR;
    private int mRightThumbColor = DEFAULT_RIGHT_THUMB_COLOR;
    private int mLeftTextColor = DEFAULT_LEFT_TEXT_COLOR;
    private int mRightTextColor = DEFAULT_RIGHT_TEXT_COLOR;
    private Typeface mLeftTextTypeface = DEFAULT_LEFT_TEXT_TYPEFACE;
    private Typeface mRightTextTypeface = DEFAULT_RIGHT_TEXT_TYPEFACE;
    private int mLeftTextSize = DEFAULT_LEFT_TEXT_SIZE;
    private int mRightTextSize = DEFAULT_RIGHT_TEXT_SIZE;
    private String mLeftText = DEFAULT_LEFT_TEXT;
    private String mRightText = DEFAULT_RIGHT_TEXT;

    private float mTextMarginLeft;
    private float mTextMarginRight;
    private float mTextMarginTop;
    private float mTextMarginBottom;
    private float mTextMarginCenter;

    private float mThumbRadius;
    private float mThumbMinRadius;
    private float mThumbMaxRadius;
    private float mThumbLeft;
    private float mThumbRight;

    private float mBackgroundMeasureRatio = 1.8f;
    private float mBackgroundRadius;

    private float mBezierControlValue;
    private float mStretchDistance;
    private float mBezierScaleRatioValue;

    private ColorChangeType mColorChangeType = DEFAULT_COLOR_CHANGE_TYPE;
    private Jelly mJelly = DEFAULT_JELLY;

    private Paint mPaint;
    private TextPaint mLeftTextPaint;
    private TextPaint mRightTextPaint;
    private Path mThumbPath;
    
    private Layout mLeftTextLayout;
    private Layout mRightTextLayout;
    private float mTextWidth;
    private float mTextHeight;

    private float mProcess;
    private ObjectAnimator mProcessAnimator;
    private int mDuration;

    private State mState;

    private int mTouchSlop;
    private int mClickTimeout;

    private PointWithHorizontalPoints mThumbP1, mThumbP3;
    private PointWithVerticalPoints mThumbP2, mThumbP4;

    private RectF mBackgroundRectF;
    private RectF mOnTextRectF;
    private RectF mOffTextRectF;

    public JellyToggleButton(Context context) {
        super(context);
        init(null);
    }

    public JellyToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public JellyToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        mClickTimeout = ViewConfiguration.getPressedStateDuration() +
                ViewConfiguration.getTapTimeout();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLeftTextPaint = getPaint();
        mRightTextPaint = getPaint();
        mThumbPath = new Path();

        mThumbP1 = new PointWithHorizontalPoints();
        mThumbP2 = new PointWithVerticalPoints();
        mThumbP3 = new PointWithHorizontalPoints();
        mThumbP4 = new PointWithVerticalPoints();

        mBackgroundRectF = new RectF();
        mOnTextRectF = new RectF();
        mOffTextRectF = new RectF();

        mProcessAnimator = ObjectAnimator.ofFloat(this, "process", 0, 0)
                .setDuration(DEFAULT_DURATION);
        mProcessAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

        Resources res = getResources();
        float density = res.getDisplayMetrics().density;

        TypedArray ta = attrs == null ?
                null : getContext().obtainStyledAttributes(attrs, R.styleable.JellyToggleButton);
        if (ta != null) {
            mLeftBackgroundColor = ta.getColor(R.styleable.JellyToggleButton_jbtLeftBackgroundColor, DEFAULT_LEFT_BACKGROUND_COLOR);
            mRightBackgroundColor = ta.getColor(R.styleable.JellyToggleButton_jbtRightBackgroundColor, DEFAULT_RIGHT_BACKGROUND_COLOR);
            mLeftThumbColor = ta.getColor(R.styleable.JellyToggleButton_jbtLeftThumbColor, DEFAULT_LEFT_THUMB_COLOR);
            mRightThumbColor = ta.getColor(R.styleable.JellyToggleButton_jbtRightThumbColor, DEFAULT_RIGHT_THUMB_COLOR);
            mLeftTextColor = ta.getColor(R.styleable.JellyToggleButton_jbtLeftTextColor, DEFAULT_LEFT_TEXT_COLOR);
            mRightTextColor = ta.getColor(R.styleable.JellyToggleButton_jbtLeftTextColor, DEFAULT_RIGHT_TEXT_COLOR);

            String onTypefaceString = ta.getString(R.styleable.JellyToggleButton_jbtLeftTextTypeface);
            try {
                mLeftTextTypeface = Typeface.createFromAsset(getContext().getAssets(), onTypefaceString);
            } catch (RuntimeException r) {
                mLeftTextTypeface = Typeface.DEFAULT;
            }
            mLeftTextPaint.setTypeface(mLeftTextTypeface);

            String offTypefaceString = ta.getString(R.styleable.JellyToggleButton_jbtRightTextTypeface);
            try {
                mRightTextTypeface = Typeface.createFromAsset(getContext().getAssets(), offTypefaceString);
            } catch (RuntimeException r) {
                mRightTextTypeface = Typeface.DEFAULT;
            }
            mRightTextPaint.setTypeface(mRightTextTypeface);

            mLeftTextSize = ta.getDimensionPixelSize(R.styleable.JellyToggleButton_jbtLeftTextSize, DEFAULT_LEFT_TEXT_SIZE);
            mLeftTextPaint.setTextSize(mLeftTextSize);
            mRightTextSize = ta.getDimensionPixelSize(R.styleable.JellyToggleButton_jbtRightTextSize, DEFAULT_RIGHT_TEXT_SIZE);
            mRightTextPaint.setTextSize(mRightTextSize);

            mLeftText = ta.getString(R.styleable.JellyToggleButton_jbtLeftText);
            mRightText = ta.getString(R.styleable.JellyToggleButton_jbtRightText);
            mTextMarginLeft = ta.getDimension(R.styleable.JellyToggleButton_jbtTextMarginLeft, DEFAULT_TEXT_MARGIN_LEFT_DP);
            mTextMarginRight = ta.getDimension(R.styleable.JellyToggleButton_jbtTextMarginRight, DEFAULT_TEXT_MARGIN_RIGHT_DP);
            mTextMarginTop = ta.getDimension(R.styleable.JellyToggleButton_jbtTextMarginTop, DEFAULT_TEXT_MARGIN_TOP_DP);
            mTextMarginBottom = ta.getDimension(R.styleable.JellyToggleButton_jbtTextMarginBottom, DEFAULT_TEXT_MARGIN_BOTTOM_DP);
            mTextMarginCenter = ta.getDimension(R.styleable.JellyToggleButton_jbtTextMarginCenter, DEFAULT_TEXT_MARGIN_CENTER_DP);

            mDuration = ta.getInteger(R.styleable.JellyToggleButton_jbtDuration, DEFAULT_DURATION);

            mThumbRadius = ta.getDimension(R.styleable.JellyToggleButton_jbtThumbRadius, DEFAULT_THUMB_RADIUS_DP * density);
            mBackgroundRadius = ta.getDimension(R.styleable.JellyToggleButton_jbtBackgroundRadius, DEFAULT_BACKGROUND_RADIUS_DP * density);

            String colorChangeTypeString = ta.getString(R.styleable.JellyToggleButton_jbtColorChangeType);
            if ("rgb".equals(colorChangeTypeString)) {
                mColorChangeType = ColorChangeType.RGB;
            } else if ("hsv".equals(colorChangeTypeString)) {
                mColorChangeType = ColorChangeType.HSV;
            }

            String jellyString = ta.getString(R.styleable.JellyToggleButton_jbtJelly);
            if (jellyString != null) mJelly = Jelly.valueOf(jellyString);
            else mJelly = DEFAULT_JELLY;

            mBezierControlValue = ta.getFloat(R.styleable.JellyToggleButton_jbtBezierControlValue, DEFAULT_BEZIER_CONTROL_VALUE);
            mStretchDistance = mThumbRadius;
            mBezierScaleRatioValue = ta.getFloat(R.styleable.JellyToggleButton_jbtBezierScaleRatioValue, DEFAULT_BEZIER_SCALE_RATIO_VALUE);
            ta.recycle();
        }

        if (mLeftText == null) mLeftText = DEFAULT_LEFT_TEXT;
        if (mRightText == null) mRightText = DEFAULT_RIGHT_TEXT;

        setFocusable(true);
        setClickable(true);

        if (isChecked()) {
            setProcess(1);
            mState = State.ON;
        } else {
            mState = State.OFF;
        }
    }

    private Layout makeLayout(CharSequence text, TextPaint textPaint) {
        return new StaticLayout(text, textPaint, (int) Math.ceil(Layout.getDesiredWidth(text, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.f, 0, false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mLeftTextLayout == null && mLeftText != null && mLeftTextPaint != null) {
            mLeftTextLayout = makeLayout(mLeftText, mLeftTextPaint);
        }
        if (mRightTextLayout == null && mRightText != null && mRightTextPaint != null) {
            mRightTextLayout = makeLayout(mRightText, mRightTextPaint);
        }
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measuredWidth;

        int minWidth = (int) (mThumbRadius * 2 * mBackgroundMeasureRatio);
        float onWidth = mLeftTextLayout != null ? mLeftTextLayout.getWidth() : 0;
        float offWidth = mRightTextLayout != null ? mRightTextLayout.getWidth() : 0;
        mTextWidth = Math.max(onWidth, offWidth);
        float leftMaxThumbToText = mTextMarginCenter;
        float rightMaxThumbToText = mTextMarginCenter;
        minWidth = Math.max(minWidth, (int) (leftMaxThumbToText + mTextWidth + mTextMarginCenter + mTextWidth + rightMaxThumbToText));
        minWidth = Math.max(minWidth, minWidth + getPaddingLeft() + getPaddingRight());
        minWidth = Math.max(minWidth, getSuggestedMinimumWidth());

        if (widthMode == MeasureSpec.EXACTLY) {
            measuredWidth = Math.max(minWidth, widthSize);
        } else {
            measuredWidth = minWidth;
            if (widthMode == MeasureSpec.AT_MOST) {
                measuredWidth = Math.min(measuredWidth, widthSize);
            }
        }

        if (onWidth != 0 || offWidth != 0) {
            // if there are text on jelly
            // calculate the radius of the thumb
            mThumbMinRadius = Math.max(mTextWidth / 2 + mTextMarginLeft, mTextWidth / 2 + mTextMarginRight);
            mThumbMaxRadius = mTextWidth / 2 + mTextMarginCenter;

            if (mThumbRadius < mThumbMinRadius) mThumbRadius = mThumbMinRadius;
            if (mThumbRadius > mThumbMaxRadius) mThumbRadius = mThumbMaxRadius;
        }

        return measuredWidth;
    }

    private int measureHeight(int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int measuredHeight;

        float onHeight = mLeftTextLayout != null ? mLeftTextLayout.getHeight() : 0;
        float offHeight = mRightTextLayout != null ? mRightTextLayout.getHeight() : 0;
        if (onHeight != 0 || offHeight != 0) {
            mTextHeight = Math.max(onHeight, offHeight) + mTextMarginTop + mTextMarginBottom;
        }

        int minHeight = (int) (mThumbRadius * 2) + getPaddingTop() + getPaddingBottom();
        if (heightMode == MeasureSpec.EXACTLY) {
            measuredHeight = Math.max(minHeight, heightSize);
        } else {
            measuredHeight = minHeight;
            if (heightMode == MeasureSpec.AT_MOST) {
                measuredHeight = Math.min(measuredHeight, heightSize);
            }
        }

        return measuredHeight;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            setup();
        }
    }

    private void setup() {
        float backgroundLeft = mThumbRadius + getPaddingLeft() - (mTextWidth / 2 + mTextMarginLeft);
        float backgroundRight = getMeasuredWidth() - getPaddingRight() - (mThumbRadius - (mTextMarginRight + mTextWidth / 2));
        if (mTextWidth == 0) {
            // no text
            backgroundLeft = getPaddingLeft() + mThumbRadius / 2;
            backgroundRight = getMeasuredWidth() - getPaddingRight() - mThumbRadius / 2;
        }
        mBackgroundRectF.set(
                backgroundLeft,
                getMeasuredHeight() / 2 - mBackgroundRadius,
                backgroundRight,
                getMeasuredHeight() / 2 + mBackgroundRadius);

        if (mLeftTextLayout != null) {
            float marginOnX = mBackgroundRectF.left + mTextMarginLeft + (mTextWidth - mLeftTextLayout.getWidth()) / 2;
            float marginOnY = mBackgroundRectF.top + (mBackgroundRectF.height() - mLeftTextLayout.getHeight()) / 2;
            mOnTextRectF.set(marginOnX, marginOnY, marginOnX + mLeftTextLayout.getWidth(), marginOnY + mLeftTextLayout.getHeight());
        }

        if (mRightTextLayout != null) {
            float marginOffX = mBackgroundRectF.right - mTextMarginRight - mTextWidth + (mTextWidth - mRightTextLayout.getWidth()) / 2;
            float marginOffY = mBackgroundRectF.top + (mBackgroundRectF.height() - mRightTextLayout.getHeight()) / 2;
            mOffTextRectF.set(marginOffX, marginOffY, marginOffX + mRightTextLayout.getWidth(), marginOffY + mRightTextLayout.getHeight());
        }

        float thumbTop = getPaddingTop();
        mThumbLeft = (mOnTextRectF.left + mOnTextRectF.right) / 2 - mThumbRadius;
        if (mLeftTextLayout == null || mOnTextRectF.width() == 0) {
            mThumbLeft = getPaddingLeft();
        }
        mThumbRight = (mOffTextRectF.left + mOffTextRectF.right) / 2 + mThumbRadius;
        if (mRightTextLayout == null || mOffTextRectF.width() == 0) {
            mThumbRight = getMeasuredWidth() - getPaddingRight();
        }

        mThumbP1.setY(thumbTop + 2 * mThumbRadius);
        mThumbP2.setX(mThumbLeft + 2 * mThumbRadius);
        mThumbP3.setY(thumbTop);
        mThumbP4.setX(mThumbLeft);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // background
        if (mLeftBackgroundColor == mRightBackgroundColor) {
            // same color
            mPaint.setColor(mLeftBackgroundColor);
        } else {
            mPaint.setColor(Utils.calculateMidColor(mLeftBackgroundColor, mRightBackgroundColor, mProcess, mColorChangeType));
        }
        canvas.drawRoundRect(mBackgroundRectF, mBackgroundRadius, mBackgroundRadius, mPaint);

        // thumb
        setStartProcessPoints();

        mJelly.changeShape(mThumbP1, mThumbP2, mThumbP3, mThumbP4, mStretchDistance, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius, mProcess);

        float totalLength = mThumbRight - mThumbLeft - 2 * mThumbRadius - mJelly.extraceLength(mStretchDistance, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius);
        mJelly.changeOffset(mThumbP1, mThumbP2, mThumbP3, mThumbP4, totalLength, mProcess);

        mThumbPath.reset();
        mThumbPath.moveTo(mThumbP1.x,mThumbP1.y);
        mThumbPath.cubicTo(mThumbP1.right.x, mThumbP1.right.y, mThumbP2.bottom.x, mThumbP2.bottom.y, mThumbP2.x,mThumbP2.y);
        mThumbPath.cubicTo(mThumbP2.top.x, mThumbP2.top.y, mThumbP3.right.x, mThumbP3.right.y, mThumbP3.x,mThumbP3.y);
        mThumbPath.cubicTo(mThumbP3.left.x, mThumbP3.left.y, mThumbP4.top.x, mThumbP4.top.y, mThumbP4.x,mThumbP4.y);
        mThumbPath.cubicTo(mThumbP4.bottom.x,mThumbP4.bottom.y,mThumbP1.left.x,mThumbP1.left.y,mThumbP1.x,mThumbP1.y);

        // thumb color
        if (mLeftThumbColor == mRightThumbColor) {
            // same color
            mPaint.setColor(mLeftThumbColor);
        } else {
            mPaint.setColor(Utils.calculateMidColor(mLeftThumbColor, mRightThumbColor, mProcess, mColorChangeType));
        }

        canvas.drawPath(mThumbPath, mPaint);

        // text
        if (mLeftTextLayout != null && mOnTextRectF != null) {
            mLeftTextLayout.getPaint().setColor(mLeftTextColor);
            canvas.save();
            canvas.translate(mOnTextRectF.left, mOnTextRectF.top);
            mLeftTextLayout.draw(canvas);
            canvas.restore();
        }
        if (mRightTextLayout != null && mOffTextRectF != null) {
            mRightTextLayout.getPaint().setColor(mRightTextColor);
            canvas.save();
            canvas.translate(mOffTextRectF.left, mOffTextRectF.top);
            mRightTextLayout.draw(canvas);
            canvas.restore();
        }

//        Paint mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mRectPaint.setStyle(Paint.Style.STROKE);
//        mRectPaint.setStrokeWidth(getResources().getDisplayMetrics().density);
//        mRectPaint.setColor(Color.parseColor("#AA0000"));
//        canvas.drawRect(mBackgroundRectF, mRectPaint);
//        mRectPaint.setColor(Color.parseColor("#0000FF"));
//        canvas.drawRect(mThumbP4.x, mThumbP3.y, mThumbP2.x, mThumbP1.y, mRectPaint);
//        mRectPaint.setColor(Color.parseColor("#00CC00"));
//        canvas.drawRect(mOnTextRectF, mRectPaint);
//        canvas.drawRect(mOffTextRectF, mRectPaint);
//        mRectPaint.setColor(Color.parseColor("#000000"));
//        canvas.drawRect(0, 0, getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight(), mRectPaint);
    }

    private void setStartProcessPoints() {
        float thumbTop = getPaddingTop();

        mThumbP1.setY(thumbTop + 2 * mThumbRadius);
        mThumbP1.x = mThumbRadius;
        mThumbP1.left.x = mThumbP1.x - mThumbRadius * mBezierControlValue;
        mThumbP1.right.x = mThumbP1.x + mThumbRadius * mBezierControlValue;

        mThumbP2.setX(2 * mThumbRadius);
        mThumbP2.y = thumbTop + mThumbRadius;
        mThumbP2.top.y = mThumbP2.y - mThumbRadius * mBezierControlValue;
        mThumbP2.bottom.y = mThumbP2.y + mThumbRadius * mBezierControlValue;

        mThumbP3.setY(thumbTop);
        mThumbP3.x = mThumbRadius;
        mThumbP3.left.x = mThumbP3.x - mThumbRadius * mBezierControlValue;
        mThumbP3.right.x = mThumbP3.x + mThumbRadius * mBezierControlValue;

        mThumbP4.setX(0);
        mThumbP4.y = thumbTop + mThumbRadius;
        mThumbP4.top.y = mThumbP4.y - mThumbRadius * mBezierControlValue;
        mThumbP4.bottom.y = mThumbP4.y + mThumbRadius * mBezierControlValue;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

        // Maybe Todo
    }

    public final float getProcess() {
        return mProcess;
    }


    public final void setProcess(final float process) {
        float tp = process;
        if (tp > 1) {
            tp = 1;
        } else if (tp < 0) {
            tp = 0;
        }
        this.mProcess = tp;
        invalidate();
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    protected void animateToState(boolean checked) {
        if (mProcessAnimator == null) {
            return;
        }
        if (mProcessAnimator.isRunning()) {
            mProcessAnimator.cancel();
        }
        mProcessAnimator.setDuration(mDuration);
        if (checked) {
            mProcessAnimator.setFloatValues(mProcess, 1);
        } else {
            mProcessAnimator.setFloatValues(mProcess, 0);
        }
        mProcessAnimator.start();
    }

    private void catchView() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override
    public void setChecked(final boolean checked) {
        // animate before super.setChecked() because user may call setChecked again in OnCheckedChangedListener
        if (isChecked() != checked) {
            animateToState(checked);
        }
        super.setChecked(checked);
    }

    public void setCheckedImmediately(boolean checked) {
        super.setChecked(checked);
        if (mProcessAnimator != null && mProcessAnimator.isRunning()) {
            mProcessAnimator.cancel();
        }
        setProcess(checked ? 1 : 0);
        invalidate();
    }

    public void toggleImmediately() {
        setCheckedImmediately(!isChecked());
    }

}
