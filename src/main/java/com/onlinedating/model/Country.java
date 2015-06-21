package com.onlinedating.model;

import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public class Country implements java.io.Serializable {

    private int CountryID;
    private String Country_Name;
    private Set<City> citySet;

    public int getCountryID() {
        return CountryID;
    }
    public void setCountryID(int id) {
        this.CountryID = id;
    }

    public String getCountry_Name() {
        return Country_Name;
    }

    public void setCountry_Name(String country_Name) {
        this.Country_Name = country_Name;
    }


    public Set<City> getCitySet() {
        return citySet;
    }
    public void setCitySet(Set<City> items) {
        this.citySet = items;
    }

}
