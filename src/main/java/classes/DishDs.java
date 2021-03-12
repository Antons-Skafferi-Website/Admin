/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.DishDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Dish;

/**
 *
 * @author jonas
 */
public class DishDs implements DishDao {

    private String getLunchDay
            = "SELECT D.DISH_ID, D.DISH_NAME, D.DESCRIPTION, D.PRICE, D.MENU_ID FROM APP.DISH AS D "
            + "INNER JOIN APP.SUB_MENU_HAS_DISH AS SMHD ON D.DISH_ID = SMHD.DISH_ID "
            + "WHERE SMHD.SUB_MENU_ID = ?";

    private String addNewDish
            = "INSERT INTO APP.DISH (DISH_NAME, DESCRIPTION, PRICE, MENU_ID) "
            + "VALUES (?, ?, ?, ?)";

    private String getAllDishes = "SELECT * FROM APP.DISH";

    private String getLunchDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 1";

    private String getSpecialDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 2";

    private String getStarterDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 3";

    private String getDessertDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 4";

    @Override
    public void addNewDish(String name, String description, double price, long menuId) {

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareStatement(addNewDish);) {

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDouble(3, price);
            statement.setLong(4, menuId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> getAllDishes() {

        List<Dish> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getAllDishes);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Dish> getLunchDishes() {
        
        List<Dish> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getLunchDishes);) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Dish> getSpecialDishes() {

        List<Dish> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getSpecialDishes);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Dish> getStarterDishes() {

        List<Dish> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getStarterDishes);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Dish> getDessertDishes() {

        List<Dish> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getDessertDishes);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Dish> getSubMenu(long menuId) {

        List<Dish> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getLunchDay);) {

            statement.setLong(1, menuId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
