package com.venkonenterprise.carbasics.Detail;


/**
 * Created by administrator on 4/17/18.
 */

public class DetailInfo {
    private String mission;
    private String vision;

    public DetailInfo() {

    }
    public DetailInfo(String mission, String vision) {
        this.mission = mission;
        this.vision = vision;
    }

    public String getMission() {
        return mission;
    }
    public void setMission(String mission) {
        this.mission = mission;
    }
    public String getVision() {
        return vision;
    }
    public void setVision(String vision) {
        this.vision = vision;
    }
}
