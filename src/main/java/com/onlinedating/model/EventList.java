package com.onlinedating.model;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public class EventList {
    private int eventList_id;
    private Set<Event> events;




    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public int getEventList_id() {
        return eventList_id;
    }

    public void setEventList_id(int eventList_id) {
        this.eventList_id = eventList_id;
    }
}
