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
import model.Menu;

/**
 *
 * @author rickard1
 */
@Named(value = "menuBean")
@SessionScoped
public class MenuController implements Serializable {

    private final MenuDs ds = new MenuDs();

    private long selectedMenuId;

    public MenuController() {
    }

    public List<Menu> getMenus() {
        return ds.getMenus();
    }

    public void setSelectedMenuId(long selectedMenuId) {
        this.selectedMenuId = selectedMenuId;
    }
    
    public long getSelectedMenuId() {
        return selectedMenuId;
    }
}
