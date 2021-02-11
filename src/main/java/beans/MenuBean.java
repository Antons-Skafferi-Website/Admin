/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author zered
 */
@Named(value = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {

    /**
     * Creates a new instance of MenuBean
     */
    
    public MenuBean() {
    } 
    public String getMenu()
    {
        return "Bönor till middag";
    }
    
    
}
