package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.MainActivity.ringBackground;
import static com.deepakagarwal.splendor.utils.Utils.startMediaPlayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RulesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_page);
        startMediaPlayer(ringBackground);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }
}