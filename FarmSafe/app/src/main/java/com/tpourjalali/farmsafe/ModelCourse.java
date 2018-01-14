package com.tpourjalali.farmsafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tpourjalali.farmsafe.database.CourseBaseHelper;
import com.tpourjalali.farmsafe.database.CourseDbSchema;

import java.util.ArrayList;

/**
 * Created by mschultz on 1/13/2018.
 */

public class ModelCourse {
//    private static
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private String courseLanguage;
    private String courseId;
    private String courseName;
//    private List<Course> mCourses;

//    public static ModelCourse get(Context context) {
//
//    }

    private ModelCourse(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CourseBaseHelper(mContext)
                .getWritableDatabase();
//        mCourses = new ArrayList<>();
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    private ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(CourseDbSchema.CourseTable.Cols.COURSE_ID, courseId);
        values.put(CourseDbSchema.CourseTable.Cols.LANGUAGE, courseLanguage);
        values.put(CourseDbSchema.CourseTable.Cols.COURSE_NAME, courseName);

        return values;
    }
}
