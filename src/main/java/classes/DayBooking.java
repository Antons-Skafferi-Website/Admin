/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author jonas
 */
public class DayBooking {

    private String reservationTime;
    private int customerCount;
    private List<String> comments;

    public DayBooking(String reservationTime, int customerCount, List<String> comments) {
        this.reservationTime = reservationTime;
        this.customerCount = customerCount;
        this.comments = comments;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public List<String> getComments() {
        return comments;
    }
}
