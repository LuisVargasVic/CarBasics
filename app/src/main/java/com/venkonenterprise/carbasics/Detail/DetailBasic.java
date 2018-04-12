package com.venkonenterprise.carbasics.Detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by administrator on 4/11/18.
 */

public class DetailBasic implements Serializable {
    private String name;
    private String tutorial;
    private String video;

    public DetailBasic(){

    }

    public DetailBasic(String name, String tutorial, String video) {
        this();
        this.name = name;
        this.tutorial = tutorial;
        this.video = video;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTutorial() {
        return this.tutorial;
    }
    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
    public String getVideo() {
        return this.video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
