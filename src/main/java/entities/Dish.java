/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zered
 */
@Entity
@Table(name = "DISH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dish.findAll", query = "SELECT d FROM Dish d")})
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISHID")
    private Integer dishid;
    @Size(max = 45)
    @Column(name = "DISHNAME")
    private String dishname;
    @Size(max = 120)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @JoinColumn(name = "SUBMENUID", referencedColumnName = "SUBMENUID")
    @ManyToOne
    private Submenu submenuid;

    public Dish() {
    }

    public Dish(Integer dishid) {
        this.dishid = dishid;
    }

    public Integer getDishid() {
        return dishid;
    }

    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Submenu getSubmenuid() {
        return submenuid;
    }

    public void setSubmenuid(Submenu submenuid) {
        this.submenuid = submenuid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dishid != null ? dishid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dish)) {
            return false;
        }
        Dish other = (Dish) object;
        if ((this.dishid == null && other.dishid != null) || (this.dishid != null && !this.dishid.equals(other.dishid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dish[ dishid=" + dishid + " ]";
    }
    
}
