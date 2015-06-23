package com.onlinedating;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import org.junit.Test;

import static com.onlinedating.model.CompatibilityAnswers.*;
import static com.onlinedating.model.CompatibilityMarks.*;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class RelationServiceTestRelation {

    Question q1;
    Question q2;
    Question q3;
    Question q4;
    User userQuestionerPasha;
    User userReporterMasha;
    User userDaria;
    User userVasya;

    NewUserService userService;

    public RelationServiceTestRelation() {

        q1 = TestUtils.createQuestion("Will you throw rubbish every day?");
        q2 = TestUtils.createQuestion("Will you dance with me?");
        q3 = TestUtils.createQuestion("Will you stay long at work?");
        q4 = TestUtils.createQuestion("Will you visit my parents monthly?");
        userService = new NewUserService();

        userQuestionerPasha = TestUtils.createUserWithQuestion(userService);
        userReporterMasha = TestUtils.createUserReporter(userService);
        userVasya = TestUtils.createUser("Vasya", userService);
        userDaria = TestUtils.createUser("Daria", userService);
    }

    @Test
    public void testRelationOnlyThisUsers() {
        //given
        userService.userValue(userQuestionerPasha, q1, IMPORTANT);
        userService.userValue(userQuestionerPasha, q2, IMPORTANT);
        userService.userValue(userQuestionerPasha, q3, UNIMPORTANT);

        userService.userValue(userDaria, q1, UNIMPORTANT);
        userService.userValue(userDaria, q3, IMPORTANT);

        userService.userValue(userVasya, q1, UNIMPORTANT);

        //when
        // answer the question
        userService.userAnswer(userReporterMasha, q1, ANSWER_NO);

        //assertStress
        TestUtils.assertStress(userQuestionerPasha, INSPECTED_IMPORTANT_NO, userReporterMasha, WHOCHECKS_IMPORTANT_NO, userService);
        TestUtils.assertStress(userVasya, 0, userDaria, 0, userService);
        TestUtils.assertStress(userVasya, INSPECTED_NOTIMPORTANT_NO, userReporterMasha, WHOCHECKS_NOTIMPORTANT_NO, userService);
    }

    @Test
    public void testRelation2UsersSameQuestion() throws Exception {
        userService.userValue(userQuestionerPasha, q1, IMPORTANT);
        userService.userValue(userQuestionerPasha, q2, IMPORTANT);
        userService.userValue(userQuestionerPasha, q3, UNIMPORTANT);

        userService.userValue(userVasya, q1, UNIMPORTANT);
        userService.userValue(userVasya, q2, UNIMPORTANT);
        userService.userValue(userVasya, q4, IMPORTANT);


        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        //assertStress
        TestUtils.assertStress(userQuestionerPasha, INSPECTED_IMPORTANT_YES_HEAVY, userReporterMasha, WHOCHECKS_IMPORTANT_YES_HEAVY, userService);
        TestUtils.assertStress(userVasya, INSPECTED_NOTIMPORTANT_YES_HEAVY, userReporterMasha, WHOCHECKS_NOTIMPORTANT_YES_HEAVY, userService);
    }

    @Test
    public void test2Questions() throws Exception {
        userService.userValue(userQuestionerPasha, q1, IMPORTANT);
        userService.userValue(userQuestionerPasha, q2, IMPORTANT);

        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        userService.userAnswer(userReporterMasha, q2, ANSWER_NO);

        int expectedPashs = INSPECTED_IMPORTANT_YES_HEAVY + INSPECTED_IMPORTANT_NO;
        int expectedMasha = WHOCHECKS_IMPORTANT_YES_HEAVY + WHOCHECKS_IMPORTANT_NO;

        TestUtils.assertStress(userQuestionerPasha, expectedPashs, userReporterMasha, expectedMasha, userService);
    }

    @Test
    public void testAnswerBoth() throws Exception {
        userService.userValue(userQuestionerPasha, q1, IMPORTANT);
        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);

        userService.userValue(userReporterMasha, q2, IMPORTANT);
        userService.userAnswer(userQuestionerPasha, q2, ANSWER_NO);

        int expectedPashs = INSPECTED_IMPORTANT_YES_HEAVY + WHOCHECKS_IMPORTANT_NO;
        int expectedMasha = WHOCHECKS_IMPORTANT_YES_HEAVY + INSPECTED_IMPORTANT_NO;

        TestUtils.assertStress(userQuestionerPasha, expectedPashs, userReporterMasha, expectedMasha, userService);
    }

    @Test
    public void testRelationDouble() throws Exception {
        userService.userValue(userQuestionerPasha, q1, IMPORTANT);
        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        userService.userValue(userQuestionerPasha, q2, IMPORTANT);

        TestUtils.assertStress(userQuestionerPasha, INSPECTED_IMPORTANT_YES_HEAVY, userReporterMasha, WHOCHECKS_IMPORTANT_YES_HEAVY, userService);

        userService.userAnswer(userReporterMasha, q2, ANSWER_NO);

        int expectedPashs = INSPECTED_IMPORTANT_YES_HEAVY + INSPECTED_IMPORTANT_NO;
        int expectedMasha = WHOCHECKS_IMPORTANT_YES_HEAVY + WHOCHECKS_IMPORTANT_NO;

        TestUtils.assertStress(userQuestionerPasha, expectedPashs, userReporterMasha, expectedMasha, userService);
    }
}

