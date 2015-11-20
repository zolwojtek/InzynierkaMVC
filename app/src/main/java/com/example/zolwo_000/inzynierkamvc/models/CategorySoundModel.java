package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.media.MediaPlayer;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class CategorySoundModel extends SoundModel {
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void play(Activity activity, CategoryModel category) {
        int resId = activity.getResources().getIdentifier(category.getName() + "_m", "raw", activity.getPackageName());
        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
            }
        });
        mediaPlayer.start();
    }
}