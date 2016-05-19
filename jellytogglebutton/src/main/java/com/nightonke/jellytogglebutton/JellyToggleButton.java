package com.nightonke.jellytogglebutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;

import com.nightonke.jellytogglebutton.ColorChangeTypes.ColorChangeType;
import com.nightonke.jellytogglebutton.EaseTypes.EaseType;
import com.nightonke.jellytogglebutton.JellyTypes.Jelly;
import com.nightonke.jellytogglebutton.JellyTypes.JellyStyle;

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

    private static final float DEFAULT_TEXT_MARGIN_LEFT_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_RIGHT_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_TOP_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_BOTTOM_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_CENTER_DP = 3;

    private static final float MIN_TEXT_MARGIN_CENTER_DP = 3;
    private static final float MAX_TEXT_MARGIN_TOP_DP = 5;
    private static final float MAX_TEXT_MARGIN_BOTTOM_DP = 5;

    private static final float DEFAULT_THUMB_RADIUS_DP = 15;

    private static final float DEFAULT_BACKGROUND_MEASURE_VALUE = 1.8f;
    private static final float DEFAULT_BACKGROUND_RADIUS_DP = 10;

    private static final float MIN_THUMB_RADIUS_DP = 15;
    private static final float MIN_BACKGROUND_MEASURE_VALUE = 1.8f;
    private static final float MIN_BACKGROUND_RADIUS_DP = 10;

    private static final int DEFAULT_DURATION = 1000;

    private static final float DEFAULT_TOUCH_MOVE_RATIO_VALUE = 5.0f;
    private static final float DEFAULT_BEZIER_CONTROL_VALUE = 0.551915024494f;
    private static final float DEFAULT_STRETCH_DISTANCE_RATIO_VALUE = 1.0f;
    private static final float DEFAULT_BEZIER_SCALE_RATIO_VALUE = 0.45f;

    private static final ColorChangeType DEFAULT_COLOR_CHANGE_TYPE = ColorChangeType.RGB;
    private static final Jelly DEFAULT_JELLY = Jelly.LAZY_TREMBLE_TAIL_FATTY;
    private static final EaseType DEFAULT_EASE_TYPE = EaseType.Linear;

    private static final boolean DEFAULT_MOVE_TO_SAME_STATE_CALL_LISTENER = false;
    private static final boolean DEFAULT_DRAGGABLE = true;

    /**
     * The following values are used to draw the JBT.
     * Library users can change these for some purposes.
     */
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

    private float mBackgroundMeasureRatio = DEFAULT_BACKGROUND_MEASURE_VALUE;
    private float mBackgroundRadius;

    /**
     * The following values are used to control the effect that JBT shows.
     * Library users can change these for some purposes.
     */
    private int mDuration = DEFAULT_DURATION;

    private float mTouchMoveRatioValue = DEFAULT_TOUCH_MOVE_RATIO_VALUE;
    private float mBezierControlValue = DEFAULT_BEZIER_CONTROL_VALUE;
    private float mStretchDistanceRatioValue = DEFAULT_STRETCH_DISTANCE_RATIO_VALUE;
    private float mBezierScaleRatioValue = DEFAULT_BEZIER_SCALE_RATIO_VALUE;

    private ColorChangeType mColorChangeType = DEFAULT_COLOR_CHANGE_TYPE;
    private Jelly mJelly = DEFAULT_JELLY;
    private Jelly mRandomJelly = null;
    private EaseType mEaseType = DEFAULT_EASE_TYPE;

    private OnStateChangeListener mOnStateChangeListener;

    private boolean mMoveToSameStateCallListener = DEFAULT_MOVE_TO_SAME_STATE_CALL_LISTENER;
    private boolean mDraggable = DEFAULT_DRAGGABLE;

    private JellyStyle mCustomJelly = null;

    /**
     * The following values are used to calculate the position or just for convenience.
     * Should not be modified by library users.
     */
    private Paint mPaint;
    private TextPaint mLeftTextPaint;
    private TextPaint mRightTextPaint;
    private Path mThumbPath;

    private Layout mLeftTextLayout;
    private Layout mRightTextLayout;
    private float mTextWidth;
    private float mTextHeight;

    private float mThumbMinRadius;
    private float mThumbMaxRadius;
    private float mThumbLeft;
    private float mThumbRight;

    private float mProcess;
    private ValueAnimator mProcessAnimator;

    private State lastState = null;
    private State mState;

    private float mStartX, mStartY, mLastX;
    private int mTouchSlop;
    private int mClickTimeout;

    private PointWithHorizontalPoints mThumbP1, mThumbP3;
    private PointWithVerticalPoints mThumbP2, mThumbP4;

    private RectF mBackgroundRectF;
    private RectF mOnTextRectF;
    private RectF mOffTextRectF;

    private int mLastRandomValue = -1;
    private boolean mStopRestoreChecked = false;

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

        setAnimator(0, true);

        Resources res = getResources();
        float density = res.getDisplayMetrics().density;

        mTextMarginLeft = DEFAULT_TEXT_MARGIN_LEFT_DP * density;
        mTextMarginRight = DEFAULT_TEXT_MARGIN_RIGHT_DP * density;
        mTextMarginTop = DEFAULT_TEXT_MARGIN_TOP_DP * density;
        mTextMarginBottom = DEFAULT_TEXT_MARGIN_BOTTOM_DP * density;
        mTextMarginCenter = DEFAULT_TEXT_MARGIN_CENTER_DP * density;
        mThumbRadius = DEFAULT_THUMB_RADIUS_DP * density;
        mBackgroundRadius = DEFAULT_BACKGROUND_RADIUS_DP * density;

        TypedArray ta = attrs == null ?
                null : getContext().obtainStyledAttributes(attrs, R.styleable.JellyToggleButton);
        if (ta != null) {
            mLeftBackgroundColor = ta.getColor(R.styleable.JellyToggleButton_jtbLeftBackgroundColor, mLeftBackgroundColor);
            mRightBackgroundColor = ta.getColor(R.styleable.JellyToggleButton_jtbRightBackgroundColor, mRightBackgroundColor);
            mLeftThumbColor = ta.getColor(R.styleable.JellyToggleButton_jtbLeftThumbColor, mLeftThumbColor);
            mRightThumbColor = ta.getColor(R.styleable.JellyToggleButton_jtbRightThumbColor, mRightThumbColor);
            mLeftTextColor = ta.getColor(R.styleable.JellyToggleButton_jtbLeftTextColor, mLeftTextColor);
            mRightTextColor = ta.getColor(R.styleable.JellyToggleButton_jtbRightTextColor, mRightTextColor);

            String leftTypefaceString = ta.getString(R.styleable.JellyToggleButton_jtbLeftTextTypeface);
            try {
                mLeftTextTypeface = Typeface.createFromAsset(getContext().getAssets(), leftTypefaceString);
            } catch (RuntimeException r) {
                mLeftTextTypeface = Typeface.DEFAULT;
            }
            mLeftTextPaint.setTypeface(mLeftTextTypeface);

            String rightTypefaceString = ta.getString(R.styleable.JellyToggleButton_jtbRightTextTypeface);
            try {
                mRightTextTypeface = Typeface.createFromAsset(getContext().getAssets(), rightTypefaceString);
            } catch (RuntimeException r) {
                mRightTextTypeface = Typeface.DEFAULT;
            }
            mRightTextPaint.setTypeface(mRightTextTypeface);

            mLeftTextSize = ta.getDimensionPixelSize(R.styleable.JellyToggleButton_jtbLeftTextSize, DEFAULT_LEFT_TEXT_SIZE);
            mLeftTextPaint.setTextSize(mLeftTextSize);
            mRightTextSize = ta.getDimensionPixelSize(R.styleable.JellyToggleButton_jtbRightTextSize, DEFAULT_RIGHT_TEXT_SIZE);
            mRightTextPaint.setTextSize(mRightTextSize);

            mLeftText = ta.getString(R.styleable.JellyToggleButton_jtbLeftText);
            mRightText = ta.getString(R.styleable.JellyToggleButton_jtbRightText);

            mTextMarginLeft = ta.getDimension(R.styleable.JellyToggleButton_jtbTextMarginLeft, mTextMarginLeft);
            mTextMarginRight = ta.getDimension(R.styleable.JellyToggleButton_jtbTextMarginRight, mTextMarginRight);
            mTextMarginTop = ta.getDimension(R.styleable.JellyToggleButton_jtbTextMarginTop, mTextMarginTop);
            mTextMarginBottom = ta.getDimension(R.styleable.JellyToggleButton_jtbTextMarginBottom, mTextMarginBottom);
            mTextMarginCenter = ta.getDimension(R.styleable.JellyToggleButton_jtbTextMarginCenter, mTextMarginCenter);

            mThumbRadius = ta.getDimension(R.styleable.JellyToggleButton_jtbThumbRadius, mThumbRadius);

            mBackgroundMeasureRatio = ta.getFloat(R.styleable.JellyToggleButton_jtbBackgroundMeasureRatioValue, mBackgroundMeasureRatio);
            mBackgroundRadius = ta.getDimension(R.styleable.JellyToggleButton_jtbBackgroundRadius, DEFAULT_BACKGROUND_RADIUS_DP * density);

            mDuration = ta.getInteger(R.styleable.JellyToggleButton_jtbDuration, DEFAULT_DURATION);

            mTouchMoveRatioValue = ta.getFloat(R.styleable.JellyToggleButton_jtbTouchMoveRatioValue, DEFAULT_TOUCH_MOVE_RATIO_VALUE);
            mBezierControlValue = ta.getFloat(R.styleable.JellyToggleButton_jtbBezierControlValue, mBezierControlValue);
            mStretchDistanceRatioValue = ta.getFloat(R.styleable.JellyToggleButton_jtbStretchDistanceRatioValue, mStretchDistanceRatioValue);
            mBezierScaleRatioValue = ta.getFloat(R.styleable.JellyToggleButton_jtbBezierScaleRatioValue, DEFAULT_BEZIER_SCALE_RATIO_VALUE);

            mMoveToSameStateCallListener = ta.getBoolean(R.styleable.JellyToggleButton_jtbMoveToSameStateCallListener, DEFAULT_MOVE_TO_SAME_STATE_CALL_LISTENER);
            mDraggable = ta.getBoolean(R.styleable.JellyToggleButton_jtbDraggable, DEFAULT_DRAGGABLE);

            int colorChangeTypeInteger = ta.getInteger(R.styleable.JellyToggleButton_jtbColorChangeType, -1);
            if (colorChangeTypeInteger != -1) mColorChangeType = ColorChangeType.values()[colorChangeTypeInteger];
            else mColorChangeType = DEFAULT_COLOR_CHANGE_TYPE;

            int jellyInteger = ta.getInteger(R.styleable.JellyToggleButton_jtbJelly, -1);
            if (jellyInteger != -1) mJelly = Jelly.values()[jellyInteger];
            else mJelly = DEFAULT_JELLY;

            int easeTypeInteger = ta.getInteger(R.styleable.JellyToggleButton_jtbEaseType, -1);
            if (easeTypeInteger != -1) mEaseType = EaseType.values()[easeTypeInteger];
            else mEaseType = DEFAULT_EASE_TYPE;

            ta.recycle();
        }

        if (mLeftText == null) mLeftText = DEFAULT_LEFT_TEXT;
        if (mRightText == null) mRightText = DEFAULT_RIGHT_TEXT;

        mLeftTextPaint.setTextSize(mLeftTextSize);
        mRightTextPaint.setTextSize(mRightTextSize);

        setFocusable(true);
        setClickable(true);

        if (isChecked()) {
            setProcess(1, false);
            mState = State.RIGHT;
        } else {
            setProcess(0, false);
            mState = State.LEFT;
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
        setup();
    }

    private int measureWidth(int widthMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measuredWidth;

        int minWidth = (int) (mThumbRadius * 2 * mBackgroundMeasureRatio);
        float leftWidth = mLeftTextLayout != null ? mLeftTextLayout.getWidth() : 0;
        float rightWidth = mRightTextLayout != null ? mRightTextLayout.getWidth() : 0;
        float leftHeight = mLeftTextLayout != null ? mLeftTextLayout.getHeight() : 0;
        float rightHeight = mRightTextLayout != null ? mRightTextLayout.getHeight() : 0;
        mTextWidth = Math.max(leftWidth, rightWidth);
        mTextHeight = Math.max(leftHeight, rightHeight);
        float leftMaxThumbToText = Math.max(mTextMarginCenter, mTextMarginLeft);
        float rightMaxThumbToText = Math.max(mTextMarginCenter, mTextMarginRight);
        float centerMaxLength = Math.max(mTextMarginCenter, Math.max(leftMaxThumbToText, rightMaxThumbToText));
        minWidth = Math.max(minWidth, (int) (leftMaxThumbToText + mTextWidth + centerMaxLength + mTextWidth + rightMaxThumbToText));
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

        if (leftWidth != 0 || rightWidth != 0) {
            // if there are text on jelly
            // calculate the radius of the thumb
            mThumbMinRadius = Math.max(mTextWidth / 2 + mTextMarginLeft, mTextWidth / 2 + mTextMarginRight);
            mThumbMaxRadius = mTextWidth / 2 + Math.max(leftMaxThumbToText, rightMaxThumbToText);

            if (mThumbRadius < mThumbMinRadius) mThumbRadius = mThumbMinRadius;
            if (mThumbRadius > mThumbMaxRadius) mThumbRadius = mThumbMaxRadius;
            mThumbRadius = Math.max(mThumbRadius, MIN_THUMB_RADIUS_DP * getResources().getDisplayMetrics().density);
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

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        Log.d("Jelly", "onSizeChanged");
//        super.onSizeChanged(w, h, oldw, oldh);
//        if (w != oldw || h != oldh) {
//            setup();
//        }
//    }

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

        if (mCustomJelly != null) {
            // use custom jelly
            mCustomJelly.changeShape(mThumbP1, mThumbP2, mThumbP3, mThumbP4, mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius, mProcess, mState);
            mCustomJelly.changeOffset(mThumbP1, mThumbP2, mThumbP3, mThumbP4, getNoExtractTotalLength(), mCustomJelly.extractLength(mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius), mProcess, mState, mEaseType);
        } else if (Jelly.RANDOM.equals(mJelly) && mRandomJelly != null) {
            // use random jelly
            mRandomJelly.changeShape(mThumbP1, mThumbP2, mThumbP3, mThumbP4, mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius, mProcess, mState);
            mRandomJelly.changeOffset(mThumbP1, mThumbP2, mThumbP3, mThumbP4, getNoExtractTotalLength(), mRandomJelly.extractLength(mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius), mProcess, mState, mEaseType);
        } else {
            // use a certain jelly
            mJelly.changeShape(mThumbP1, mThumbP2, mThumbP3, mThumbP4, mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius, mProcess, mState);
            mJelly.changeOffset(mThumbP1, mThumbP2, mThumbP3, mThumbP4, getNoExtractTotalLength(), mJelly.extractLength(mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius), mProcess, mState, mEaseType);
        }

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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (!isEnabled() || !isClickable()) {
            return false;
        }

        int action = event.getAction();

        float deltaX = event.getX() - mStartX;
        float deltaY = event.getY() - mStartY;

        // status the view going to change to when finger released
        boolean nextStatus;

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                catchView();
                mStartX = event.getX();
                mStartY = event.getY();
                mLastX = mStartX;
                setPressed(true);
                break;

            case MotionEvent.ACTION_MOVE:
                if (!mDraggable) return true;
                float x = event.getX();
                setProcess(getProcess() + (x - mLastX) / (getNoExtractTotalLength() * mTouchMoveRatioValue), true);
                mLastX = x;
                break;

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setPressed(false);
                nextStatus = getStatusBasedOnPos();
                float time = event.getEventTime() - event.getDownTime();
                if (deltaX < mTouchSlop && deltaY < mTouchSlop && time < mClickTimeout) {
                    performClick();
                } else {
                    if (nextStatus != isChecked()) {
                        playSoundEffect(SoundEffectConstants.CLICK);
                        animateToState(nextStatus, true, true);
                    } else {
                        animateToState(nextStatus, mMoveToSameStateCallListener, true);
                    }
                }
                break;

            default:
                break;
        }
        return true;
    }

    private void setStartProcessPoints() {
        float thumbTop = getPaddingTop();
        float thumbLeft = getPaddingLeft();

        mThumbP1.setY(thumbTop + 2 * mThumbRadius);
        mThumbP1.x = thumbLeft + mThumbRadius;
        mThumbP1.left.x = mThumbP1.x - mThumbRadius * mBezierControlValue;
        mThumbP1.right.x = mThumbP1.x + mThumbRadius * mBezierControlValue;

        mThumbP2.setX(thumbLeft + 2 * mThumbRadius);
        mThumbP2.y = thumbTop + mThumbRadius;
        mThumbP2.top.y = mThumbP2.y - mThumbRadius * mBezierControlValue;
        mThumbP2.bottom.y = mThumbP2.y + mThumbRadius * mBezierControlValue;

        mThumbP3.setY(thumbTop);
        mThumbP3.x = thumbLeft + mThumbRadius;
        mThumbP3.left.x = mThumbP3.x - mThumbRadius * mBezierControlValue;
        mThumbP3.right.x = mThumbP3.x + mThumbRadius * mBezierControlValue;

        mThumbP4.setX(thumbLeft + 0);
        mThumbP4.y = thumbTop + mThumbRadius;
        mThumbP4.top.y = mThumbP4.y - mThumbRadius * mBezierControlValue;
        mThumbP4.bottom.y = mThumbP4.y + mThumbRadius * mBezierControlValue;
    }

    private float getNoExtractTotalLength() {
        if (mCustomJelly != null) {
            // use custom jelly
            return mThumbRight - mThumbLeft - 2 * mThumbRadius - mCustomJelly.extractLength(mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius);
        } else if (Jelly.RANDOM.equals(mJelly) && mRandomJelly != null) {
            // use random jelly
            return mThumbRight - mThumbLeft - 2 * mThumbRadius - mRandomJelly.extractLength(mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius);
        } else {
            // use a certain jelly
            return mThumbRight - mThumbLeft - 2 * mThumbRadius - mJelly.extractLength(mStretchDistanceRatioValue * mThumbRadius, mBezierControlValue, mBezierScaleRatioValue, mThumbRadius);
        }
    }

    private boolean getStatusBasedOnPos() {
        return getProcess() > 0.5f;
    }

    private final float getProcess() {
        return mProcess;
    }

    private void setProcess(float process, boolean callListener) {
        float tp = process;
        if (tp >= 1) {
            tp = 1;
            mState = State.RIGHT;
        } else if (tp <= 0) {
            tp = 0;
            mState = State.LEFT;
        } else {
            if (mState.equals(State.RIGHT)) {
                mState = State.RIGHT_TO_LEFT;
            } else if (mState.equals(State.LEFT)) {
                mState = State.LEFT_TO_RIGHT;
            }
        }
        this.mProcess = tp;
        if (mState.equals(State.LEFT)) {
            super.setChecked(false);
            // if the jelly type is random, change it here
            if (mJelly.equals(Jelly.RANDOM)) randomChangeJelly();
        }
        if (mState.equals(State.RIGHT)) {
            super.setChecked(true);
            // if the jelly type is random, change it here
            if (mJelly.equals(Jelly.RANDOM)) randomChangeJelly();
        }
        if (callListener && mOnStateChangeListener != null) {
            if (mState.equals(State.LEFT) || mState.equals(State.RIGHT)) {
                // at this time, we don't need to call the listener
                if (!mState.equals(lastState)) {
                    mOnStateChangeListener.onStateChange(mProcess, mState, this);
                }
            } else {
                mOnStateChangeListener.onStateChange(mProcess, mState, this);
            }
        }
        lastState = mState;
        invalidate();
    }

    private void randomChangeJelly() {
        int r = (int) (Math.random() * 17);
        while (r == mLastRandomValue) r = (int) (Math.random() * 17);
        mLastRandomValue = r;
        mRandomJelly = Jelly.values()[r];
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    private void animateToState(boolean checked, boolean callListener, boolean resetToTarget) {
        if (mProcessAnimator == null) {
            return;
        }
        if (mProcessAnimator.isRunning()) {
            return;
        }
        if (checked) {
            setAnimator(1, callListener);
        } else {
            setAnimator(0, callListener);
        }
        int duration = mDuration;
        if (resetToTarget) {
            // this situation happens when user drag the thumb to target,
            // but then leave the target for a bit.
            if (checked) duration *= 1 - mProcess;
            else duration *= mProcess - 0;
        }
        mProcessAnimator.setDuration(duration);
        mProcessAnimator.start();
    }

    private void catchView() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override
    public boolean isChecked() {
        return super.isChecked();
    }

    @Override
    public void setChecked(boolean checked) {
        if (mStopRestoreChecked) return;
        setChecked(checked, true);
    }

    public void setChecked(boolean checked, boolean callListener) {
        mProcess = checked ? 0 : 1;
        if (callListener) lastState = checked ? State.LEFT : State.RIGHT;
        animateToState(checked, callListener, false);
        super.setChecked(checked);
    }

    public void setCheckedImmediately(boolean checked) {
        setCheckedImmediately(checked, true);
    }

    public void setCheckedImmediately(boolean checked, boolean callListener) {
        super.setChecked(checked);
        if (mProcessAnimator != null && mProcessAnimator.isRunning()) {
            mProcessAnimator.cancel();
        }
        if (callListener) lastState = null;
        setProcess(checked ? 1 : 0, callListener);
    }

    private void setAnimator(float target, final boolean callListener) {
        mProcessAnimator = ValueAnimator.ofFloat(mProcess, target);
        mProcessAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setProcess((Float) animation.getAnimatedValue(), callListener);
            }
        });
        mProcessAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mProcess == 0) JellyToggleButton.super.setChecked(false);
                if (mProcess == 1) JellyToggleButton.super.setChecked(true);
                super.onAnimationEnd(animation);
            }
        });
        mProcessAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean callListener) {
        setChecked(!isChecked(), callListener);
    }

    public void toggleImmediately() {
        toggleImmediately(true);
    }

    public void toggleImmediately(boolean callListener) {
        setCheckedImmediately(!isChecked(), callListener);
    }

    public int getLeftBackgroundColor() {
        return mLeftBackgroundColor;
    }

    public void setLeftBackgroundColor(int color) {
        this.mLeftBackgroundColor = color;
        invalidate();
    }

    public void setLeftBackgroundColor(String color) {
        setLeftBackgroundColor(Color.parseColor(color));
    }

    public void setLeftBackgroundColorRes(int res) {
        setLeftBackgroundColor(ContextCompat.getColor(getContext(), res));
    }

    public int getRightBackgroundColor() {
        return mRightBackgroundColor;
    }

    public void setRightBackgroundColor(int color) {
        this.mRightBackgroundColor = color;
        invalidate();
    }

    public void setRightBackgroundColor(String color) {
        setRightBackgroundColor(Color.parseColor(color));
    }

    public void setRightBackgroundColorRes(int res) {
        setRightBackgroundColor(ContextCompat.getColor(getContext(), res));
    }

    public void setBackgroundColor(int color) {
        setLeftBackgroundColor(color);
        setRightBackgroundColor(color);
    }

    public void setBackgroundColor(String color) {
        setBackgroundColor(Color.parseColor(color));
    }

    public void setBackgroundColorRes(int res) {
        setBackgroundColor(ContextCompat.getColor(getContext(), res));
    }

    public int getLeftThumbColor() {
        return mLeftThumbColor;
    }

    public void setLeftThumbColor(int color) {
        this.mLeftThumbColor = color;
        invalidate();
    }

    public void setLeftThumbColor(String color) {
        setLeftThumbColor(Color.parseColor(color));
    }

    public void setLeftThumbColorRes(int res) {
        setLeftThumbColor(ContextCompat.getColor(getContext(), res));
    }

    public int getRightThumbColor() {
        return mRightThumbColor;
    }

    public void setRightThumbColor(int color) {
        this.mRightThumbColor = color;
        invalidate();
    }

    public void setRightThumbColor(String color) {
        setRightThumbColor(Color.parseColor(color));
    }

    public void setRightThumbColorRes(int res) {
        setRightThumbColor(ContextCompat.getColor(getContext(), res));
    }

    public void setThumbColor(int color) {
        setLeftThumbColor(color);
        setRightThumbColor(color);
    }

    public void setThumbColor(String color) {
        setThumbColor(Color.parseColor(color));
    }

    public void setThumbColorRes(int res) {
        setThumbColor(ContextCompat.getColor(getContext(), res));
    }

    public int getLeftTextColor() {
        return mLeftTextColor;
    }

    public void setLeftTextColor(int color) {
        this.mLeftTextColor = color;
        invalidate();
    }

    public void setLeftTextColor(String color) {
        setLeftTextColor(Color.parseColor(color));
    }

    public void setLeftTextColorRes(int res) {
        setLeftTextColor(ContextCompat.getColor(getContext(), res));
    }

    public int getRightTextColor() {
        return mRightTextColor;
    }

    public void setRightTextColor(int color) {
        this.mRightTextColor = color;
        invalidate();
    }

    public void setRightTextColor(String color) {
        setRightTextColor(Color.parseColor(color));
    }

    public void setRightTextColorRes(int res) {
        setRightTextColor(ContextCompat.getColor(getContext(), res));
    }

    public void setTextColor(int color) {
        setLeftTextColor(color);
        setRightTextColor(color);
    }

    public void setTextColor(String color) {
        setTextColor(Color.parseColor(color));
    }

    public void setTextColorRes(int res) {
        setTextColor(ContextCompat.getColor(getContext(), res));
    }

    public Typeface getLeftTextTypeface() {
        return mLeftTextTypeface;
    }

    public void setLeftTextTypeface(Typeface typeface) {
        this.mLeftTextTypeface = typeface;
        mLeftTextPaint.setTypeface(typeface);

        mLeftTextLayout = null;
        requestLayout();
    }

    public void setLeftTextTypeface(String typefaceString) {
        try {
            mLeftTextTypeface = Typeface.createFromAsset(getContext().getAssets(), typefaceString);
        } catch (RuntimeException r) {
            mLeftTextTypeface = Typeface.DEFAULT;
        }
        mLeftTextPaint.setTypeface(mLeftTextTypeface);

        mLeftTextLayout = null;
        requestLayout();
    }

    public Typeface getRightTextTypeface() {
        return mRightTextTypeface;
    }

    public void setRightTextTypeface(Typeface typeface) {
        this.mRightTextTypeface = typeface;
        mRightTextPaint.setTypeface(typeface);

        mRightTextLayout = null;
        requestLayout();
    }

    public void setRightTextTypeface(String typefaceString) {
        try {
            mRightTextTypeface = Typeface.createFromAsset(getContext().getAssets(), typefaceString);
        } catch (RuntimeException r) {
            mRightTextTypeface = Typeface.DEFAULT;
        }
        mRightTextPaint.setTypeface(mRightTextTypeface);

        mRightTextLayout = null;
        requestLayout();
    }

    public void setTextTypeface(Typeface typeface) {
        setLeftTextTypeface(typeface);
        setRightTextTypeface(typeface);
    }

    public void setTextTypeface(String typefaceString) {
        setLeftTextTypeface(typefaceString);
        setRightTextTypeface(typefaceString);
    }

    public int getLeftTextSize() {
        return mLeftTextSize;
    }

    public void setLeftTextSize(int textSize) {
        this.mLeftTextSize = textSize;

        if (mLeftTextPaint != null) mLeftTextPaint.setTextSize(mLeftTextSize);

        mLeftTextLayout = null;
        mRightTextLayout = null;
        requestLayout();
    }

    public void setLeftTextSizeRes(int res) {
        setLeftTextSize(getContext().getResources().getDimensionPixelSize(res));
    }

    public int getRightTextSize() {
        return mRightTextSize;
    }

    public void setRightTextSize(int textSize) {
        this.mRightTextSize = textSize;

        if (mRightTextPaint != null) mRightTextPaint.setTextSize(mRightTextSize);

        mLeftTextLayout = null;
        mRightTextLayout = null;
        requestLayout();
    }

    public void setRightTextSizeRes(int res) {
        setRightTextSize(getContext().getResources().getDimensionPixelSize(res));
    }

    public void setTextSize(int textSize) {
        setLeftTextSize(textSize);
        setRightTextSize(textSize);
    }

    public void setTextSizeRes(int res) {
        setTextSize(getContext().getResources().getDimensionPixelSize(res));
    }

    public String getLeftText() {
        return mLeftText;
    }

    public void setLeftText(String text) {
        this.mLeftText = text;

        mLeftTextLayout = null;
        requestLayout();
    }

    public void setLeftTextRes(int res) {
        setLeftText(getContext().getResources().getString(res));
    }

    public String getRightText() {
        return mRightText;
    }

    public void setRightText(String text) {
        this.mRightText = text;

        mRightTextLayout = null;
        requestLayout();
    }

    public void setRightTextRes(int res) {
        setRightText(getContext().getResources().getString(res));
    }

    public void setText(String leftText, String rightText) {
        setLeftText(leftText);
        setRightText(rightText);
    }

    public void setTextRes(int leftRes, int rightRes) {
        setLeftText(getContext().getResources().getString(leftRes));
        setRightText(getContext().getResources().getString(rightRes));
    }

    public float getTextMarginLeft() {
        return mTextMarginLeft;
    }

    public void setTextMarginLeft(float margin) {
        mTextMarginLeft = margin;
        requestLayout();
    }

    public void setTextMarginLeftRes(int res) {
        setTextMarginLeft(getContext().getResources().getDimension(res));
    }

    public float getTextMarginRight() {
        return mTextMarginRight;
    }

    public void setTextMarginRight(float margin) {
        mTextMarginRight = margin;
        requestLayout();
    }

    public void setTextMarginRightRes(int res) {
        setTextMarginRight(getContext().getResources().getDimension(res));
    }

    public float getTextMarginTop() {
        return mTextMarginTop;
    }

    public void setTextMarginTop(float margin) {
        mTextMarginTop = Math.min(margin, MAX_TEXT_MARGIN_TOP_DP * getResources().getDisplayMetrics().density);
        requestLayout();
    }

    public void setTextMarginTopRes(int res) {
        setTextMarginTop(getContext().getResources().getDimension(res));
    }

    public float getTextMarginBottom() {
        return mTextMarginBottom;
    }

    public void setTextMarginBottom(float margin) {
        mTextMarginBottom = Math.min(margin, MAX_TEXT_MARGIN_BOTTOM_DP * getResources().getDisplayMetrics().density);
        requestLayout();
    }

    public void setTextMarginBottomRes(int res) {
        setTextMarginBottom(getContext().getResources().getDimension(res));
    }

    public float getTextMarginCenter() {
        return mTextMarginCenter;
    }

    public void setTextMarginCenter(float margin) {
        mTextMarginCenter = Math.max(margin, MIN_TEXT_MARGIN_CENTER_DP * getResources().getDisplayMetrics().density);
        requestLayout();
    }

    public void setTextMarginCenterRes(int res) {
        setTextMarginCenter(getContext().getResources().getDimension(res));
    }

    public float getThumbRadius() {
        return mThumbRadius;
    }

    public void setThumbRadius(float radius) {
        mThumbRadius = Math.max(radius, MIN_THUMB_RADIUS_DP * getResources().getDisplayMetrics().density);
        requestLayout();
    }

    public void setThumbRadiusRes(int res) {
        setThumbRadius(getContext().getResources().getDimension(res));
    }

    public float getBackgroundMeasureRatio() {
        return mBackgroundMeasureRatio;
    }

    public void setBackgroundMeasureRatio(float ratio) {
        mBackgroundMeasureRatio = ratio;
        mBackgroundMeasureRatio = Math.max(ratio, MIN_BACKGROUND_MEASURE_VALUE);
        requestLayout();
    }

    public void setBackgroundMeasureRatioRes(int res) {
        TypedValue outValue = new TypedValue();
        getResources().getValue(res, outValue, true);
        setBackgroundMeasureRatio(outValue.getFloat());
    }

    public float getBackgroundRadius() {
        return mBackgroundRadius;
    }

    public boolean isDraggable() {
        return mDraggable;
    }

    public void setDraggable(boolean draggable) {
        this.mDraggable = draggable;
    }

    public void setBackgroundRadius(float radius) {
        mBackgroundRadius = radius;
        mBackgroundRadius = Math.max(radius, MIN_BACKGROUND_RADIUS_DP * getResources().getDisplayMetrics().density);
        requestLayout();
    }

    public void setBackgroundRadiusRes(int res) {
        TypedValue outValue = new TypedValue();
        getResources().getValue(res, outValue, true);
        setBackgroundRadius(outValue.getFloat());
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
        mProcessAnimator.setDuration(duration);
    }

    public void setDurationRes(int res) {
        setDuration(getResources().getInteger(res));
    }

    public float getTouchMoveRatioValue() {
        return mTouchMoveRatioValue;
    }

    public void setTouchMoveRatioValue(float ratio) {
        mTouchMoveRatioValue = ratio;
    }

    public void setTouchMoveRatioValueRes(int res) {
        TypedValue outValue = new TypedValue();
        getResources().getValue(res, outValue, true);
        setTouchMoveRatioValue(outValue.getFloat());
    }

    public float getBezierControlValue() {
        return mBezierControlValue;
    }

    public void setBezierControlValue(float value) {
        mBezierControlValue = value;
        requestLayout();
    }

    public void setBezierControlValueRes(int res) {
        TypedValue outValue = new TypedValue();
        getResources().getValue(res, outValue, true);
        setBezierControlValue(outValue.getFloat());
    }

    public float getStretchDistanceRatioValue() {
        return mStretchDistanceRatioValue;
    }

    public void setStretchDistanceRatioValue(float value) {
        mStretchDistanceRatioValue = value;
    }

    public float getBezierScaleRatioValue() {
        return mBezierScaleRatioValue;
    }

    public void setBezierScaleRatioValue(float value) {
        mBezierScaleRatioValue = value;
    }

    public void setBezierScaleRatioValueRes(int res) {
        TypedValue outValue = new TypedValue();
        getResources().getValue(res, outValue, true);
        setBezierScaleRatioValue(outValue.getFloat());
    }

    public ColorChangeType getColorChangeType() {
        return mColorChangeType;
    }

    public void setColorChangeType(ColorChangeType colorChangeType) {
        mColorChangeType = colorChangeType;
    }

    public Jelly getJelly() {
        return mJelly;
    }

    public void setJelly(Jelly jelly) {
        mJelly = jelly;
    }

    public EaseType getEaseType() {
        return mEaseType;
    }

    public void setEaseType(EaseType easeType) {
        mEaseType = easeType;
    }

    public OnStateChangeListener getOnStateChangeListener() {
        return mOnStateChangeListener;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        mOnStateChangeListener = onStateChangeListener;
    }

    public JellyStyle getCustomJelly() {
        return mCustomJelly;
    }

    public void setCustomJelly(JellyStyle customJelly) {
        mCustomJelly = customJelly;
    }

    public void removeCustomJelly() {
        mCustomJelly = null;
    }

    public boolean getMoveToSameStateCallListener() {
        return mMoveToSameStateCallListener;
    }

    public void setMoveToSameStateCallListener(boolean callListener) {
        mMoveToSameStateCallListener = callListener;
    }

    public interface OnStateChangeListener {
        void onStateChange(float process, State state, JellyToggleButton jtb);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.leftText = mLeftText;
        ss.rightText = mRightText;
        ss.isChecked = isChecked();
        return ss;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        setText(ss.leftText, ss.rightText);
        setCheckedImmediately(ss.isChecked, false);
        mStopRestoreChecked = true;
        super.onRestoreInstanceState(ss.getSuperState());
        mStopRestoreChecked = false;
    }

    static class SavedState extends BaseSavedState {
        String leftText;
        String rightText;
        boolean isChecked = false;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            leftText = in.readString();
            rightText = in.readString();
            isChecked = in.readByte() != 0;
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(leftText);
            out.writeString(rightText);
            out.writeByte((byte) (isChecked ? 1 : 0));
        }

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
