package com.example.zolwo_000.inzynierkamvc;


import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class BoldHint implements Hint {
    @Override
    public void show() {
        GameController gameController = GameApplication.getGameController();
        CategoryModel categoryMToLearn = gameController.getCategoryToLearn();

        categoryMToLearn.getDisplayedPhoto().setBorder(10);

    }
}
