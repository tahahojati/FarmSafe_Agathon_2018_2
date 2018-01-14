package com.tpourjalali.farmsafe.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by mschultz on 1/13/2018.
 */

public class CourseCursorWrapper extends CursorWrapper {
    public CourseCursorWrapper(Cursor cursor) {
        super(cursor);
    }
}
