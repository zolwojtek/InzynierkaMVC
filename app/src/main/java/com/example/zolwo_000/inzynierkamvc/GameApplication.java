package com.example.zolwo_000.inzynierkamvc;

import android.app.Application;

import com.example.zolwo_000.inzynierkamvc.Controllers.CategoryController;
import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.models.GameModel;

import java.util.Random;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class GameApplication extends Application {

    transient private static GameModel gameModel = null;
    transient private static GameController gameController = null;
    transient private static CategoryController categoryController = null;
    transient private static GameMode gameMode = null;
    transient private static Random random = null;


    public static GameModel getGameModel() {
        if (gameModel == null) {
            gameModel = new GameModel();
        }
        return gameModel;
    }

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController(getGameModel());
        }
        return gameController;
    }
////Finalnie to nie bedzie moglo byc tu, poniewaz to zalezy od ustawien
//    public static GameMode getGameMode() {
//        if (gameMode == null) {
//
//            gameMode = GameModeFactory.getGameModeClass()
//        }
//        return gameMode;
//    }

    public static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    public static CategoryController getCategoryController() {
        if (categoryController == null) {
            categoryController = new CategoryController();
        }
        return categoryController;
    }
}
