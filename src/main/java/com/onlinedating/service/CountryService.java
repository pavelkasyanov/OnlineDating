package com.onlinedating.service;

import com.onlinedating.model.Country;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface CountryService {

    void Add( Country country);
    Country get_btID(int id);
    List<Country> countryList();
}
