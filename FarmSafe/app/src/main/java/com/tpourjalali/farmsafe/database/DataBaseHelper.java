package com.tpourjalali.farmsafe.database;

import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import com.tpourjalali.farmsafe.Course;
import com.tpourjalali.farmsafe.database.CourseDbSchema.CourseTable;
import com.tpourjalali.farmsafe.database.TermDbSchema.TermTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by mschultz on 1/13/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "FarmSafe.db";
    private static final String TAG = "DataBaseHelper";
    private static final String SQL_SEED_FILE = "database-seed.sql";
    private AssetManager mAssetManager;
    private SQLiteDatabase mDb;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        mAssetManager = context.getAssets();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mDb = db;
        db.execSQL("create table " + CourseTable.NAME + "(" +
            CourseTable.Cols.COURSE_ID + " integer primary key autoincrement, " +
            CourseTable.Cols.COURSE_NAME + ", " +
            CourseTable.Cols.LANGUAGE + ", " +
                CourseTable.Cols.SECTIONS + " blob"+
            ");"
        );

        db.execSQL("create table " + TermTable.NAME + "(" +
                TermTable.Cols.TERM_ID + " integer primary key autoincrement, " +
                TermTable.Cols.TERM + ", " +
                TermTable.Cols.LANGUAGE + ", " +
                TermTable.Cols.DEFINITION + ", " +
                TermTable.Cols.IMAGE_ID +
                ")"
        );
        Log.i(TAG, "Database tables created ");

        seedDatabase();
    }

    public void seedDatabase(){
        try {
            InputStream is = mAssetManager.open(SQL_SEED_FILE);
            //BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            Scanner scanner = new Scanner(is);
            scanner.useDelimiter(";");
            String sqlCommand = null;
            while(scanner.hasNext()){
                sqlCommand = scanner.next() + "; ";
                mDb.execSQL(sqlCommand);
            }
        } catch (IOException e) {
            Log.e(TAG, "could not open seed file ", e);
        }
        Cursor cursor = mDb.query(CourseTable.NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        cursor.moveToFirst();
        Log.i(TAG, cursor.getString(cursor.getColumnIndex(CourseTable.Cols.COURSE_NAME)));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
