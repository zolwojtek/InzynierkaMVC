package com.example.zolwo_000.inzynierkamvc.gameModes;

import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;

/**
 * Created by zolwo_000 on 21.11.2015.
 */
public class AutomaticMode implements GameMode {
    @Override
    public void setPlanForNextExercise() {
        GameController gameController = GameApplication.getGameController();
        boolean successWithFirstTry = gameController.isSuccessWithFirstTry();
        boolean previousSuccess = gameController.wasPreviousSuccessWithFirstTry();
        int triesNumber;
        int successesNumber;
        boolean automaticGeneralization = gameController.isAutomaticGeneralization();


        if(successWithFirstTry) {
            if(previousSuccess) {
                gameController.incrementSuccessesWithFirstTryNumber();
            }
            gameController.changePhotosOrder();
            gameController.changePhotosForAllDisplayedCategories(automaticGeneralization);
        }
        gameController.incrementTriesNumber();
        successesNumber = gameController.getSuccessesWithFirstTryNumber();
        triesNumber = gameController.getTriesNumber();


        /*if(successWithFirstTry && previousSuccess) {
            gameController.incrementSuccessesWithFirstTryNumber();
            gameController.changePhotosOrder();
            gameController.changePhotosForAllDisplayedCategories();
        }
        gameController.incrementTriesNumber();
        triesNumber = gameController.getTriesNumber();
        successesNumber = gameController.getSuccessesWithFirstTryNumber();*/

        int param = gameController.getAutomaticRepeats(); //to będzie do ustawienia
        if(successWithFirstTry && triesNumber >= param) {
            if (successesNumber == param && successesNumber == triesNumber) {
                if(automaticGeneralization) {
                    gameController.changeCategoryToLearn();
                    gameController.setAutomaticGeneralization(false);
                } else {
                    gameController.setAutomaticGeneralization(true);
                }
            }

            gameController.setSuccessesWithFirstTryNumber(0);
            gameController.setTriesNumber(0);

        }
        gameController.setPreviousSuccessWithFirstTry(successWithFirstTry);
    }
}
