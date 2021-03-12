/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import classes.MenuDs;

/**
 *
 * @author jonas
 */
public class Submenu {

    private long submenuId;
    private String name;

    public Submenu() {
    }

    public Submenu(long submenuId, String name) {
        this.name = name;
        this.submenuId = submenuId;
    }

    public String getName() {
        return name;
    }

    public long getSubmenuId() {
        return submenuId;
    }  
    
}
