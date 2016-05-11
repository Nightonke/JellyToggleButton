package com.nightonke.jellytogglebuttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ToggleButton;

import com.nightonke.jellytogglebutton.JellyToggleButton;

public class MainActivity extends AppCompatActivity {

    private JellyToggleButton jellyToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jellyToggleButton = (JellyToggleButton)findViewById(R.id.jelly_toggle_button);
    }
}
