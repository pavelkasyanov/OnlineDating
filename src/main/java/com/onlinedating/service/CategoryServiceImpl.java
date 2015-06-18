package com.onlinedating.service;

import com.onlinedating.dao.CategoryDAO;
import com.onlinedating.dao.CategoryDAOImpl;
import com.onlinedating.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Override
    public void Add(Category category) {
        categoryDAO.Add(category);
    }

    @Override
    public Category get_byID(int id) {
        return categoryDAO.get_byID(id);
    }

    @Override
    public Category get_byName(String name) {
        return  categoryDAO.get_byName(name);
    }

    @Override
    public List<Category> category_list() {
        return categoryDAO.category_list();
    }
}
