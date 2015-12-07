package com.example.zolwo_000.inzynierkamvc.Controllers;

import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.utils.PhotoParameters;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

import java.util.List;
import java.util.Random;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class CategoryController {
    public void setRandomPhotoForCategory(CategoryModel category, boolean generalization) {
        List<PhotoModel> photosList;
        int photosNumber;
        if(generalization) {
            photosList = category.getPhotosGeneralizationSet();
            photosNumber = category.getPhotosGeneralizationNumber();
        } else {
            photosList = category.getPhotosLearningSet();
            photosNumber = category.getPhotosLearningNumber();
        }

        Random random = GameApplication.getRandom();
        //int photosNumber = category.getPhotosNumber();
        if(photosNumber == 0) {
            return; //jesli nie bedzie zadnego zdjecia...zeby apki nie wywalalo
        }
        PhotoModel photo = photosList.get(random.nextInt(photosNumber));
        category.setDisplayedPhoto(photo);
    }

    public void setPhotosParameters(CategoryModel category, PhotoParameters photoParameters) {
        List<PhotoModel> photosList = category.getPhotosList();
        for(int i = 0;i < photosList.size(); ++i) {
            photosList.get(i).setPhotoParameters(photoParameters);
        }
    }
}
