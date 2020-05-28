package com.example.gocars;

import android.graphics.Bitmap;

public class Model_Pojo {
    private String imageName;
    private Bitmap image;
    private    String noOfdoors;
    private   String noOfseats;
    private   String drivingmode;
    private String coolingtype;
    private String expectedcost;
    private Integer id;
    private String specification;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }



    public Model_Pojo(String imageName, Bitmap image, String noOfdoors, String noOfseats, String drivingmode, String coolingtype, String expectedcost, String specification) {
        this.imageName = imageName;
        this.image = image;

        this.noOfdoors = noOfdoors;
        this.noOfseats = noOfseats;
        this.drivingmode = drivingmode;
        this.coolingtype = coolingtype;
        this.expectedcost = expectedcost;
        this.id = id;
        this.specification = specification;
    }


}
