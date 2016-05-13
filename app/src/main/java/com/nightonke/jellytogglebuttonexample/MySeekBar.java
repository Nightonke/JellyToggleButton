package com.nightonke.jellytogglebuttonexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by Weiping on 2016/5/13.
 */
public class MySeekBar extends SeekBar {

    public MySeekBar(Context context) {
        super(context);
    }
    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MySeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    Drawable mThumb;
    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
        mThumb = thumb;
    }
    public Drawable getSeekBarThumb() {
        return mThumb;
    }

}
