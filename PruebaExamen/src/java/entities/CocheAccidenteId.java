/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author aitor
 */
@Embeddable
public class CocheAccidenteId implements Serializable{
 
    
    private Integer cocheId;
    private Integer accidenteId;

    public Integer getCocheId() {
        return cocheId;
    }

    public void setCocheId(Integer cocheId) {
        this.cocheId = cocheId;
    }

    public Integer getAccidenteId() {
        return accidenteId;
    }

    public void setAccidenteId(Integer accidenteId) {
        this.accidenteId = accidenteId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.cocheId);
        hash = 89 * hash + Objects.hashCode(this.accidenteId);
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
        final CocheAccidenteId other = (CocheAccidenteId) obj;
        if (!Objects.equals(this.cocheId, other.cocheId)) {
            return false;
        }
        if (!Objects.equals(this.accidenteId, other.accidenteId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CocheAccidenteId{" + "cocheId=" + cocheId + ", accidenteId=" + accidenteId + '}';
    }
    
    
}

