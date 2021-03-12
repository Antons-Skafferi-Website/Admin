/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.DishDs;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jonas
 */
@Named(value = "dishBean")
@SessionScoped
public class Dish implements Serializable {

    private long dishId;
    private String name;
    private String description;
    private double price;
    private long menuId;

    private long selectedDishId;

    private final DishDs ds = new DishDs();

    public Dish() {
    }

    public Dish(long dishId, String name, String description, double price, long menuId) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public long getMenuId() {
        return menuId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getSelectedDishId() {
        return selectedDishId;
    }

    public long getDishId() {
        return dishId;
    }

    public void setSelectedDishId(long selectedDishId) {
        this.selectedDishId = selectedDishId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public void addNewDish() {
        ds.addNewDish(name, description, price, menuId);
    }

    public void removeDish() {
        //Derby has no DELETE ON CASCADE so this should not be implemented right now.
    }

    public void resetDishBean() {
        this.name = null;
        this.description = null;
        this.price = 0.0;
        this.menuId = 1;
    }

    public List<Dish> getAllDishes() {
        return ds.getAllDishes();
    }

    public List<Dish> getLunchDishes() {
        return ds.getLunchDishes();
    }

    public List<Dish> getSpecialDishes() {
        return ds.getSpecialDishes();
    }

    public List<Dish> getStarterDishes() {
        return ds.getStarterDishes();
    }

    public List<Dish> getDessertDishes() {
        return ds.getDessertDishes();
    }
}
