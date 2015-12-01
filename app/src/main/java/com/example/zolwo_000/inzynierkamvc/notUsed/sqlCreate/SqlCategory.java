package com.example.zolwo_000.inzynierkamvc.notUsed.sqlCreate;

public final class SqlCategory extends BaseSQL{

    public static final String TABLE_NAME="KATEGORIA";
    public static final String NAZWA = "NAZWA";
    public static final String AUDIO1 = "AUDIO1";
    public static final String AUDIO2 = "AUDIO2";
    public static final String STAN = "STAN";

    public static final String[] CATEGORY_ALL_COLUMNS = {NAZWA,AUDIO1,AUDIO2,STAN};

    public String getTableName(){
        return TABLE_NAME;
    }

    @Override
    public String createSql() {

        return createTable(TABLE_NAME)
                .addField(NAZWA, TEXT_FIELD, PRIMARY_KEY)
                .addField(AUDIO1, TEXT_FIELD, NOT_NULL)
                .addField(AUDIO2, TEXT_FIELD, NOT_NULL)
                .addField(STAN, TEXT_FIELD, NOT_NULL)
                .finishCreateSql();
    }
}
