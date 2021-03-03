/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
import classes.ReservationHolder;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    
    private String name;
    private String email;
    private int customerCount;
    private String comment;
    private String time;
    private String date;
    private String phone;
    
    public Booking() {}
    
    public Booking(String name, String email, int customerCount, String date, String time, String comment) {
        this.name = name;
        this.email = email;
        this.customerCount = customerCount;
        this.date = date;
        this.time = time;
        this.phone = "073-8282122";
        
        if(comment == null)
            this.comment = "Inga önskemål";
        else
            this.comment = comment;
    }
    
    private String getWeekDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day);
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(calendar.getTimeInMillis());
     
        return sdf.format(date);
    }
        
    public List<ReservationHolder> getMondayReservations() {
        return connection.getReservations(getWeekDay(Calendar.MONDAY));
    }
    
    public List<ReservationHolder> getTuesdayReservations() {
        return connection.getReservations(getWeekDay(Calendar.TUESDAY));
    }
    
    public List<ReservationHolder> getWednesdayReservations() {
        return connection.getReservations(getWeekDay(Calendar.WEDNESDAY));
    }
    
    public List<ReservationHolder> getThursdayeservations() {
        return connection.getReservations(getWeekDay(Calendar.THURSDAY));
    }
    
    public List<ReservationHolder> getFridayReservations() {
        return connection.getReservations(getWeekDay(Calendar.FRIDAY));
    }
    
    public List<ReservationHolder> getSaturdayReservations() {
        return connection.getReservations(getWeekDay(Calendar.SATURDAY));
    }
    
    public List<ReservationHolder> getSundayReservations() {
        return connection.getReservations(getWeekDay(Calendar.SUNDAY));
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

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    
}
