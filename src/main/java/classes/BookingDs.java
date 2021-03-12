/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import beans.Booking;

import interfaces.BookingDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class BookingDs implements BookingDao {

    private String getReserverations
            = "SELECT * FROM APP.RESERVATION "
            + "WHERE RESERVATION_DATE = ? "
            + "ORDER BY RESERVATION_TIME ";

    private String getCustomerCount
            = "SELECT SUM(CUSTOMER_COUNT) FROM APP.RESERVATION "
            + "WHERE RESERVATION_DATE = ? ";

    @Override
    public List<BookingHolder> getBookings(String date) {

        List<BookingHolder> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getReserverations);) {

            statement.setString(1, date);
            ResultSet rs = statement.executeQuery();

            String time = null;
            int holderCount = -1;

            while (rs.next()) {

                if (time == null || !rs.getString(7).equals(time)) {
                    time = rs.getString(7);
                    holderCount++;
                    list.add(new BookingHolder(time));
                }

                Booking booking = new Booking(rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.get(holderCount).addBooking(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int getCustomerCount(String date) {

        int count = -1;

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getCustomerCount);) {

            statement.setString(1, date);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

}
