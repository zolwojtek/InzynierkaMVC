package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;

import com.example.zolwo_000.inzynierkamvc.Controllers.DataBaseController;
import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.DbAdapter;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.UIBlocker;
import com.example.zolwo_000.inzynierkamvc.enumerators.Level;
import com.example.zolwo_000.inzynierkamvc.sounds.SoundBase;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class CategorySound extends SoundBase {
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void play(final Activity activity, CategoryModel category, final Level level, final UIBlocker UIBlocker) {

        Context sharedContext = null;
        try {
            sharedContext = activity.createPackageContext("com.example.klaudia.configapp", Context.CONTEXT_INCLUDE_CODE);
            if (sharedContext == null) {
                return;
            }
        } catch (Exception e) {
            String error = e.getMessage();
            return;
        }

        DbAdapter sharedDBadapter = new DbAdapter(sharedContext);
        sharedDBadapter.openDB();


        DataBaseController dataBaseController = new DataBaseController();

        dataBaseController.setDb(sharedDBadapter.getDb());

       // Cursor cursorCategories = dataBaseController.loadCategories();


        //DataBaseController dataBaseController = new DataBaseController();
        //dataBaseController.openDataBase();
        Cursor audioPath = dataBaseController.loadAudioPath(category.getName());
        audioPath.moveToNext();

        Uri uri;
        if (level == Level.LEVEL3 && audioPath.getString(1) == "") {
            uri = Uri.parse(audioPath.getString(1));
        } else {
            uri = Uri.parse(audioPath.getString(0));
        }

        dataBaseController.closeDataBase();

        mediaPlayer = MediaPlayer.create(activity, uri);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                if (UIBlocker != null){
                    UIBlocker.blockUI(activity, false);
                }

                destroy();
                //TYMCZASOWE//
                GameController gameController = GameApplication.getGameController();
                CategoryModel[] displayedCategories = gameController.getDisplayedCategories();
                for(int i = 0; i < displayedCategories.length; ++i) {
                    displayedCategories[i].getDisplayedPhoto().getImageView().setVisibility(View.VISIBLE);
                }
                ////
            }
        });
        mediaPlayer.start();
    }
}
