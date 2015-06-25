package com.onlinedating.dao;

import com.onlinedating.model.ContactList;
import com.onlinedating.model.MessageList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public class MessageListDAOImpl implements MessageListDAO {
    private SessionFactory sessionFactory;

    public MessageListDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(MessageList messageList) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        session.save(messageList);

        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public MessageList get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        MessageList messageList = (MessageList)session.get(MessageList.class,id);

        session.getTransaction().commit();
        // session.close();
        return messageList;
    }

    @Override
    @Transactional
    public void test() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List messageList = null;
        messageList = session.createQuery("FROM MessageList").list();
        session.getTransaction().commit();

    }
}
