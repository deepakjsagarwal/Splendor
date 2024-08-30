package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.AskNumberOfPlayers.game;
import static com.deepakagarwal.splendor.MainActivity.ringBackground;
import static com.deepakagarwal.splendor.utils.Constants.COLORS;
import static com.deepakagarwal.splendor.utils.Constants.COUNT_TABLE_LEVEL_CARD;
import static com.deepakagarwal.splendor.utils.Constants.COUNT_TABLE_NOBEL;
import static com.deepakagarwal.splendor.utils.Constants.LEVELS;
import static com.deepakagarwal.splendor.utils.Constants.NOBEL;
import static com.deepakagarwal.splendor.utils.Constants.intToColor;
import static com.deepakagarwal.splendor.utils.Utils.startMediaPlayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.deepakagarwal.splendor.models.Card;
import com.deepakagarwal.splendor.utils.Utils;

public class GameScreen extends AppCompatActivity {

    ImageView[][] table_cards;

    TextView[] adders;
    ImageView[] tokenImages;

    TextView[] cardsWithVP;
    TextView[] tokens;

    TextView currentPlayerName;

    TextView[] informationTable;
    TextView whichPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        currentPlayerName = findViewById(R.id.currentPlayerName);

        int[][] table_card_ids = {
                {R.id.l1card1, R.id.l1card2, R.id.l1card3, R.id.l1card4},
                {R.id.l2card1, R.id.l2card2, R.id.l2card3, R.id.l2card4},
                {R.id.l3card1, R.id.l3card2, R.id.l3card3, R.id.l3card4},
                {R.id.nobel1, R.id.nobel2, R.id.nobel3}
        };

        table_cards = new ImageView[LEVELS][COUNT_TABLE_LEVEL_CARD];
        table_cards[NOBEL] = new ImageView[COUNT_TABLE_NOBEL];

        for (int i = 0; i < table_cards.length; i++) {
            for (int j = 0; j < table_cards[i].length; j++) {
                table_cards[i][j] = findViewById(table_card_ids[i][j]);
            }
        }

        int[] numberAddedIds = {
                R.id.pinknumberadded,
                R.id.bluenumberadded,
                R.id.greennumberadded,
                R.id.rednumberadded,
                R.id.blacknumberadded
        };
        adders = new TextView[COLORS];

        for (int i = 0; i < numberAddedIds.length; i++) {
            adders[i] = findViewById(numberAddedIds[i]);
        }

        int[] tokenImageIds = {
                R.id.pinkTokenImage,
                R.id.blueTokenImage,
                R.id.greenTokenImage,
                R.id.redTokenImage,
                R.id.blackTokenImage
        };

        tokenImages = new ImageView[tokenImageIds.length];

        for (int i = 0; i < tokenImageIds.length; i++) {
            tokenImages[i] = findViewById(tokenImageIds[i]);
        }

        int[] cardsWithVPIds = {
                R.id.pinkcards,
                R.id.bluecards,
                R.id.greencards,
                R.id.redcards,
                R.id.blackcards,
                R.id.victorypoints
        };

        cardsWithVP = new TextView[cardsWithVPIds.length];

        for (int i = 0; i < cardsWithVPIds.length; i++) {
            cardsWithVP[i] = findViewById(cardsWithVPIds[i]);
        }

        int[] tokenTextIds = {
                R.id.pinktokens,
                R.id.bluetokens,
                R.id.greentokens,
                R.id.redtokens,
                R.id.blacktokens
        };

        tokens = new TextView[tokenTextIds.length];

        for (int i = 0; i < tokenTextIds.length; i++) {
            tokens[i] = findViewById(tokenTextIds[i]);
        }

        whichPlayer = findViewById(R.id.whichplayer);

        informationTable = new TextView[4];
        informationTable[0] = findViewById(R.id.player1showtable);
        informationTable[1] = findViewById(R.id.player2showtable);
        informationTable[2] = findViewById(R.id.player3showtable);
        informationTable[3] = findViewById(R.id.player4showtable);

        setTableForPlayer(0);
        startMediaPlayer(ringBackground);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }

    public void pickCard(View view) {

        String s = String.valueOf(view.getTag());
        int x = Integer.parseInt(String.valueOf(s.charAt(0)));
        int y = Integer.parseInt(String.valueOf(s.charAt(1)));

        if (game.getCurrentPlayer().canPurchaseCard(game.tableCard[x][y])) {
            game.purchaseCard(game.tableCard[x][y]);
            game.tableCard[x][y] = game.levelDeck[x].drawCard();
            game.checkAndPurchaseNobel();
            // setting adders to zero for a new player to be set
            setAddersToZero();
            if (game.isGameOver()) {
                if (game.currentPlayer == game.players.length - 1) {
                    Intent intent = new Intent(this, WinnerPage.class);
                    startActivity(intent);
                    finish();
                } else {
                    changeCurrentPlayer();
                    Toast.makeText(this, game.getCurrentPlayer().name + ", It is your last turn.", Toast.LENGTH_SHORT).show();
                }
            } else {
                changeCurrentPlayer();
            }
        } else {
            Toast.makeText(this, "You don't have the resources.", Toast.LENGTH_SHORT).show();
        }
    }

    public void done(View view) {
        System.out.println("abc Before done:" + game);
        int[] colourAdded = getAdders();

        String error = game.checkTokenAdded(colourAdded);
        if (error.isEmpty()) {

            game.pickTokens(colourAdded);
            // setting adders to zero for a new player to be set
            setAddersToZero();

            if (game.isGameOver()) {
                if (game.currentPlayer == game.players.length - 1) {
                    Intent intent = new Intent(this, WinnerPage.class);
                    startActivity(intent);
                    finish();
                } else {
                    changeCurrentPlayer();
                    Toast.makeText(this, game.getCurrentPlayer().name + ", It is your last turn.", Toast.LENGTH_SHORT).show();
                }
            } else {
                changeCurrentPlayer();
            }
        } else {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
        System.out.println("abc After done:" + game);

    }

    public void changeCurrentPlayer() {
        ringNextPlayer();
        game.changeCurrentPlayer();
        setTableForPlayer(game.currentPlayer);
    }

    public void ringNextPlayer() {
        MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
        ringNextPlayer.start();
    }

    public void setImageForCard(ImageView i, Card c) {
        int cardImage = getResources().getIdentifier("c" + c.idNumber, "drawable", getPackageName());
        i.setImageResource(cardImage);
    }

    public void setAddersToZero() {
        for (int x = 0; x < 5; x++) {
            TextView tAdd = adders[x];
            tAdd.setText("0");
        }
    }

    public void setImageForTableTokens() {
        for (int i = 0; i < game.tableTokens.length; i++) {
            int tokenImage = getResources().getIdentifier(intToColor(i) + "token" + game.tableTokens[i], "drawable", getPackageName());
            ImageView image = tokenImages[i];
            image.setImageResource(tokenImage);
        }
    }

    public void setTableForPlayer(int playerId) {

        // Top heading for Current Players Turn (Independent of the player id)
        currentPlayerName.setText(game.getCurrentPlayer().name + "'s Turn");

        //Setting up all table cards for L1,L2,L3 and NOBEL
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < game.tableCard[i].length; j++) {
                setImageForCard(table_cards[i][j], game.tableCard[i][j]);
            }
        }

        // Setting Table Tokens left for the Game (independent of player id)
        setImageForTableTokens();

        // Names of Players to get the table for them
        for (int i = 0; i < game.players.length; i++) {
            informationTable[i].setText(game.players[i].name);
        }
        for (int i = game.players.length; i < 4; i++) {
            informationTable[i].setText("");
        }

        // Player ID: Player Cards and VP
        for (int x = 0; x < 6; x++) {
            TextView t = cardsWithVP[x];
            t.setText(String.valueOf(game.players[playerId].cards[x]));
        }
        // Player ID: Player Tokens
        for (int x = 0; x < 5; x++) {
            TextView t = tokens[x];
            t.setText(String.valueOf(game.players[playerId].tokens[x]));
        }
        // To show the Table is for which Player ID
        whichPlayer.setText(game.players[playerId].name + " Score");

    }

    public void showInfo(View view) {
        if (view.getId() == R.id.player1showtable)
            setTableForPlayer(0);
        else if (view.getId() == R.id.player2showtable)
            setTableForPlayer(1);
        if (game.players.length >= 3 && view.getId() == R.id.player3showtable)
            setTableForPlayer(2);
        if (game.players.length == 4 && view.getId() == R.id.player4showtable)
            setTableForPlayer(3);
    }

    public int[] getAdders() {
        int[] colourAdded = new int[adders.length];

        for (int i = 0; i < adders.length; i++) {
            colourAdded[i] = Utils.value(adders[i]);
        }
        return colourAdded;
    }

    public void plusToken(View view) {
        int[] plusButtonIds = {R.id.plus1, R.id.plus2, R.id.plus3, R.id.plus4, R.id.plus5};

        for (int i = 0; i < plusButtonIds.length; i++) {
            if (view.getId() == plusButtonIds[i]) {
                plus(adders[i]);
                return;
            }
        }
    }

    public void plus(TextView t) {
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        S++;
        if (S > 2) S = 2;
        t.setText(String.valueOf(S));
    }

    public void minusToken(View view) {
        int[] minusButtonIds = {R.id.minus1, R.id.minus2, R.id.minus3, R.id.minus4, R.id.minus5};

        for (int i = 0; i < minusButtonIds.length; i++) {
            if (view.getId() == minusButtonIds[i]) {
                minus(adders[i]);
                return;
            }
        }
    }

    public void minus(TextView t) {
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        S--;
        if (S < 0) S = 0;
        t.setText(String.valueOf(S));
    }

    public void music(View view) {
        if (ringBackground.isPlaying()) {
            int musicImage = getResources().getIdentifier("musicoff", "drawable", getPackageName());
            ImageView image = findViewById(R.id.musicON);
            image.setImageResource(musicImage);

            ringBackground.pause();
        } else {
            int musicImage = getResources().getIdentifier("musicon", "drawable", getPackageName());
            ImageView image = findViewById(R.id.musicON);
            image.setImageResource(musicImage);
            ringBackground.start();
        }
    }
}