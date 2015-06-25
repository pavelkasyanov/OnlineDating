package com.onlinedating.model;

import java.util.Date;

/**
 * Created by Aver on 22.06.2015.
 */
public class Contacts {
    private int contact_id;
    private int MyRelation;
    private int FriendRelation;
    private User friend;
    private ContactList contactList;

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getMyRelation() {
        return MyRelation;
    }

    public void setMyRelation(int myRelation) {
        MyRelation = myRelation;
    }

    public int getFriendRelation() {
        return FriendRelation;
    }

    public void setFriendRelation(int friendRelation) {
        FriendRelation = friendRelation;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }
}
