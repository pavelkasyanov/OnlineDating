package com.onlinedating.service;

import com.onlinedating.model.Event;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface EventService {
    void Add(Event event);

    Event get_btID(int id);
    void update(Event event, int id);
    void delete(int id);

    List<Event> question_list();
}
