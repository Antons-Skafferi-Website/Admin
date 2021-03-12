/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
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

    private final Database connection = new Database();

    public Alacarte() {

    }

    public List<Dish> getStarters() {
        return connection.getSubMenu(6);
    }

    public List<Dish> getMainDishes() {
        return connection.getSubMenu(7);
    }

    public List<Dish> getDesserts() {
        return connection.getSubMenu(8);
    }

    public void deleteFromStarters(int dishId) {
        connection.removeDishFromSubmenu(dishId, 6);
    }

    public void deleteFromMain(int dishId) {
        connection.removeDishFromSubmenu(dishId, 7);
    }

    public void addToMain(int dishId) {
        connection.addDishToSubmenu(dishId, 7);
    }

    public void addToStarters(int dishId) {
        connection.addDishToSubmenu(dishId, 6);
    }
}
