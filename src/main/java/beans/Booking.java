/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.BookingDs;
import classes.BookingHolder;
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

    private final BookingDs ds = new BookingDs();

    private String name;
    private String email;
    private int customerCount;
    private String comment;
    private String time;
    private String date;
    private String phone;

    public Booking() {
    }

    public Booking(String name, String email, int customerCount, String date, String time, String comment, String phone) {
        this.name = name;
        this.email = email;
        this.customerCount = customerCount;
        this.date = date;
        this.time = time;
        this.phone = phone;

        if (comment == null) {
            this.comment = "Inga önskemål";
        } else {
            this.comment = comment;
        }
    }

    private String getWeekDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(calendar.getTimeInMillis());

        return sdf.format(date);
    }

    public List<BookingHolder> getMondayReservations() {
        return ds.getBookings(getWeekDay(Calendar.MONDAY));
    }

    public List<BookingHolder> getTuesdayReservations() {
        return ds.getBookings(getWeekDay(Calendar.TUESDAY));
    }

    public List<BookingHolder> getWednesdayReservations() {
        return ds.getBookings(getWeekDay(Calendar.WEDNESDAY));
    }

    public List<BookingHolder> getThursdayeservations() {
        return ds.getBookings(getWeekDay(Calendar.THURSDAY));
    }

    public List<BookingHolder> getFridayReservations() {
        return ds.getBookings(getWeekDay(Calendar.FRIDAY));
    }

    public List<BookingHolder> getSaturdayReservations() {
        return ds.getBookings(getWeekDay(Calendar.SATURDAY));
    }

    public List<BookingHolder> getSundayReservations() {
        return ds.getBookings(getWeekDay(Calendar.SUNDAY));
    }

    public int getMondayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.MONDAY));
    }

    public int getTuesdayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.TUESDAY));
    }

    public int getWednesdayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.WEDNESDAY));
    }

    public int getThursdayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.THURSDAY));
    }

    public int getFridayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.FRIDAY));
    }

    public int getSaturdayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.SATURDAY));
    }

    public int getSundayCustomerCount() {
        return ds.getCustomerCount(getWeekDay(Calendar.SUNDAY));
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
