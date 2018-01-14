package com.tpourjalali.farmsafe;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class Term {
    private long mId;
    private Language mLanguage;
    private String mTerm;
    private String mDefinition;
    private int mImageId;

    public Term(long id, Language language, String term, String definition, int imageId) {
        mId = id;
        mLanguage = language;
        mTerm = term;
        mDefinition = definition;
        mImageId = imageId;
    }

    public int getImageResourceId(){
        //TODO: implement
        return R.drawable.ic_dashboard_black_24dp;
    }
    //TODO: implement Constructors
    public long getId() {
        return mId;
    }

    public Language getLanguage() {
        return mLanguage;
    }

    public String getTerm() {
        return mTerm;
    }

    public String getDefinition() {
        return mDefinition;
    }
}
