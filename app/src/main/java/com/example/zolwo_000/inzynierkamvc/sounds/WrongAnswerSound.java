package com.example.zolwo_000.inzynierkamvc.sounds;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.sounds.SoundBase;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class WrongAnswerSound extends SoundBase {
    @Override
    public void play(Activity activity, CategoryModel category) {
        int resId = activity.getResources().getIdentifier("zle", "raw", activity.getPackageName());
        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
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
