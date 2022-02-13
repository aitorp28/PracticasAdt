/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aitor
 */
@Entity
@Table(name="CocheAccidente", schema="pruebaadt")
@XmlRootElement

public class CocheAccidente implements Serializable{
    
    
    @EmbeddedId
    private CocheAccidenteId idcocheaccidente;
    @MapsId("cocheid")
    @ManyToOne
    private Coche coche;
    @MapsId("accidenteid")
    @ManyToOne
    private Accidente accidente;

    @Override
    public String toString() {
        return "CocheAccidente{" + "idcocheaccidente=" + idcocheaccidente + ", coche=" + coche + ", accidente=" + accidente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idcocheaccidente);
        hash = 79 * hash + Objects.hashCode(this.coche);
        hash = 79 * hash + Objects.hashCode(this.accidente);
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
        final CocheAccidente other = (CocheAccidente) obj;
        if (!Objects.equals(this.idcocheaccidente, other.idcocheaccidente)) {
            return false;
        }
        if (!Objects.equals(this.coche, other.coche)) {
            return false;
        }
        if (!Objects.equals(this.accidente, other.accidente)) {
            return false;
        }
        return true;
    }

    public CocheAccidenteId getIdcocheaccidente() {
        return idcocheaccidente;
    }

    public void setIdcocheaccidente(CocheAccidenteId idcocheaccidente) {
        this.idcocheaccidente = idcocheaccidente;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Accidente getAccidente() {
        return accidente;
    }

    public void setAccidente(Accidente accidente) {
        this.accidente = accidente;
    }
}
