package com.onlinedating.model;

import com.onlinedating.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class Relationship {

    Map<User, Integer> userStress = new HashMap();

    public Relationship(User userWithQuestion, User userReporter) {
        userStress.put(userWithQuestion, 0);
        userStress.put(userReporter, 0);
    }

    public int getStress(User user) {
        Integer integer = userStress.get(user);
        return integer;
    }

    public void addStress(User user, int stress) {
        Integer integer = userStress.get(user);
        userStress.put(user, integer + stress);
    }

}
