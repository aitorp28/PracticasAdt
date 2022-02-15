/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aitor
 */
@NamedQueries({
    
    @NamedQuery(name="findByCantMuertos", query="SELECT a FROM Accidente a WHERE a.herido=:herido"),
    
    
})
@Entity
@Table(name="Accidente", schema="pruebaadt")
@XmlRootElement
public class Accidente implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String ubicacion;
    private Integer herido;
    private Integer muerto;
    
    //No entiendo por que aqui es coches y en coches accidentes
    @OneToMany(cascade = ALL, mappedBy="accidente")
    private List<CocheAccidente> coches;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getHeridos() {
        return herido;
    }

    public void setHeridos(Integer heridos) {
        this.herido = heridos;
    }

    public Integer getMuertos() {
        return muerto;
    }

    public void setMuertos(Integer muertos) {
        this.muerto = muertos;
    }

    @XmlTransient
    public List<CocheAccidente> getCoches() {
        return coches;
    }

    public void setCoches(List<CocheAccidente> coches) {
        this.coches = coches;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.ubicacion);
        hash = 41 * hash + Objects.hashCode(this.herido);
        hash = 41 * hash + Objects.hashCode(this.muerto);
        hash = 41 * hash + Objects.hashCode(this.coches);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accidente other = (Accidente) obj;
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.herido, other.herido)) {
            return false;
        }
        if (!Objects.equals(this.muerto, other.muerto)) {
            return false;
        }
        if (!Objects.equals(this.coches, other.coches)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Accidente{" + "id=" + id + ", ubicacion=" + ubicacion + ", heridos=" + herido + ", muertos=" + muerto + ", coches=" + coches + '}';
    }
}
