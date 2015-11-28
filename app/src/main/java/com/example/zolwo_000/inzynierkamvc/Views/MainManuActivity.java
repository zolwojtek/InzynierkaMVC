package com.example.zolwo_000.inzynierkamvc.Views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.PreferencesManager;
import com.example.zolwo_000.inzynierkamvc.models.ConfigurationModel;
import com.example.zolwo_000.inzynierkamvc.models.GameModel;

import java.io.File;

public class MainManuActivity extends Activity implements FView<GameModel> {

    //na razie tworze tutaj tablicę stringów lobalnie...bedzie ona reprezentowac czesci mowy, które maja byc dostepne do cwiczenia...docelowo, odczytane z bazy/pliku konfiguracyjnego
    private String[] partsOfSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manu);

        Context context = null;
        try {
             context = createPackageContext("com.example.klaudia.configapp", Context.CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String b = Environment.getExternalStorageDirectory().toString();
//        File file = new File(b+"/Android/"+"data/"+"InzynierkaPliki/"+"Dzwieki/"+"ser_m.mp3");
//        boolean c = file.exists();

        ////////////////Zczytywanie parametrów
        SharedPreferences prefs = context.getSharedPreferences("sharedPref", Context.MODE_WORLD_READABLE);
        ConfigurationModel config = new ConfigurationModel("noun");
        //ConfigurationModel verbConfig = new ConfigurationModel("verb");
        PreferencesManager storage = new PreferencesManager(prefs, config);
        storage.read();
        ////////////////////////

        //INITIALIZATION
        //ExerciseInitializeParameters exerciseParams = new ExerciseInitializeParameters();
        GameController gameController = GameApplication.getGameController();
        GameModel gameModel = GameApplication.getGameModel();
        gameModel.addView(this);
        gameModel.setActivity(this);
        gameModel.addCategories();
        gameController.initializeExercise(config);
        //END OF INITIALIZATION

        LinearLayout buttonsLayout = (LinearLayout) findViewById(R.id.buttonsLayout);
        buttonsLayout.setOrientation(LinearLayout.VERTICAL);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainManuActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        };

        //int numberOfButtons = partsOfSpeech.length;
        //for(int i = 0; i < numberOfButtons; i++) {
        ImageButton startButton = (ImageButton) findViewById(R.id.startButton);

            //Button button = new Button(getApplicationContext());
            //button.setBackgroundColor(Color.BLACK);
            //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            //layoutParams.setMargins(0, 0, 0, 20);
            //button.setText("Start");
            //button.setId(0);
            //buttonsLayout.addView(button, layoutParams);
            startButton.setOnClickListener(buttonListener);
        //}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_manu, menu);
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
}
