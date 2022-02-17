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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aitor
 */
@NamedQueries({
    @NamedQuery(name="findCocheByAccidente", query="SELECT a.coche FROM CocheAccidente a WHERE a.accidente.id=:numero"),
    @NamedQuery(name="finddeUnCocheQueAccidentes", query="SELECT a.accidente FROM CocheAccidente a WHERE a.coche.id=:numero1"),
})
@Entity
@Table(name="COCHEACCIDENTE", schema="pruebaexamen")
@XmlRootElement
public class CocheAccidente implements Serializable{
 
    @EmbeddedId
    private CocheAccidenteId idCocheAccidente;
    
    @MapsId("cocheId")
    @ManyToOne
    private Coche coche;
    
    
    @MapsId("accidenteId")
    @ManyToOne
    private Accidente accidente;

    public CocheAccidenteId getIdCocheAccidente() {
        return idCocheAccidente;
    }

    public void setIdCocheAccidente(CocheAccidenteId idCocheAccidente) {
        this.idCocheAccidente = idCocheAccidente;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idCocheAccidente);
        hash = 31 * hash + Objects.hashCode(this.coche);
        hash = 31 * hash + Objects.hashCode(this.accidente);
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
        if (!Objects.equals(this.idCocheAccidente, other.idCocheAccidente)) {
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

    @Override
    public String toString() {
        return "CocheAccidente{" + "idCocheAccidente=" + idCocheAccidente + ", coche=" + coche + ", accidente=" + accidente + '}';
    }
    
    
    
}
