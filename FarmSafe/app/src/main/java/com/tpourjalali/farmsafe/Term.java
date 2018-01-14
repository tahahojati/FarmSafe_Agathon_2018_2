package com.tpourjalali.farmsafe;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class Term {
    private int mId;
    private Language mLanguage;
    private String mTerm;
    private String mDefinition;
    private int mImageId;

    public Term(int id, Language language, String term, String definition, int imageId) {
        mId = id;
        mLanguage = language;
        mTerm = term;
        mDefinition = definition;
        mImageId = imageId;
    }

    public Term(int id) {
        mId = id;
    }

    public int getImageResourceId(){
        //TODO: implement
        return R.drawable.ic_dashboard_black_24dp;
    }
    //TODO: implement Constructors
    public int getId() {
        return mId;
    }

    public Language getLanguage() {
        return mLanguage;
    }

    public void setLanguage(Language language) {
         mLanguage = language;
    }

    public void setTermName(String termName) { mTerm = termName; }

    public void setDefinition(String definition) { mDefinition = definition; }

    public void setImageId(int imageId) { mImageId = imageId; }

    public String getTerm() {
        return mTerm;
    }

    public String getDefinition() {
        return mDefinition;
    }
}
