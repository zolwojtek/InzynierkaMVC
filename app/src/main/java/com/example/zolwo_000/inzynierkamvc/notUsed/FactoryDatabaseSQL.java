package com.example.zolwo_000.inzynierkamvc.notUsed;


import android.database.sqlite.SQLiteDatabase;

import com.example.zolwo_000.inzynierkamvc.sqlCreate.SqlCategory;
import com.example.zolwo_000.inzynierkamvc.sqlCreate.SqlImage;

/**
 * Created by Chris on 10/24/2014.
 */
class FactoryDataBaseSQL {
    public FactoryDataBaseSQL(){

    }

    public void CreateDatabaseSQL(SQLiteDatabase db){

        try {
            db.execSQL(new SqlCategory().createSql());
            db.execSQL(new SqlImage().createSql());
//            db.execSQL(new CZ_AK().createSql());
//            db.execSQL(new Uzytkownik().createSql());
//            db.execSQL(new Plan().createSql());
//            db.execSQL(new Terminarz().createSql());
//            db.execSQL(new AK_PL().createSql());
//            db.execSQL(new UstawieniaUzytkownika().createSql());
//            db.execSQL(new UST_USER().createSql());
//            db.execSQL(new ChoosenUser().createSql());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void DropDatabaseSql(SQLiteDatabase db){

        try {
            db.execSQL(new SqlCategory().dropSql());
            db.execSQL(new SqlImage().dropSql());
//            db.execSQL(new CZ_AK().dropSql());
//            db.execSQL(new Uzytkownik().dropSql());
//            db.execSQL(new Plan().dropSql());
//            db.execSQL(new Terminarz().dropSql());
//            db.execSQL(new AK_PL().dropSql());
//            db.execSQL(new UstawieniaUzytkownika().dropSql());
//            db.execSQL(new UST_USER().dropSql());
//            db.execSQL(new ChoosenUser().dropSql());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}

