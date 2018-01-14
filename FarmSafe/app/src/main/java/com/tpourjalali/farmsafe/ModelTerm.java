package com.tpourjalali.farmsafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tpourjalali.farmsafe.database.CourseCursorWrapper;
import com.tpourjalali.farmsafe.database.CourseDbSchema.CourseTable;
import com.tpourjalali.farmsafe.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mschultz on 1/13/2018.
 */

public class ModelTerm {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private ModelTerm(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DataBaseHelper(mContext)
                .getWritableDatabase();
//        mCourses = new ArrayList<>();
    }

    private ContentValues getContentValues(Course c) {
        ContentValues values = new ContentValues();
        values.put(CourseTable.Cols.LANGUAGE, c.getCourseLanguage().toString());
        values.put(CourseTable.Cols.COURSE_NAME, c.getCourseName());

        return values;
    }

    public void addCourse(Course c) {
        ContentValues values = getContentValues(c);

        mDatabase.insert(CourseTable.NAME, null, values);
    }

    public void updateCourse(Course c) {
        String nameString = c.getCourseName();
        ContentValues values = getContentValues(c);

        mDatabase.update(CourseTable.NAME, values,
                CourseTable.Cols.COURSE_NAME + " = ?",
                new String[] { nameString });
    }

    private CourseCursorWrapper queryCourses(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CourseTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new CourseCursorWrapper(cursor);
    }

    public List<Course>getCourses() {
        List<Course> courses = new ArrayList<>();

        CourseCursorWrapper cursor = queryCourses(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                courses.add(cursor.getCourse());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return courses;
    }

    public Course getCourse(String courseName) {
        CourseCursorWrapper cursor = queryCourses(
                CourseTable.Cols.COURSE_NAME + " = ?",
                new String[] { courseName }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCourse();
        } finally {
            cursor.close();
        }
    }
}
