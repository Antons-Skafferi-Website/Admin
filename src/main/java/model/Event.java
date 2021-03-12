/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zered
 */
public class Event {

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

    public Event() {
    }

    public Event(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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

}
