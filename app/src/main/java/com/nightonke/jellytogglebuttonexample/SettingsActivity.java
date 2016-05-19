package com.nightonke.jellytogglebuttonexample;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.jellytogglebutton.ColorChangeTypes.ColorChangeType;
import com.nightonke.jellytogglebutton.EaseTypes.EaseType;
import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.JellyTypes.Jelly;
import com.nightonke.jellytogglebutton.State;

public class SettingsActivity extends AppCompatActivity
        implements
        View.OnClickListener,
        JellyToggleButton.OnStateChangeListener,
        ColorChooseDialog.OnColorChoseListener {

    private Toast lastToast;

    private LinearLayout base;

    private JellyToggleButton jtb;

    private ProgressBar progressBar;

    private TextView durationText;
    private SeekBar durationSeekBar;
    
    private TextView fontSizeText;
    private SeekBar fontSizeSeekBar;

    private EditText leftText;
    private EditText rightText;

    private TextView textMarginLeftRightText;
    private SeekBar textMarginLeftRightSeekBar;

    private TextView textMarginCenterText;
    private SeekBar textMarginCenterSeekBar;

    private TextView textMarginTopBottomText;
    private SeekBar textMarginTopBottomSeekBar;

    private RadioGroup colorChangeType;

    private Spinner easeTypes;

    private Spinner jellys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        base = findView(R.id.base);

        setActivityBackgroundColor(ContextCompat.getColor(this, R.color.jtbBackground));

        jtb = findView(R.id.jtb);
        jtb.setOnStateChangeListener(this);

        progressBar = findView(R.id.progress);

        findView(R.id.set_check_with_listener).setOnClickListener(this);
        findView(R.id.set_check_without_listener).setOnClickListener(this);
        findView(R.id.set_check_immediately_with_listener).setOnClickListener(this);
        findView(R.id.set_check_immediately_without_listener).setOnClickListener(this);
        findView(R.id.toggle_with_listener).setOnClickListener(this);
        findView(R.id.toggle_without_listener).setOnClickListener(this);
        findView(R.id.toggle_immediately_with_listener).setOnClickListener(this);
        findView(R.id.toggle_immediately_without_listener).setOnClickListener(this);
        findView(R.id.color_left_background).setOnClickListener(this);
        findView(R.id.color_right_background).setOnClickListener(this);
        findView(R.id.color_background).setOnClickListener(this);
        findView(R.id.color_left_thumb).setOnClickListener(this);
        findView(R.id.color_right_thumb).setOnClickListener(this);
        findView(R.id.color_thumb).setOnClickListener(this);
        findView(R.id.color_left_text).setOnClickListener(this);
        findView(R.id.color_right_text).setOnClickListener(this);
        findView(R.id.color_text).setOnClickListener(this);
        findView(R.id.color_activity_background).setOnClickListener(this);
        findView(R.id.font_hairline).setOnClickListener(this);
        findView(R.id.font_light).setOnClickListener(this);
        findView(R.id.font_default).setOnClickListener(this);
        findView(R.id.draggable).setOnClickListener(this);
        findView(R.id.custom).setOnClickListener(this);
        findView(R.id.remove_custom).setOnClickListener(this);

        durationText = findView(R.id.duration_text);
        durationSeekBar = findView(R.id.duration);
        durationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int duration = progress * 500 + 500;
                durationText.setText(duration + "ms");
                jtb.setDuration(duration);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        durationSeekBar.setProgress((jtb.getDuration() - 500) / 500);
        
        fontSizeText = findView(R.id.font_size_text);
        fontSizeSeekBar = findView(R.id.font_size);
        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fontSize = progress + 15;
                fontSizeText.setText(fontSize + "");
                jtb.setTextSize(fontSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        fontSizeSeekBar.setProgress((int) (jtb.getTextSize() - 15));
        
        leftText = findView(R.id.left_text);
        leftText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                jtb.setLeftText(leftText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        leftText.setText(jtb.getLeftText());

        rightText = findView(R.id.right_text);
        rightText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                jtb.setRightText(rightText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rightText.setText(jtb.getRightText());

        textMarginLeftRightText = findView(R.id.text_margin_left_right_text);
        textMarginLeftRightSeekBar = findView(R.id.text_margin_left_right);
        textMarginLeftRightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                jtb.setTextMarginLeft(dpToPx(progress));
                jtb.setTextMarginRight(dpToPx(progress));
                textMarginLeftRightText.setText("Margin Left and Margin Right: " + progress + "dp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        textMarginLeftRightSeekBar.setProgress(pxToDp((int) jtb.getTextMarginLeft()));

        textMarginCenterText = findView(R.id.text_margin_center_text);
        textMarginCenterSeekBar = findView(R.id.text_margin_center);
        textMarginCenterSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                jtb.setTextMarginCenter(dpToPx(progress));
                textMarginCenterText.setText("Margin Center: " + progress + "dp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        textMarginCenterSeekBar.setProgress(pxToDp((int) jtb.getTextMarginCenter()));

        textMarginTopBottomText = findView(R.id.text_margin_top_bottom_text);
        textMarginTopBottomSeekBar = findView(R.id.text_margin_top_bottom);
        textMarginTopBottomSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                jtb.setTextMarginTop(dpToPx(progress));
                jtb.setTextMarginBottom(dpToPx(progress));
                textMarginTopBottomText.setText("Margin Top and Margin Bottom: " + progress + "dp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        textMarginTopBottomSeekBar.setProgress(pxToDp((int) jtb.getTextMarginTop()));

        colorChangeType = findView(R.id.color_change_type);
        colorChangeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.color_change_type_rgb:
                        jtb.setColorChangeType(ColorChangeType.RGB);
                        break;
                    case R.id.color_change_type_hsv:
                        jtb.setColorChangeType(ColorChangeType.HSV);
                        break;
                }
            }
        });
        colorChangeType.check(R.id.color_change_type_rgb);

        easeTypes = findView(R.id.ease_types);
        easeTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jtb.setEaseType(EaseType.values()[position]);
                jtb.setEaseType(EaseType.EaseInOutCirc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        easeTypes.setSelection(30);

        jellys = findView(R.id.jellys);
        jellys.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jtb.setJelly(Jelly.values()[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        jellys.setSelection(1);
    }

    @Override
    public void onStateChange(float process, State state, JellyToggleButton jbt) {
        if (state.equals(State.LEFT)) {
            if (lastToast != null) lastToast.cancel();
            lastToast = Toast.makeText(this, "Left!", Toast.LENGTH_SHORT);
            lastToast.show();
        }
        if (state.equals(State.RIGHT)) {
            if (lastToast != null) lastToast.cancel();
            lastToast = Toast.makeText(this, "Right!", Toast.LENGTH_SHORT);
            lastToast.show();
        }
        progressBar.setProgress((int) (100 * process));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_check_with_listener:
                jtb.setChecked(!jtb.isChecked());
                break;
            case R.id.set_check_without_listener:
                jtb.setChecked(!jtb.isChecked(), false);
                break;
            case R.id.set_check_immediately_with_listener:
                jtb.setCheckedImmediately(!jtb.isChecked());
                break;
            case R.id.set_check_immediately_without_listener:
                jtb.setCheckedImmediately(!jtb.isChecked(), false);
                break;
            case R.id.toggle_with_listener:
                jtb.toggle();
                break;
            case R.id.toggle_without_listener:
                jtb.toggle(false);
                break;
            case R.id.toggle_immediately_with_listener:
                jtb.toggleImmediately();
                break;
            case R.id.toggle_immediately_without_listener:
                jtb.toggleImmediately(false);
                break;
            case R.id.color_left_background:
                setColor("Left Background", jtb.getLeftBackgroundColor(), R.id.color_left_background);
                break;
            case R.id.color_right_background:
                setColor("Right Background", jtb.getRightBackgroundColor(), R.id.color_right_background);
                break;
            case R.id.color_background:
                setColor("L & R Background", jtb.getLeftBackgroundColor(), R.id.color_background);
                break;
            case R.id.color_left_thumb:
                setColor("Left Thumb", jtb.getLeftThumbColor(), R.id.color_left_thumb);
                break;
            case R.id.color_right_thumb:
                setColor("Right Thumb", jtb.getRightThumbColor(), R.id.color_right_thumb);
                break;
            case R.id.color_thumb:
                setColor("L & R Thumb", jtb.getLeftThumbColor(), R.id.color_thumb);
                break;
            case R.id.color_left_text:
                setColor("Left Text", jtb.getLeftTextColor(), R.id.color_left_text);
                break;
            case R.id.color_right_text:
                setColor("Right Text", jtb.getRightTextColor(), R.id.color_right_text);
                break;
            case R.id.color_text:
                setColor("L & R Text", jtb.getLeftTextColor(), R.id.color_text);
                break;
            case R.id.color_activity_background:
                setColor("Activity Background", ((ColorDrawable)base.getBackground()).getColor(), R.id.color_activity_background);
                break;
            case R.id.font_hairline:
                jtb.setTextTypeface("fonts/Lato-Hairline.ttf");
                break;
            case R.id.font_light:
                jtb.setTextTypeface("fonts/Lato-Light.ttf");
                break;
            case R.id.font_default:
                jtb.setTextTypeface(Typeface.DEFAULT);
                break;
            case R.id.draggable:
                jtb.setDraggable(!jtb.isDraggable());
                break;
            case R.id.custom:
                jtb.setCustomJelly(new CustomJelly());
                break;
            case R.id.remove_custom:
                jtb.removeCustomJelly();
                break;
        }
    }

    private void setColor(String title, int color, int tag) {
        new ColorChooseDialog.Builder(this)
                .title(title)
                .color(color)
                .tag(tag)
                .show();
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    private void setActivityBackgroundColor(int color) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Do something for lollipop and above versions
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
        if (base != null) base.setBackgroundColor(color);
    }

    @Override
    public void ok(int color, int tag) {
        switch (tag) {
            case R.id.color_left_background:
                jtb.setLeftBackgroundColor(color);
                break;
            case R.id.color_right_background:
                jtb.setRightBackgroundColor(color);
                break;
            case R.id.color_background:
                jtb.setBackgroundColor(color);
                break;
            case R.id.color_left_thumb:
                jtb.setLeftThumbColor(color);
                break;
            case R.id.color_right_thumb:
                jtb.setRightThumbColor(color);
                break;
            case R.id.color_thumb:
                jtb.setThumbColor(color);
                break;
            case R.id.color_left_text:
                jtb.setLeftTextColor(color);
                break;
            case R.id.color_right_text:
                jtb.setRightTextColor(color);
                break;
            case R.id.color_text:
                jtb.setTextColor(color);
                break;
            case R.id.color_activity_background:
                setActivityBackgroundColor(color);
                break;
        }
    }

    @Override
    public void cancel() {

    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    private int pxToDp(int px) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}
