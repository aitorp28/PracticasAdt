/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aitor
 */
@NamedQueries({
    @NamedQuery(name="findConductorBySexo", query="SELECT c FROM Conductor c WHERE c.sexo=:sexo"),
})

@Entity
@Table(name="CONDUCTOR", schema="pruebaexamen")
@XmlRootElement
public class Conductor implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private Integer edad;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @ManyToOne
    private Coche coche;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.edad);
        hash = 17 * hash + Objects.hashCode(this.sexo);
        hash = 17 * hash + Objects.hashCode(this.coche);
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
        final Conductor other = (Conductor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.coche, other.coche)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conductor{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", coche=" + coche + '}';
    }
    
    
    
}
