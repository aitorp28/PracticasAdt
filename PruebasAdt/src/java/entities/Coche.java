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
import javax.persistence.ManyToOne;
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
     @NamedQuery( name="listCarByMarca", query="SELECT c FROM Coche c WHERE c.marca=:marca"),
})
//Anotaciones paso 2
@Entity
@Table (name= "COCHE", schema="pruebaadt")
@XmlRootElement
public class Coche implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String marca;
    private Integer anio;
    private Integer kilometraje;
    
    @ManyToOne
    private Conductor conductor;
    
    
    @OneToMany ( cascade = ALL, mappedBy="coche")
    private List<CocheAccidente> accidentes;
     
     
     
     
    @XmlTransient
    public List<CocheAccidente> getAccidentes() {
        return accidentes;
    }

    public void setAccidentes(List<CocheAccidente> accidentes) {
        this.accidentes = accidentes;
    }
   

    public Integer getId() {
        return id;
    }
    
    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Coche{" + "id=" + id + ", marca=" + marca + ", anio=" + anio + ", kilometraje=" + kilometraje + ", conductor=" + conductor + '}';
    }

  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.anio);
        hash = 67 * hash + Objects.hashCode(this.kilometraje);
        hash = 67 * hash + Objects.hashCode(this.conductor);
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
        final Coche other = (Coche) obj;
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.anio, other.anio)) {
            return false;
        }
        if (!Objects.equals(this.kilometraje, other.kilometraje)) {
            return false;
        }
         if (!Objects.equals(this.conductor, other.conductor)) {
            return false;
        }
        return true;
    }
    
}
