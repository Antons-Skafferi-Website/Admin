/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author zered
 */
public class Events {

    private long eventId;
    private String eventDate;
    private String eventTime;
    private String eventName;
    private String description;
    private String imageUrl;

    public Events(long eventId, String eventName, String description, String date, String time, String imageUrl) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.eventDate = date;
        this.eventTime = time;
        this.imageUrl = imageUrl;
    }

    public String getEventName() {
        return eventName;
    }

    public long getEventId() {
        return eventId;
    }

    public String getDescription() {
        return description;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
