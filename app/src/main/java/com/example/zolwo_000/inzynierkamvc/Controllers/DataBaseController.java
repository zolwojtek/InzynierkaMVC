package com.example.zolwo_000.inzynierkamvc.Controllers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ola on 2015-11-21.
 */
public class DataBaseController {
    String dataBasePath = "sdcard/InzynierkaPliki/db.s3db";
    SQLiteDatabase db;

    public void openDataBase() {
        db = SQLiteDatabase.openDatabase(dataBasePath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public void closeDataBase() {
        db.close();
    }

    public Cursor loadCategories() {
        String column[] = {"Nazwa"};
        return db.query("KATEGORIA", column, null, null, null, null, null, null);
    }

    public Cursor loadPhotosPath(String category) {
        String column[] = {"Grafika"};
        String where_clause = "Kategoria='"+category+"'";

        return db.query("OBRAZ", column, where_clause, null, null, null, null, null);
    }

    public Cursor loadAudioPath(String category) {
        String column[] = {"Audio1","Audio2"};
        String where_clause = "Nazwa='"+category+"'";

        return db.query("KATEGORIA", column, where_clause, null, null, null, null, null);
    }

}
