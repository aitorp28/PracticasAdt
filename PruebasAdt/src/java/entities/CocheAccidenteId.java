/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author aitor
 */

@Embeddable
public class CocheAccidenteId implements Serializable{
    
    private Integer cocheid;
    private Integer accidenteid;

    public Integer getCocheid() {
        return cocheid;
    }

    public void setCocheid(Integer cocheid) {
        this.cocheid = cocheid;
    }

    public Integer getAccidenteid() {
        return accidenteid;
    }

    public void setAccidenteid(Integer accidenteid) {
        this.accidenteid = accidenteid;
    }
}
