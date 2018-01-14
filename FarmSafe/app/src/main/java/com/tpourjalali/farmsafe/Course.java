package com.tpourjalali.farmsafe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.tpourjalali.farmsafe.database.CourseBaseHelper;

/**
 * Created by mschultz on 1/13/2018.
 */

public class Course {
//    private static
    private String mCourseLanguage;
    private String mCourseName;
//    private List<Course> mCourses;

//    public static Course get(Context context) {
//
//    }



    public String getCourseLanguage() {
        return mCourseLanguage;
    }


    public String getCourseName() {
        return mCourseName;
    }

}
