/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import edu.iit.sat.itmd4515.vblancoravena.security.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;

/**
 *
 * @author virginiablancoravena
 */
@Entity
@NamedQuery(name = "Buyer.findAll", query = "select buyer from Buyer buyer")
@NamedQuery(name = "Buyer.findByUsername", query = "select buyer from Buyer buyer where buyer.user.userName = :username")
public class Buyer extends AbstractEntity {

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

    //bi-directional relationship with Sale
    @OneToMany(mappedBy = "buyer")
    private List<Sale> sales = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    public Buyer() {
    }

    public Buyer(String firstName, String lastName, LocalDate birthday, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
//        this.password = password;
        this.address = address;
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
    public void setbBirthday(LocalDate birthday) {
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

    @Override
    public String toString() {
//        return "Buyer{" + "buyerID=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", email=" + email + ", password=" + password + ", address=" + address + '}';
        return "Buyer{" + "buyerID=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", email=" + email + ", address=" + address + ", username=" + user  + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Buyer other = (Buyer) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
