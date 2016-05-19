package com.nightonke.jellytogglebuttonexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.State;

public class MainActivity extends AppCompatActivity
        implements
        JellyToggleButton.OnStateChangeListener,
        View.OnClickListener {

    private static final int[] JTB_ID = new int[]{
            R.id.jtb_00, R.id.jtb_01, R.id.jtb_02,
            R.id.jtb_03, R.id.jtb_04, R.id.jtb_05,
            R.id.jtb_06, R.id.jtb_07, R.id.jtb_08,
    };

    private Toast lastToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.app_title);

        for (int id : JTB_ID) ((JellyToggleButton)findViewById(id)).setOnStateChangeListener(this);

        findView(R.id.change_all).setOnClickListener(this);
        findView(R.id.settings_button).setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_all:
                for (int id : JTB_ID) ((JellyToggleButton)findViewById(id)).toggle(false);
                break;
            case R.id.settings_button:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }
}
