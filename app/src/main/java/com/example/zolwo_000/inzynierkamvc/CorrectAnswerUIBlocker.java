package com.example.zolwo_000.inzynierkamvc;

import android.app.Activity;
import android.widget.ImageButton;

/**
 * Created by Ola on 2015-12-02.
 */
public class CorrectAnswerUIBlocker implements UIBlocker {
    @Override
    public void blockUI(Activity activity, boolean block) {
        ImageButton nextTryImageButton = (ImageButton) activity.findViewById(R.id.nextTryImageButton);
        nextTryImageButton.setClickable(!block);
        ImageButton soundTubeImageButton = (ImageButton) activity.findViewById(R.id.soundTubeImageButton);
        soundTubeImageButton.setClickable(!block);
    }
}
