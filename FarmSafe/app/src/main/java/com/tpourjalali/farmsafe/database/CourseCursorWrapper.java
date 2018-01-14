package com.tpourjalali.farmsafe.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.tpourjalali.farmsafe.Course;
import com.tpourjalali.farmsafe.Language;

/**
 * Created by mschultz on 1/13/2018.
 */

public class CourseCursorWrapper extends CursorWrapper {
    public CourseCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Course getCourse() {
        String courseName = getString(getColumnIndex(CourseDbSchema.CourseTable.Cols.COURSE_NAME));
        Language language = Language.valueOf(getString(getColumnIndex(CourseDbSchema.CourseTable.Cols.LANGUAGE)));

        Course course = new Course(courseName);
        course.setCourseLanguage(language);

        return course;
    }
}
