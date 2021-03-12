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
import model.Dish;

/**
 *
 * @author jonas
 */
@Named(value = "dishBean")
@SessionScoped
public class DishController implements Serializable {

    private long selectedDishId;

    private final DishDs ds = new DishDs();

    public long getSelectedDishId() {
        return selectedDishId;
    }

    public void setSelectedDishId(long selectedDishId) {
        this.selectedDishId = selectedDishId;
    }
    
    public void addNewDish(String name, String description, Double price, int menuId) {
        
        if(name.isEmpty()|| description.isEmpty() || price == null)
            return;
        
        ds.addNewDish(name, description, price, menuId);
    }

    public void removeDish() {
        //Derby has no DELETE ON CASCADE so this should not be implemented right now.
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
