package com.tpourjalali.farmsafe;

import java.util.ArrayList;

/**
 * Created by mschultz on 1/13/2018.
 */

public class Course {
//    private static
    private Language mCourseLanguage;
    private String mCourseName;
    private int mId;
    private ArrayList<CourseSectionBase> mSections;

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public int getId() {
        return mId;
    }

    //    private List<Course> mCourses;

//    public static Course get(Context context) {
//
//    }

    public Course(String courseName) {
        mCourseName = courseName;
    }

    public Language getCourseLanguage() {
        return mCourseLanguage;
    }

    public void setCourseLanguage(Language courseLanguage) {
        mCourseLanguage = courseLanguage;
    }

    public String getCourseName() {
        return mCourseName;
    }

}
