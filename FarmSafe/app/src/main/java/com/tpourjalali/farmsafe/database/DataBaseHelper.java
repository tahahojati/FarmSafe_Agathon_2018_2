package com.tpourjalali.farmsafe.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.tpourjalali.farmsafe.Course;
import com.tpourjalali.farmsafe.database.CourseDbSchema.CourseTable;
import com.tpourjalali.farmsafe.database.TermDbSchema.TermTable;

/**
 * Created by mschultz on 1/13/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "FarmSafe.db";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CourseTable.NAME + "(" +
            CourseTable.Cols.COURSE_ID + " integer primary key autoincrement, " +
            CourseTable.Cols.COURSE_NAME + ", " +
            CourseTable.Cols.LANGUAGE + ", " +
                CourseTable.Cols.SECTIONS + " blob"+
            ")"
        );

        db.execSQL("create table " + TermTable.NAME + "(" +
                TermTable.Cols.TERM_ID + " integer primary key autoincrement, " +
                TermTable.Cols.TERM + ", " +
                TermTable.Cols.LANGUAGE + ", " +
                TermTable.Cols.DEFINITION + ", " +
                TermTable.Cols.IMAGE_ID +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
