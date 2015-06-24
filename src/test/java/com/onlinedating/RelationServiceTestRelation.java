package com.onlinedating;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import com.onlinedating.service.CompatibilityMarks;
import com.onlinedating.service.NewUserService;
import org.junit.Test;

import static com.onlinedating.service.CompatibilityAnswers.*;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class RelationServiceTestRelation {
    static final String CONFIG_FILE_NAME = "configCompatibility.properties";
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    User userQuestionerPasha;
    User userReporterMasha;
    User userDaria;
    User userVasya;
    CompatibilityMarks cm = null;
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

        cm = new CompatibilityMarks();
        cm.loadProperties(CONFIG_FILE_NAME);
    }

    @Test
    public void testRelationOnlyThisUsers() {
        //given
        userService.userValue(userQuestionerPasha, q1, PRIORITY_IMPORTANT);
        userService.userValue(userQuestionerPasha, q2, PRIORITY_IMPORTANT);
        userService.userValue(userQuestionerPasha, q3, PRIORITY_UNIMPORTANT);

        userService.userValue(userDaria, q1, PRIORITY_UNIMPORTANT);
        userService.userValue(userDaria, q3, PRIORITY_IMPORTANT);

        userService.userValue(userVasya, q1, PRIORITY_UNIMPORTANT);

        //when
        // answer the question
        userService.userAnswer(userReporterMasha, q1, ANSWER_NO);

        //assertStress
        TestUtils.assertStress(userQuestionerPasha, cm.getImportantNoQuestioner(), userReporterMasha, cm.getImportantNoRespondent(), userService);
        TestUtils.assertStress(userVasya, 0, userDaria, 0, userService);
        TestUtils.assertStress(userVasya, cm.getUnimportantNoQuestioner(), userReporterMasha, cm.getUnimportantNoRespondent(), userService);
    }

    @Test
    public void testRelation2UsersSameQuestion() throws Exception {
        userService.userValue(userQuestionerPasha, q1, PRIORITY_IMPORTANT);
        userService.userValue(userQuestionerPasha, q2, PRIORITY_IMPORTANT);
        userService.userValue(userQuestionerPasha, q3, PRIORITY_UNIMPORTANT);

        userService.userValue(userVasya, q1, PRIORITY_UNIMPORTANT);
        userService.userValue(userVasya, q2, PRIORITY_UNIMPORTANT);
        userService.userValue(userVasya, q4, PRIORITY_IMPORTANT);


        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        //assertStress
        TestUtils.assertStress(userQuestionerPasha, cm.getImportantYesHeavilyQuestioner(), userReporterMasha, cm.getImportantYesHeavilyRespondent(), userService);
        TestUtils.assertStress(userVasya, cm.getUnimportantYesHeavilyQuestioner(), userReporterMasha, cm.getUnimportantYesHeavilyRespondent(), userService);
    }

    @Test
    public void test2Questions() throws Exception {
        userService.userValue(userQuestionerPasha, q1, PRIORITY_IMPORTANT);
        userService.userValue(userQuestionerPasha, q2, PRIORITY_IMPORTANT);

        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        userService.userAnswer(userReporterMasha, q2, ANSWER_NO);

        int expectedPasha = cm.getImportantYesHeavilyQuestioner() + cm.getImportantNoQuestioner();
        int expectedMasha = cm.getImportantYesHeavilyRespondent() + cm.getImportantNoRespondent();

        TestUtils.assertStress(userQuestionerPasha, expectedPasha, userReporterMasha, expectedMasha, userService);
    }

    @Test
    public void testAnswerBoth() throws Exception {
        userService.userValue(userQuestionerPasha, q1, PRIORITY_IMPORTANT);
        userService.userValue(userReporterMasha, q2, PRIORITY_IMPORTANT);

        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        userService.userAnswer(userQuestionerPasha, q2, ANSWER_NO);

        int expectedPasha = cm.getImportantYesHeavilyQuestioner() + cm.getImportantNoRespondent();
        int expectedMasha = cm.getImportantYesHeavilyRespondent() + cm.getImportantNoQuestioner();

        TestUtils.assertStress(userQuestionerPasha, expectedPasha, userReporterMasha, expectedMasha, userService);
    }

    @Test
    public void testRelationDouble() throws Exception {
        userService.userValue(userQuestionerPasha, q1, PRIORITY_IMPORTANT);
        userService.userAnswer(userReporterMasha, q1, ANSWER_YES_HEAVILY);
        userService.userValue(userQuestionerPasha, q2, PRIORITY_IMPORTANT);

        TestUtils.assertStress(userQuestionerPasha, cm.getImportantYesHeavilyQuestioner(), userReporterMasha, cm.getImportantYesHeavilyRespondent(), userService);

        userService.userAnswer(userReporterMasha, q2, ANSWER_NO);

        int expectedPasha = cm.getImportantYesHeavilyQuestioner() + cm.getImportantNoQuestioner();
        int expectedMasha = cm.getImportantYesHeavilyRespondent() + cm.getImportantNoRespondent();

        TestUtils.assertStress(userQuestionerPasha, expectedPasha, userReporterMasha, expectedMasha, userService);
    }

}//

