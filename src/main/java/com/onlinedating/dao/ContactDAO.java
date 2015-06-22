package com.onlinedating.dao;

import com.onlinedating.model.Contacts;
import com.onlinedating.model.Message;

import java.util.List;

/**
 * Created by Aver on 22.06.2015.
 */
public interface ContactDAO {
    void Add( Contacts contacts);

    Contacts get_btID(int id);
    void update( Contacts contacts, int id);
    void delete (int id);

    List<Contacts> contacts_list();
}
