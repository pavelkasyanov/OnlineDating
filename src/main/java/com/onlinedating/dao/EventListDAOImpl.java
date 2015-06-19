package com.onlinedating.dao;
import com.onlinedating.model.EventList;
import com.onlinedating.model.QuestionList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;

/**
 * Created by Aver on 17.06.2015.
 */
public class EventListDAOImpl implements EventListDAO {
    private SessionFactory sessionFactory;

    public EventListDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(EventList eventList) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        //����������� ��� ������� � ��������

        session.save(eventList);

        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public EventList get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        EventList eventList = (EventList)session.get(EventList.class,id);

        session.getTransaction().commit();

        return eventList;
    }
}
