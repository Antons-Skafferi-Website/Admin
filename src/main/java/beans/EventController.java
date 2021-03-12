/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.EventDs;
import java.util.Calendar;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import model.Event;

/**
 *
 * @author zered
 */
@Named(value = "eventAdd")
@SessionScoped
public class EventController implements Serializable {

    private final EventDs ds = new EventDs();
    
    public EventController() {
    }

    private String getWeekDay(int day) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(calendar.getTimeInMillis());

        return sdf.format(date);
    }

    public void removeEvent(long whichEvent) {
        //Derby has no DELETE ON CASCADE so this should not be implemented right now.
    }

    public List<Event> getEvents() {
        String string = getWeekDay(Calendar.TUESDAY);
        List<Event> list = ds.getEvents(string);
        //list.add(new Events(22,errorss,"","",""));
        return list;
    }
    
    public void addNewEvent(String name, String description, String image) {
        //Date nDate = new Date(year + 100, month - 1, day);
        //Time nTime = new Time(hour, minute, 0);
        ds.addNewEvent(name, description, image);
    }
}
