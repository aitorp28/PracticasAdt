/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author aitor
 */



@Embeddable
public class VentaId implements Serializable{
    
    private Integer productoid;
    private Integer compradorid;
    private Integer vendedorid;

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public Integer getCompradorid() {
        return compradorid;
    }

    public void setCompradorid(Integer compradorid) {
        this.compradorid = compradorid;
    }

    public Integer getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(Integer vendedorid) {
        this.vendedorid = vendedorid;
    }
    
}
