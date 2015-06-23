package com.onlinedating;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import org.junit.Test;

import java.util.Set;

import static com.onlinedating.model.CompatibilityAnswers.*;
import static com.onlinedating.model.CompatibilityMarks.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class RelationServiceTest {

    Question q;
    User userQuestioner;
    User userReporter;

    NewUserService userService;

    public RelationServiceTest() {
        q = TestUtils.createQuestion("Will you throw rubbish every day?");
        userService = new NewUserService();
        userQuestioner = TestUtils.createUserWithQuestion(userService);
        userReporter = TestUtils.createUserReporter(userService);
    }

    @Test
    public void testUserValue() {
        //when
        userService.userValue(userQuestioner, q, IMPORTANT);
        //then

        User userQuestUpdated = userService.getUser(userQuestioner);
        Set<Answer> answers = userQuestUpdated.getAnswers();
        assertEquals(1, answers.size());
    }

    @Test
    public void testAnswer() {
        //given
        userService.userValue(userQuestioner, q, IMPORTANT);

        //when
        // answer the question
        userService.userAnswer(userReporter, q, ANSWER_NO);
        //then

        User userReportUpdated = userService.getUser(userReporter);
        Set<Answer> answers = userReportUpdated.getAnswers();
        assertEquals(1, answers.size());
    }

    @Test
    public void testRelation() {
        //given
        userService.userValue(userQuestioner, q, IMPORTANT);

        //when
        // answer the question
        userService.userAnswer(userReporter, q, ANSWER_NO);

        //then
        //assertStress
        TestUtils.assertStress(userQuestioner, INSPECTED_IMPORTANT_NO, userReporter, WHOCHECKS_IMPORTANT_NO, userService);
    }

}

