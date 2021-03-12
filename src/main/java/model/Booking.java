/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonas
 */
public class Booking {

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
