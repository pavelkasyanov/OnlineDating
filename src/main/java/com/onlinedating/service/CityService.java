package com.onlinedating.service;

import com.onlinedating.model.City;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface CityService {

    void Add( City country);
    City get_btID(int id);
    List<City> CityList();
}
