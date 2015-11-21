package com.example.zolwo_000.inzynierkamvc.Controllers;

import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.zolwo_000.inzynierkamvc.CategoryType;
import com.example.zolwo_000.inzynierkamvc.ExerciseInitializeParameters;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.Hint;
import com.example.zolwo_000.inzynierkamvc.HintType;
import com.example.zolwo_000.inzynierkamvc.PhotoParameters;
import com.example.zolwo_000.inzynierkamvc.Timer;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.GameModel;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

import java.util.List;
import java.util.Random;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class GameController extends FController<GameModel> {
    public GameController(GameModel gameModel) {
        super(gameModel);
    }

    public void initializeExercise(ExerciseInitializeParameters params) {
        //obiekt params powinien byc zapisywany
        int displayedCategoriesNumber = params.getDisplayedCategoriesNumber();
        this.model.setDisplayedPhotosNumber(displayedCategoriesNumber);

        int[] photosOrder = getSimpleOrder(displayedCategoriesNumber);
        this.model.setPhotosOrder(photosOrder);
        setCategoryToLearn();
        setFakeCategories();

    }

    public CategoryModel[] getDisplayedCategories() {
        return this.model.getDisplayedCategories();
    }

    /*public PhotoModel[] getPhotosForDisplayedCategories() {
        CategoryModel[] displayedCategories = this.model.getDisplayedCategories();
        int displayedCategoriesNumber = this.model.getDisplayedCategoriesNumber();

        PhotoModel[] photos = new PhotoModel[displayedCategoriesNumber];
        for(int i = 0; i < displayedCategoriesNumber; ++i) {
            photos[i] = displayedCategories[i].getDisplayedPhoto();
        }
        return photos;
    }*/

    public int getDisplayedCategoriesNumber() {
        return this.model.getDisplayedCategoriesNumber();
    }

    private void setFakeCategories() {
        int fakeCategoriesNumber = this.model.getDisplayedCategoriesNumber() - 1;
        CategoryModel[] displayedCategories = new CategoryModel[fakeCategoriesNumber + 1];
        CategoryModel currentCategory = this.model.getCurrentCategory();
        for(int i = 0; i < fakeCategoriesNumber; ++i) {
            displayedCategories[i] = getRandomCategory(currentCategory.getType());
        }
        displayedCategories[fakeCategoriesNumber] = currentCategory;

        this.model.setDisplayedCategories(displayedCategories);
    }

    public void changeFakeCategories() {
        resetDisplayedCategories();
        CategoryModel currentCategory = this.model.getCurrentCategory();
        CategoryModel[] displayedCategories = this.model.getDisplayedCategories();
        int displayedCategoriesNumber = this.model.getDisplayedCategoriesNumber();

        for(int  i = 0; i < displayedCategoriesNumber - 1; ++i) {
            displayedCategories[i] = getRandomCategory(currentCategory.getType());
        }
        displayedCategories[displayedCategoriesNumber] = currentCategory;
        currentCategory.setIsUsed(true);
    }

    public void changePhotosOrder() {
        int displayedCategoriesNumber = model.getDisplayedCategoriesNumber();
        int[] newPhotosOrder = getSimpleOrder(displayedCategoriesNumber);
        permute(newPhotosOrder, displayedCategoriesNumber);
        this.model.setPhotosOrder(newPhotosOrder);
    }

    private void setCategoryToLearn() {
        CategoryModel categoryToLearn = getRandomCategoryToLearn();
        categoryToLearn.setIsUsed(true);
        this.model.setCurrentCategory(categoryToLearn);
    }

    public CategoryModel getCategoryToLearn() {
        return this.model.getCurrentCategory();
    }

    private CategoryModel getRandomCategoryToLearn() {
        List<CategoryModel> categoriesToLearn = this.model.getCategoriesToLearn();

        Random random = GameApplication.getRandom();
        int categoriesToLearnNumber = categoriesToLearn.size();
        return categoriesToLearn.get(random.nextInt(categoriesToLearnNumber));
    }

    private CategoryModel getRandomCategory(CategoryType categoryType) {
        List<List<CategoryModel>> allCategories = this.model.getAllCategories();
        List<CategoryModel> categories = null;
        int allCategoriesSize = allCategories.size();
        for (int i = 0; i < allCategoriesSize; ++i) {
            if(allCategories.get(i).get(0).getType() == categoryType) {
                categories = allCategories.get(i);
            }
        }

        Random random = GameApplication.getRandom();
        int categoriesNumber = categories.size();
        CategoryModel randomCategory;
        do{
            randomCategory = categories.get(random.nextInt(categoriesNumber));
        }while(randomCategory.getIsUsed());
        randomCategory.setIsUsed(true);
        return randomCategory;
    }

    public void changeCategoryToLearn() {
        CategoryModel currentCategory = this.model.getCurrentCategory();
        CategoryModel newCategory;

        resetDisplayedCategories();

        do{
            newCategory = getRandomCategoryToLearn();
        }while(newCategory.getName().equals(currentCategory.getName()));

        newCategory.setIsUsed(true);
        this.model.setCurrentCategory(newCategory);
        setFakeCategories();

    }



    public void changePhotoForCurrentCategory() {
        CategoryModel currentCategory = this.model.getCurrentCategory();
        CategoryController categoryController = GameApplication.getCategoryController();
        categoryController.setRandomPhotoForCategory(currentCategory);
    }

    public void changePhotosForFakeCategories() {
        CategoryModel[] displayedCategories = this.model.getDisplayedCategories();
        CategoryModel currentCategory = this.model.getCurrentCategory();
        CategoryController categoryController = GameApplication.getCategoryController();

        int displayedCategoriesSize = displayedCategories.length;
        for(int i = 0 ;i < displayedCategoriesSize; ++i) {
            if(!displayedCategories[i].getName().equals(currentCategory.getName())) {
                categoryController.setRandomPhotoForCategory(displayedCategories[i]);
            }
        }
    }

    public void changePhotosForAllCategories() {
        changePhotoForCurrentCategory();
        changePhotosForFakeCategories();
    }

    public void setPhotosParameters(PhotoParameters photosParameters) {
        CategoryController categoryController = GameApplication.getCategoryController();
        List<List<CategoryModel>> allCategories = this.model.getAllCategories();
        int allCategoriesSize = allCategories.size();
        for(int i = 0; i < allCategoriesSize; ++i) {
            for(CategoryModel category: allCategories.get(i)){
                categoryController.setPhotosParameters(category, photosParameters);
            }
        }
    }

    public void showHint(Hint hint) {
        hint.show();
    }

    private Timer timer = null;

    public void startTimer(int timeForHint, int timeForAnswer) {
        timer = new Timer();
        timer.execute(timeForHint, timeForAnswer);
    }

    public void stopTimer() {
        timer.cancel(true);
    }


    private void resetAllCategories() {
        List<List<CategoryModel>> allCategories = this.model.getAllCategories();
        int allCategoriesSize = allCategories.size();
        for(int i = 0; i < allCategoriesSize; ++i) {
            for(CategoryModel category: allCategories.get(i)){
                category.setIsUsed(false);
            }
        }
    }

    private void resetDisplayedCategories() {
        CategoryModel[] displayedCategories = this.model.getDisplayedCategories();
        int displayedCategoriesSize = displayedCategories.length;
        for(int  i = 0; i < displayedCategoriesSize; ++i) {
            displayedCategories[i].setIsUsed(false);
        }
    }



    private static int[] getSimpleOrder(int n) {
        int[] tab= new  int[n];
        for(int  i = 0; i < n; ++i) {
            tab[i] = i;
        }
        return tab;
    }

    private static void swap(int[] table, int a, int b){
        int c = table[a];
        table[a] = table[b];
        table[b] = c;
    }

    private static void permute(int[] table, int routeTimes)
    {
        Random rand = new Random();
        int n = table.length;
        for(int i = 0; i < routeTimes; ++i){
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);

            swap(table,a,b);
        }
    }







}

