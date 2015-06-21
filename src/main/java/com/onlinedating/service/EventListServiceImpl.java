package com.onlinedating.service;

import com.onlinedating.dao.EventListDAO;
import com.onlinedating.dao.EventListDAOImpl;
import com.onlinedating.model.EventList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by Aver on 17.06.2015.
 */
public class EventListServiceImpl implements EventListService {

    @Autowired
    EventListDAO eventListDAO;

    @Override
    public void Add(EventList eventList) {

        eventListDAO.Add(eventList);
    }

    @Override
    public EventList get_btID(int id) {
       return eventListDAO.get_btID(id);
    }
}
