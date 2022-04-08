package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.MainActivity.ringBackground;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RulesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_page);
        ringBackground.start();
        ringBackground.setLooping(true);
        ringBackground.setVolume(100,100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ringBackground.start();
        ringBackground.setLooping(true);
        ringBackground.setVolume(100,100);
    }
}