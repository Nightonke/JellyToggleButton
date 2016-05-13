package com.nightonke.jellytogglebuttonexample;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.jellytogglebutton.JellyToggleButton;
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

        durationText = (TextView)findViewById(R.id.duration_text);
        durationSeekBar = (SeekBar)findViewById(R.id.duration);
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
        
        fontSizeText = (TextView)findViewById(R.id.font_size_text);
        fontSizeSeekBar = (SeekBar)findViewById(R.id.font_size);
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
        
        leftText = (EditText)findViewById(R.id.left_text);
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

        rightText = (EditText)findViewById(R.id.right_text);
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
}
