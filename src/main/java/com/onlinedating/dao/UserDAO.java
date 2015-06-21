package com.onlinedating.dao;

import com.onlinedating.model.City;
import com.onlinedating.model.User;
import java.util.List;

public interface UserDAO {

    void Add( User user);
    User get_btID(int id);
    User get_byLogin(String login);
    void update ( User user, int id);
    List<User> list();
}
