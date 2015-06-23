package com.onlinedating;

import com.onlinedating.model.Question;
import com.onlinedating.model.Relationship;
import com.onlinedating.model.User;
import com.onlinedating.service.NewUserService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artem.Zolotov on 6/22/2015.
 */
public class TestUtils {

    static Question createQuestion(String text) {
        Question question = new Question();
        question.setText(text);
        return question;
    }

    static  public User createUserReporter(NewUserService userService) {
        User user = createUser("masha", userService);
        return user;
    }

    static User createUserWithQuestion(NewUserService userService) {
        User user = createUser("pavlik", userService);
        return user;

    }

    static User createUser(String name, NewUserService userService) {
        User user = new User();
        user.setUser_Name(name);
        user.setUser_login(name);
        userService.registerUser(user);
        return user;
    }

    static void assertStress(User questioner, int expectedQuest, User reporter, int expectedReporter, NewUserService service) {
        Relationship rel = service.getRelationship(questioner, reporter);
        int stressQuestioner = rel.getStress(questioner);
        int stressReporter = rel.getStress(reporter);

        assertEquals(expectedQuest, stressQuestioner);
        assertEquals(expectedReporter, stressReporter);
    }
}
