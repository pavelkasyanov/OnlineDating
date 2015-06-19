package com.onlinedating.service;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pavlik on 19.06.2015.
 */
public class UserServiceImplND implements UserService {
    @Override
    public User get(int id) {
        return getUserPavlik();
    }

    @Override
    public User get(String login) {
        if ("pavlik".equals(login)) {
            return getUserPavlik();
        } else {
            return getUserOther();
        }
    }


    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user, int id) {

    }

    public List<User> getList() {
        List<User> a = new ArrayList<User>();

        a.add(getUserPavlik());

        a.add(getUserOther());

        return a;
    }

    @Override
    public Set<Question> getQuestions(User user) {
        String user_login = user.getUser_login();
        System.out.println(user_login);
        if ("pavlik".equals(user_login)) {
            return getQuestions();
        } else {
            return getQuestions2();
        }
    }

    private Set<Question> getQuestions() {
        Set<Question> set = new HashSet<Question>();

        Question q;
        q = new Question();
        q.setText("ask_1");
        set.add(q);

        q = new Question();
        q.setText("ask_2");
        set.add(q);

        q = new Question();
        q.setText("ask_3");
        set.add(q);

        q = new Question();
        q.setText("ask_4");
        set.add(q);

        return set;
    }

    public Set<Question> getQuestions2() {
        Set<Question> set = new HashSet<Question>();

        Question q;
        q = new Question();
        q.setText("ask_1_1");
        set.add(q);

        q = new Question();
        q.setText("ask_2_2");
        set.add(q);

        q = new Question();
        q.setText("ask_3_3");
        set.add(q);

        q = new Question();
        q.setText("ask_4_4");
        set.add(q);


        q = new Question();
        q.setText("ask_5_5");
        set.add(q);

        return set;
    }

    private User getUserOther() {
        User user = new User();
        user.setUser_Name("vlad");
        user.setSex("man");
        user.setUser_login("vlad");
        return user;
    }

    private User getUserPavlik() {
        User user = new User();
        user.setUser_Name("pavlik");
        user.setUser_login("pavlik");
        user.setSex("man");
        return user;
    }
}
