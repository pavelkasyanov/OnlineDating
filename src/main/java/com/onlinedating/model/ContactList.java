package com.onlinedating.model;

import java.util.Set;

/**
 * Created by Aver on 22.06.2015.
 */
public class ContactList {
    private int contactlist_id;
    private Set<Contacts> contactsSet;

    public int getContactlist_id() {
        return contactlist_id;
    }

    public void setContactlist_id(int contactlist_id) {
        this.contactlist_id = contactlist_id;
    }

    public Set<Contacts> getContactsSet() {
        return contactsSet;
    }

    public void setContactsSet(Set<Contacts> contactsSet) {
        this.contactsSet = contactsSet;
    }
}
