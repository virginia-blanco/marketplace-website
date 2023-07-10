/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import edu.iit.sat.itmd4515.vblancoravena.domain.Department;
import java.time.LocalDate;
import java.util.*;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author virginiablancoravena
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "select product from Product product")
public class Product extends AbstractEntity {

    @NotBlank(message = "Name is required")
    private String name;
    @Positive
    @NotNull(message = "Price is required")
    private Double price;
    @NotNull(message = "Marketplace is required")
    @Size(min = 3, max = 3)
    private String marketplace;
    @Enumerated(EnumType.STRING)
    private Department department;
    private Double salesRatesAvg;
    
    //bi-directional relationship with Seller
    //Seller owning side 
    @ManyToMany(mappedBy = "products")
    private List<Seller> sellers = new ArrayList<>();

    //bi-directional relationship with Sale
    //Sale owning side 
    @OneToMany(mappedBy = "product")
    private List<Sale> sales = new ArrayList<>();
    
    

    public Product() {
        this.salesRatesAvg=0.0;
    }

    
    public Product(String name, Double price, String marketplace, Department department) {
        this.name = name;
        this.price = price;
        this.marketplace = marketplace;
        this.department = department;
        this.salesRatesAvg=0.0;
    }

    public void updateSales(Sale newSale) {
        if (!this.getSales().contains(newSale)) {
            this.getSales().add(newSale);
        }

        Double count_avg = 0.0;
        for (Sale sale : sales) {
            if (sale.getRate() == null) {
                continue;
            }
            count_avg += sale.getRate();
        }
        
        this.salesRatesAvg = Math.round(count_avg / sales.size() * 100.0) / 100.0;
        
    }
    
    /**
     * Get the value of salesRatesAvg
     *
     * @return the value of salesRatesAvg
     */
    public Double getSalesRatesAvg() {
        return salesRatesAvg;
    }

    /**
     * Set the value of salesRatesAvg
     *
     * @param salesRatesAvg new value of salesRatesAvg
     */
    public void setSalesRatesAvg(Double salesRatesAvg) {
        this.salesRatesAvg = salesRatesAvg;
    }

    /**
     * Get the value of sales
     *
     * @return the value of sales
     */
    public List<Sale> getSales() {
        return sales;
    }

    /**
     * Set the value of sales
     *
     * @param sale new value of sales
     */
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    /**
     * Get the value of department
     *
     * @return the value of department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Set the value of department
     *
     * @param department new value of department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Get the value of marketplace
     *
     * @return the value of marketplace
     */
    public String getMarketplace() {
        return marketplace;
    }

    /**
     * Set the value of marketplace
     *
     * @param marketplace new value of marketplace
     */
    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of seller
     *
     * @return the value of seller
     */
    public List<Seller> getSellers() {
        return sellers;
    }

    /**
     * Set the value of seller
     *
     * @param seller new value of seller
     */
    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + id + ", name=" + name + ", price=" + price + ", marketplace=" + marketplace + ", department=" + department +", salesRatesAvg="+salesRatesAvg+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Product other = (Product) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
