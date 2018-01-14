package com.tpourjalali.farmsafe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.tpourjalali.farmsafe.database.CourseBaseHelper;

/**
 * Created by mschultz on 1/13/2018.
 */

public class Course {
//    private static
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private String mCourseLanguage;
    private String mCourseId;
    private String mCourseName;
//    private List<Course> mCourses;

//    public static Course get(Context context) {
//
//    }

    private Course(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CourseBaseHelper(mContext)
                .getWritableDatabase();
//        mCourses = new ArrayList<>();
    }

    public String getCourseLanguage() {
        return mCourseLanguage;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public String getCourseName() {
        return mCourseName;
    }

}
