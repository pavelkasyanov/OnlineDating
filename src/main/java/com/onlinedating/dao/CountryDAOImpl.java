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

         Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");

        session.save(country);

     /*   session.close();*/
    }

    @Override
    @Transactional
    public Country get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Country country = (Country)session.get(Country.class, id);

        session.getTransaction().commit();

        return country;
    }

    @Override
    @Transactional
    public List<Country> countryList() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");

        List countries = null;
        countries = session.createQuery("FROM Country").list();
        for (Iterator iterator = countries.iterator(); iterator.hasNext();){
            System.out.println("Object readed successfully.....!!");
            Country employee = (Country) iterator.next();
            System.out.print("Cuntry Name: " + employee.getCountry_Name());

        }


        return countries;
    }
}
