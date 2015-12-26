package com.example.zolwo_000.inzynierkamvc.sounds;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.zolwo_000.inzynierkamvc.UIBlocker;
import com.example.zolwo_000.inzynierkamvc.enumerators.Level;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class QuestionSound extends SoundBase {

    public void play(final Activity activity, final CategoryModel category, final Level level, final UIBlocker uiBlocker) {//doecelowo bedzie pobierać ze sciezki ktora bezdzie zapisana w kategorii
        super.play(activity, category, level);

        int resId = 0;
        switch(level) {
            case LEVEL1:
            {
                resId = activity.getResources().getIdentifier("pusty", "raw", activity.getPackageName());
                break;
            }
            case LEVEL2:
            {
                resId = activity.getResources().getIdentifier("exercise1", "raw", activity.getPackageName());
                break;
            }
            case LEVEL3:
            {
                resId = activity.getResources().getIdentifier("exercise2", "raw", activity.getPackageName());
                break;
            }
        }

        mediaPlayer = MediaPlayer.create(activity, resId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
                CategorySound categorySound = new CategorySound();
                categorySound.play(activity, category, level, uiBlocker);
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
