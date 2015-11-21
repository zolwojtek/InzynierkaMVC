package com.example.zolwo_000.inzynierkamvc;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;

/**
 * Created by zolwo_000 on 21.11.2015.
 */
public class TherapistMode implements GameMode {
    @Override
    public void setPlanForNextExercise() {
        GameController gameController = GameApplication.getGameController();
        boolean successWithFirstTry = gameController.isSuccessWithFirstTry();
        //boolean isGeneralization = gameController.isGeneralization();

        if(successWithFirstTry) {
            //ta sama kategoria, inne zdjecia i kolejnosc
            gameController.changePhotosOrder();
            gameController.changePhotosForAllDisplayedCategories();
        } else {
            //powtorz dokladnie to samo
            //terapeyta bedzie mial przycisk, ze nawet przy dobrej odpowiedzi bedzie mogl powtorzyc dokladnie to samo
        }
    }
}
