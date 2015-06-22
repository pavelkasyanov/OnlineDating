package com.onlinedating.model;

import java.util.Set;

/**
 * Created by Aver on 22.06.2015.
 */
public class MessageList {
    private int messagelist_id;
    private Set<Message> messageSet;

    public int getMessagelist_id() {
        return messagelist_id;
    }

    public void setMessagelist_id(int messagelist_id) {
        this.messagelist_id = messagelist_id;
    }

    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }
}
