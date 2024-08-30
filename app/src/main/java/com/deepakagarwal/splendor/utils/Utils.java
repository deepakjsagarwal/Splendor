package com.deepakagarwal.splendor.utils;

import android.media.MediaPlayer;
import android.widget.TextView;

public class Utils {

    public static void startMediaPlayer(MediaPlayer ringBackground) {
        ringBackground.start();
        ringBackground.setLooping(true);
        ringBackground.setVolume(100, 100);
    }

    public static int value(TextView t) {
        String s = t.getText().toString();
        return Integer.parseInt(s);
    }
}
