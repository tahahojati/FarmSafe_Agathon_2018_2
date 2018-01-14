package com.tpourjalali.farmsafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tpourjalali.farmsafe.database.CourseCursorWrapper;
import com.tpourjalali.farmsafe.database.CourseDbSchema.CourseTable;
import com.tpourjalali.farmsafe.database.DataBaseHelper;
import com.tpourjalali.farmsafe.database.TermCursorWrapper;
import com.tpourjalali.farmsafe.database.TermDbSchema;
import com.tpourjalali.farmsafe.database.TermDbSchema.TermTable;

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

    private ContentValues getContentValues(Term t) {
        ContentValues values = new ContentValues();
        values.put(TermTable.Cols.DEFINITION, t.getDefinition());
        values.put(TermTable.Cols.IMAGE_ID, t.getImageResourceId());
        values.put(TermTable.Cols.LANGUAGE, t.getLanguage().toString());
        values.put(TermTable.Cols.TERM, t.getTerm());
        values.put(TermTable.Cols.TERM_ID, t.getId());

        return values;
    }

    public void addTerm(Term t) {
        ContentValues values = getContentValues(t);

        mDatabase.insert(TermTable.NAME, null, values);
    }

    public void updateTerm(Term t) { //find term to update using term name as a nameString, but may want to use termId in the future
        String nameString = t.getTerm();
        ContentValues values = getContentValues(t);

        mDatabase.update(TermTable.NAME, values,
                TermTable.Cols.TERM + " = ?",
                new String[] { nameString });
    }

    private TermCursorWrapper queryTerms(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                TermTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new TermCursorWrapper(cursor);
    }

    public List<Term>getTerms() {
        List<Term> terms = new ArrayList<>();

        TermCursorWrapper cursor = queryTerms(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                terms.add(cursor.getTerm());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return terms;
    }

    public Term getTerm(String termName) {
        TermCursorWrapper cursor = queryTerms(
                TermTable.Cols.TERM + " = ?",
                new String[] { termName }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getTerm();
        } finally {
            cursor.close();
        }
    }
}
