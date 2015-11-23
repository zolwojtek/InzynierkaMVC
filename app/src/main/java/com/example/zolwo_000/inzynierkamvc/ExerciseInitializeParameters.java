package com.example.zolwo_000.inzynierkamvc;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class ExerciseInitializeParameters {
    private int numberOfDisplayedPhotos = 0;
    private Level level;

    public ExerciseInitializeParameters() {
        numberOfDisplayedPhotos = 6;
        level = Level.Level2;
    }

    public int getDisplayedCategoriesNumber() {
        return numberOfDisplayedPhotos;
    }

    public Level getLevel() { return level; }
}
