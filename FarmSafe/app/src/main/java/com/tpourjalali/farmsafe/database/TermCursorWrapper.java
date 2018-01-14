package com.tpourjalali.farmsafe.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.tpourjalali.farmsafe.Term;
import com.tpourjalali.farmsafe.Language;

/**
 * Created by mschultz on 1/13/2018.
 */

public class TermCursorWrapper extends CursorWrapper {
    public TermCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Term getTerm() {
        int termId = /*getString(*/getColumnIndex(TermDbSchema.TermTable.Cols.TERM_ID)/*)*/;
        Language language = Language.valueOf(getString(getColumnIndex(TermDbSchema.TermTable.Cols.LANGUAGE)));

        Term term = new Term(termId);
        term.setLanguage(language);

        return term;
    }
}
