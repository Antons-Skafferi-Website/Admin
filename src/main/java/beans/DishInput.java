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
 * @author jonas
 */
@Named(value = "addDish")
@SessionScoped
public class DishInput implements Serializable{
    
    private String name;
    private String Description;
    private double price;

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public void reset() {
        this.name = "";
        this.Description = "";
        this.price = 0.0;
    }
}
