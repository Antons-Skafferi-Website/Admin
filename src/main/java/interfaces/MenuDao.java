/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import beans.Submenu;
import beans.Menu;
import java.util.List;

/**
 *
 * @author jonas
 */
public interface MenuDao {

    void removeDishFromSubmenu(long dishId, long submenuId);

    void addDishToSubmenu(long dishId, long submenuId);

    List<Submenu> getLunchSubmenus();

    List<Submenu> getStartersSubmenus();

    List<Submenu> getSpecialsSubmenus();

    List<Submenu> getDessertSubmenus();

    List<Menu> getMenus();

}
