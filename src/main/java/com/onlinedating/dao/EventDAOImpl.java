package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.Event;
import com.onlinedating.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class EventDAOImpl implements EventDAO{

    private SessionFactory sessionFactory;

    public EventDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(Event event) {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    @Transactional
    public Event get_btID(int id) {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Event event = (Event)session.get(Event.class,id);
        session.getTransaction().commit();
        session.close();
        return event;
    }



    @Override
    @Transactional
    public void update(Event event, int id) {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        Event employee =
                (Event)session.get(Event.class, id);
        employee = event;
        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Event question =
                (Event)session.get(Event.class, id);
        session.delete(question);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public List<Event> question_list() {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List event = null;
        event = session.createQuery("FROM E ").list();
        for (Iterator iterator = event.iterator(); iterator.hasNext();){
            Event employee = (Event) iterator.next();
            System.out.print("Category Name: " + employee.getText());

        }
        session.getTransaction().commit();
        session.close();
        return event;
    }
}
