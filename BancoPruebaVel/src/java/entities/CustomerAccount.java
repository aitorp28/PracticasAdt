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
@Table(name="CUSTOMERACCOUNT", schema="bankdb")
@XmlRootElement
public class CustomerAccount implements Serializable{
    
    @EmbeddedId
    private CustomerAccountId idCustomerAcount;
    
    @MapsId("accountid")
    @ManyToOne
    private Account account;
    
    @MapsId("customerid")
    @ManyToOne
    private Customer customer;

    public CustomerAccountId getIdCustomerAcount() {
        return idCustomerAcount;
    }

    public void setIdCustomerAcount(CustomerAccountId idCustomerAcount) {
        this.idCustomerAcount = idCustomerAcount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idCustomerAcount);
        hash = 29 * hash + Objects.hashCode(this.account);
        hash = 29 * hash + Objects.hashCode(this.customer);
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
        final CustomerAccount other = (CustomerAccount) obj;
        if (!Objects.equals(this.idCustomerAcount, other.idCustomerAcount)) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" + "idCustomerAcount=" + idCustomerAcount + ", account=" + account + ", customer=" + customer + '}';
    }
    
    
}
