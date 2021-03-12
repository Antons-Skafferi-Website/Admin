/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import beans.Menu;
import beans.Submenu;
import interfaces.MenuDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class MenuDs implements MenuDao {

    private String deleteFromSubmenu = "DELETE FROM APP.SUB_MENU_HAS_DISH WHERE DISH_ID = ? AND SUB_MENU_ID = ?";

    private String getLunchSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID < 6";

    private String getStartersSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID = 6";

    private String getSpecialsSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID = 7";

    private String getDessertSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID = 8";
    
    private String addDishSubmenu
            = "INSERT INTO APP.SUB_MENU_HAS_DISH (DISH_ID, SUB_MENU_ID) "
            + "VALUES (?, ?)";
    
    private String getMenus = "SELECT * FROM APP.MENU";

    @Override
    public void removeDishFromSubmenu(long dishId, long submenuId) {

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(deleteFromSubmenu);) {

            statement.setLong(1, dishId);
            statement.setLong(2, submenuId);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDishToSubmenu(long dishId, long submenuId) {

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareStatement(addDishSubmenu);) {

            statement.setLong(1, dishId);
            statement.setLong(2, submenuId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Submenu> getLunchSubmenus() {

        List<Submenu> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getLunchSubmenus);) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Submenu> getStartersSubmenus() {

        List<Submenu> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getStartersSubmenus);) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Submenu> getSpecialsSubmenus() {

        List<Submenu> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getSpecialsSubmenus);) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Submenu> getDessertSubmenus() {

        List<Submenu> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getDessertSubmenus);) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Menu> getMenus() {

        List<Menu> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getMenus);) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Menu(rs.getLong(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
