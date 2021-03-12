/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.BookingHolder;
import java.util.List;

/**
 *
 * @author jonas
 */
public interface BookingDao {

    public List<BookingHolder> getBookings(String date);

    public int getCustomerCount(String date);
}
