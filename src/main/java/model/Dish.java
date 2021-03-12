/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonas
 */
public class Dish {

    private long dishId;
    private String name;
    private String description;
    private double price;
    private long menuId;

    public Dish() {
    }

    public Dish(long dishId, String name, String description, double price, long menuId) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuId = menuId;
    }

    public String getDescription() {
        return description;
    }

    public long getDishId() {
        return dishId;
    }

    public long getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
