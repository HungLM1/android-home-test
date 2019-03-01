package com.und.models;

/**
 * Created by hungle on 01/03/2019.
 */

import java.util.ArrayList;


public class CatagoriesModel {



    private String headerTitle;
    private ArrayList<KeyworkModel> allItemsInSection;


    public CatagoriesModel() {

    }
    public CatagoriesModel(String headerTitle, ArrayList<KeyworkModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<KeyworkModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<KeyworkModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }
}
