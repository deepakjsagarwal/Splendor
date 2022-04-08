package com.deepakagarwal.splendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer ringBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ringBackground = MediaPlayer.create(MainActivity.this,R.raw.backgroundmusic);
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

    public void playNewGame(View view){
        //Toast.makeText(this, "Starting new game....", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AskNumberOfPlayers.class);
        startActivity(intent);
    }

    public void rules(View view){
        Intent intent = new Intent(this,RulesPage.class);
        startActivity(intent);
    }
}