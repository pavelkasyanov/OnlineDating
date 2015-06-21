package com.onlinedating.dao;

import com.onlinedating.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public User get_btID(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = (User)session.get(User.class,id);

        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    @Transactional
    public User get_byLogin(String login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user =
                (User)session.createCriteria( User.class ).
                        add(Restrictions.eq("User_login", login)).
                        uniqueResult();

        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    @Transactional
    public void update(User user , int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User employee = (User)session.get(User.class, id);
        employee = user;
        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> listUser = (List<User>) session
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        session.getTransaction().commit();
        session.close();

        return listUser;
    }
}
