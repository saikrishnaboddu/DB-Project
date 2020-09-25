package com.example.demo;

public class RestaurantData
{
    private String restName;
    private String restLocation;
    private String restRating;

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestLocation() {
        return restLocation;
    }

    public void setRestLocation(String restLocation) {
        this.restLocation = restLocation;
    }

    public String getRestRating() {
        return restRating;
    }

    public void setRestRating(String restRating) {
        this.restRating = restRating;
    }

    public RestaurantData(String name,String Location,String rating)
    {
        this.restName=name;
        this.restLocation=Location;
        this.restRating=rating;
    }
}
