package com.example.zolwo_000.inzynierkamvc.hints;

import com.example.zolwo_000.inzynierkamvc.enumerators.HintType;
import com.example.zolwo_000.inzynierkamvc.hints.BorderHint;
import com.example.zolwo_000.inzynierkamvc.hints.FadeHint;
import com.example.zolwo_000.inzynierkamvc.hints.Hint;
import com.example.zolwo_000.inzynierkamvc.hints.NoneHint;

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
