package com.onlinedating.service;

import com.onlinedating.model.Category;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface CategoryService {

    void Add( Category category);
    Category get_byID(int id);
    Category get_byName(String name);
    List<Category> category_list ();
}
