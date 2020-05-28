package com.example.gocars;

public class City_pojo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    private int id;
    private String cityname;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;
    public City_pojo(int id, String cityname,String location) {
        this.id = id;
        this.cityname = cityname;
        this.location=location;
    }


}
