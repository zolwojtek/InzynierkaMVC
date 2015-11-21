package com.example.zolwo_000.inzynierkamvc.models;

import android.app.Activity;

import com.example.zolwo_000.inzynierkamvc.Controllers.CategoryController;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.Views.FView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class GameModel extends FModel<FView> {
    private List<List<CategoryModel>> partsOfSpeech = null;
    private List<CategoryModel> categoriesToLearn = null;
    private CategoryModel[] displayedCategories = null;
    private CategoryModel currentCategory = null;
    private int[] displayedOrder = null;
    private int displayedPhotosNumber = 0;

    public GameModel() {
        //wczytywanie kategorii i zdjec
        //addCategories();
    }

    public CategoryModel[] getDisplayedCategories() {
       return displayedCategories;
    }

    public void  setDisplayedCategories(CategoryModel[] displayedCategories) {
        this.displayedCategories = displayedCategories;
    }

    public void setCurrentCategory(CategoryModel category) {
        currentCategory = category;
    }

    public CategoryModel getCurrentCategory() {
        return currentCategory;
    }

    public List<CategoryModel> getCategoriesToLearn() {
        return categoriesToLearn;
    }

    public List<List<CategoryModel>> getAllCategories() {
        return partsOfSpeech;
    }

    public void setDisplayedPhotosNumber(int displayedPhotosNumber) {
        this.displayedPhotosNumber = displayedPhotosNumber;
    }
    public void setPhotosOrder(int[] photosOrder) {
        displayedOrder = photosOrder;
    }

    public int getDisplayedCategoriesNumber() {
        return this.displayedPhotosNumber;
    }




//------------TYMCZASOWE------------//

    private Activity activity = null;
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void addCategories() {
        List<List<CategoryModel>> allCatogories = new ArrayList<>();
        List<CategoryModel> categoriesToLearn = new ArrayList<>();
        List<CategoryModel> nouns = new ArrayList<>();

        CategoryController categoryController = GameApplication.getCategoryController();

        ArrayList<PhotoModel>nameList = new ArrayList<>();

        String base = "lalka";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
            //photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat1 = new CategoryModel();
        cat1.setName(base);
        cat1.setPhotosList(nameList);
        cat1.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat1);
        //cat1.isAccusative = true;

        nameList = new ArrayList<>();
        base = "pies";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           //photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat2 = new CategoryModel();
        cat2.setName(base);
        cat2.setPhotosList(nameList);
        cat2.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat2);
        //cat2.isAccusative = true;

        nameList = new ArrayList<>();
        base = "samochod";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           // photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat3 = new CategoryModel();
        cat3.setName(base);
        cat3.setPhotosList(nameList);
        cat3.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat3);
        //cat3.isAccusative = false;

        nameList = new ArrayList<>();
        base = "ser";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
            //photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat4 = new CategoryModel();
        cat4.setName(base);
        cat4.setPhotosList(nameList);
        cat4.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat4);
        //cat4.isAccusative = false;

        nameList = new ArrayList<>();
        base = "chleb";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
            //photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat5 = new CategoryModel();
        cat5.setName(base);
        cat5.setPhotosList(nameList);
        cat5.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat5);
//        cat5.isAccusative = false;

        nameList = new ArrayList<>();
        base = "cytryna";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           // photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat6 = new CategoryModel();
        cat6.setName(base);
        cat6.setPhotosList(nameList);
        cat6.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat6);
//        cat6.isAccusative = true;

        nameList = new ArrayList<>();
        base = "gruszka";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           // photo.setImageViewInTable(activity);
          //  photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat7 = new CategoryModel();
        cat7.setName(base);
        cat7.setPhotosList(nameList);
        cat7.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat7);
//        cat7.isAccusative = true;

        nameList = new ArrayList<>();
        base = "jablko";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           // photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat8 = new CategoryModel();
        cat8.setName(base);
        cat8.setPhotosList(nameList);
        cat8.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat8);
//        cat8.isAccusative = false;

        nameList = new ArrayList<>();
        base = "kot";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           // photo.setImageViewInTable(activity);
//            photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat9 = new CategoryModel();
        cat9.setName(base);
        cat9.setPhotosList(nameList);
        cat9.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat9);
//        cat9.isAccusative = true;

        nameList = new ArrayList<>();
        base = "kubek";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
           // photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat10 = new CategoryModel();
        cat10.setName(base);
        cat10.setPhotosList(nameList);
        cat10.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat10);
//        cat10.isAccusative = false;

        nameList = new ArrayList<>();
        base = "pilka";
        for(int i = 0; i < 6; ++i)
        {
            PhotoModel photo = new PhotoModel(base + i);
          //  photo.setImageViewInTable(activity);
            //photo.setActivity(activity);
            nameList.add(photo);
        }

        CategoryModel cat11 = new CategoryModel();
        cat11.setName(base);
        cat11.setPhotosList(nameList);
        cat11.setPhotosNumber(6);
        categoryController.setRandomPhotoForCategory(cat11);
//        cat11.isAccusative = true;

        nouns.add(cat1);
        categoriesToLearn.add(cat1);
        nouns.add(cat2);
        categoriesToLearn.add(cat2);
        nouns.add(cat3);
        categoriesToLearn.add(cat3);
        nouns.add(cat4);
        categoriesToLearn.add(cat4);
        nouns.add(cat5);
        categoriesToLearn.add(cat5);
        nouns.add(cat6);
        categoriesToLearn.add(cat6);
        nouns.add(cat7);
        categoriesToLearn.add(cat7);
        nouns.add(cat8);
        categoriesToLearn.add(cat8);
        nouns.add(cat9);
        categoriesToLearn.add(cat9);
        nouns.add(cat10);
        categoriesToLearn.add(cat10);
        nouns.add(cat11);
        categoriesToLearn.add(cat11);

        allCatogories.add(nouns);
        this.partsOfSpeech = allCatogories;
        this.categoriesToLearn = categoriesToLearn;
    }
}
