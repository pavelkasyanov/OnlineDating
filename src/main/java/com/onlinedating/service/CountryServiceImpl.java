package com.onlinedating.service;

import com.onlinedating.dao.CategoryDAO;
import com.onlinedating.dao.CountryDAOImpl;
import com.onlinedating.dao.ICountryDAO;
import com.onlinedating.model.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class CountryServiceImpl implements  CountryService{
    @Autowired
    ICountryDAO countryDAO;

    @Override
    public void Add(Country country) {
        countryDAO.Add(country);
    }

    @Override
    public Country get_btID(int id) {
        return countryDAO.get_btID(id);
    }

    @Override
    public List<Country> countryList() {
        return countryDAO.countryList();
    }
}
