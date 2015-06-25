package com.onlinedating.service;

import com.onlinedating.model.*;
import com.onlinedating.model.mvc.AskRow;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by pavlik on 19.06.2015.
 */
public class UserServiceImplND implements UserService {

    List<User> users;

    @Autowired
    QuestionService questionService;

    @Autowired
    NewUserService relationService;

    @Override
    public void init() {
        System.out.println("UserService init");
        users = new ArrayList<User>();

        User userPavlik = createUserPavlik();
        Set<Question> questionsPavlik = createQuestionsPavlik();
        questionService.addQuestions(questionsPavlik);
        userPavlik.setQuestions(questionsPavlik);
        users.add(userPavlik);

        User userOther = createUserOther();
        Set<Question> questions2 = createQuestions2();
        questionService.addQuestions(questions2);
        userOther.setQuestions(questions2);
        users.add(userOther);

        User user3 = createUser3("aver");
        users.add(user3);

        User user4 = createUser3("kirill");
        users.add(user4);

        relationService.registerUser(userPavlik);
        relationService.registerUser(userOther);
        relationService.registerUser(user3);
        relationService.registerUser(user4);

        // value 1 question
        relationService.userValue(userPavlik, questionsPavlik.iterator().next(), CompatibilityAnswers.PRIORITY_IMPORTANT);

        questionService.setUserService(this);
    }

    @Override
    public User get(int id) {
        return createUserPavlik();
    }

    @Override
    public User get(String login) {
        for (User user : users) {
            if (login.equals(user.getUser_login())) {
                return user;
            }
        }
        return users.get(users.size() - 1);
    }


    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user, int id) {

    }

    public List<User> getList() {
        return users;
    }

    @Override
    @Deprecated
    public Set<Question> getQuestions(User user) {
        String user_login = user.getUser_login();
        System.out.println(user_login);
        if ("pavlik".equals(user_login)) {
            return createQuestionsPavlik();
        } else {
            return createQuestions2();
        }
    }

    @Override
    @Deprecated
    /**
     * @deprecated use QuestionService#getAnswers
     */
    public Set<AskRow> getAnswers(User user) {
        Set<AskRow> o = new HashSet<AskRow>();
        Set<Question> questions = getQuestions(user);
        int count = 0;
        for (Iterator<Question> iterator = questions.iterator(); iterator.hasNext(); ) {
            Question next = iterator.next();
            AskRow askRow = new AskRow(next);
            // mark every 2/3 answer with imp
            if (count % 3 == 1) {
                Answer answer = new Answer(next, CompatibilityAnswers.PRIORITY_IMPORTANT);
                askRow.setAnswer(answer);
            }
            if (count % 3 == 2) {
                Answer answer = new Answer(next, CompatibilityAnswers.PRIORITY_UNIMPORTANT);
                askRow.setAnswer(answer);
            }
            count++;
            o.add(askRow);
        }
        return o;
    }


    private Set<Question> createQuestionsPavlik() {
        Set<Question> set = new HashSet<Question>();

        Question q;
        q = new Question();
        q.setText("ask_1. Будешь меня носить на руках?");
        set.add(q);

        q = new Question();
        q.setText("ask_2. Будешь радоваться моим цветам?");
        set.add(q);

        q = new Question();
        q.setText("ask_3. Будешь каждый день убирать ванну?");
        set.add(q);

        q = new Question();
        q.setText("ask_4. Будешь вытирать руки не об занавеску? ");
        set.add(q);

        return set;
    }

    public Set<Question> createQuestions2() {
        Set<Question> set = new HashSet<Question>();

        Question q;
        q = new Question();
        q.setText("ask_1_1. Будешь называть мою маму мамой?");
        set.add(q);

        q = new Question();
        q.setText("ask_2_2. Будешь со мной ходить на концерт Тяни-Толкая?");
        set.add(q);

        q = new Question();
        q.setText("ask_3_3. Хочешь иметь двоих детей?");
        set.add(q);

        q = new Question();
        q.setText("ask_4_4. Хочу прыгнуть вместе с паращютом");
        set.add(q);


        q = new Question();
        q.setText("ask_5_5. Будешь звонить мне, если опаздываешь?");
        set.add(q);

        return set;
    }

    private User createUserOther() {
        User user = new User();
        user.setUser_Name("vlad");
        user.setSex("man");
        user.setUser_login("vlad");

        String avatarUrl = "resources/css/img/ph2.jpg";
        Photo p = new Photo();
        user.setPhoto(p);
        p.setUrl(avatarUrl);

        String aboutMeText = "нам надо сегодня поставить подпись и печати.";
        user.setUser_Inf(aboutMeText);


        return user;
    }

    private User createUser3(String name) {
        User user = new User();
        user.setUser_Name(name);
        user.setSex("man");
        user.setUser_login(name);
        int random = (new Random().nextInt(9)) + 3;
        String avatarUrl = "resources/css/img/ph" + random + ".jpg";
        Photo p = new Photo();
        user.setPhoto(p);
        p.setUrl(avatarUrl);

        String aboutMeText = "В понедельник нам вроде надо уже отчеты сдавать)";
        user.setUser_Inf(aboutMeText);
        return user;
    }

    private User createUserPavlik() {
        User user = new User();
        user.setUser_Name("pavlik");
        user.setUser_login("pavlik");
        user.setSex("man");

        String aboutMeText = "С шести лет и до шестнадцати я занималась музыкой. И две мои сестры занимались музыкой. В коридоре\n" +
                "      висел специальный ремень для тех, кто отказывался заниматься музыкой. Говорили, у меня талант. Мой\n" +
                "      плейлист – это песни, которые берут в долгую дорогу, чтобы не заснуть. Там рядом Тэйлор Свифт и Михаил\n" +
                "      Шуфутинский. Я усердно учусь и моей профессией будет преподавание русского языка и литературы в старших классах.\n" +
                "      Парни думают, что быть учительницей – это моя сексуальная фантазия. Нет. Это призвание. А ещё мне нравится\n" +
                "      готовить пироги и торты. Только сама я их не ем. Чтобы другим больше было";
        user.setUser_Inf(aboutMeText);

        String avatarUrl = "resources/css/img/ph1.jpg";
        Photo p = new Photo();
        user.setPhoto(p);
        p.setUrl(avatarUrl);
        return user;
    }
}
