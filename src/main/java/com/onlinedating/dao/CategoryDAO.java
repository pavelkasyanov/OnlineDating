package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.City;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface CategoryDAO {
    void Add( Category category);
    Category get_byName(String name);
    Category get_byID(int id);

    List<Category> category_list ();
}
