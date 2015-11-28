package com.example.zolwo_000.inzynierkamvc;

import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;

/**
 * Created by Klaudia on 2015-11-15.
 */
public class Child {
    private int id;
    private String set = "";
    private CategoryModel categoryObj;
    private String category = "";
    private String image = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryModel getCategoryObj() {
        return categoryObj;
    }

    public void setCategoryObj(CategoryModel categoryObj) {
        this.categoryObj = categoryObj;
    }
}
