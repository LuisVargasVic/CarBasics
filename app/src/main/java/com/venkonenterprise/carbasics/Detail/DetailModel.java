package com.venkonenterprise.carbasics.Detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by administrator on 4/10/18.
 */

public class DetailModel implements Serializable {
    private String name;
    private String imageModel;
    private HashMap<String, DetailBasic> basics;

    public DetailModel(){
        this.basics = new HashMap<String, DetailBasic>();
    }
    
    public DetailModel(String name, String imageModel, HashMap<String, DetailBasic> basics) {
        this();
        this.name = name;
        this.imageModel = imageModel;
        this.basics = basics;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageModel() {
        return imageModel;
    }
    public void setImageModel(String imageModel) {
        this.imageModel = imageModel;
    }
    public HashMap<String, DetailBasic> getBasics(){ return this.basics; }
    public ArrayList<DetailBasic> getBasicsList() {
        ArrayList<DetailBasic> basics = new ArrayList<DetailBasic>();
        for (DetailBasic p : this.basics.values()){
            basics.add(p);
        }
        return basics;

    }
    public void setBasicsList(HashMap<String, DetailBasic> basics) {
        this.basics = basics;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
