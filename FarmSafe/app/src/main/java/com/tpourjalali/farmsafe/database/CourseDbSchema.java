package com.tpourjalali.farmsafe.database;

/**
 * Created by mschultz on 1/13/2018.
 */

public class CourseDbSchema {
    public static final class CourseTable {
        public static final String NAME = "courses";

        public static final class Cols {
            public static final String COURSE_ID = "_id";
            public static final String LANGUAGE = "language";
            public static final String COURSE_NAME = "course_name";
            public static final String SECTIONS = "sections";
//            public static final String IMAGE_ID = "image_id";
        }
    }
}
