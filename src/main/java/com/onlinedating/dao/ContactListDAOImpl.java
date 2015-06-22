package com.onlinedating.dao;

import com.onlinedating.model.ContactList;
import com.onlinedating.model.QuestionList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public class ContactListDAOImpl implements ContactListDAO {
    private SessionFactory sessionFactory;

    public ContactListDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(ContactList contactList) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        session.save(contactList);

        session.getTransaction().commit();

    }

    @Override
   @ Transactional
    public ContactList get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        ContactList contactList = (ContactList)session.get(ContactList.class,id);

        session.getTransaction().commit();
        // session.close();
        return contactList;
    }

    @Override
    @ Transactional
    public void test() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List contactList = null;
        contactList = session.createQuery("FROM ContactList").list();
        session.getTransaction().commit();

    }
}
