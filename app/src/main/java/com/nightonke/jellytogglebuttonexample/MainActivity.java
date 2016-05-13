package com.nightonke.jellytogglebuttonexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.State;

public class MainActivity extends AppCompatActivity
        implements
        JellyToggleButton.OnStateChangeListener,
        View.OnClickListener {

    private JellyToggleButton jtb0;
    private JellyToggleButton jtb1;
    private JellyToggleButton jtb2;

    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jtb0 = (JellyToggleButton)findViewById(R.id.jtb_0);
//        jtb0.setOnStateChangeListener(this);
        jtb0.setChecked(true);

        jtb1 = (JellyToggleButton)findViewById(R.id.jtb_1);
        jtb1.setOnStateChangeListener(this);
        jtb1.setChecked(true);

        settings = (Button)findViewById(R.id.settings_button);
        settings.setOnClickListener(this);
    }

    @Override
    public void onStateChange(float process, State state, JellyToggleButton jbt) {
        if (state.equals(State.LEFT)) Toast.makeText(this, "Left!", Toast.LENGTH_SHORT).show();
        if (state.equals(State.RIGHT)) Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settings_button:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }
    }
}
