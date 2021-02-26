/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import beans.Dish;
import beans.Menu;
import beans.Submenu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class Database {
    
    private String dbURL;
    private String user;
    private String pw;
    
    private String getLunchDay = 
    "SELECT D.DISH_ID, D.DISH_NAME, D.DESCRIPTION, D.PRICE, D.MENU_ID FROM APP.DISH AS D " +
    "INNER JOIN APP.SUB_MENU_HAS_DISH AS SMHD ON D.DISH_ID = SMHD.DISH_ID " +
    "WHERE SMHD.SUB_MENU_ID = ?";
    
    private String deleteFromSubmenu = 
    "DELETE FROM APP.SUB_MENU_HAS_DISH WHERE DISH_ID = ? AND SUB_MENU_ID = ?";
    
    private String addNewDish = 
    "INSERT INTO APP.DISH (DISH_NAME, DESCRIPTION, PRICE, MENU_ID) " +
    "VALUES (?, ?, ?, ?)";
    
    private String addDishSubmenu = 
    "INSERT INTO APP.SUB_MENU_HAS_DISH (DISH_ID, SUB_MENU_ID) " +
    "VALUES (?, ?)";
    
    private String getAllDishes = "SELECT * FROM APP.DISH";
    
    private String getLunchDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 1";
    
    private String getSpecialDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 2";
    
    private String getStarterDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 3";
    
    private String getDessertDishes = "SELECT * FROM APP.DISH WHERE MENU_ID = 4";
    
    private String getLunchSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID < 6";
    
    private String getStartersSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID = 6";
    
    private String getSpecialsSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID = 7";
    
    private String getDessertSubmenus = "SELECT * FROM APP.SUB_MENU WHERE SUB_MENU_ID = 8";
    
    private String getMenus = "SELECT * FROM APP.MENU";
    
    public Database() {
        this.dbURL = "jdbc:derby://localhost:1527/AntonsSkafferi";
        this.user = "anton";
        this.pw = "anton";
    }

    public List<Dish> getSubMenu(long menuId) {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getLunchDay);
        ){
            
            statement.setLong(1, menuId);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }

    
    public void removeDishFromSubmenu(long dishId, long submenuId) {
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(deleteFromSubmenu);
        ){
            
            statement.setLong(1, dishId);
            statement.setLong(2, submenuId);
            statement.execute();
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addNewDish(String name, String description, double price, long menuId) {
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareStatement(addNewDish);
        ){
            
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDouble(3, price);
            statement.setLong(4, menuId);
            statement.executeUpdate();
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Dish> getAllDishes() {      
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getAllDishes);
        ){
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Dish> getLunchDishes() {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getLunchDishes);
        ){
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Dish> getSpecialDishes() {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getSpecialDishes);
        ){
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Dish> getStarterDishes() {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getStarterDishes);
        ){
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Dish> getDessertDishes() {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getDessertDishes);
        ){
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getLong(5)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void addDishToSubmenu(long dishId, long submenuId) {
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareStatement(addDishSubmenu);
        ){
            
            statement.setLong(1, dishId);
            statement.setLong(2, submenuId);
            statement.executeUpdate();
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Submenu> getLunchSubmenus() {
        
        List<Submenu> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getLunchSubmenus);
        ){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Submenu> getStartersSubmenus() {
        
        List<Submenu> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getStartersSubmenus);
        ){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Submenu> getSpecialsSubmenus() {
        
        List<Submenu> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getSpecialsSubmenus);
        ){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Submenu> getDessertSubmenus() {
        
        List<Submenu> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getDessertSubmenus);
        ){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Submenu(rs.getLong(1), rs.getString(2)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Menu> getMenus() {
        
        List<Menu> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getMenus);
        ){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Menu(rs.getLong(1), rs.getString(2)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
