package com.onlinedating.model;

import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public class City implements java.io.Serializable {
    private int CityID;
    private String City_Name;
    private Country country;
    private Set<User> userSet;

    public int getCityID() {
        return CityID;
    }
    public void setCityID(int id) {
        this.CityID = id;
    }
    public String getCity_Name() {
        return City_Name;
    }
    public void setCity_Name(String city_Name) {
        this.City_Name = city_Name;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public Set<User> getUserSet() {
        return userSet;
    }
    public void setUserSet(Set<User> items) {
        this.userSet = items;
    }

}