package com.example.zolwo_000.inzynierkamvc.notUsed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

/**
 * Created by Klaudia on 2015-11-16.
 */

class DBAdapter2 {
//    private static final String DB_PATH = "/data/data/com.example.klaudia.configapp/databases/";
//    private static final String DB_NAME = "db.s3db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME =   "commments2.db";



//    private final Context context;
//
//    private DatabaseHelper DBHelper;
    private static SQLiteDatabase db;



    public static synchronized SQLiteDatabase getDb(){
        if(db==null){
            try {
                db = SQLiteDatabase.openOrCreateDatabase(Environment.getExternalStorageDirectory().toString().concat("/").concat(DATABASE_NAME), null);
                boolean b =db.isOpen();
                int v = db.getVersion();
                if(db.getVersion()!=DATABASE_VERSION){
                    onUpgrade(db,db.getVersion(),DATABASE_VERSION);
                    insertInitValues(db);
                    db.setVersion(DATABASE_VERSION);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return db;
        }else{
            return db;
        }
    }

    public DBAdapter2(Context context) {

    }

    //@Override
    public void onCreate(SQLiteDatabase database) {

        new FactoryDataBaseSQL().DropDatabaseSql(database);
        new FactoryDataBaseSQL().CreateDatabaseSQL(database);
        insertInitValues(database);
        this.db = database;

    }

    //@Override
    public static synchronized void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBAdapter2.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );

        new FactoryDataBaseSQL().DropDatabaseSql(db);
        new FactoryDataBaseSQL().CreateDatabaseSQL(db);
    }

    public static synchronized  void insertInitValues(SQLiteDatabase database) {



        //new InsertSqlFactory().execInsert(database);

        //przyklad aktywnosci o schemie csv
        /*CsvConverter csv = new CsvConverter(database);
        try {
             csv.open("IWRD_AKTYWNOSCI/CSV ACTIVITY/schemat.csv");
            csv.CreateSlides();
        } catch (Exception e) {
            Log.i("CSV_CONVERTER EXCEPTION", e.getMessage());
        }
*/

    }








//    public DBAdapter(Context ctx) {
//        this.context = ctx;
//        DBHelper = new DatabaseHelper(context);
//    }
//
//    public class DatabaseHelper extends SQLiteOpenHelper {
//
//        DatabaseHelper(Context context) {
//            super(context, DB_NAME, null, DATABASE_VERSION);
//            try {
//                createDB();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void createDB() throws IOException
//        {
//            boolean dbExist = checkDataBase();
//
//            if(dbExist)
//            {}
//            else{
//                this.getWritableDatabase();
//                try {
//                    copyDataBase();
//                } catch (IOException e) {
//                    throw new Error("Error copying database");
//                }
//            }
//        }
//
//        private boolean checkDataBase()
//        {
//            SQLiteDatabase checkDB = null;
//            try
//            {
//                String myPath = DB_PATH + DB_NAME;
//                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
//            }catch(SQLiteException e)
//            {}
//            if(checkDB != null)
//            {
//                checkDB.close();
//            }
//            return checkDB != null ? true : false;
//        }
//
//        private void copyDataBase() throws IOException
//        {
//            //Open your local db as the input stream
//            InputStream myInput = context.getAssets().open(DB_NAME);
//
//            // Path to the just created empty db
//            String outFileName = DB_PATH + DB_NAME;
//
//            //Open the empty db as the output stream
//            OutputStream myOutput = new FileOutputStream(outFileName);
//
//            //transfer bytes from the inputfile to the outputfile
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = myInput.read(buffer))>0)
//            {
//                myOutput.write(buffer, 0, length);
//            }
//            //Close the streams
//            myOutput.flush();
//            myOutput.close();
//            myInput.close();
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase db){
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        }
//    }
//
//    public DBAdapter open() throws SQLException {
//        db = DBHelper.getWritableDatabase();
//        return this;
//    }
//
//    public void openDB() {
//        db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
//    }
//
//    public void close() {
//        DBHelper.close();
//    }
//
//    public List<CategoryModel> getCategories() {
//        List<CategoryModel> categories = new LinkedList<CategoryModel>();
//        String columns[] = {"Nazwa", "Stan", "Audio1", "Audio2"};
//        Cursor cursor = db.query("KATEGORIA", columns, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            CategoryModel cat = new CategoryModel();
//            cat.setName(cursor.getString(0));
//            cat.setStatus(cursor.getString(1));
//            cat.setAudio1(cursor.getString(2));
//            cat.setAudio2(cursor.getString(3));
//            categories.add(cat);
//        }
//        return categories;
//    }
//
//    public void addCategory(CategoryModel category) {
//        ContentValues values = new ContentValues();
//        values.put("nazwa", category.getName());
//        values.put("stan", category.getStatus());
//        values.put("audio1", category.getAudio1());
//        values.put("audio2", category.getAudio2());
//        db.insertOrThrow("KATEGORIA", null, values);
//    }
//
//    public void addChild(Child child) {
//        ContentValues values = new ContentValues();
//        values.put("zbior", child.getSet());
//        values.put("kategoria", child.getCategory());
//        values.put("grafika", child.getImage());
//        db.insertOrThrow("OBRAZ", null, values);
//    }
//
//    public List<Child> getChildrenFromCategory(String category) {
//        List<Child> children = new LinkedList<Child>();
//        Cursor cursor = db.rawQuery("select id, zbior, kategoria, grafika from OBRAZ where kategoria='" + category + "'", null);
//        while (cursor.moveToNext()) {
//            Child child = new Child();
//            child.setId(cursor.getInt(0));
//            child.setSet(cursor.getString(1));
//            child.setCategory(cursor.getString(2));
//            child.setImage(cursor.getString(3));
//            children.add(child);
//        }
//        return children;
//    }
//
//    public Child getChild(String id) {
//        Child child = new Child();
//        Cursor cursor = db.rawQuery("select id, zbior, kategoria, grafika from OBRAZ where id='" + id + "'", null);
//        cursor.moveToNext();
//        child.setId(cursor.getInt(0));
//        child.setSet(cursor.getString(1));
//        child.setCategory(cursor.getString(2));
//        child.setImage(cursor.getString(3));
//        return child;
//    }
//
//    public CategoryModel getCategory(String category) {
//        CategoryModel cat = new CategoryModel();
//        Cursor cursor = db.rawQuery("select nazwa, stan, audio1, audio2 from KATEGORIA where nazwa='" + category + "'", null);
//        cursor.moveToNext();
//        cat.setName(cursor.getString(0));
//        cat.setStatus(cursor.getString(1));
//        cat.setAudio1(cursor.getString(2));
//        cat.setAudio2(cursor.getString(3));
//        return cat;
//    }
//
//    public void deleteCategory(String name) {
//        String[] columns = {name};
//        db.delete("KATEGORIA", "nazwa=?", columns);
//    }
//
//    public void deleteChild(String id) {
//        String[] columns = {id};
//        db.delete("OBRAZ", "id=?", columns);
//    }
//
//    public void editCategory(CategoryModel category) {
//        ContentValues values = new ContentValues();
//        values.put("stan", category.getStatus());
//        values.put("audio1", category.getAudio1());
//        values.put("audio2", category.getAudio2());
//        String key[] = {category.getName()};
//        db.update("KATEGORIA", values, "nazwa=?", key);
//    }
//
//    public void editChild(Child child) {
//        ContentValues values = new ContentValues();
//        values.put("zbior", child.getSet());
//        values.put("kategoria", child.getCategory());
//        values.put("grafika", child.getImage());
//        String key[] = {""+child.getId()};
//        db.update("OBRAZ", values, "id=?", key);
//    }
}
