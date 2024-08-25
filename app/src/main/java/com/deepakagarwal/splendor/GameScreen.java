package com.deepakagarwal.splendor;

import static com.deepakagarwal.splendor.AskNumberOfPlayers.game;
import static com.deepakagarwal.splendor.MainActivity.ringBackground;
import static com.deepakagarwal.splendor.utils.Utils.startMediaPlayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.deepakagarwal.splendor.cardsParameters.cardsParams;
import com.deepakagarwal.splendor.cardsParameters.gameDeck;

import java.util.HashMap;
import java.util.Map;

public class GameScreen extends AppCompatActivity {

    ImageView l11card,l12card,l13card,l14card;
    ImageView l21card,l22card,l23card,l24card;
    ImageView l31card,l32card,l33card,l34card;
    ImageView nobel1,nobel2,nobel3;
    gameDeck deck;
    TextView pinkNumberAdded,blueNumberAdded,blackNumberAdded,greenNumberAdded,redNumberAdded;
    ImageView pinkTokenImage,blueTokenImage,blackTokenImage,greenTokenImage,redTokenImage;
    TextView pinkCards,blueCards,blackCards,greenCards,redCards,score;
    TextView pinkTokens,blueTokens,blackTokens,greenTokens,redTokens;
    cardsParams[][] card;
    Map<String, ImageView> mapImageView;
    Map<String,TextView> mapTextView;
    TextView currentPlayerName;
    String[] tableCards;
    String[] tableTokens;
    String[] imageTokens;
    String[] tokensAdded;
    int[] colourID;
    TextView[] informationTable;
    TextView whichplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        currentPlayerName = (TextView)findViewById(R.id.currentPlayerName);
        l11card = (ImageView)findViewById(R.id.l1card1);
        l12card = (ImageView)findViewById(R.id.l1card2);
        l13card = (ImageView)findViewById(R.id.l1card3);
        l14card = (ImageView)findViewById(R.id.l1card4);
        l21card = (ImageView)findViewById(R.id.l2card1);
        l22card = (ImageView)findViewById(R.id.l2card2);
        l23card = (ImageView)findViewById(R.id.l2card3);
        l24card = (ImageView)findViewById(R.id.l2card4);
        l31card = (ImageView)findViewById(R.id.l3card1);
        l32card = (ImageView)findViewById(R.id.l3card2);
        l33card = (ImageView)findViewById(R.id.l3card3);
        l34card = (ImageView)findViewById(R.id.l3card4);
        nobel1 = (ImageView)findViewById(R.id.nobel1);
        nobel2 = (ImageView)findViewById(R.id.nobel2);
        nobel3 = (ImageView)findViewById(R.id.nobel3);

        mapImageView = new HashMap<String,ImageView>();
        mapImageView.put("l11card",l11card);
        mapImageView.put("l12card",l12card);
        mapImageView.put("l13card",l13card);
        mapImageView.put("l14card",l14card);
        mapImageView.put("l21card",l21card);
        mapImageView.put("l22card",l22card);
        mapImageView.put("l23card",l23card);
        mapImageView.put("l24card",l24card);
        mapImageView.put("l31card",l31card);
        mapImageView.put("l32card",l32card);
        mapImageView.put("l33card",l33card);
        mapImageView.put("l34card",l34card);
        mapImageView.put("nobel1",nobel1);
        mapImageView.put("nobel2",nobel2);
        mapImageView.put("nobel3",nobel3);


        pinkNumberAdded = (TextView)findViewById(R.id.pinknumberadded);
        blueNumberAdded = (TextView)findViewById(R.id.bluenumberadded);
        greenNumberAdded = (TextView)findViewById(R.id.greennumberadded);
        redNumberAdded = (TextView)findViewById(R.id.rednumberadded);
        blackNumberAdded = (TextView)findViewById(R.id.blacknumberadded);
        pinkTokenImage = (ImageView)findViewById(R.id.pinkTokenImage);
        blueTokenImage = (ImageView)findViewById(R.id.blueTokenImage);
        greenTokenImage = (ImageView)findViewById(R.id.greenTokenImage);
        redTokenImage = (ImageView)findViewById(R.id.redTokenImage);
        blackTokenImage = (ImageView)findViewById(R.id.blackTokenImage);

        mapImageView.put("pink",pinkTokenImage);
        mapImageView.put("black",blackTokenImage);
        mapImageView.put("blue",blueTokenImage);
        mapImageView.put("red",redTokenImage);
        mapImageView.put("green",greenTokenImage);


        card = new cardsParams[4][];
        card[0] = new cardsParams[4];
        card[1] = new cardsParams[4];
        card[2] = new cardsParams[4];
        card[3] = new cardsParams[3];

        deck = new gameDeck();
        game.playerTable = new int[game.numOfPlayers][2][];
        for(int x = 0; x<game.numOfPlayers;x++) {
            game.playerTable[x][0] = new int[6];    // Cards with Score
            game.playerTable[x][1] = new int[5];    // Tokens
        }

        deck.reset();
        deck.shuffle();

        for(int i = 0;i<3;i++){
           for(int j = 0; j<4;j++){
                card[i][j] = deck.drawCard(i+1);
                String cardImage = "l"+(i+1)+(j+1)+"card";
                imageSetCard(cardImage,card[i][j],i+1);
            }
        }
        for(int a = 0; a<card[3].length;a++){
            card[3][a] = deck.drawCard(4);
            String cardImage = "nobel"+(a+1);
            imageSetCard(cardImage,card[3][a],4);
        }

        pinkCards = (TextView)findViewById(R.id.pinkcards);
        blackCards = (TextView)findViewById(R.id.blackcards);
        blueCards = (TextView)findViewById(R.id.bluecards);
        greenCards = (TextView)findViewById(R.id.greencards);
        redCards = (TextView)findViewById(R.id.redcards);
        pinkTokens = (TextView)findViewById(R.id.pinktokens);
        blackTokens = (TextView)findViewById(R.id.blacktokens);
        blueTokens = (TextView)findViewById(R.id.bluetokens);
        redTokens = (TextView)findViewById(R.id.redtokens);
        greenTokens = (TextView)findViewById(R.id.greentokens);
        score = (TextView)findViewById(R.id.victorypoints);
        mapTextView = new HashMap<String,TextView>();
        mapTextView.put("pinkCards",pinkCards);
        mapTextView.put("blackCards",blackCards);
        mapTextView.put("blueCards",blueCards);
        mapTextView.put("redCards",redCards);
        mapTextView.put("greenCards",greenCards);
        mapTextView.put("pinkTokens",pinkTokens);
        mapTextView.put("blackTokens",blackTokens);
        mapTextView.put("blueTokens",blueTokens);
        mapTextView.put("redTokens",redTokens);
        mapTextView.put("greenTokens",greenTokens);
        mapTextView.put("pinkNumberAdded",pinkNumberAdded);
        mapTextView.put("blackNumberAdded",blackNumberAdded);
        mapTextView.put("blueNumberAdded",blueNumberAdded);
        mapTextView.put("redNumberAdded",redNumberAdded);
        mapTextView.put("greenNumberAdded",greenNumberAdded);
        mapTextView.put("score",score);


        tableCards = new String[]{"pinkCards", "blueCards", "greenCards", "redCards", "blackCards","score"};
        tableTokens = new String[]{"pinkTokens", "blueTokens", "greenTokens", "redTokens", "blackTokens"};
        imageTokens = new String[]{"pink", "blue", "green", "red", "black"};
        tokensAdded = new String[]{"pinkNumberAdded", "blueNumberAdded", "greenNumberAdded", "redNumberAdded", "blackNumberAdded"};


        if(game.numOfPlayers==2){ colourID = new int[]{4,4,4,4,4}; }
        else if(game.numOfPlayers==3){ colourID = new int[]{6,6,6,6,6};}
        else if(game.numOfPlayers==4){ colourID = new int[]{8,8,8,8,8};}
        colourID = setImageOfTokenImageWhileGivingToken(new int[]{0, 0, 0, 0, 0},colourID);

        informationTable = new TextView[4];
        informationTable[0] = (TextView)findViewById(R.id.player1showtable);
        informationTable[1] = (TextView)findViewById(R.id.player2showtable);
        informationTable[2] = (TextView)findViewById(R.id.player3showtable);
        informationTable[3] = (TextView)findViewById(R.id.player4showtable);

        for(int i = 0; i<game.numOfPlayers;i++){
            informationTable[i].setText(game.playerName[i]);
        }
        for(int i =game.numOfPlayers;i<4;i++){
            informationTable[i].setText("");
        }
        whichplayer = (TextView)findViewById(R.id.whichplayer);
        whichplayer.setText(game.playerName[0]+" Score");
        currentPlayerName.setText(game.playerName[0]+"'s Turn");

        startMediaPlayer(ringBackground);

    }

    @Override
    protected void onResume() {
        super.onResume();
        startMediaPlayer(ringBackground);
    }

    public void pickCard(View view){
        String s = String.valueOf(view.getTag());
        int x = Integer.parseInt(String.valueOf(s.charAt(0)));
        int y = Integer.parseInt(String.valueOf(s.charAt(1)));

        if(checkPrice(card[x-1][y-1],false)){
            int[] extraTokens = findExtraTokens(card[x-1][y-1],game.playerTable[game.currentPlayer][0]);

            colourID = setImageOfTokenImageWhileGivingToken(extraTokens,colourID);
            game.playerTable[game.currentPlayer][1] = removeTokenFromTableOfCurrentPlayer(extraTokens,game.playerTable[game.currentPlayer][1]);
            addCardWithScoreToCurrentPlayerTable(card[x-1][y-1],game.playerTable[game.currentPlayer][0]);
            checkNobel();
            setAddersToZero(tokensAdded);
            if(isGameOver()){
                if(game.currentPlayer == game.numOfPlayers - 1){
                    Intent intent = new Intent(this,WinnerPage.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    // Changing to Next Player
                    MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                    ringNextPlayer.start();
                    card[x-1][y-1] = deck.drawCard(x);
                    String cardImage = "l"+x+y+"card";
                    imageSetCard(cardImage,card[x-1][y-1],x);

                    game.currentPlayer = (++game.currentPlayer)%game.numOfPlayers;
                    currentPlayerName.setText(game.playerName[game.currentPlayer]+"'s Turn");
                    Toast.makeText(this, game.playerName[game.currentPlayer]+", It is your last turn.", Toast.LENGTH_SHORT).show();
                    setTableForNextPlayer(game.currentPlayer);
                }
            }
            else{
            // Changing to Next Player
            MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
            ringNextPlayer.start();
            card[x-1][y-1] = deck.drawCard(x);
            String cardImage = "l"+x+y+"card";
            imageSetCard(cardImage,card[x-1][y-1],x);

            game.currentPlayer = (++game.currentPlayer)%game.numOfPlayers;
            currentPlayerName.setText(game.playerName[game.currentPlayer]+"'s Turn");
            setTableForNextPlayer(game.currentPlayer);
            }
        }

        else{
            Toast.makeText(this, "You don't have the resources.", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkPrice(cardsParams c,boolean isItNobel){
        boolean result = false;
        if(!isItNobel){
        for(int x =0; x<5;x++) {
            if (c.priceWithVP[x] <= game.playerTable[game.currentPlayer][0][x] + game.playerTable[game.currentPlayer][1][x])
                result = true;
            else return false;
        }
        }
        else {
            for(int x =0; x<5;x++) {
                if (c.priceWithVP[x] <= game.playerTable[game.currentPlayer][0][x])
                    result = true;
                else return false;
            }
        }
        return result;
    }
    public void imageSetCard(String s,cardsParams c,int drawCI){
        ImageView i = mapImageView.get(s);
        int card = deck.drawCardImage(c,drawCI);
        int cardImage = getResources().getIdentifier("c"+card,"drawable",getPackageName());
        i.setImageResource(cardImage);
    }
    public void plusToken(View view){
        switch(view.getId()){
            case R.id.plus1:
                plus(pinkNumberAdded);
                break;
            case R.id.plus2:
                plus(blueNumberAdded);
                break;
            case R.id.plus3:
                plus(greenNumberAdded);
                break;
            case R.id.plus4:
                plus(redNumberAdded);
                break;
            case R.id.plus5:
                plus(blackNumberAdded);
                break;
        }
    }
    public void plus(TextView t){
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        S++;
        if(S>2) S=2;
        t.setText(""+S);
    }
    public void minusToken(View view){
        switch(view.getId()){
            case R.id.minus1:
                minus(pinkNumberAdded);
                break;
            case R.id.minus2:
                minus(blueNumberAdded);
                break;
            case R.id.minus3:
                minus(greenNumberAdded);
                break;
            case R.id.minus4:
                minus(redNumberAdded);
                break;
            case R.id.minus5:
                minus(blackNumberAdded);
                break;
        }
    }
    public void minus(TextView t){
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        S--;
        if(S <0) S=0;
        t.setText(""+S);
    }
    public void done(View view){
        if(checkTokenAdded(pinkNumberAdded,blueNumberAdded,greenNumberAdded,redNumberAdded,blackNumberAdded,colourID)){
            colourID = setImageOfTokenImageWhileTakingToken(tokensAdded,colourID);
            game.playerTable[game.currentPlayer][1] = addTokenToTableOfCurrentPlayer(game.playerTable[game.currentPlayer][1],tokensAdded);
            setAddersToZero(tokensAdded);

            if(isGameOver()) {
                if (game.currentPlayer == game.numOfPlayers - 1) {
                    Intent intent = new Intent(this, WinnerPage.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    // Changing the player
                    MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                    ringNextPlayer.start();
                    game.currentPlayer = (++game.currentPlayer) % game.numOfPlayers;
                    currentPlayerName.setText(game.playerName[game.currentPlayer] + "'s Turn");
                    Toast.makeText(this, game.playerName[game.currentPlayer]+", It is your last turn.", Toast.LENGTH_SHORT).show();
                    setTableForNextPlayer(game.currentPlayer);
                }
            }
            else {
                // Changing the player
                MediaPlayer ringNextPlayer = MediaPlayer.create(GameScreen.this, R.raw.nextplayerturn);
                ringNextPlayer.start();
                game.currentPlayer = (++game.currentPlayer) % game.numOfPlayers;
                currentPlayerName.setText(game.playerName[game.currentPlayer] + "'s Turn");
                setTableForNextPlayer(game.currentPlayer);
            }

        }
    }
    public void setTableForNextPlayer(int newCurrentPlayer){
        for(int x = 0; x<6;x++){
            TextView t = mapTextView.get(tableCards[x]);
            t.setText(""+game.playerTable[newCurrentPlayer][0][x]);
        }
        for(int x = 0; x<5;x++){
            TextView t = mapTextView.get(tableTokens[x]);
            t.setText(""+game.playerTable[newCurrentPlayer][1][x]);
        }
        whichplayer.setText(game.playerName[newCurrentPlayer]+" Score");

    }
    public void setAddersToZero(String[] tokenAdded){
        for(int x=0;x<5;x++){
            TextView tAdd = mapTextView.get(tokenAdded[x]);
            tAdd.setText("0");
        }
    }
    public int[] addTokenToTableOfCurrentPlayer(int[] tableContent,String[] tokenAdded){
        for(int x=0;x<5;x++){
            TextView tAdd = mapTextView.get(tokenAdded[x]);
            String t = tAdd.getText().toString();
            int token = Integer.parseInt(t);
            tableContent[x] += token;
        }
        return tableContent;
    }
    public int[] removeTokenFromTableOfCurrentPlayer(int[] extraTokens,int[] playerTokenTable){
        for(int x =0;x<5;x++){
            playerTokenTable[x] -= extraTokens[x];
        }
        return playerTokenTable;
    }
    public void addCardWithScoreToCurrentPlayerTable(cardsParams c, int[] playerCardsTable){
        if(c.colour.equals("pink")) playerCardsTable[0]++;
        else if(c.colour.equals("blue")) playerCardsTable[1]++;
        else if(c.colour.equals("green")) playerCardsTable[2]++;
        else if(c.colour.equals("red")) playerCardsTable[3]++;
        else if(c.colour.equals("black")) playerCardsTable[4]++;

        playerCardsTable[5] += c.priceWithVP[5];
    }
    public int[] findExtraTokens(cardsParams c,int[] playerTable){
        int[] extraTokens = new int[5];
        for(int x = 0; x<5;x++){
            if(c.priceWithVP[x]-playerTable[x] >=0)
                extraTokens[x] = c.priceWithVP[x]-playerTable[x];
            else
                extraTokens[x] = 0;
        }
        return extraTokens;
    }
    public int[] setImageOfTokenImageWhileTakingToken(String[] tokenAdded,int[] colourID){
        for(int y = 0;y<5;y++){
            TextView tAdd = mapTextView.get(tokenAdded[y]);
            String s = tAdd.getText().toString();
            int S = Integer.parseInt(s);
            colourID[y] = colourID[y] - S;
            int tokenImage = getResources().getIdentifier(""+imageTokens[y]+"token"+colourID[y],"drawable",getPackageName());
            ImageView i = mapImageView.get(imageTokens[y]);
            i.setImageResource(tokenImage);
        }
        return colourID;
    }
    public int[] setImageOfTokenImageWhileGivingToken(int[] extraTokens, int[] colourID){
        for(int i = 0;i<5;i++){
            colourID[i] = colourID[i] + extraTokens[i];
            int tokenImage = getResources().getIdentifier(""+imageTokens[i]+"token"+colourID[i],"drawable",getPackageName());
            ImageView image = mapImageView.get(imageTokens[i]);
            image.setImageResource(tokenImage);
        }
        return colourID;
    }
    public void checkNobel(){
        for(int x = 0 ;x<card[3].length;x++){
                if(checkPrice(card[3][x],true)) {
                    addCardWithScoreToCurrentPlayerTable(card[3][x],game.playerTable[game.currentPlayer][0]);
                    card[3][x] = deck.nobelback;
                    String s = "nobel"+(x+1);
                    ImageView i = mapImageView.get(s);
                    int cardImage = getResources().getIdentifier("nobel","drawable",getPackageName());
                    i.setImageResource(cardImage);
                }
        }
    }
    public void showInfo(View view){
        if(view.getId() == R.id.player1showtable)
            setTableForNextPlayer(0);
        else if(view.getId()== R.id.player2showtable)
        setTableForNextPlayer(1);
        if(game.numOfPlayers >=3 && view.getId()== R.id.player3showtable)
        setTableForNextPlayer(2);
        if(game.numOfPlayers == 4 && view.getId()== R.id.player4showtable)
            setTableForNextPlayer(3);
    }
    public boolean isGameOver(){
        for(int x = 0; x<game.numOfPlayers;x++){
            if(game.playerTable[x][0][5] >=15)
                return true;
        }
        return false;
    }
    public boolean checkTokenAdded(TextView pink,TextView blue,TextView green,TextView red,TextView black,int[] tID){

        int[] colourAdded = new int[]{value(pink),value(blue),value(green),value(red),value(black)};


        if(colourAdded[0]>tID[0]) {
            Toast.makeText(this, "Enough Pink Tokens are not available.", Toast.LENGTH_SHORT).show();
                return false;
            }
        else if(colourAdded[1]>tID[1]) {
            Toast.makeText(this, "Enough Blue Tokens are not available.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(colourAdded[2]>tID[2]) {
            Toast.makeText(this, "Enough Green Tokens are not available.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(colourAdded[3]>tID[3]) {
            Toast.makeText(this, "Enough Red Tokens are not available.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(colourAdded[4]>tID[4]) {
            Toast.makeText(this, "Enough Black Tokens are not available.", Toast.LENGTH_SHORT).show();
            return false;
        }
        
        int addedTokens = 0;
        for(int x = 0; x<5;x++){
            addedTokens+= colourAdded[x];
        }
        if(addedTokens >3){
            Toast.makeText(this, "You cannot pick more than 3 Tokens.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(addedTokens<=0){
            Toast.makeText(this, "Choose some tokens.", Toast.LENGTH_SHORT).show();
            return false;
        }

        switch(totalTokenForPlayer()){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                switch(addedTokens){
                    case 3:
                        if(allDifferentToken(colourAdded, 3)){
                            return true;
                        }
                        else {
                            Toast.makeText(this, "You have to choose 3 Different Tokens.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    case 2:
                        if(twoSameToken(colourAdded,tID)) return true;
                        else if(allDifferentToken(colourAdded,2) && numOfZeroToken(tID) == 3) return true;
                        else{
                            Toast.makeText(this, "You have to choose 2 Same tokens or 3 Different.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    case 1:
                        if(numOfZeroToken(tID) == 4 && oneTokenAdded(colourAdded, tID)){
                            return true;
                        }
                        else {
                            Toast.makeText(this, "Try Again, You can pick more than 1 Token.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    default:
                        return false;
                }
            case 8:
                switch(addedTokens){
                    case 2:
                        if(allDifferentToken(colourAdded,2)) return true;
                        else if(twoSameToken(colourAdded,tID)) return true;
                        else{
                            Toast.makeText(this, "You can pick 2 Different or 2 Same only if there are 4 or more tokens available.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    case 1:
                        if(numOfZeroToken(tID) == 4 && oneTokenAdded(colourAdded, tID)){
                            return true;
                        }
                        else {
                            Toast.makeText(this, "You can pick 2 Tokens.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    default:
                        Toast.makeText(this, "You have 8 Tokens, you can not pick 3 Tokens.", Toast.LENGTH_SHORT).show();
                        return false;
                }
            case 9:
                if(allDifferentToken(colourAdded,1)){
                    return true;
                }
                else{
                    Toast.makeText(this, "You have 9 Tokens, you can not pick more than 1 Tokens.", Toast.LENGTH_SHORT).show();
                    return false;
                }
            default:
                Toast.makeText(this, "You have 10 Tokens, can't pick more.", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
    public boolean allDifferentToken(int[] colour,int numOfDifferentTokens){
        int count = 0;
        for(int x =0;x<5;x++){
            if(colour[x] == 1) count++;
        }
        return count == numOfDifferentTokens;
    }
    public int numOfZeroToken(int[] colour){
        int count = 0;
        for(int x =0;x<5;x++){
            if(colour[x] == 0) count++;
        }
        return count;
    }
    public boolean twoSameToken(int[] colourAdded,int[] colourID){
        if(allDifferentToken(colourAdded,2))
            return false;
        else {
            for (int x = 0; x < 5; x++) {
                if (colourAdded[x] == 2)
                    return colourID[x] >= 4;
            }
        }
        return false;
    }
    public boolean oneTokenAdded(int[] colourAdded,int[] colourID){
        for(int x = 0; x<5;x++){
            if(colourAdded[x] == 1)
                return colourID[x] < 4;
        }
        return false;
    }
    public int value(TextView t){
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        return S;
    }
    public int totalTokenForPlayer(){
        int totalTokens = 0;
        for(int x =0;x<5;x++)
            totalTokens+=game.playerTable[game.currentPlayer][1][x];
        return totalTokens;
    }

    public void music(View view){
        if(ringBackground.isPlaying())
        {
            int musicImage = getResources().getIdentifier("musicoff","drawable",getPackageName());
            ImageView image = findViewById(R.id.musicON);
            image.setImageResource(musicImage);

            ringBackground.pause();
        }

        else {
            int musicImage = getResources().getIdentifier("musicon","drawable",getPackageName());
            ImageView image = findViewById(R.id.musicON);
            image.setImageResource(musicImage);
            ringBackground.start();
        }
    }
}