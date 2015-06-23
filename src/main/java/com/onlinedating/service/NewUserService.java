package com.onlinedating.service;

import com.onlinedating.model.Answer;
import com.onlinedating.model.Question;
import com.onlinedating.model.Relationship;
import com.onlinedating.model.User;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class NewUserService implements INewUserService {

    Map<String, User> users = new HashMap();
    HashMap<String, Relationship> relationshipMap = new HashMap();

    @Override
    public void registerUser(User user) {
        users.put(user.getUser_login(), user);
    }

    @Override
    public User getUser(User userQuestioner) {
        return users.get(userQuestioner.getUser_login());
    }

    @Override
    public void userValue(User userQuestioner, Question q, int important) {
        addAnswer(userQuestioner, q, new Answer(q, important));
    }

    @Override
    public void userAnswer(User userReporter, Question q, String answer) {
        addAnswer(userReporter, q, new Answer(q, answer));
    }

    private void addAnswer(User userQuestioner, Question q, Answer answer) {
        Set<Question> questions;
        if (userQuestioner.getQuestions() == null) {
            questions = new HashSet<Question>();
        } else {
            questions = userQuestioner.getQuestions();
        }
        questions.add(q);

        Set<Answer> answers;
        if (userQuestioner.getAnswers() == null) {
            answers = new HashSet<Answer>();
        } else {
            answers = userQuestioner.getAnswers();
        }

        answers.add(answer);

        User user = getUser(userQuestioner);
        user.setAnswers(answers);
        user.setQuestions(questions);

        //  updateRelationShips(user);
    }


    public Relationship getRelationship(User userWithQuestion, User userReporter) {
        Relationship relationship = getOrCreateRelationship(userWithQuestion, userReporter);

        CheckCompatibility cc = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/configCompatibility.properties");
            cc = new CheckCompatibility(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Set<Answer> answers1 = userWithQuestion.getAnswers();
        Set<Answer> answers2 = userReporter.getAnswers();
        for (Answer an1 : answers1) {
            for (Answer an2 : answers2) {
                Question question1 = an1.getQuestion();
                Question question2 = an2.getQuestion();
                if (question1.equals(question2)) {
                    cc.check(an1.getImportance(), an2.getAnswer());
                    relationship.addStress(userWithQuestion, cc.getValueQuestioner());
                    relationship.addStress(userReporter, cc.getValueRespondent());
                }
            }
        }


        return relationship;
    }

    private Relationship getOrCreateRelationship(User userWithQuestion, User userReporter) {
        String user_login1 = userWithQuestion.getUser_login();
        String user_login2 = userReporter.getUser_login();
        int compareTo = user_login1.compareTo(user_login2);
        String key;
        if (compareTo >= 0) {
            key = user_login1 + "_" + user_login2;
        } else {
            key = user_login2 + "_" + user_login1;
        }
        Relationship relationship = relationshipMap.get(key);
        if (relationship == null) {
            relationship = new Relationship(userWithQuestion, userReporter);
            relationshipMap.put(key, relationship);
        }

        return relationship;
    }

    private void updateRelationShips(User user) {

    }


}
