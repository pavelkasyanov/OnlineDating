package com.onlinedating.dao;

import com.onlinedating.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class CityDAOImpl implements ICityDAO {

    private SessionFactory sessionFactory;

    public CityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public void Add(City city) {

        Session session =  sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public City get_btID(int id) {
        Session session = sessionFactory.openSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        City city = (City)session.get(City.class,id);

        session.getTransaction().commit();
        session.close();
        return city;
    }

    @Override
    @Transactional
    public List<City> CityList() {
        Session session = sessionFactory.openSession();

        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List cities = null;
        cities = session.createQuery("FROM City ").list();
        for (Iterator iterator = cities.iterator(); iterator.hasNext();){
            City employee = (City) iterator.next();
            System.out.print("Cuntry Name: " + employee.getCity_Name());

        }
        session.getTransaction().commit();
        session.close();
        return cities;
    }
}
