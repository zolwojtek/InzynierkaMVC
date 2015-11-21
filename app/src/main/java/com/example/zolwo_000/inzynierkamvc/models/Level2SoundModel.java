package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.media.MediaPlayer;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class Level2SoundModel extends SoundModel {
    public void play(final Activity activity, final CategoryModel category) {//doecelowo bedzie pobierać ze sciezki ktora bezdzie zapisana w kategorii
        super.play(activity,category);
        int resId = activity.getResources().getIdentifier("exercise1", "raw", activity.getPackageName());
        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
                CategorySoundModel categorySound = new CategorySoundModel();
                categorySound.play(activity, category);
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
