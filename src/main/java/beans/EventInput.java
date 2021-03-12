/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author zered
 */
@Named(value = "addEvent")
@SessionScoped
public class EventInput implements Serializable{
    
    private String eventName;
    private String description;
    private String image;

    public String getImage() {
        return image;
    }
    
    public String getDescription() {
        return description;
    }

    public String getEventName() {
        return eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
