package com.example.zolwo_000.inzynierkamvc.Views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.GameUIBlocker;
import com.example.zolwo_000.inzynierkamvc.UIBlocker;
import com.example.zolwo_000.inzynierkamvc.utils.PhotoParameters;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.models.CategoryModel;
import com.example.zolwo_000.inzynierkamvc.models.GameModel;
import com.example.zolwo_000.inzynierkamvc.sounds.QuestionSound;
import com.example.zolwo_000.inzynierkamvc.models.PhotoModel;

public class ExerciseActivity extends Activity implements FView<GameModel> {

    QuestionSound askedQuestion;
    GameUIBlocker uiBlocker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        activity = this;

        //-----------TO DO------------
        //TRZEBA DODAC SPRAWDZENIE CZY BYL ZAPIS OSTATNIO CWICZONEJ KATEGORII
        start();
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void start() {
        GameController gameController = GameApplication.getGameController();
        drawGameInterface();// czy da sie to zrobic po odsluchaniu polecenia?? (nie bedzie miec jakich null-pointer references?)...jesli tak, to tak nalezy zrobic

        ImageButton soundTube = (ImageButton) activity.findViewById(R.id.buttonSoundTube);
        soundTube.setOnClickListener(soundTubeClickListener);

        //TYMCZASOWE//
        CategoryModel[] displayedCategories = gameController.getDisplayedCategories();
        for(int i = 0; i < displayedCategories.length; ++i) {
            displayedCategories[i].getDisplayedPhoto().getImageView().setVisibility(View.GONE);
            displayedCategories[i].getDisplayedPhoto().getFrameLayout().setBackgroundColor(Color.WHITE);
        }
        ////

        //-----------TO DO------------
        //ZABLOKUJ UI DOPOKI NIE SKONCZY POLECENIA
        uiBlocker = new GameUIBlocker();
        uiBlocker.blockUI(activity, true);
        soundTubeClickListener.onClick(soundTube);
        uiBlocker = null;



        //-----------TO DO------------
        //STARTTIMER POWINIEN CZYTAC PARAMETRY Z POZIOMU WYWOLANIA FUKCJI Z CONFIGURATIONMODEL SKLADOWANEGO W KONTROLERZE
        gameController.startTimer();
        gameController.setSuccessWithFirstTry(true);
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
        rows = initializeTableRows(tableLayout, rowCount);
        CategoryModel[] displayedCategories = gameController.getDisplayedCategories();

        initializePhotos(rowMargin, columnMargin, photoWidth, photoHeight, gameController, displayedCategories);
        setPhotosIntoTable(rows, rowCount, photosPerRow, displayedCategories);
    }

    private void setPhotosIntoTable(TableRow[] rows, int rowCount, int photosPerRow, CategoryModel[] displayedCategories) {
        int tmp = 0;
        for(int i = 0; i < rowCount; i++) {
            for (int j = 0; j < photosPerRow; j++) {
                PhotoModel photo = displayedCategories[tmp].getDisplayedPhoto();
                rows[i].addView(photo.getFrameLayout());
                tmp++;
            }
        }
    }

    private void initializePhotos(int rowMargin, int columnMargin, int photoWidth, int photoHeight, GameController gameController, CategoryModel[] displayedCategories) {
        PhotoParameters photoParameters = new PhotoParameters(photoWidth, photoHeight, rowMargin, columnMargin);
        for(int i = 0; i < displayedCategories.length; ++i) {
            PhotoModel photo = displayedCategories[i].getDisplayedPhoto();
            photo.setImageViewInTable(this);
            photo.setPhotoParameters(photoParameters);
            photo.setOnClickListener(wrongPhotoClickListener);
        }

        CategoryModel correctCategory = gameController.getCategoryToLearn();
        correctCategory.getDisplayedPhoto().setOnClickListener(rightPhotoClickListener);
        //askForAnswer(correctCategory.getName());
    }

    @NonNull
    private TableRow[] initializeTableRows(TableLayout tableLayout, int rowCount) {
        TableRow[] rows;
        rows = new TableRow[rowCount];
        for (int i = 0; i < rowCount; i++) {
            rows[i] = new TableRow(this);
            tableLayout.addView(rows[i]);
        }
        return rows;
    }

    Activity activity;
    public View.OnClickListener rightPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            //TextView exerciseDescription = (TextView) findViewById(R.id.questionTextView);
            //exerciseDescription.setText("dobrze");
            GameController gameController = GameApplication.getGameController();

            Intent intent = new Intent(ExerciseActivity.this, CorrectAnswerActivity.class);
            gameController.stopTimer();
            startActivity(intent);
        }
    };

   /* private void askForAnswer(String name) {
        TextView exerciseDescription = (TextView) findViewById(R.id.questionTextView);
        exerciseDescription.setText("Gdzie jest " + name + "?");
    }*/


    public View.OnClickListener wrongPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            TextView exerciseDescription = (TextView) findViewById(R.id.questionTextView);
            exerciseDescription.setText("zle");
            GameController gameController = GameApplication.getGameController();
            gameController.wrongAnswerChosen();

        }
    };

    public View.OnClickListener soundTubeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View clickedPhoto) {
            GameController gameController = GameApplication.getGameController();
            askedQuestion = new QuestionSound();
            askedQuestion.play(activity, gameController.getCategoryToLearn(), gameController.getLevel(), uiBlocker);
        }
    };
}
