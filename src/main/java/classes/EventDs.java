/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.EventDao;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class EventDs implements EventDao {

    private String getEvents
            = "SELECT EVENT_ID, EVENT_NAME, EVENT_DESC, EVENT_DATE, EVENT_TIME, IMAGE_URL FROM APP.EVENTS ";

    private String addNewEvent
            = "INSERT INTO APP.EVENTS (EVENT_NAME, EVENT_DESC, EVENT_DATE, EVENT_TIME, IMAGE_URL) "
            + "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Events> getEvents(String date) {

        List<Events> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getEvents);) {
            
            ResultSet eventsResult = statement.executeQuery();

            //Fill list with bookings and comments
            while (eventsResult.next()) {
                list.add(new Events(eventsResult.getLong(1), eventsResult.getString(2), eventsResult.getString(3), eventsResult.getDate(4).toString(), eventsResult.getTime(5).toString(), eventsResult.getString(6)));
            }

        } catch (SQLException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            list.add(new Events(0, "Error:", errors.toString(), "", "", ""));

        }

        return list;
    }

    @Override
    public void addNewEvent(String name, String description, Date date, Time time, String imageUrl) {

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareStatement(addNewEvent);) {

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDate(3, date);
            statement.setTime(4, time);
            statement.setString(5, imageUrl);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
