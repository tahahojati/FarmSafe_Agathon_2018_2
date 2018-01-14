package com.tpourjalali.farmsafe;

/**
 * Created by micah on 1/13/18.
 */

public class LanguageRow {

    private String rowString;
    private String localeString;

    public LanguageRow(String s, String l){
        setRowString(s);
        setLocaleString(l);
    }

    public void setRowString(String s){
        rowString = s;
    }

    public String getRowString(){
        return rowString;
    }

    public String getLocaleString() {
        return localeString;
    }

    public void setLocaleString(String localeString) {
        this.localeString = localeString;
    }
}
