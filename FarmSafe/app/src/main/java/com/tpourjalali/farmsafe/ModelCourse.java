package com.tpourjalali.farmsafe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tpourjalali.farmsafe.database.CourseBaseHelper;

import java.util.ArrayList;

/**
 * Created by mschultz on 1/13/2018.
 */

public class ModelCourse {
//    private static
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private List<Course> mCourses;

    private ModelCourse(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CourseBaseHelper(mContext)
                .getWritableDatabase();
//        mCourses = new ArrayList<>();
    }
}
