package com.onlinedating.dao;

import com.onlinedating.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class CountryDAOImpl implements  ICountryDAO {
    private SessionFactory sessionFactory;

    public CountryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    @Override
    public void Add(Country country) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.save(country);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public Country get_btID(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = (Country)session.get(Country.class, id);

        session.getTransaction().commit();
        session.close();

        return country;
    }

    @Override
    @Transactional
    public List<Country> countryList() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List countries = null;
        countries = session.createQuery("FROM Country").list();

        session.getTransaction().commit();
        session.close();

        return countries;
    }
}
