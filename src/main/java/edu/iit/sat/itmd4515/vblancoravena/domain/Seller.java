/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import edu.iit.sat.itmd4515.vblancoravena.security.User;
import java.time.LocalDate;
import java.util.*;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author virginiablancoravena
 */
@Entity
@NamedQuery(name = "Seller.findAll", query = "select seller from Seller seller")
@NamedQuery(name = "Seller.findByUsername", query = "select seller from Seller seller where seller.user.userName = :username")
public class Seller extends AbstractEntity {

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Birthday is required")
    @PastOrPresent(message = "Birthday has to be in the past")
    private LocalDate birthday;
    @NotBlank(message = "Email is required")
    @Email(message = "Email field must have email shape")
    private String email;
//    @NotBlank(message = "Password is required")
//    private String password;

    private String address;
    //bi-directional relationship with Product
    //Seller owning side 
    @ManyToMany
    @JoinTable(name = "SELLER_PRODUCTS",
            joinColumns = @JoinColumn(name = "sellers_SELLERID"),
            inverseJoinColumns = @JoinColumn(name = "products_PRODUCTID"))
    private List<Product> products = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    public Seller() {
    }

    public Seller(String firstName, String lastName, LocalDate birthday, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
//        this.password = password;
        this.address = address;
    }

    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
        if (!product.getSellers().contains(this)) {
            product.getSellers().add(this);
        }
    }

    public void removeProduct(Product product) {
//        for (Product p : this.products){
//            if (p.getId() == product.getId()){
//                LOG.info("Inside Seller.removeProduct " + p.toString());
//                this.products.remove(p);
//            }
//        }
//        for (Seller s : product.getSellers()){
//            if (s.getId() == this.getId()){
//                LOG.info("Inside Seller.removeProduct " + s.toString());
//                this.products.remove(this);
//            }
//        }
        
        if (this.products.contains(product)) {
            this.products.remove(product);
        }
        if (product.getSellers().contains(this)) {
            product.getSellers().remove(this);
        }
    }
    private static final Logger LOG = Logger.getLogger(Seller.class.getName());
    
    public void updateProduct(Product product) {
        LOG.info("Inside Seller.updateProduct with new product " + product.toString());
        int index = 0;
        for (Product p : this.products) {
            LOG.info("========> Inside Seller.updateProduct with products old list" + p.toString());
            if (p.id == product.id) {
                LOG.info("Inside Seller.updateProduct with old product " + p.toString());
                this.products.set(index, product);
            }
            index +=1;
        }
        for (Product p : this.products) {
            LOG.info("========> Inside Seller.updateProduct with products new list" + p.toString());
        }
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the value of birthday
     *
     * @return the value of birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Set the value of birthday
     *
     * @param birthday new value of birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

//    /**
//     * Get the value of password
//     *
//     * @return the value of password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * Set the value of password
//     *
//     * @param password new value of password
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the value of products
     *
     * @return the value of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Set the value of products
     *
     * @param products new value of products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
//        return "Seller{" + "sellerID=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", email=" + email + ", password=" + password + ", address=" + address + '}';
        return "Seller{" + "sellerID=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", email=" + email + ", address=" + address+ ", username=" + user + '}';

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Seller other = (Seller) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
