package com.onlinedating.dao;

import com.onlinedating.model.QuestionList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionListDAOImpl implements  QuestionListDAO{
    private SessionFactory sessionFactory;

    public QuestionListDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void Add(QuestionList questionList) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        session.save(questionList);

        session.getTransaction().commit();

    }

    @Override
    public QuestionList get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        QuestionList questionList = (QuestionList)session.get(QuestionList.class,id);

        session.getTransaction().commit();
       // session.close();
        return questionList;
    }

    @Override
    public void test() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List category = null;
        category = session.createQuery("FROM Category").list();
        session.getTransaction().commit();

    }
}
