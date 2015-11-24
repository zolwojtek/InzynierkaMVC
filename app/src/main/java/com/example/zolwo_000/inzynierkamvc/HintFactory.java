package com.example.zolwo_000.inzynierkamvc;

/**
 * Created by zolwo_000 on 24.11.2015.
 */
public class HintFactory {

    public static Hint getHintClass(HintType hint) {
        Hint hintClass;
        switch(hint) {
            case BORDER:
            {
                hintClass = new BorderHint();
                break;
            }
            case FADE:
            {
                hintClass = new FadeHint();
                break;
            }
            default:
            {
                hintClass = new NoneHint();
            }
        }
        return hintClass;
    }
}
