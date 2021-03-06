package com.example.zolwo_000.inzynierkamvc.Views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.zolwo_000.inzynierkamvc.CorrectAnswerUIBlocker;
import com.example.zolwo_000.inzynierkamvc.UIBlocker;
import com.example.zolwo_000.inzynierkamvc.managers.AnimationManager;
import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.gameModes.GameMode;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.sounds.CorrectAnswerSound;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

public class CorrectAnswerActivity extends Activity {

    private Activity activity = null;
    private ImageView iv;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector SGD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);

        iv=(ImageView)findViewById(R.id.correctPhotoImageView);
        SGD = new ScaleGestureDetector(this,new ScaleListener());

        activity = this;

        ImageButton nextTryImageButton = (ImageButton) activity.findViewById(R.id.nextTryImageButton);
        nextTryImageButton.setVisibility(View.GONE);

        exposeRightPhoto();
        photoAnimation();

        CorrectAnswerUIBlocker uiBlocker = new CorrectAnswerUIBlocker();
        uiBlocker.blockUI(activity, true);
        playApplause(uiBlocker);

        //-----------TO DO------------
        //ZABLOKOWAC UI DOPOKI NIE SKONCZY MOWIC

        //ImageButton nextTryImageButton = (ImageButton) activity.findViewById(R.id.nextTryImageButton);
        nextTryImageButton.setOnClickListener(nextTryClickListener);
        nextTryImageButton.bringToFront();
        //-----------TO DO------------
        //UKRYTE MIEJSCE, GDZIE JAK SIE DOTKNIE MULTI-TOUCHEM, POWTARZANE JEST DOKLADNIE TAKIE SAMO CWICZENIE (BRAK JAKICHKOLWIEK ZMIAN USTAWIEN)

        ImageButton soundTubeImageButton = (ImageButton) this.findViewById(R.id.soundTubeImageButton);
        soundTubeImageButton.setOnClickListener(soundTubeClickListener);
        soundTubeImageButton.bringToFront();

        final GameController gameController = GameApplication.getGameController();

        GameMode gameMode = gameController.getGameMode();
        gameMode.setPlanForNextExercise();


    }


    public boolean onTouchEvent(MotionEvent ev) {
        SGD.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.

            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            /*scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            matrix.setScale(scale, scale);
            iv.setImageMatrix(matrix);*/
            GameController gameController = GameApplication.getGameController();
            gameController.changeCategoryToLearn();
            return true;
        }
    }









    private void playApplause(UIBlocker uiBlocker) {
        GameController gameController = GameApplication.getGameController();
        CorrectAnswerSound correctAnswerSound = new CorrectAnswerSound();
        correctAnswerSound.play(this, gameController.getCategoryToLearn(), uiBlocker);
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
                ImageButton nextTryImageButton = (ImageButton) activity.findViewById(R.id.nextTryImageButton);
                nextTryImageButton.setVisibility(View.VISIBLE);
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
            playApplause(null);
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
