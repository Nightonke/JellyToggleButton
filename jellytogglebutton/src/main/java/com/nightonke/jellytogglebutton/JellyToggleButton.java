package com.nightonke.jellytogglebutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;

/**
 * Created by Weiping on 2016/5/10.
 */
public class JellyToggleButton extends CompoundButton {

    private static final int DEFAULT_BACKGROUND_COLOR = Color.parseColor("#1E59AF");
    private static final int DEFAULT_ON_THUMB_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_OFF_THUMB_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_ON_TEXT_COLOR = Color.parseColor("#4085EE");
    private static final int DEFAULT_OFF_TEXT_COLOR = Color.parseColor("#4085EE");
    private static final Typeface DEFAULT_ON_TEXT_TYPEFACE = Typeface.DEFAULT;
    private static final Typeface DEFAULT_OFF_TEXT_TYPEFACE = Typeface.DEFAULT;
    private static final String DEFAULT_ON_TEXT = "On";
    private static final String DEFAULT_OFF_TEXT = "Off";
    private static final int DEFAULT_DURATION = 250;
    private static final float DEFAULT_MARGIN_LEFT_DP = 4;
    private static final float DEFAULT_MARGIN_RIGHT_DP = 4;
    private static final float DEFAULT_MARGIN_TOP_DP = 2;
    private static final float DEFAULT_MARGIN_BOTTOM_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_LEFT_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_RIGHT_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_TOP_DP = 2;
    private static final float DEFAULT_TEXT_MARGIN_BOTTOM_DP = 2;
    private static final float DEFAULT_THUMB_AND_BACKGROUND_HORIZONTAL_MARGIN_DP = 4;
    private static final float DEFAULT_ON_TEXT_AND_OFF_TEXT_MARGIN_DP = 12;

    private int mBackgroundColor = DEFAULT_BACKGROUND_COLOR;
    private int mOnThumbColor = DEFAULT_ON_THUMB_COLOR;
    private int mOffThumbColor = DEFAULT_OFF_THUMB_COLOR;
    private int mOnTextColor = DEFAULT_ON_TEXT_COLOR;
    private int mOffTextColor = DEFAULT_OFF_TEXT_COLOR;
    private Typeface mOnTextTypeface = DEFAULT_ON_TEXT_TYPEFACE;
    private Typeface mOffTextTypeface = DEFAULT_OFF_TEXT_TYPEFACE;
    private String mOnText = DEFAULT_ON_TEXT;
    private String mOffText = DEFAULT_OFF_TEXT;

    private float mMarginLeft;
    private float mMarginRight;
    private float mMarginTop;
    private float mMarginBottom;

    private float mTextMarginLeft;
    private float mTextMarginRight;
    private float mTextMarginTop;
    private float mTextMarginBottom;

    private float mThumbAndBackgroundHorizontalMargin;
    private float mOnTextAndOffTextMargin;

    private float mThumbRadius;
    private float mBackgroundRadius;

    private Paint mPaint;
    private Paint mTextPaint;

    private float mProcess;
    private ObjectAnimator mProcessAnimator;
    private int mDuration;

    private int mTouchSlop;
    private int mClickTimeout;

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
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mProcessAnimator = ObjectAnimator.ofFloat(this, "process", 0, 0)
                .setDuration(DEFAULT_DURATION);
        mProcessAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

        Resources res = getResources();
        float density = res.getDisplayMetrics().density;
        mMarginLeft = density * DEFAULT_MARGIN_LEFT_DP;
        mMarginRight = density * DEFAULT_MARGIN_RIGHT_DP;
        mMarginTop = density * DEFAULT_MARGIN_TOP_DP;
        mMarginBottom = density * DEFAULT_MARGIN_BOTTOM_DP;
        mTextMarginLeft = density * DEFAULT_TEXT_MARGIN_LEFT_DP;
        mTextMarginRight = density * DEFAULT_TEXT_MARGIN_RIGHT_DP;
        mTextMarginTop = density * DEFAULT_TEXT_MARGIN_TOP_DP;
        mTextMarginBottom = density * DEFAULT_TEXT_MARGIN_BOTTOM_DP;
        mThumbAndBackgroundHorizontalMargin = density * DEFAULT_THUMB_AND_BACKGROUND_HORIZONTAL_MARGIN_DP;
        mOnTextAndOffTextMargin = density * DEFAULT_ON_TEXT_AND_OFF_TEXT_MARGIN_DP;

        TypedArray ta = attrs == null ?
                null : getContext().obtainStyledAttributes(attrs, R.styleable.JellyToggleButton);
        if (ta != null) {
            mBackgroundColor = ta.getColor(R.styleable.JellyToggleButton_jbtBackgroundColor, DEFAULT_BACKGROUND_COLOR);
            mOnThumbColor = ta.getColor(R.styleable.JellyToggleButton_jbtOnThumbColor, DEFAULT_ON_THUMB_COLOR);
            mOffThumbColor = ta.getColor(R.styleable.JellyToggleButton_jbtOffThumbColor, DEFAULT_OFF_THUMB_COLOR);
            mOnTextColor = ta.getColor(R.styleable.JellyToggleButton_jbtOnTextColor, DEFAULT_ON_TEXT_COLOR);
            mOffTextColor = ta.getColor(R.styleable.JellyToggleButton_jbtOnTextColor, DEFAULT_OFF_TEXT_COLOR);
            String onTypefaceString = ta.getString(R.styleable.JellyToggleButton_jbtOnTextTypeface);
            try {
                mOnTextTypeface = Typeface.createFromAsset(getContext().getAssets(), onTypefaceString);
            } catch (RuntimeException r) {
                mOnTextTypeface = Typeface.DEFAULT;
            }
            String offTypefaceString = ta.getString(R.styleable.JellyToggleButton_jbtOffTextTypeface);
            try {
                mOffTextTypeface = Typeface.createFromAsset(getContext().getAssets(), offTypefaceString);
            } catch (RuntimeException r) {
                mOffTextTypeface = Typeface.DEFAULT;
            }
            mOnText = ta.getString(R.styleable.JellyToggleButton_jbtOnText);
            mOffText = ta.getString(R.styleable.JellyToggleButton_jbtOffText);
            mMarginLeft = ta.getDimension(R.styleable.JellyToggleButton_jbtMarginLeft, mMarginLeft);
            mMarginRight = ta.getDimension(R.styleable.JellyToggleButton_jbtMarginRight, mMarginRight);


            ta.recycle();
        }



    }

}
