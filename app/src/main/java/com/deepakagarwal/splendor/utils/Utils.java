package com.deepakagarwal.splendor.utils;

import android.media.MediaPlayer;

public class Utils {

    public static void startMediaPlayer(MediaPlayer ringBackground) {
        ringBackground.start();
        ringBackground.setLooping(true);
        ringBackground.setVolume(100, 100);
    }
}
