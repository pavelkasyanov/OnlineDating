package com.onlinedating.service;

import com.onlinedating.dao.ICityDAO;
import com.onlinedating.model.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class CityServiceImpl implements CityService {
    @Autowired
    ICityDAO cityService;
    @Override
    public void Add(City country) {

        cityService.Add(country);
    }

    @Override
    public City get_btID(int id) {
        return cityService.get_btID(id);
    }

    @Override
    public List<City> CityList() {
        return cityService.CityList();
    }
}
