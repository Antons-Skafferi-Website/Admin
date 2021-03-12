/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import beans.Dish;

/**
 *
 * @author jonas
 */
public interface DishDao {

    void addNewDish(String name, String description, double price, long menuId);

    public List<Dish> getAllDishes();

    public List<Dish> getLunchDishes();

    public List<Dish> getSpecialDishes();

    List<Dish> getStarterDishes();

    List<Dish> getSubMenu(long menuId);
    
    List<Dish> getDessertDishes();

}
