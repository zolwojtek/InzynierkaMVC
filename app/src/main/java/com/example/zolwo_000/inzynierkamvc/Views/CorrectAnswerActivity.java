package com.example.zolwo_000.inzynierkamvc.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;

import com.example.zolwo_000.inzynierkamvc.utils.AnimationManager;
import com.example.zolwo_000.inzynierkamvc.controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.gameModes.GameMode;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.CorrectAnswerSoundModel;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

public class CorrectAnswerActivity extends Activity {

    private Activity activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);
        activity = this;

        exposeRightPhoto();
        photoAnimation();
        playApplause();
        //-----------TO DO------------
        //ZABLOKOWAC UI DOPOKI NIE SKONCZY MOWIC

        ImageButton nextTryImageButton = (ImageButton) activity.findViewById(R.id.nextTryImageButton);
        nextTryImageButton.setOnClickListener(nextTryClickListener);
        nextTryImageButton.bringToFront();
        //-----------TO DO------------
        //UKRYTE MIEJSCE, GDZIE JAK SIE DOTKNIE MULTI-TOUCHEM, POWTARZANE JEST DOKLADNIE TAKIE SAMO CWICZENIE (BRAK JAKICHKOLWIEK ZMIAN USTAWIEN)

        ImageButton soundTubeImageButton = (ImageButton) this.findViewById(R.id.soundTubeImageButton);
        soundTubeImageButton.setOnClickListener(soundTubeClickListener);
        soundTubeImageButton.bringToFront();

        GameController gameController = GameApplication.getGameController();

        GameMode gameMode = gameController.getGameMode();
        gameMode.setPlanForNextExercise();
    }



    private void playApplause() {
        GameController gameController = GameApplication.getGameController();
        CorrectAnswerSoundModel correctAnswerSound = new CorrectAnswerSoundModel();
        correctAnswerSound.play(this, gameController.getCategoryToLearn());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_correct_answer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void exposeRightPhoto() {
        GameController gameController = GameApplication.getGameController();
        CategoryModel categoryToLearn = gameController.getCategoryToLearn();
        PhotoModel correctPhotoModel = categoryToLearn.getDisplayedPhoto();
        correctPhotoModel.setExposedImageView(this);
    }

    public void photoAnimation() {
        AnimationManager animationManager = new AnimationManager(this);
        Animation animation = animationManager.getRandomAnimation();
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                //buttonNext.setVisibility(View.VISIBLE);
            }
        });
        GameController gameController = GameApplication.getGameController();
        CategoryModel categoryToLearn = gameController.getCategoryToLearn();
        PhotoModel correctPhotoModel = categoryToLearn.getDisplayedPhoto();
        correctPhotoModel.getImageView().startAnimation(animation);
    }

    public View.OnClickListener soundTubeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            playApplause();
        }
    };

    public View.OnClickListener nextTryClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            Intent intent = new Intent(CorrectAnswerActivity.this,ExerciseActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    };
}
