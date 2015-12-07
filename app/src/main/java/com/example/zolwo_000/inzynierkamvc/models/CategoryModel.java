package com.example.zolwo_000.inzynierkamvc.models;

import com.example.zolwo_000.inzynierkamvc.enumerators.CategoryType;
import com.example.zolwo_000.inzynierkamvc.Views.FView;

import java.util.List;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class CategoryModel extends FModel<FView> {

    private List<PhotoModel> photosLearningSet = null;
    private List<PhotoModel> photosGeneralizationSet = null;
    private List<PhotoModel> photosList = null;
    private PhotoModel displayedPhoto = null;
    private CategoryType type = null;
    private String status = "";
    private String audio1 = "";
    private String audio2 = "";
    private String name = null;
    //private int photosNumber;
    private int photosGeneralizationNumber;
    private int photosLearningNumber;
    private boolean isUsed = false;

    public int getPhotosGeneralizationNumber() {
        return photosGeneralizationNumber;
    }

    public void setPhotosGeneralizationNumber(int photosGeneralizationNumber) {
        this.photosGeneralizationNumber = photosGeneralizationNumber;
    }

    public int getPhotosLearningNumber() {
        return photosLearningNumber;
    }

    public void setPhotosLearningNumber(int photosLearningNumber) {
        this.photosLearningNumber = photosLearningNumber;
    }

    public List<PhotoModel> getPhotosLearningSet() {
        return photosLearningSet;
    }

    public void setPhotosLearningSet(List<PhotoModel> photosLearningSet) {
        this.photosLearningSet = photosLearningSet;
    }

    public List<PhotoModel> getPhotosGeneralizationSet() {
        return photosGeneralizationSet;
    }

    public void setPhotosGeneralizationSet(List<PhotoModel> photosGeneralizationSet) {
        this.photosGeneralizationSet = photosGeneralizationSet;
    }

    public List<PhotoModel> getPhotosList() {
        return photosList;
    }

    public void setPhotosList(List<PhotoModel> photosList) {
        this.photosList = photosList;
    }

    public PhotoModel getDisplayedPhoto() {
        return displayedPhoto;
    }

    public void setDisplayedPhoto(PhotoModel displayedPhoto) {
        this.displayedPhoto = displayedPhoto;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAudio1() {
        return audio1;
    }

    public void setAudio1(String audio1) {
        this.audio1 = audio1;
    }

    public String getAudio2() {
        return audio2;
    }

    public void setAudio2(String audio2) {
        this.audio2 = audio2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getPhotosNumber() {
//        return photosNumber;
//    }
//
//    public void setPhotosNumber(int photosNumber) {
//        this.photosNumber = photosNumber;
//    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
