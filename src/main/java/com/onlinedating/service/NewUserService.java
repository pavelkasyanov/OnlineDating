package com.onlinedating.service;

import com.onlinedating.model.Answer;
import com.onlinedating.model.Question;
import com.onlinedating.model.Relationship;
import com.onlinedating.model.User;

import java.util.*;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class NewUserService implements INewUserService {

    Map<String, User> users = new HashMap();
    HashMap<String, Relationship> relationshipMap = new HashMap();
    private boolean isWeb;

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
        boolean newAnswer = true;
        // check if user valued or answered this question
        for (Answer next : answers) {
            if (next.getQuestion().equals(q)) {
                next.mergeAnswers(answer);
                newAnswer = false;
                break;
            }
        }
        if (newAnswer) {
            answers.add(answer);
        }

        User user = getUser(userQuestioner);
        user.setAnswers(answers);
        user.setQuestions(questions);

        //  updateRelationShips(user);
    }


    public Relationship getRelationship(User userWithQuestion, User userReporter) {
        Relationship relationship = getOrCreateRelationship(userWithQuestion, userReporter);

        Relationship relationshipInverse = new Relationship(userWithQuestion, userReporter);

        CheckCompatibility cc = getNewCheckCompatibility();
        CheckCompatibility ccInverse = getNewCheckCompatibility();
        System.out.println("-- Computing relationship --");
        Set<Answer> answers1 = userWithQuestion.getAnswers() != null ? userWithQuestion.getAnswers() : Collections.<Answer>emptySet();
        Set<Answer> answers2 = userReporter.getAnswers() != null ? userReporter.getAnswers() : Collections.<Answer>emptySet();

        for (Answer an1 : answers1) {
            for (Answer an2 : answers2) {
                System.out.println(an1);
                System.out.println(an2);

                Question question1 = an1.getQuestion();
                Question question2 = an2.getQuestion();
                if (question1.equals(question2)) {
                    checkingStress(userWithQuestion, an1, userReporter, an2, relationship, cc);
                    System.out.println("Direct:" + relationship);
                    //checking into other direction
                    checkingStress(userReporter, an2, userWithQuestion, an1, relationshipInverse, ccInverse);
                    System.out.println("Inverse:" + relationshipInverse);
                }
            }
        }
        relationship.addStress(userWithQuestion, relationshipInverse.getStress(userWithQuestion));
        relationship.addStress(userReporter, relationshipInverse.getStress(userReporter));

        System.out.println("final result = " + relationship);
        System.out.println("Computing relationship  ends ---- \n  ");

        return relationship;
    }

    private CheckCompatibility getNewCheckCompatibility() {
        return CheckCompatibility.getDefault(isWeb);
    }

    private void checkingStress(User userWithQuestion, Answer an1, User userReporter, Answer an2, Relationship relationship, CheckCompatibility cc) {
        cc.check(an1.getImportance(), an2.getAnswer());
        relationship.setStress(userWithQuestion, cc.getValueQuestioner());
        relationship.setStress(userReporter, cc.getValueRespondent());
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


    public void init() {
        System.out.println("RelationshipService init");
    }

    public void setIsWeb(boolean isWeb) {
        this.isWeb = isWeb;
    }


}
