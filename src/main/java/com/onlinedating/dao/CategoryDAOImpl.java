package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class CategoryDAOImpl implements  CategoryDAO {
    private SessionFactory sessionFactory;

    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public void Add(Category category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(category);

        session.getTransaction().commit();
        session.close();
    }


    @Override
    @Transactional
    public Category get_byID(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Category category = (Category)session.get(Category.class,id);

        session.getTransaction().commit();
        session.close();

        return category;
    }

    @Override
    @Transactional
    public Category get_byName(String category_name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Category category =
                (Category)session.createCriteria( Category.class ).
                        add(Restrictions.eq("Category_Name", category_name)).
                        uniqueResult();

        session.getTransaction().commit();
        session.close();
        return category;
    }

    @Override
    @Transactional
    public List<Category> category_list() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Category> category = session.createQuery("FROM Category").list();

        session.getTransaction().commit();
        session.close();

        return category;
    }
}
