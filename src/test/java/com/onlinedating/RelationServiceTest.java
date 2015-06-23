package com.onlinedating;

import com.onlinedating.model.Answer;
import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import com.onlinedating.service.CheckCompatibility;
import com.onlinedating.service.CompatibilityMarks;
import com.onlinedating.service.NewUserService;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import static com.onlinedating.service.CompatibilityAnswers.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class RelationServiceTest {

    static final String CONFIG_FILE_NAME = "src/main/resources/configCompatibility.properties";
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
        userService.userValue(userQuestioner, q, PRIORITY_IMPORTANT);
        //then

        User userQuestUpdated = userService.getUser(userQuestioner);
        Set<Answer> answers = userQuestUpdated.getAnswers();
        assertEquals(1, answers.size());
    }

    @Test
    public void testAnswer() {
        //given
        userService.userValue(userQuestioner, q, PRIORITY_IMPORTANT);

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
        userService.userValue(userQuestioner, q, PRIORITY_IMPORTANT);

        //when
        // answer the question
        userService.userAnswer(userReporter, q, ANSWER_NO);

        //then
        //assertStress
        CompatibilityMarks cm = new CompatibilityMarks();
        cm.loadProperties(CONFIG_FILE_NAME);
        TestUtils.assertStress(userQuestioner, cm.getImportantNoQuestioner() , userReporter,cm.getImportantNoRespondent(), userService);
    }

}

