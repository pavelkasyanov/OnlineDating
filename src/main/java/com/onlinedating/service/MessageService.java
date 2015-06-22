package com.onlinedating.service;

import com.onlinedating.model.Message;
import com.onlinedating.model.Question;

import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public interface MessageService {
    Message Add( String question, String text, String category);

    Message get_btID(int id);
    void update( Message question, int id);
    void delete (int id);

    List<Message> question_list();
}
