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

public class GameScreen extends AppCompatActivity {

    ImageView[][] table_cards;

    TextView[] adders;
    ImageView[] tokenImages;

    TextView[] cardsWithVP;
    TextView[] tokens;

    Card[][] card;

    TextView currentPlayerName;

    int[] colourID;
    TextView[] informationTable;
    TextView whichplayer;

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

        card = new Card[4][];
        card[0] = new Card[4];
        card[1] = new Card[4];
        card[2] = new Card[4];
        card[3] = new Card[3];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < card[i].length; j++) {
                card[i][j] = game.levelDeck[i].drawCard();
                imageSetCard(table_cards[i][j], card[i][j], i);
            }
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

        if (game.players.length == 2) {
            colourID = new int[]{4, 4, 4, 4, 4};
        } else if (game.players.length == 3) {
            colourID = new int[]{6, 6, 6, 6, 6};
        } else if (game.players.length == 4) {
            colourID = new int[]{8, 8, 8, 8, 8};
        }
        colourID = setImageOfTokenImageWhileGivingToken(new int[]{0, 0, 0, 0, 0}, colourID);

        informationTable = new TextView[4];
        informationTable[0] = findViewById(R.id.player1showtable);
        informationTable[1] = findViewById(R.id.player2showtable);
        informationTable[2] = findViewById(R.id.player3showtable);
        informationTable[3] = findViewById(R.id.player4showtable);

        for (int i = 0; i < game.players.length; i++) {
            informationTable[i].setText(game.players[i].name);
        }
        for (int i = game.players.length; i < 4; i++) {
            informationTable[i].setText("");
        }
        whichplayer = findViewById(R.id.whichplayer);
        whichplayer.setText(game.players[0].name + " Score");
        currentPlayerName.setText(game.players[0].name + "'s Turn");

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

        if (game.players[game.currentPlayer].checkPrice(card[x][y], false)) {
            int[] extraTokens = game.players[game.currentPlayer].findExtraTokens(card[x][y]);

            colourID = setImageOfTokenImageWhileGivingToken(extraTokens, colourID);
            game.players[game.currentPlayer].tokens = game.players[game.currentPlayer].removeTokenFromTableOfCurrentPlayer(extraTokens);
            game.players[game.currentPlayer].addCardWithScoreToCurrentPlayerTable(card[x][y]);
            checkNobel();
            setAddersToZero();
            if (game.isGameOver()) {
                if (game.currentPlayer == game.players.length - 1) {
                    Intent intent = new Intent(this, WinnerPage.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Changing to Next Player
                    MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                    ringNextPlayer.start();
                    card[x][y] = game.levelDeck[x].drawCard();
                    imageSetCard(table_cards[x][y], card[x][y], x);

                    game.currentPlayer = (++game.currentPlayer) % game.players.length;
                    currentPlayerName.setText(game.players[game.currentPlayer].name + "'s Turn");
                    Toast.makeText(this, game.players[game.currentPlayer].name + ", It is your last turn.", Toast.LENGTH_SHORT).show();
                    setTableForNextPlayer(game.currentPlayer);
                }
            } else {
                // Changing to Next Player
                MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                ringNextPlayer.start();
                card[x][y] = game.levelDeck[x].drawCard();
                imageSetCard(table_cards[x][y], card[x][y], x);

                game.currentPlayer = (++game.currentPlayer) % game.players.length;
                currentPlayerName.setText(game.players[game.currentPlayer].name + "'s Turn");
                setTableForNextPlayer(game.currentPlayer);
            }
        } else {
            Toast.makeText(this, "You don't have the resources.", Toast.LENGTH_SHORT).show();
        }
    }


    public void imageSetCard(ImageView i, Card c, int drawCI) {
        int card = game.levelDeck[drawCI].drawCardImage(c);
        int cardImage = getResources().getIdentifier("c" + card, "drawable", getPackageName());
        i.setImageResource(cardImage);
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
        t.setText("" + S);
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
        t.setText("" + S);
    }

    public void done(View view) {

        if (checkTokenAdded(adders, colourID)) {
            colourID = setImageOfTokenImageWhileTakingToken(colourID);
            game.players[game.currentPlayer].tokens = addTokenToTableOfCurrentPlayer(game.players[game.currentPlayer].tokens);
            setAddersToZero();

            if (game.isGameOver()) {
                if (game.currentPlayer == game.players.length - 1) {
                    Intent intent = new Intent(this, WinnerPage.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Changing the player
                    MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                    ringNextPlayer.start();
                    game.currentPlayer = (++game.currentPlayer) % game.players.length;
                    currentPlayerName.setText(game.players[game.currentPlayer].name + "'s Turn");
                    Toast.makeText(this, game.players[game.currentPlayer].name + ", It is your last turn.", Toast.LENGTH_SHORT).show();
                    setTableForNextPlayer(game.currentPlayer);
                }
            } else {
                // Changing the player
                MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                ringNextPlayer.start();
                game.currentPlayer = (++game.currentPlayer) % game.players.length;
                currentPlayerName.setText(game.players[game.currentPlayer].name + "'s Turn");
                setTableForNextPlayer(game.currentPlayer);
            }

        }

    }

    public void setTableForNextPlayer(int newCurrentPlayer) {
        for (int x = 0; x < 6; x++) {
            TextView t = cardsWithVP[x];
            t.setText("" + game.players[newCurrentPlayer].cards[x]);
        }
        for (int x = 0; x < 5; x++) {
            TextView t = tokens[x];
            t.setText("" + game.players[newCurrentPlayer].tokens[x]);
        }
        whichplayer.setText(game.players[newCurrentPlayer].name + " Score");

    }

    public void setAddersToZero() {
        for (int x = 0; x < 5; x++) {
            TextView tAdd = adders[x];
            tAdd.setText("0");
        }
    }

    public int[] addTokenToTableOfCurrentPlayer(int[] tableContent) {
        for (int x = 0; x < 5; x++) {
            TextView tAdd = adders[x];
            String t = tAdd.getText().toString();
            int token = Integer.parseInt(t);
            tableContent[x] += token;
        }
        return tableContent;
    }


    public int[] setImageOfTokenImageWhileTakingToken(int[] colourID) {
        for (int y = 0; y < 5; y++) {
            TextView tAdd = adders[y];
            String s = tAdd.getText().toString();
            int S = Integer.parseInt(s);
            colourID[y] = colourID[y] - S;
            int tokenImage = getResources().getIdentifier("" + intToColor(y) + "token" + colourID[y], "drawable", getPackageName());
            ImageView i = tokenImages[y];
            i.setImageResource(tokenImage);
        }
        return colourID;
    }

    public int[] setImageOfTokenImageWhileGivingToken(int[] extraTokens, int[] colourID) {
        for (int i = 0; i < 5; i++) {
            colourID[i] = colourID[i] + extraTokens[i];
            int tokenImage = getResources().getIdentifier("" + intToColor(i) + "token" + colourID[i], "drawable", getPackageName());
            ImageView image = tokenImages[i];
            image.setImageResource(tokenImage);
        }
        return colourID;
    }

    public void checkNobel() {
        for (int x = 0; x < card[3].length; x++) {
            if (game.players[game.currentPlayer].checkPrice(card[3][x], true)) {
                game.players[game.currentPlayer].addCardWithScoreToCurrentPlayerTable(card[3][x]);
                card[3][x] = game.levelDeck[3].back;
                ImageView i = table_cards[3][x];
                int cardImage = getResources().getIdentifier("nobel", "drawable", getPackageName());
                i.setImageResource(cardImage);
            }
        }
    }

    public void showInfo(View view) {
        if (view.getId() == R.id.player1showtable)
            setTableForNextPlayer(0);
        else if (view.getId() == R.id.player2showtable)
            setTableForNextPlayer(1);
        if (game.players.length >= 3 && view.getId() == R.id.player3showtable)
            setTableForNextPlayer(2);
        if (game.players.length == 4 && view.getId() == R.id.player4showtable)
            setTableForNextPlayer(3);
    }

    public boolean checkTokenAdded(TextView[] adders, int[] tID) {

        int[] colourAdded = new int[adders.length];

        for (int i = 0; i < adders.length; i++) {
            colourAdded[i] = value(adders[i]);
        }

        for (int i = 0; i < adders.length; i++) {
            if (colourAdded[i] > tID[i]) {
                Toast.makeText(this, "Enough " + intToColor(i) + " Tokens are not available.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        int addedTokens = 0;
        for (int i = 0; i < 5; i++) {
            addedTokens += colourAdded[i];
        }
        if (addedTokens > 3) {
            Toast.makeText(this, "You cannot pick more than 3 Tokens.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (addedTokens <= 0) {
            Toast.makeText(this, "Choose some tokens.", Toast.LENGTH_SHORT).show();
            return false;
        }

        switch (totalTokenForPlayer()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                switch (addedTokens) {
                    case 3:
                        if (allDifferentToken(colourAdded, 3)) {
                            return true;
                        } else {
                            Toast.makeText(this, "You have to choose 3 Different Tokens.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    case 2:
                        if (twoSameToken(colourAdded, tID)) return true;
                        else if (allDifferentToken(colourAdded, 2) && numOfZeroToken(tID) == 3)
                            return true;
                        else {
                            Toast.makeText(this, "You have to choose 2 Same tokens or 3 Different.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    case 1:
                        if (numOfZeroToken(tID) == 4 && oneTokenAdded(colourAdded, tID)) {
                            return true;
                        } else {
                            Toast.makeText(this, "Try Again, You can pick more than 1 Token.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    default:
                        return false;
                }
            case 8:
                switch (addedTokens) {
                    case 2:
                        if (allDifferentToken(colourAdded, 2)) return true;
                        else if (twoSameToken(colourAdded, tID)) return true;
                        else {
                            Toast.makeText(this, "You can pick 2 Different or 2 Same only if there are 4 or more tokens available.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    case 1:
                        if (numOfZeroToken(tID) == 4 && oneTokenAdded(colourAdded, tID)) {
                            return true;
                        } else {
                            Toast.makeText(this, "You can pick 2 Tokens.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    default:
                        Toast.makeText(this, "You have 8 Tokens, you can not pick 3 Tokens.", Toast.LENGTH_SHORT).show();
                        return false;
                }
            case 9:
                if (allDifferentToken(colourAdded, 1)) {
                    return true;
                } else {
                    Toast.makeText(this, "You have 9 Tokens, you can not pick more than 1 Tokens.", Toast.LENGTH_SHORT).show();
                    return false;
                }
            default:
                Toast.makeText(this, "You have 10 Tokens, can't pick more.", Toast.LENGTH_SHORT).show();
                return false;
        }
    }

    public boolean allDifferentToken(int[] colour, int numOfDifferentTokens) {
        int count = 0;
        for (int x = 0; x < 5; x++) {
            if (colour[x] == 1) count++;
        }
        return count == numOfDifferentTokens;
    }

    public int numOfZeroToken(int[] colour) {
        int count = 0;
        for (int x = 0; x < 5; x++) {
            if (colour[x] == 0) count++;
        }
        return count;
    }

    public boolean twoSameToken(int[] colourAdded, int[] colourID) {
        if (allDifferentToken(colourAdded, 2))
            return false;
        else {
            for (int x = 0; x < 5; x++) {
                if (colourAdded[x] == 2)
                    return colourID[x] >= 4;
            }
        }
        return false;
    }

    public boolean oneTokenAdded(int[] colourAdded, int[] colourID) {
        for (int x = 0; x < 5; x++) {
            if (colourAdded[x] == 1)
                return colourID[x] < 4;
        }
        return false;
    }

    public int value(TextView t) {
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        return S;
    }

    public int totalTokenForPlayer() {
        int totalTokens = 0;
        for (int x = 0; x < 5; x++)
            totalTokens += game.players[game.currentPlayer].tokens[x];
        return totalTokens;
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