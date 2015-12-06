package com.example.zolwo_000.inzynierkamvc.sounds;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.UIBlocker;
import com.example.zolwo_000.inzynierkamvc.enumerators.Level;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.CategorySound;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class CorrectAnswerSound extends SoundBase {
    @Override
    public void play(final Activity activity, final CategoryModel category, final UIBlocker uiBlocker) {
        super.play(activity,category, uiBlocker);
        int resId = activity.getResources().getIdentifier("dobrze", "raw", activity.getPackageName());
        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
                CategorySound categorySound = new CategorySound();
                categorySound.play(activity, category, Level.LEVEL1, uiBlocker);
            }
        });
        mediaPlayer.start();

    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();

    }
}
