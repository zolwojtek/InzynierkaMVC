package com.example.zolwo_000.inzynierkamvc.models;

import com.example.zolwo_000.inzynierkamvc.CategoryType;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.Views.FView;

import java.util.List;
import java.util.Random;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class CategoryModel extends FModel<FView> {
    private String name = null;
    private List<PhotoModel> photosLearningSet = null;
    private List<PhotoModel> photosGeneralizationSet = null;
    private List<PhotoModel> photosList = null;
    private PhotoModel displayedPhoto = null;
    private CategoryType type = null;
    private int photosNumber;
    private boolean isUsed;


    public int getPhotosNumber() {
        return photosNumber;
    }

    public void setPhotosNumber(int photosNumber) {
        this.photosNumber = photosNumber;
    }

    public void setPhotosList(List<PhotoModel> photosList) {
        this.photosList = photosList;
    }

    public List<PhotoModel> getPhotosList() {
        return photosList;
    }

    public void setDisplayedPhoto(PhotoModel photo) {
        this.displayedPhoto = photo;
    }

    public PhotoModel getDisplayedPhoto() {
        return displayedPhoto;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }


}
