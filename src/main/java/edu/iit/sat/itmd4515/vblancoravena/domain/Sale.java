/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author virginiablancoravena
 */
@Entity
@NamedQuery(name = "Sale.findAll", query = "select sale from Sale sale")
@NamedQuery(name = "Sale.findByProduct", query = "select sale from Sale sale where sale.product.id = :productId")
public class Sale extends AbstractEntity {

    @Max(5)
    @Min(1)
    private Integer rate;
    private LocalDate dateCreated;

    //bi-directional relationship with Buyer
    //Sale owning side 
    @ManyToOne
    private Buyer buyer;
    //bi-didirectional relationship with Product
    //Sale owning side 
    @ManyToOne
    private Product product;

    public Sale() {
        this.dateCreated = LocalDate.now();
    }

    public Sale(Integer rate) {
        this.rate = rate;
        this.dateCreated = LocalDate.now();
    }
    
    public void addThisSaletoBuyerandProduct(Buyer buyer, Product product) { 
        if (!buyer.getSales().contains(this)) {
            buyer.getSales().add(this);
        }
        this.buyer = buyer;
        if (!product.getSales().contains(this)) {
            product.getSales().add(this);
        }
        
        product.updateSales(this);
        this.product = product;
    }

    /**
     * Get the value of dateCreated
     *
     * @return the value of dateCreated
     */
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    /**
     * Set the value of dateCreated
     *
     * @param dateCreated new value of dateCreated
     */
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Get the value of rate
     *
     * @return the value of rate
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * Set the value of rate
     *
     * @param rate new value of rate
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the value of buyer
     *
     * @return the value of buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Set the value of buyer
     *
     * @param buyer new value of buyer
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
      return "Sale{" + "saleID=" + id + ", rate=" + rate + ", dateCreated=" + dateCreated + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Sale other = (Sale) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
