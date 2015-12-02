package com.example.zolwo_000.inzynierkamvc;

import android.app.Activity;
import android.widget.ImageButton;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;

/**
 * Created by Ola on 2015-12-02.
 */
public class GameUIBlocker implements UIBlocker {
    @Override
    public void blockUI(Activity activity, boolean block) {

        GameController gameController = GameApplication.getGameController();
        CategoryModel[] displayedCategories = gameController.getDisplayedCategories();

        ImageButton soundTube = (ImageButton) activity.findViewById(R.id.buttonSoundTube);
        soundTube.setClickable(!block);
        for(int i = 0; i < displayedCategories.length; ++i) {
            displayedCategories[i].getDisplayedPhoto().getImageView().setClickable(!block);
        }

    }
}
