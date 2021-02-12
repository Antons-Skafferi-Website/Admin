/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Dish;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    String[] menus;
    @PersistenceContext(unitName = "AntonsPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public MenuBean() {
        menus = new String[7];
        menus[0] = "Måndag - Bönor";
        menus[1] = "Tisdag - Bönor";
        menus[2] = "Onsdag - Bönor";
        menus[3] = "Torsdag - Bönor";
        menus[4] = "Fredag - Bönor";
        menus[5] = "Lördag - Bönor";
        menus[6] = "Söndag - Bönor";
    } 
    public String getMenu()
    {
        TypedQuery<Dish> menuQuery = em.createNamedQuery("Dish.findAll", Dish.class);
        List<Dish> menuList = menuQuery.getResultList();
        return menuList.get(0).getDishname();
    }
    
    

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    
}
