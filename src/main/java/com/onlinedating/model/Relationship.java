package com.onlinedating.model;

import java.util.HashMap;
import java.util.Iterator;
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

    public void setStress(User user, int stress) {
        Integer integer = userStress.get(user);
        userStress.put(user, stress);
    }

    public void addStress(User user, int stress) {
        Integer integer = userStress.get(user);
        userStress.put(user, integer + stress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Relationship{");
        Iterator<User> iterator = userStress.keySet().iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            sb.append(next).append(" stress = ").append(userStress.get(next)).append(" ");
        }

        sb.append('}');
        return sb.toString();
    }
}
