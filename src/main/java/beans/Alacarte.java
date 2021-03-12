/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.DishDs;
import classes.MenuDs;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jonas
 */
@Named(value = "alacarteBean")
@SessionScoped
public class Alacarte implements Serializable {

    private final DishDs dishDs = new DishDs();
    private final MenuDs menuDs = new MenuDs();

    public Alacarte() {
    }

    public List<Dish> getStarters() {
        return dishDs.getSubMenu(6);
    }

    public List<Dish> getMainDishes() {
        return dishDs.getSubMenu(7);
    }

    public List<Dish> getDesserts() {
        return dishDs.getSubMenu(8);
    }

    public void deleteFromStarters(int dishId) {
        menuDs.removeDishFromSubmenu(dishId, 6);
    }

    public void deleteFromMain(int dishId) {
        menuDs.removeDishFromSubmenu(dishId, 7);
    }

    public void addToMain(int dishId) {
        menuDs.addDishToSubmenu(dishId, 7);
    }

    public void addToStarters(int dishId) {
        menuDs.addDishToSubmenu(dishId, 6);
    }
}
