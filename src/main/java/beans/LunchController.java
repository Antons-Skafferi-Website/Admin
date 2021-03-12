/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.DishDs;
import classes.MenuDs;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import model.Dish;

/**
 *
 * @author jonas
 */
@Named(value = "lunchBean")
@Dependent
public class LunchController implements Serializable {

    private final DishDs dishDs = new DishDs();
    private final MenuDs menuDs = new MenuDs();

    public LunchController() {
    }

    public void addDishToMonday(int dishId) {
        menuDs.addDishToSubmenu(dishId, 1);
    }

    public void addDishToTuesday(int dishId) {
        menuDs.addDishToSubmenu(dishId, 2);
    }

    public void addDishToWednesday(int dishId) {
        menuDs.addDishToSubmenu(dishId, 3);
    }

    public void addDishToThursday(int dishId) {
        menuDs.addDishToSubmenu(dishId, 4);
    }

    public void addDishToFriday(int dishId) {
        menuDs.addDishToSubmenu(dishId, 5);
    }

    public List<Dish> getMondayLunch() {
        return dishDs.getSubMenu(1);
    }

    public List<Dish> getTuesdayLunch() {
        return dishDs.getSubMenu(2);
    }

    public List<Dish> getWednesdayLunch() {
        return dishDs.getSubMenu(3);
    }

    public List<Dish> getThursdayLunch() {
        return dishDs.getSubMenu(4);
    }

    public List<Dish> getFridayLunch() {
        return dishDs.getSubMenu(5);
    }

    public List<Dish> getTodaysLunch() {

        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        switch (day) {
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

        switch (day) {
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
        menuDs.removeDishFromSubmenu(dishId, 1);
    }

    public void removeDishFromTueday(long dishId) {
        menuDs.removeDishFromSubmenu(dishId, 2);
    }

    public void removeDishFromWednesday(long dishId) {
        menuDs.removeDishFromSubmenu(dishId, 3);
    }

    public void removeDishFromThursday(long dishId) {
        menuDs.removeDishFromSubmenu(dishId, 4);
    }

    public void removeDishFromFriday(long dishId) {
        menuDs.removeDishFromSubmenu(dishId, 5);
    }
}
