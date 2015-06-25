package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.Event;
import com.onlinedating.model.Question;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface EventDAO {
    void Add( Event event);

    Event get_btID(int id);
    void update( Event event, int id);
    void delete (int id);

    List<Event> event_list();
}
