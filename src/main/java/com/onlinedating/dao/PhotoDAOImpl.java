package com.onlinedating.dao;

import com.onlinedating.model.Photo;
import com.onlinedating.model.QuestionList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;

/**
 * Created by Aver on 18.06.2015.
 */
public class PhotoDAOImpl implements PhotoDAO {
    private SessionFactory sessionFactory;

    public PhotoDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void add(Photo photo) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        session.save(photo);

        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public Photo get_byID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Photo photo = (Photo)session.get(Photo.class,id);

        session.getTransaction().commit();
        // session.close();
        return photo;
    }
}
