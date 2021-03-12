/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.EventDs;
import classes.Events;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author zered
 */
@Named(value = "eventsBean")
@SessionScoped
public class EventsBean implements Serializable {

    private final EventDs ds = new EventDs();

    private long selectedEventId;
    private String name;
    private String description;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String imageUrl;
    private String errorss;

    public EventsBean() {
    }

    public EventsBean(String name, String description, int y, int m, int d, int h, int mn, String imageUrl) {
        this.name = name;
        this.description = description;
        this.year = y;
        this.month = m;
        this.day = d;
        this.hour = h;
        this.minute = mn;
        this.imageUrl = imageUrl;
    }

    private String getWeekDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(calendar.getTimeInMillis());

        return sdf.format(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String nName) {
        name = nName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int n) {
        year = n;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int n) {
        month = n;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int n) {
        day = n;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int n) {
        hour = n;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int n) {
        minute = n;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String nDesc) {
        description = nDesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String nUrl) {
        imageUrl = nUrl;
    }

    public void setSelectedEventId(long selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public long getSelectedEventId() {
        return selectedEventId;
    }

    public void removeEvent(long whichEvent) {
        //Derby has no DELETE ON CASCADE so this should not be implemented right now.
    }

    public List<Events> getEvents() {
        String string = getWeekDay(Calendar.TUESDAY);
        List<Events> list = ds.getEvents(string);
        //list.add(new Events(22,errorss,"","",""));
        return list;
    }

    public void addNewEvent() {
        Date nDate = new Date(year + 100, month - 1, day);
        Time nTime = new Time(hour, minute, 0);
        ds.addNewEvent(name, description, nDate, nTime, imageUrl);
    }
}
