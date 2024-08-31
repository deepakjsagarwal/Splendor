package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.MainActivity.ringBackground;
import static com.deepakagarwal.splendor.utils.Constants.MAX_PLAYERS;
import static com.deepakagarwal.splendor.utils.Constants.MIN_PLAYERS;
import static com.deepakagarwal.splendor.utils.Utils.startMediaPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.deepakagarwal.splendor.models.Game;

public class AskNumberOfPlayers extends AppCompatActivity {

    public static Game game;
    int numOfPlayers;
    TextView[] players;
    TextView[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_number_of_players);

        numOfPlayers = MIN_PLAYERS;

        int[] playerNameIds = {R.id.player1name, R.id.player2name, R.id.player3name, R.id.player4name};

        names = new TextView[playerNameIds.length];
        for (int i = 0; i < playerNameIds.length; i++) {
            names[i] = findViewById(playerNameIds[i]);
        }

        int[] playerIds = {R.id.player1, R.id.player2, R.id.player3, R.id.player4};
        players = new TextView[playerIds.length];

        for (int i = 0; i < playerIds.length; i++) {
            players[i] = findViewById(playerIds[i]);
        }

        startMediaPlayer(ringBackground);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }

    public void save(View view) {
        if (checkName()) {
            game = new Game(numOfPlayers);
            for (int x = 0; x < numOfPlayers; x++)
                game.players[x].name = names[x].getText().toString();

            Intent intent = new Intent(this, GameScreen.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Name can't be Empty.", Toast.LENGTH_SHORT).show();
        }
    }

    public void plus(View view) {
        numOfPlayers++;
        if (numOfPlayers >= MAX_PLAYERS) numOfPlayers = MAX_PLAYERS;
        players[numOfPlayers - 1].setVisibility(View.VISIBLE);
        names[numOfPlayers - 1].setVisibility(View.VISIBLE);
    }

    public void minus(View view) {
        if (numOfPlayers > MIN_PLAYERS) {
            players[numOfPlayers - 1].setVisibility(View.INVISIBLE);
            names[numOfPlayers - 1].setVisibility(View.INVISIBLE);
        }
        numOfPlayers--;
        if (numOfPlayers < MIN_PLAYERS) numOfPlayers = MIN_PLAYERS;
    }

    public boolean checkName() {
        for (int x = 0; x < numOfPlayers; x++) {
            if (names[x].getText().toString().trim().isEmpty()) return false;
        }
        return true;
    }
}