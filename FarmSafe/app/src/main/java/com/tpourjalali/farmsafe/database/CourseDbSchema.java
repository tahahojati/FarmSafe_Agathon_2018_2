package com.tpourjalali.farmsafe.database;

/**
 * Created by mschultz on 1/13/2018.
 */

public class CourseDbSchema {
    public static final class CourseTable {
        public static final String NAME = "courses";

        public static final class Cols {
            public static final String COURSE_ID = "course_id";
            public static final String LANGUAGE = "language";
        }
    }
}
