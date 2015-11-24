package com.example.zolwo_000.inzynierkamvc;

/**
 * Created by zolwo_000 on 24.11.2015.
 */
public class GameModeFactory {
    public static GameMode getGameModeClass(GameModeType gameModeType) {
        GameMode gameMode;
        switch(gameModeType) {
            case AUTO:
            {
                gameMode = new AutomaticMode();
                break;
            }
            case THERAPIST:
            {
                gameMode = new TherapistMode();
                break;
            }
            default:
            {
                gameMode = new AutomaticMode();
            }
        }
        return gameMode;
    }
}
