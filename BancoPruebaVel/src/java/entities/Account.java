/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginBalanceTimestamp;
    private AccountType type;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.description);
        hash = 11 * hash + Objects.hashCode(this.balance);
        hash = 11 * hash + Objects.hashCode(this.creditLine);
        hash = 11 * hash + Objects.hashCode(this.beginBalance);
        hash = 11 * hash + Objects.hashCode(this.beginBalanceTimestamp);
        hash = 11 * hash + Objects.hashCode(this.type);
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
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", type=" + type + '}';
    }
    
    
}
