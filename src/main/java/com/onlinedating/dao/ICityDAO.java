package com.onlinedating.dao;

import com.onlinedating.model.City;
import com.onlinedating.model.Country;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface ICityDAO {
    void Add( City country);
    City get_btID(int id);
    List<City> CityList();
}
