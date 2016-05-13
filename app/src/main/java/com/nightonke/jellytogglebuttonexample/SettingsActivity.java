package com.nightonke.jellytogglebuttonexample;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.State;

public class SettingsActivity extends AppCompatActivity
        implements
        View.OnClickListener,
        JellyToggleButton.OnStateChangeListener,
        ColorChooseDialog.OnColorChoseListener {

    private LinearLayout base;

    private JellyToggleButton jtb;

    private ProgressBar progressBar;

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
        findView(R.id.color_activity_background).setOnClickListener(this);
    }

    @Override
    public void onStateChange(float process, State state, JellyToggleButton jbt) {
        if (state.equals(State.LEFT)) Toast.makeText(this, "Left!", Toast.LENGTH_SHORT).show();
        if (state.equals(State.RIGHT)) Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
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
            case R.id.color_activity_background:
                setColor("Activity Background", ((ColorDrawable)base.getBackground()).getColor(), R.id.color_activity_background);
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
            case R.id.color_activity_background:
                setActivityBackgroundColor(color);
                break;
        }
    }

    @Override
    public void cancel() {

    }
}
