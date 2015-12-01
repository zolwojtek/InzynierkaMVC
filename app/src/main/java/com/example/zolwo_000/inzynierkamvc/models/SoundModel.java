package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.enumerators.Level;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public abstract class SoundModel {
    protected MediaPlayer mediaPlayer;

    public void  play(Activity activity, CategoryModel category) {
    }

    public void play(Activity activity, CategoryModel category, Level level) {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
    public void stop() {
        mediaPlayer.stop();
    }
    public void destroy(){
        mediaPlayer.reset();
        mediaPlayer.release();
    }


}
