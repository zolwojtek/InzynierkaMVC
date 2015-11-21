package com.example.zolwo_000.inzynierkamvc;

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
        int triesNumber = gameController.getTriesNumber();
        int successesNumber = gameController.getSuccessesWithFirstTryNumber();

        if(successWithFirstTry && previousSuccess) {
            gameController.incrementSuccessesWithFirstTryNumber();
            gameController.changePhotosOrder();
            gameController.changePhotosForAllDisplayedCategories();
        } else {
            //powtorz dokladnie to samo
            //terapeyta bedzie mial przycisk, ze nawet przy dobrej odpowiedzi bedzie mogl powtorzyc dokladnie to samo
        }
        gameController.incrementTriesNumber();

        int param = 1; //to będzie do ustawienia
        if(triesNumber == param) {
            if (successesNumber == param) {
                gameController.changeCategoryToLearn();
            }

            gameController.setSuccessesWithFirstTryNumber(0);
            gameController.setTriesNumber(0);

        }
        gameController.setPreviousSuccessWithFirstTry(successWithFirstTry);
    }
}
