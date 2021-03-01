/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
import classes.DayBooking;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jonas
 */
@Named(value = "bookingBean")
@SessionScoped
public class Booking implements Serializable {
    
    private final Database connection = new Database();
    
    private long tableId;
    private String name;
    private String email;
    private int customerCount;
    private Timestamp dateTime;
    private String comment;
    
    public Booking() {}
    
    public Booking(long tableId, String name, String email, int customerCount, Timestamp dateTime, String comment) {
        this.tableId = tableId;
        this.name = name;
        this.email = email;
        this.customerCount = customerCount;
        this.dateTime = dateTime;
        this.comment = comment;
    }
    
    private String getWeekDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day);
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(calendar.getTimeInMillis());
     
        return sdf.format(date);
    }
        
    public List<DayBooking> getMondayReservations() {
        String string = getWeekDay(Calendar.MONDAY);
        List<DayBooking> list = connection.getReservations(string);
        return list;
    }
    
    public List<DayBooking> getTuesdayReservations() {
        List<DayBooking> list = connection.getReservations(getWeekDay(Calendar.TUESDAY));
        return list;
    }
    
    public List<DayBooking> getWednesdayReservations() {
        List<DayBooking> list = connection.getReservations(getWeekDay(Calendar.WEDNESDAY));
        return list;
    }
    
    public List<DayBooking> getThursdayeservations() {
        List<DayBooking> list = connection.getReservations(getWeekDay(Calendar.THURSDAY));
        return list;
    }
    
    public List<DayBooking> getFridayReservations() {
        List<DayBooking> list = connection.getReservations(getWeekDay(Calendar.FRIDAY));
        return list;
    }
    
    public List<DayBooking> getSaturdayReservations() {
        List<DayBooking> list = connection.getReservations(getWeekDay(Calendar.SATURDAY));
        return list;
    }
    
    public List<DayBooking> getSundayReservations() {
        List<DayBooking> list = connection.getReservations(getWeekDay(Calendar.SUNDAY));
        return list;
    }
    
    public int getMondayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.MONDAY));
    }
    
    public int getTuesdayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.TUESDAY));
    }
    
    public int getWednesdayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.WEDNESDAY));
    }
    
    public int getThursdayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.THURSDAY));
    }
    
    public int getFridayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.FRIDAY));
    }
    
    public int getSaturdayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.SATURDAY));
    }
    
    public int getSundayCustomerCount() {
        return connection.getCustomerCount(getWeekDay(Calendar.SUNDAY));
    }
    
    public String getComment() {
        return comment;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }
    
}
