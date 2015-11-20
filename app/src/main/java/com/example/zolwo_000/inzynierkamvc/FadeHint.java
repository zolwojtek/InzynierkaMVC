package com.example.zolwo_000.inzynierkamvc;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class FadeHint implements Hint {
    @Override
    public void show() {
        GameController gameController = GameApplication.getGameController();
        int displayedCategoriesNumber = gameController.getDisplayedCategoriesNumber();

        CategoryModel categoryToLearn = gameController.getCategoryToLearn();
        String categoryToLearnname = categoryToLearn.getName();
        CategoryModel[] displayedCategories = gameController.getDisplayedCategories();
        for (int i = 0; i < displayedCategoriesNumber; i++) {
            if(!displayedCategories[i].getName().equals(categoryToLearnname)) {
                PhotoModel photo = displayedCategories[i].getDisplayedPhoto();
                photo.setPhotoAlpha(50);
            }
        }


        //categoryToLearn.getDisplayedPhoto().setPhotoAlpha(100);
    }
}
