package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.utils.Utils.startMediaPlayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer ringBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ringBackground = MediaPlayer.create(MainActivity.this, R.raw.backgroundmusic);
        startMediaPlayer(ringBackground);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }

    public void playNewGame(View view) {
        Toast.makeText(this, "Starting new game....", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AskNumberOfPlayers.class);
        startActivity(intent);
    }

    public void rules(View view) {
        Intent intent = new Intent(this, RulesPage.class);
        startActivity(intent);
    }
}