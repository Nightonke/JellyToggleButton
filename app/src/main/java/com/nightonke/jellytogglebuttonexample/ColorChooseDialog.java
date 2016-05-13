package com.nightonke.jellytogglebuttonexample;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Weiping on 2016/5/13.
 */
public class ColorChooseDialog extends Dialog {

    private String mTitle = "";
    private int mColor = Color.parseColor("#000000");
    private int mTag = -1;

    private Context mContext;
    private OnColorChoseListener mListener;

    private TextView title;
    private TextView colorValue;
    private View indicator;
    private MySeekBar colorR;
    private TextView colorRValue;
    private MySeekBar colorG;
    private TextView colorGValue;
    private MySeekBar colorB;
    private TextView colorBValue;
    private View cancel;
    private View ok;

    public ColorChooseDialog(Context context, String title, int color, int tag) {
        super(context);

        this.mContext = context;
        this.mTitle = title;
        this.mColor = color;
        this.mTag = tag;

        try {
            this.mListener = (OnColorChoseListener) context;
        } catch (ClassCastException c) {
            c.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_color_choose);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = (int) (getScreenWidth(mContext) * 0.8f);
        getWindow().setAttributes(params);

        title = findView(R.id.title);
        colorValue = findView(R.id.color);
        indicator = findView(R.id.colorIndicator);
        colorR = findView(R.id.colorR);
        colorR.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
        colorRValue = findView(R.id.colorRValue);
        colorG = findView(R.id.colorG);
        colorG.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
        colorGValue = findView(R.id.colorGValue);
        colorB = findView(R.id.colorB);
        colorB.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
        colorBValue = findView(R.id.colorBValue);
        cancel = findView(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorChooseDialog.this.dismiss();
                if (mListener != null) mListener.cancel();
            }
        });
        ok = findView(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorChooseDialog.this.dismiss();
                if (mListener != null) mListener.ok(mColor, mTag);
            }
        });

        setColor(mColor);
        setTitle(mTitle);
    }


    public ColorChooseDialog setColor(int color) {
        mColor = color;

        colorR.setProgress(Color.red(mColor));
        colorRValue.setText(Color.red(mColor) + "");
        colorG.setProgress(Color.green(mColor));
        colorGValue.setText(Color.green(mColor) + "");
        colorB.setProgress(Color.blue(mColor));
        colorBValue.setText(Color.blue(mColor) + "");

        title.setTextColor(mColor);
        colorValue.setText(decToHex(mColor));
        indicator.setBackgroundColor(mColor);

        setSeekBarColor(colorR, mColor);
        setSeekBarColor(colorG, mColor);
        setSeekBarColor(colorB, mColor);

        return this;
    }

    public ColorChooseDialog setTag(int tag) {
        mTag = tag;
        return this;
    }

    public ColorChooseDialog setTitle(String titleString) {
        title.setText(titleString);
        return this;
    }

    public static class Builder {
        protected Context mContext;
        protected String mTitle;
        protected int mColor;
        protected int mTag;

        public Builder(Context context) {
            this.mContext = context;
        }

        Builder title(String title) {
            mTitle = title;
            return this;
        }

        Builder color(int color) {
            mColor = color;
            return this;
        }

        Builder tag(int tag) {
            mTag = tag;
            return this;
        }

        @UiThread
        public ColorChooseDialog build() {
            return new ColorChooseDialog(mContext, mTitle, mColor, mTag);
        }

        @UiThread
        public ColorChooseDialog show() {
            ColorChooseDialog dialog = build();
            dialog.show();
            return dialog;
        }
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    public interface OnColorChoseListener {
        void ok(int color, int tag);
        void cancel();
    }

    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                setColor(Color.rgb(colorR.getProgress(), colorG.getProgress(), colorB.getProgress()));
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void setSeekBarColor(MySeekBar seekBar, int newColor){
        seekBar.getProgressDrawable().setColorFilter(newColor, PorterDuff.Mode.SRC_IN);
        seekBar.getSeekBarThumb().setColorFilter(newColor, PorterDuff.Mode.SRC_IN);
    }

    private int getScreenWidth(Context context) {
        Display localDisplay
                = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay();
        Point point = new Point();
        localDisplay.getSize(point);
        return point.x;
    }

    private int getScreenHeight(Context context) {
        Display localDisplay
                = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay();
        Point point = new Point();
        localDisplay.getSize(point);
        return point.y;
    }

    private String decToHex(int color) {
        String r = Integer.toHexString(Color.red(color));
        if (r.length() == 1) r = "0" + r;
        String g = Integer.toHexString(Color.green(color));
        if (g.length() == 1) g = "0" + g;
        String b = Integer.toHexString(Color.blue(color));
        if (b.length() == 1) b = "0" + b;
        return "#" + r + g + b;
    }
}
