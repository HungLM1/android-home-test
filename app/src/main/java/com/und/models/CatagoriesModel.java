package com.und.models;

/**
 * Created by hungle on 01/03/2019.
 */

import java.util.ArrayList;


public class CatagoriesModel {



    private String headerTitle;
    private ArrayList<KeywordModel> allItemsInSection;


    public CatagoriesModel() {

    }
    public CatagoriesModel(String headerTitle, ArrayList<KeywordModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<KeywordModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<KeywordModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }
}
