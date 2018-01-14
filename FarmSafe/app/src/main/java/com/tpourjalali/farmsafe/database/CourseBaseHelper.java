package com.tpourjalali.farmsafe.database;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by mschultz on 1/13/2018.
 */

public class CourseBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "courseBase.db";

    public CourseBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
