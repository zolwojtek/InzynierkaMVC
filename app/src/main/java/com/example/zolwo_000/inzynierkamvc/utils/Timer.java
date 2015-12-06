package com.example.zolwo_000.inzynierkamvc.utils;

import android.os.AsyncTask;

import com.example.zolwo_000.inzynierkamvc.GameApplication;
import com.example.zolwo_000.inzynierkamvc.Controllers.GameController;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class Timer extends AsyncTask<Integer, Void, Void> {

    @Override
    protected Void doInBackground(Integer... params) {
        try {
            Thread.sleep(params[0] * 1000);
            publishProgress();
            Thread.sleep(params[0] * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values){
        GameController gameController = GameApplication.getGameController();
        gameController.showHint();
    }

    @Override
    protected void onPostExecute(Void result) {
        this.cancel(true);
    }
}
