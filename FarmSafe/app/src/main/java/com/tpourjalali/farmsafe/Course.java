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

    public Course(String courseName) {
        mCourseName = courseName;
    }

    public String getCourseLanguage() {
        return mCourseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        mCourseLanguage = courseLanguage;
    }

    public String getCourseName() {
        return mCourseName;
    }

}
