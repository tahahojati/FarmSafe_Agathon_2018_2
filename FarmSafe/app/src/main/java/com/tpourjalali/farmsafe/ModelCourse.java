package com.tpourjalali.farmsafe;

import android.content.ContentValues;

import com.tpourjalali.farmsafe.database.CourseDbSchema;

/**
 * Created by mschultz on 1/13/2018.
 */

public class ModelCourse {
    private ContentValues getContentValues(Course c) {
        ContentValues values = new ContentValues();
        values.put(CourseDbSchema.CourseTable.Cols.LANGUAGE, c.getCourseLanguage());
        values.put(CourseDbSchema.CourseTable.Cols.COURSE_NAME, c.getCourseName());

        return values;
    }

    public void addCourse(Course c) {
        ContentValues values = getContentValues(c);
    }
}
