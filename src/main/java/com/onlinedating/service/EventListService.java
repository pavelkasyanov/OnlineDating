package com.onlinedating.service;

import com.onlinedating.model.EventList;

/**
 * Created by Aver on 17.06.2015.
 */
public interface EventListService {
    void Add(EventList eventList);
    EventList get_btID(int id);
}
