package com.onlinedating.dao;

import com.onlinedating.model.Event;
import com.onlinedating.model.EventList;
import com.onlinedating.model.QuestionList;

/**
 * Created by Aver on 17.06.2015.
 */
public interface EventListDAO {
    void Add( EventList eventList);
    EventList get_btID(int id);
}
