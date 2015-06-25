package com.onlinedating.dao;

import com.onlinedating.model.ContactList;
import com.onlinedating.model.QuestionList;

/**
 * Created by Aver on 22.06.2015.
 */
public interface ContactListDAO {
    void Add( ContactList contactList);
    ContactList get_btID(int id);
    void test ();
}
