/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import beans.Booking;
import java.util.ArrayList;
import java.util.List;

public class ReservationHolder {
    
    private List<Booking> list = new ArrayList<>();
    private String time;
    
    public ReservationHolder(String time) {
        this.time = time;
    }
    
    public void addBooking(Booking booking) {
        list.add(booking);
    }

    public List<Booking> getBookings() {
        return list;
    }

    public String getTime() {
        return time;
    }
    
}
