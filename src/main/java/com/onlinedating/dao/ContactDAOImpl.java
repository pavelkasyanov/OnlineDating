package com.onlinedating.dao;

import com.onlinedating.model.Contacts;
import com.onlinedating.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public class ContactDAOImpl implements ContactDAO {
    private SessionFactory sessionFactory;

    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(Contacts contacts) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        session.save(contacts);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public Contacts get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Contacts contacts = (Contacts)session.get(Contacts.class,id);
        session.getTransaction().commit();
        return contacts;
    }

    @Override
    @Transactional
    public void update(Contacts contacts, int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        Contacts employee =
                (Contacts)session.get(Contacts.class, id);
        employee = contacts;
        session.update(employee);

        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Contacts contacts =
                (Contacts)session.get(Contacts.class, id);
        session.delete(contacts);
        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public List<Contacts> contacts_list() {
        Session session = sessionFactory.getCurrentSession();

        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List contacts = null;
        contacts = session.createQuery("FROM Contacts").list();
        for (Iterator iterator = contacts.iterator(); iterator.hasNext();){
            Contacts employee = (Contacts) iterator.next();
            System.out.print("Category Name: " + employee.getMyRelation());

        }
        session.getTransaction().commit();

        return contacts;
    }
}
