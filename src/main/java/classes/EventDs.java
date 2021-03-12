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
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.Event;

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
    public List<Event> getEvents(String date) {

        List<Event> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getEvents);) {
            
            ResultSet eventsResult = statement.executeQuery();
            
            while (eventsResult.next()) {
                list.add(new Event(eventsResult.getString(2), eventsResult.getString(3), eventsResult.getString(6)));
            }

        } catch (SQLException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
        }

        return list;
    }

    @Override
    public void addNewEvent(String name, String description, String imageUrl) {

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareStatement(addNewEvent);) {

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDate(3, Date.valueOf("2020-01-01"));
            statement.setTime(4, Time.valueOf("11:11:22"));
            statement.setString(5, imageUrl);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
