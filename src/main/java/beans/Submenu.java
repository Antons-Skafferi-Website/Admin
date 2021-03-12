/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.MenuDs;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jonas
 */
@Named(value = "submenuBean")
@SessionScoped
public class Submenu implements Serializable {

    private final MenuDs ds = new MenuDs();
    private long submenuId;
    private String name;

    private long selectedSubmenuId;

    public Submenu() {
    }

    public Submenu(long submenuId, String name) {
        this.name = name;
        this.submenuId = submenuId;
    }

    public List<Submenu> getSubmenusLunch() {
        return ds.getLunchSubmenus();
    }

    public List<Submenu> getSubmenusStarters() {
        return ds.getStartersSubmenus();
    }

    public List<Submenu> getSubmenusSpecials() {
        return ds.getSpecialsSubmenus();
    }

    public List<Submenu> getSubmenusDessert() {
        return ds.getDessertSubmenus();
    }

    public void addDishToSubmenu(int dishId, int submenuId) {
        ds.addDishToSubmenu(dishId, submenuId);
    }

    public void removeDishFromSubmenu(int dishId, int submenuId) {
        ds.removeDishFromSubmenu(dishId, submenuId);
    }

    public String getName() {
        return name;
    }

    public long getSubmenuId() {
        return submenuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubmenuId(long submenuId) {
        this.submenuId = submenuId;
    }

    public void setSelectedSubmenuId(long selectedSubmenuId) {
        this.selectedSubmenuId = selectedSubmenuId;
    }

    public long getSelectedSubmenuId() {
        return selectedSubmenuId;
    }
}
