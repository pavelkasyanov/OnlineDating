package com.onlinedating.dao;

import com.onlinedating.model.Event;
import com.onlinedating.model.Message;

import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public interface MessageDAO {
    void Add( Message message);

    Message get_btID(int id);
    void update( Message message, int id);
    void delete (int id);

    List<Message> message_list();
}
