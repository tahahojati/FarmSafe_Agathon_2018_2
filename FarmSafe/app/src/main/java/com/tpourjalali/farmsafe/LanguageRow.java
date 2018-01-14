package com.tpourjalali.farmsafe;

/**
 * Created by micah on 1/13/18.
 */

public class LanguageRow {

    private String rowString;

    public LanguageRow(String s){
        setRowString(s);
    }
    public void setRowString(String s){
        rowString = s;
    }

    public String getRowString(){
        return rowString;
    }
}
