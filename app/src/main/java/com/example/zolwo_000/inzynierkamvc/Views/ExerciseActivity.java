package com.example.zolwo_000.inzynierkamvc.Views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.ExerciseInitializeParameters;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.Hint;
import com.example.zolwo_000.inzynierkamvc.HintType;
import com.example.zolwo_000.inzynierkamvc.PhotoParameters;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.CorrectAnswerSoundModel;
import com.example.zolwo_000.inzynierkamvc.models.GameModel;
import com.example.zolwo_000.inzynierkamvc.models.Level2SoundModel;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

public class ExerciseActivity extends Activity implements FView<GameModel> {

    //static int a = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        activity = this;

        //Wczytujemy plik konfiguracyjny swoj(zapis) oraz aplikacji terapeuty
        //jesli nie bylo zapisu(pierwszy raz uruchamiana apka)
        start();

    }

    private void start() {
        GameController gameController = GameApplication.getGameController();
        //if(a==1)
        drawGameInterface();
        //++a;

        ImageButton soundTube = (ImageButton) activity.findViewById(R.id.buttonSoundTube);
        soundTube.setOnClickListener(soundTubeClickListener);
        soundTubeClickListener.onClick(soundTube);
        gameController.startTimer(5,10); // oczywiscie z ustawien...gameController bedzie to mogl czytac bezposrednio ze skladowanych ustawien, parametry nie beda potrzebne
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercise, menu);
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

    @Override
    public void update(GameModel model) {

    }


    private void drawGameInterface() {
        ImageButton soundTube = (ImageButton) this.findViewById(R.id.buttonSoundTube);

        Display display = this.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        TableLayout tableLayout = (TableLayout) this.findViewById(R.id.gameTableLayout);
        tableLayout.removeAllViews();
        TableRow[] rows;
        int rowCount = 0;
        int photosPerRow = 0;
        int rowMargin = 0;
        int columnMargin = 0;
        int photoWidth = 0;
        int photoHeight = 0;



        GameController gameController = GameApplication.getGameController();
        int displayedCategoriesNumber = gameController.getDisplayedCategoriesNumber();


        switch (displayedCategoriesNumber) {
            case 2:
                rowCount = 1;
                photosPerRow = 2;
                rowMargin = 20;
                columnMargin = 20;
                photoWidth = screenWidth/3;
                photoHeight = screenHeight/2;
                break;
            case 3:
                rowCount = 1;
                photosPerRow = 3;
                rowMargin = 20;
                columnMargin = 20;
                photoWidth = screenWidth/4;
                photoHeight = screenHeight/4;
                break;
            case 4:
                rowCount = 2;
                photosPerRow = 2;
                rowMargin = 20;
                columnMargin = 20;
                photoWidth = screenWidth/3;
                photoHeight = screenHeight/3;
                break;
            case 6:
                rowCount = 2;
                photosPerRow = 3;
                rowMargin = 20;
                columnMargin = 20;
                photoWidth = screenWidth/4;
                photoHeight = screenHeight/4;
                break;
        }
        PhotoParameters photoParameters = new PhotoParameters(photoWidth, photoHeight, rowMargin, columnMargin);
//        gameController.setPhotosParameters(photoParameters);



        rows = new TableRow[rowCount];
        for (int i = 0; i < rowCount; i++) {
            rows[i] = new TableRow(this);
            tableLayout.addView(rows[i]);
        }

        CategoryModel[] displayedCategories = gameController.getDisplayedCategories();

        for(int i = 0; i < displayedCategories.length; ++i) {
            PhotoModel photo = displayedCategories[i].getDisplayedPhoto();
            photo.setImageViewInTable(this);
            photo.setPhotoParameters(photoParameters);
            photo.setOnClickListener(wrongPhotoClickListener);
        }

        CategoryModel correctCategory = gameController.getCategoryToLearn();
        correctCategory.getDisplayedPhoto().setOnClickListener(rightPhotoClickListener);
        askForAnswer(correctCategory.getName());

        int tmp = 0;
        for(int i = 0; i < rowCount; i++) {
            for (int j = 0; j < photosPerRow; j++) {
                PhotoModel photo = displayedCategories[tmp].getDisplayedPhoto();
                rows[i].addView(photo.getFrameLayout());
                tmp++;
            }
        }



    }

    Activity activity;
    public View.OnClickListener rightPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            TextView exerciseDescription = (TextView) findViewById(R.id.questionTextView);
            exerciseDescription.setText("dobrze");
            GameController gameController = GameApplication.getGameController();


            Intent intent = new Intent(ExerciseActivity.this, CorrectAnswerActivity.class);
            gameController.stopTimer();
            startActivity(intent);
        }
    };

    private void askForAnswer(String name) {
        TextView excerciseDescription = (TextView) findViewById(R.id.questionTextView);
        excerciseDescription.setText("Gdzie jest " + name + "?");
    }


    public View.OnClickListener wrongPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
              TextView exerciseDescription = (TextView) findViewById(R.id.questionTextView);
              exerciseDescription.setText("zle");

        }
    };

    public View.OnClickListener soundTubeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            GameController gameController = GameApplication.getGameController();
            Level2SoundModel akedQestion = new Level2SoundModel();
            akedQestion.play(activity, gameController.getCategoryToLearn());
        }
    };


}
