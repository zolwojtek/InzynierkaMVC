package com.example.zolwo_000.inzynierkamvc.sqlCreate;

/**
 * Created by zolwo_000 on 28.11.2015.
 */
public class SqlImage extends BaseSQL {

    public static final String TABLE_NAME="OBRAZ";
    public static final String NAZWA = "NAZWA";
    public static final String GRAFIKA = "GRAFIKA";
    public static final String ZBIOR = "ZBIOR";
    public static final String KATEGORIA = "KATEGORIA";

    public static final String[] IMAGE_ALL_COLUMNS = {NAZWA,GRAFIKA,ZBIOR,KATEGORIA};

    public String getTableName(){
        return TABLE_NAME;
    }

    @Override
    public String createSql() {

        return createTable(TABLE_NAME)
                .addField(NAZWA, TEXT_FIELD, PRIMARY_KEY)
                .addField(GRAFIKA, TEXT_FIELD, NOT_NULL)
                .addField(ZBIOR, TEXT_FIELD, NOT_NULL)
                .addField(KATEGORIA, TEXT_FIELD, REFERENCES(SqlCategory.TABLE_NAME,SqlCategory.NAZWA), NOT_NULL)
                .finishCreateSql();
    }
}
