package com.example.zolwo_000.inzynierkamvc.sounds;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.enumerators.Level;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public abstract class SoundBase {
    protected MediaPlayer mediaPlayer;

    public void play(Activity activity, CategoryModel category) {
    }

    public void play(Activity activity, CategoryModel category, Level level) {
    }

    public void stop() {
        mediaPlayer.stop();
    }
    public void destroy(){
        mediaPlayer.reset();
        mediaPlayer.release();
    }


}
