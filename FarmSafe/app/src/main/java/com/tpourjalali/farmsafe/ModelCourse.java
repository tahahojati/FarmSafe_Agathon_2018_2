package com.tpourjalali.farmsafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.tpourjalali.farmsafe.database.CourseBaseHelper;
import com.tpourjalali.farmsafe.database.CourseDbSchema;

/**
 * Created by mschultz on 1/13/2018.
 */

public class ModelCourse {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private ModelCourse(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CourseBaseHelper(mContext)
                .getWritableDatabase();
//        mCourses = new ArrayList<>();
    }

    private ContentValues getContentValues(Course c) {
        ContentValues values = new ContentValues();
        values.put(CourseDbSchema.CourseTable.Cols.LANGUAGE, c.getCourseLanguage());
        values.put(CourseDbSchema.CourseTable.Cols.COURSE_NAME, c.getCourseName());

        return values;
    }

    public void addCourse(Course c) {
        ContentValues values = getContentValues(c);

        mDatabase.insert(CourseDbSchema.CourseTable.NAME, null, values);
    }

    public void updateCourse(Course c) {
        String nameString = c.getCourseName();
        ContentValues values = getContentValues(c);

        mDatabase.update(CourseDbSchema.CourseTable.NAME, values,
                CourseDbSchema.CourseTable.Cols.COURSE_NAME + " = ?",
                new String[] { nameString });
    }
}
