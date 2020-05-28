package com.example.gocars;

import android.graphics.Bitmap;

public class Model {
    private String imageName;
    private Bitmap image;
   private String classtype;
    private    String noOfdoors;
    private   String noOfseats;
    private   String drivingmode;
    private String coolingtype;
    private String expectedcost;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    public String getNoOfdoors() {
        return noOfdoors;
    }

    public void setNoOfdoors(String noOfdoors) {
        this.noOfdoors = noOfdoors;
    }

    public String getNoOfseats() {
        return noOfseats;
    }

    public void setNoOfseats(String noOfseats) {
        this.noOfseats = noOfseats;
    }

    public String getDrivingmode() {
        return drivingmode;
    }

    public void setDrivingmode(String drivingmode) {
        this.drivingmode = drivingmode;
    }

    public String getCoolingtype() {
        return coolingtype;
    }

    public void setCoolingtype(String coolingtype) {
        this.coolingtype = coolingtype;
    }

    public String getExpectedcost() {
        return expectedcost;
    }

    public void setExpectedcost(String expectedcost) {
        this.expectedcost = expectedcost;
    }

    public Model(String imageName, Bitmap image, String classtype, String noOfdoors, String noOfseats, String drivingmode, String coolingtype, String expectedcost, Integer id) {
        this.imageName = imageName;
        this.image = image;
        this.classtype = classtype;
        this.noOfdoors = noOfdoors;
        this.noOfseats = noOfseats;
        this.drivingmode = drivingmode;
        this.coolingtype = coolingtype;
        this.expectedcost = expectedcost;
        this.id = id;
    }
/* public Model(String imageName, Bitmap image, String classtype, String noOfdoors, String noOfseats, String drivingmode, String coolingtype, String expectedcost) {
        this.imageName = imageName;
        this.image = image;
        this.classtype = classtype;
        this.noOfdoors = noOfdoors;
        this.noOfseats = noOfseats;
        this.drivingmode = drivingmode;
        this.coolingtype = coolingtype;
        this.expectedcost = expectedcost;
    }*/


   /* public Model(String imageName, Bitmap image) {
        this.imageName = imageName;
        this.image = image;
    }



    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }*/


}
