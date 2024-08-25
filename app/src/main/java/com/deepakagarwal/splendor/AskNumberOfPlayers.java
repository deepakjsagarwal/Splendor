package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.MainActivity.ringBackground;
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
    int i;
    TextView[] player;
    TextView[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_number_of_players);
        i = 1;
        names = new TextView[4];
        names[0] = (TextView)findViewById(R.id.player1name);
        names[1] = (TextView)findViewById(R.id.player2name);
        names[2] = (TextView)findViewById(R.id.player3name);
        names[3] = (TextView)findViewById(R.id.player4name);
        player = new TextView[4];
        player[0] = (TextView)findViewById(R.id.player1);
        player[1] = (TextView)findViewById(R.id.player2);
        player[2] = (TextView)findViewById(R.id.player3);
        player[3] = (TextView)findViewById(R.id.player4);

        startMediaPlayer(ringBackground);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }

    public void save(View view){
        if(checkName()) {
            game = new Game(i+1);
            game.playerNames = new String[game.numOfPlayers];
            for (int x = 0; x <= i; x++)
                game.playerNames[x] = names[x].getText().toString();
            Intent intent = new Intent(this, GameScreen.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Name can't be Empty.", Toast.LENGTH_SHORT).show();
        }
    }
    public void plus(View view){
        i++;
        if(i>=3) i =3;
        player[i].setVisibility(View.VISIBLE);
        names[i].setVisibility(View.VISIBLE);
    }
    public void minus(View view){
        if(i>1) {
            player[i].setVisibility(View.INVISIBLE);
            names[i].setVisibility(View.INVISIBLE);
        }
        i--;
        if(i<1) i =1;
    }
    public boolean checkName(){
        for (int x = 0; x <= i; x++){
            if(names[x].getText().toString().trim().isEmpty()) return false;
        }
        return true;
    }
}