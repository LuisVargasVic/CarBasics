package com.venkonenterprise.carbasics.Detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by administrator on 4/10/18.
 */

public class DetailBrand implements Serializable {
    private String name;
    private String imageBrand;
    private HashMap<String, DetailModel> models;

    public DetailBrand(){
        this.models = new HashMap<String, DetailModel>();
    }

    public DetailBrand(String name, String imageBrand, HashMap<String, DetailModel> models) {
        this();
        this.name = name;
        this.imageBrand = imageBrand;
        this.models = models;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageBrand() {
        return imageBrand;
    }
    public void setImageBrand(String imageBrand) {
        this.imageBrand = imageBrand;
    }
    public HashMap<String, DetailModel> getModels(){ return this.models; }
    public ArrayList<DetailModel> getModelsList() {
        ArrayList<DetailModel> models = new ArrayList<DetailModel>();
        for (DetailModel p : this.models.values()){
            models.add(p);
        }
        return models;
    }
    public void setModelsList(HashMap<String, DetailModel> models) {
        this.models = models;
    }
    @Override
    public String toString() {
        return this.getName();
    }

}
