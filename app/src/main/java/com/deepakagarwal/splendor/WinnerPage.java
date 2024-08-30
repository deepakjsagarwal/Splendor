package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.AskNumberOfPlayers.game;
import static com.deepakagarwal.splendor.MainActivity.ringBackground;
import static com.deepakagarwal.splendor.utils.Utils.startMediaPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinnerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_page);
        TextView winnerName = findViewById(R.id.winnerName);

        winnerName.setText("Congratulations " + game.getWinner() + "!\nYou won.");
        LinearLayout name = findViewById(R.id.nameLayout);
        LinearLayout score = findViewById(R.id.scoreLayout);
        LinearLayout cards = findViewById(R.id.cardsLayout);
        for (int x = 0; x < game.players.length; x++) {
            TextView nameText = new TextView(this);
            TextView scoreText = new TextView(this);
            TextView cardsText = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            nameText.setText(game.players[x].name);
            scoreText.setText(String.valueOf(game.players[x].cards[5]));
            cardsText.setText(String.valueOf(game.players[x].getCountOfCards()));
            nameText.setTextSize(30);
            scoreText.setTextSize(30);
            cardsText.setTextSize(30);
            nameText.setGravity(Gravity.CENTER);
            scoreText.setGravity(Gravity.CENTER);
            cardsText.setGravity(Gravity.CENTER);
            nameText.setLayoutParams(layoutParams);
            scoreText.setLayoutParams(layoutParams);
            cardsText.setLayoutParams(layoutParams);
            name.addView(nameText);
            score.addView(scoreText);
            cards.addView(cardsText);
        }

        startMediaPlayer(ringBackground);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }

    public void backToGame(View view) {
        Intent intent = new Intent(this, AskNumberOfPlayers.class);
        startActivity(intent);
        finish();
    }
}