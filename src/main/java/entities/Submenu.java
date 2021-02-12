/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zered
 */
@Entity
@Table(name = "SUBMENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submenu.findAll", query = "SELECT s FROM Submenu s")})
public class Submenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBMENUID")
    private Integer submenuid;
    @Size(max = 45)
    @Column(name = "SUBMENUNAME")
    private String submenuname;
    @JoinColumn(name = "MENUID", referencedColumnName = "MENUID")
    @ManyToOne
    private Menu menuid;
    @OneToMany(mappedBy = "submenuid")
    private List<Dish> dishList;

    public Submenu() {
    }

    public Submenu(Integer submenuid) {
        this.submenuid = submenuid;
    }

    public Integer getSubmenuid() {
        return submenuid;
    }

    public void setSubmenuid(Integer submenuid) {
        this.submenuid = submenuid;
    }

    public String getSubmenuname() {
        return submenuname;
    }

    public void setSubmenuname(String submenuname) {
        this.submenuname = submenuname;
    }

    public Menu getMenuid() {
        return menuid;
    }

    public void setMenuid(Menu menuid) {
        this.menuid = menuid;
    }

    @XmlTransient
    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submenuid != null ? submenuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submenu)) {
            return false;
        }
        Submenu other = (Submenu) object;
        if ((this.submenuid == null && other.submenuid != null) || (this.submenuid != null && !this.submenuid.equals(other.submenuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Submenu[ submenuid=" + submenuid + " ]";
    }
    
}
