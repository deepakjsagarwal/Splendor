package com.deepakagarwal.splendor;

import android.widget.TextView;

public class copyForToken {

    public static boolean checkTokenAdded(TextView pink, TextView blue, TextView green, TextView red, TextView black, int[] tID){
        int[] colourAdded = new int[]{value(pink),value(blue),value(green),value(red),value(black)};
        for(int x = 0;x<5;x++){
            if(colourAdded[x]>tID[x]) return false;
        }

        int addedTokens = 0;
        for(int x = 0; x<5;x++){
            addedTokens+= colourAdded[x];
        }
        return addedTokens == 1 || addedTokens == 2;

    }
    public static int value(TextView t){
        String s = t.getText().toString();
        int S = Integer.parseInt(s);
        return S;
    }
}
