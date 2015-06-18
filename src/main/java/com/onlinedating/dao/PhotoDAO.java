package com.onlinedating.dao;

import com.onlinedating.model.Photo;

/**
 * Created by Aver on 18.06.2015.
 */
public interface PhotoDAO {
    void add(Photo photo);
    Photo get_byID( int id);
}
