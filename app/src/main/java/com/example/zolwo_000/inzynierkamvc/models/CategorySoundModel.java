package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.zolwo_000.inzynierkamvc.controllers.DataBaseController;
import com.example.zolwo_000.inzynierkamvc.enumerators.Level;

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
    public void play(Activity activity, CategoryModel category, Level level) {

        DataBaseController dataBaseController = new DataBaseController();
        dataBaseController.openDataBase();
        Cursor audioPath = dataBaseController.loadAudioPath(category.getName());
        audioPath.moveToNext();

        Uri uri;
        if (level == Level.Level2 && audioPath.getString(1) == "") {
            uri = Uri.parse(audioPath.getString(1));
        } else {
            uri = Uri.parse(audioPath.getString(0));
        }

        dataBaseController.closeDataBase();

        mediaPlayer = MediaPlayer.create(activity, uri);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                destroy();
            }
        });
        mediaPlayer.start();
    }
}
