package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.Question;
import com.onlinedating.model.QuestionList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionDAOImpl implements QuestionDAO {
    private SessionFactory sessionFactory;

    public QuestionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void Add(Question question) {
        //Session session = sessionFactoryopenSession();//
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();


    }

    @Override
    @Transactional
    public Question get_btID(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        Question question = (Question)session.get(Question.class,id);
        session.getTransaction().commit();



        return question;
    }

    @Override
    public void update(Question question, int id) {

        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();

        Question employee =
                (Question)session.get(Question.class, id);
        employee = question;
        session.update(employee);

        session.getTransaction().commit();



    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Question question =
                (Question)session.get(Question.class, id);
        session.delete(question);
        session.getTransaction().commit();



    }

    @Override
       @Transactional
       public List<Question> question_list() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List question = null;
        question = session.createQuery("FROM Question").list();
        for (Iterator iterator = question.iterator(); iterator.hasNext();){
            Question employee = (Question) iterator.next();
            System.out.print("Category Name: " + employee.getText());

        }
        session.getTransaction().commit();



        return question;
    }

    @Override
    @Transactional
    public List<Question> question_list_byCategory( Category category) {
        Session session = sessionFactory.getCurrentSession();

        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List cities = null;
        int  countryID = category.getCategoryID();
        cities = session.createQuery("FROM Question where Category_CategorID =" + countryID).list();
        session.getTransaction().commit();


        return cities;
    }


    public List<Question> Get_Question_list_byquestionList(QuestionList questionList)
    {
        Session session = sessionFactory.getCurrentSession();

        System.out.println("Maven + Hibernate + MySQL");
        session.beginTransaction();
        List cities = null;
       int  countryID = questionList.getQuestionListID();
        cities = session.createQuery("FROM Question where QuestionList_QuestionListID =" + countryID).list();
        session.getTransaction().commit();


        return cities;

    }
}
