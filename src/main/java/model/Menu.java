/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonas
 */
public class Menu {

    private long menuId;
    private String name;

    public Menu() {
    }

    public Menu(long id, String name) {
        this.menuId = id;
        this.name = name;
    }

    public long getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

}
