/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.demo;

import edu.iit.sat.itmd4515.vblancoravena.domain.*;
import java.time.LocalDate;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author virginiablancoravena
 */
public class Demo {
    public static void main (String ... args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        
        System.out.println("Hello, demo file");
        Product product1 = new Product();
        product1.setName("Felix Felicis");
        long l=1; 
        //product1.setSellerID(l);
        product1.setPrice(6.99);
        product1.setMarketplace("GBR");
        product1.setDepartment(Department.FOOD_GLOCERY);
        System.out.println(product1.toString());

    }
}
