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
public class BookingController implements Serializable {

    private final BookingDs ds = new BookingDs();

    public BookingController() {
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

}
