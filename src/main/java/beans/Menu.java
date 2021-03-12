/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.MenuDs;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rickard1
 */
@Named(value = "menuBean")
@SessionScoped
public class Menu implements Serializable {

    private final MenuDs ds = new MenuDs();
    private long menuId;
    private String name;

    private long selectedMenuId;

    public Menu() {
    }

    public Menu(long id, String name) {
        this.menuId = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getMenuId() {
        return menuId;
    }

    public List<Menu> getMenus() {
        return ds.getMenus();
    }

    public long getSelectedMenuId() {
        return selectedMenuId;
    }
}
