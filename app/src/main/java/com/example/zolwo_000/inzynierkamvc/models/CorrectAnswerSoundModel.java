package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.enumerators.Level;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class CorrectAnswerSoundModel extends  SoundModel {
    @Override
    public void play(final Activity activity, final CategoryModel category) {//doecelowo bedzie pobierać ze sciezki ktora bezdzie zapisana w kategorii
        super.play(activity,category);
        int resId = activity.getResources().getIdentifier("dobrze", "raw", activity.getPackageName());
        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
                CategorySoundModel categorySound = new CategorySoundModel();
                categorySound.play(activity, category, Level.Level0);
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
