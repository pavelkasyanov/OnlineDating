package com.onlinedating.service;

import com.onlinedating.dao.EventDAO;
import com.onlinedating.dao.EventDAOImpl;
import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;

    @Override
    public void Add(Event event) {

        eventDAO.Add(event);

    }


    @Override

    public Event get_btID(int id) {

        return eventDAO.get_btID(id);
    }



    @Override

    public void update(Event event, int id) {
        eventDAO.update(event, id);
    }

    @Override

    public void delete(int id) {
        eventDAO.delete(id);

    }

    @Override

    public List<Event> question_list() {
        return eventDAO.question_list();
    }
}
