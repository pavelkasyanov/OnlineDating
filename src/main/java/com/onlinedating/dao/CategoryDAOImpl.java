package com.onlinedating.dao;

import com.onlinedating.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();



        session.save(category);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    @Transactional
    public Category get_btID(int id) {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Category category = (Category)session.get(Category.class,id);

        session.getTransaction().commit();
        session.close();
        return category;
    }

    @Override
    @Transactional
    public List<Category> category_list() {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List category = null;
        category = session.createQuery("FROM Category").list();
        for (Iterator iterator = category.iterator(); iterator.hasNext();){
            Category employee = (Category) iterator.next();
            System.out.print("Category Name: " + employee.getCategory_Name());

        }
        session.getTransaction().commit();
        session.close();
        return category;
    }
}
