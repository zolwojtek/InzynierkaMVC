package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.enumerators.Level;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class QuestionSoundModel extends SoundModel {
    public void play(final Activity activity, final CategoryModel category, final Level level) {//doecelowo bedzie pobierać ze sciezki ktora bezdzie zapisana w kategorii
        super.play(activity, category, level);

        int resId;
        if (level == Level.Level0) {
            CategorySoundModel categorySound = new CategorySoundModel();
            categorySound.play(activity, category, level);
            return;
        } else if (level == Level.Level1) {
            resId = activity.getResources().getIdentifier("exercise1", "raw", activity.getPackageName());
        } else {
            resId = activity.getResources().getIdentifier("exercise2", "raw", activity.getPackageName());
        }

        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
                CategorySoundModel categorySound = new CategorySoundModel();
                categorySound.play(activity, category, level);
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
