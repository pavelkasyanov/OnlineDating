package com.onlinedating.dao;

import com.onlinedating.model.Country;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface ICountryDAO {
    void Add( Country country);
    Country get_btID(int id);
    List<Country> countryList();
}
