/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aitor
 */
@Entity
@Table(name="ACCOUNT", schema="bankdb")
@XmlRootElement
public class Account implements Serializable{
   
    
    
     @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private Float balance;
    private Float creditLine;
    private Float beginBalance;
    private Date beginBalanceTimestamp;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    
    
    @OneToMany (cascade=ALL, mappedBy="account")
    private List<Movement> movements;
    
    @OneToMany (cascade=ALL, mappedBy="account")
    private List<CustomerAccount> customeraccounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Float creditLine) {
        this.creditLine = creditLine;
    }

    public Float getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(Float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public Date getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(Date beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @XmlTransient
    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @XmlTransient
    public List<CustomerAccount> getCustomeraccounts() {
        return customeraccounts;
    }

    public void setCustomeraccounts(List<CustomerAccount> customeraccounts) {
        this.customeraccounts = customeraccounts;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.balance);
        hash = 29 * hash + Objects.hashCode(this.creditLine);
        hash = 29 * hash + Objects.hashCode(this.beginBalance);
        hash = 29 * hash + Objects.hashCode(this.beginBalanceTimestamp);
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + Objects.hashCode(this.movements);
        hash = 29 * hash + Objects.hashCode(this.customeraccounts);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.creditLine, other.creditLine)) {
            return false;
        }
        if (!Objects.equals(this.beginBalance, other.beginBalance)) {
            return false;
        }
        if (!Objects.equals(this.beginBalanceTimestamp, other.beginBalanceTimestamp)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.movements, other.movements)) {
            return false;
        }
        if (!Objects.equals(this.customeraccounts, other.customeraccounts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", type=" + type + ", movements=" + movements + ", customeraccounts=" + customeraccounts + '}';
    }
    
    
    
}
