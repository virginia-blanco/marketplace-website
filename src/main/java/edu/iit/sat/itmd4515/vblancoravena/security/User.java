/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.security;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author virginiablancoravena
 */
@Entity
@Table(name= "sec_user")
@EntityListeners(UserListener.class)
@NamedQuery(name="User.findAll",query="select u from User u")
public class User {

    @Id
    @NotBlank(message="Username is required")
    private String userName;
    @NotBlank(message="Password is required")
    private String password;
    private Boolean enabled;
    
    @ManyToMany
    @JoinTable(name="sec_user_groups", 
            joinColumns = @JoinColumn(name="USERNAME"), 
            inverseJoinColumns = @JoinColumn(name="GROUPNAME"))
    private List<Group> groups = new ArrayList<>();
    
    public User() {
    }

    public User(String userName, String password, Boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }
    
    public void addGroup(Group group){
        if (!this.groups.contains(group)) {
            this.groups.add(group);
        }
        if (!group.getUsers().contains(this)) {
            group.getUsers().add(this);
        }        
    }
    
    public void removeGroup(Group group){
        if (this.groups.contains(group)) {
            this.groups.remove(group);
        }
        if (group.getUsers().contains(this)) {
            group.getUsers().remove(this);
        }
    }
    
    
    /**
     * Get the value of groups
     *
     * @return the value of groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Set the value of groups
     *
     * @param groups new value of groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Get the value of enabled
     *
     * @return the value of enabled
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Set the value of enabled
     *
     * @param enabled new value of enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
}
