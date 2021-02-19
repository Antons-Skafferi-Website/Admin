/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;


/**
 *
 * @author jonas
 */
@Named(value = "lunchBean")
@Dependent
public class Lunch implements Serializable {
    
    private final Database connection = new Database();

    public Lunch() {}
    
    public void addDishToMonday(int dishId) {
        connection.addDishToSubmenu(dishId, 1);
    }
    
    public void addDishToTuesday(int dishId) {
        connection.addDishToSubmenu(dishId, 2);
    }
    
    public void addDishToWednesday(int dishId) {
        connection.addDishToSubmenu(dishId, 3);
    }
    
    public void addDishToThursday(int dishId) {
        connection.addDishToSubmenu(dishId, 4);
    }
    
    public void addDishToFriday(int dishId) {
        connection.addDishToSubmenu(dishId, 5);
    }
    
    public List<Dish> getMondayLunch() {
        return connection.getSubMenu(1);
    }
    
    public List<Dish> getTuesdayLunch() {
        return connection.getSubMenu(2);
    }
    
    public List<Dish> getWednesdayLunch() {
        return connection.getSubMenu(3);
    }
    
    public List<Dish> getThursdayLunch() {
        return connection.getSubMenu(4);
    }
    
    public List<Dish> getFridayLunch() {
        return connection.getSubMenu(5);
    }
    
    public List<Dish> getTodaysLunch() {
        
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        
        switch(day) {
            case Calendar.MONDAY:
                return getMondayLunch();
            case Calendar.TUESDAY:
                return getTuesdayLunch();
            case Calendar.WEDNESDAY:
                return getWednesdayLunch();
            case Calendar.THURSDAY:
                return getThursdayLunch();
            case Calendar.FRIDAY:
                return getFridayLunch();
        }
        
        return Collections.emptyList();
    }
    
    public String getTodaysWeekday() {
        
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        
        switch(day) {
            case Calendar.MONDAY:
                return "Måndag";
            case Calendar.TUESDAY:
                return "Tisdag";
            case Calendar.WEDNESDAY:
                return "Onsdag";
            case Calendar.THURSDAY:
                return "Torsdag";
            case Calendar.FRIDAY:
                return "Fredag";
        }
        
        return "Kommer på måndag";
    }
    
    public void removeDishFromMonday(long dishId) {
        connection.removeDishFromSubmenu(dishId, 1);
    }
    
    public void removeDishFromTueday(long dishId) {
        connection.removeDishFromSubmenu(dishId, 2);
    }
    
    public void removeDishFromWednesday(long dishId) {
        connection.removeDishFromSubmenu(dishId, 3);
    }
    
    public void removeDishFromThursday(long dishId) {
        connection.removeDishFromSubmenu(dishId, 4);
    }
    
    public void removeDishFromFriday(long dishId) {
        connection.removeDishFromSubmenu(dishId, 5);
    }
}
