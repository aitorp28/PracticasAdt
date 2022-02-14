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
@Table(name="VENTA", schema="pruebaadt2")
@XmlRootElement
public class Venta implements Serializable{
    
    @EmbeddedId
    private VentaId ventaid;
    private Float precio;
    @MapsId("vendedorid")
    @ManyToOne
    private Vendedor vendedor;
    @MapsId("compradorid")
    @ManyToOne  
    private Comprador comprador;
    @MapsId("productoid")
    @ManyToOne  
    private Producto producto;

    public VentaId getVentaid() {
        return ventaid;
    }

    public void setVentaid(VentaId ventaid) {
        this.ventaid = ventaid;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.ventaid);
        hash = 17 * hash + Objects.hashCode(this.precio);
        hash = 17 * hash + Objects.hashCode(this.vendedor);
        hash = 17 * hash + Objects.hashCode(this.comprador);
        hash = 17 * hash + Objects.hashCode(this.producto);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.ventaid, other.ventaid)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        if (!Objects.equals(this.comprador, other.comprador)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "ventaid=" + ventaid + ", precio=" + precio + ", vendedor=" + vendedor + ", comprador=" + comprador + ", producto=" + producto + '}';
    }

   
    
}
