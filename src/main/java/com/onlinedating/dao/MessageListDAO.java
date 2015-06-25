package com.onlinedating.dao;

import com.onlinedating.model.ContactList;
import com.onlinedating.model.MessageList;

/**
 * Created by Aver on 22.06.2015.
 */
public interface MessageListDAO {
    void Add( MessageList messageList);
    MessageList get_btID(int id);
    void test ();
}
