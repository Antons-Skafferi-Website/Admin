/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Events;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author jonas
 */
public interface EventDao {

    List<Events> getEvents(String date);

    void addNewEvent(String name, String description, Date date, Time time, String imageUrl);
}
