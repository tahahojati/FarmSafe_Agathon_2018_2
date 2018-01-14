package com.tpourjalali.farmsafe.database;

/**
 * Created by mschultz on 1/13/2018.
 */

public class TermDbSchema {
    public static final class TermTable {
        public static final String NAME = "terms";

        public static final class Cols {
            public static final String TERM_ID = "_id";
            public static final String LANGUAGE = "language";
            public static final String TERM = "term";
            public static final String DEFINITION = "definition";
            public static final String IMAGE_ID = "image_id";
        }
    }
}
