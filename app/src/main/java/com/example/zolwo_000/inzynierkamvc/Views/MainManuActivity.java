package com.example.zolwo_000.inzynierkamvc.Views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;
import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.managers.PreferencesManager;
import com.example.zolwo_000.inzynierkamvc.sounds.ConfigurationModel;
import com.example.zolwo_000.inzynierkamvc.models.GameModel;

public class MainManuActivity extends Activity implements FView<GameModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manu);
        GameController gameController = GameApplication.getGameController();
        GameModel gameModel = GameApplication.getGameModel();

        Context context;
        context = getTherapistContext();
        ConfigurationModel config = getConfigurationModel(context);

        gameModel.addView(this);
        gameModel.setActivity(this);
        gameModel.addCategories();
        gameController.initializeExercise(config);

        LinearLayout buttonsLayout = (LinearLayout) findViewById(R.id.buttonsLayout);
        buttonsLayout.setOrientation(LinearLayout.VERTICAL);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainManuActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        };

        ImageButton startButton = (ImageButton) findViewById(R.id.startButton);
        startButton.setOnClickListener(buttonListener);
    }

    @NonNull
    private ConfigurationModel getConfigurationModel(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("sharedPref", Context.MODE_WORLD_READABLE);
        ConfigurationModel config = new ConfigurationModel("noun");
        PreferencesManager storage = new PreferencesManager(prefs, config);
        storage.read();
        return config;
    }

    private Context getTherapistContext() {
        Context context = null;
        try {
             context = createPackageContext("com.example.klaudia.configapp", Context.CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return context;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //-----------TO DO------------
        //ZAPISYWANIE CWICZONEJ KATEGORII DLA TRYBU TERAPEUTY
    }
}
