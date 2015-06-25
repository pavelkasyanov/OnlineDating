package com.onlinedating.dao;

import com.onlinedating.model.Event;
import com.onlinedating.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public class MessageDAOImpl implements MessageDAO {


    private SessionFactory sessionFactory;

    public MessageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(Message message) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public Message get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Message message = (Message)session.get(Message.class,id);
        session.getTransaction().commit();
        return message;
    }

    @Override
    @Transactional
    public void update(Message message, int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        Message employee =
                (Message)session.get(Message.class, id);
        employee = message;
        session.update(employee);

        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Message message =
                (Message)session.get(Message.class, id);
        session.delete(message);
        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public List<Message> message_list() {

        Session session = sessionFactory.getCurrentSession();

        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List message = null;
        message = session.createQuery("FROM Message").list();
        for (Iterator iterator = message.iterator(); iterator.hasNext();){
            Message employee = (Message) iterator.next();
            System.out.print("Category Name: " + employee.getText());

        }
        session.getTransaction().commit();

        return message;
    }
}
