/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import edu.iit.sat.itmd4515.vblancoravena.domain.Product;

import javax.persistence.*;
import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author virginiablancoravena
 */
public class ProductJPATestDisabled extends AbstractJPATest{
    

//    @Test
//    public void createTest(){
//        Object createMe = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :NAME").setParameter("NAME", "a").getSingleResult();
//        System.out.println("createTest: " +((Product)createMe).toString());
//
//        assertEquals("a", ((Product)createMe).getName());
//        tx.begin();
//        em.remove(((Product)createMe));
//        tx.commit();
//        em.close();
//
//    }
//
//    @Test
//    public void readTest(){
//        Object readMe = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :NAME").setParameter("NAME", "a").getSingleResult();        
//        System.out.println("readTest: " +((Product)readMe).toString());
//        
//        assertEquals("a", ((Product)readMe).getName());
//        tx.begin();
//        em.remove(((Product)readMe));
//        tx.commit();
//        em.close();
//       
//    }
//
//    @Test
//    public void updateTest(){
//        Object udMe = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :NAME").setParameter("NAME", "a").getSingleResult();
//        System.out.println("updateTest1: " +((Product)udMe).toString());
//        
//        Product updateMe = ((Product)udMe);
//        System.out.println("updateTest2: " +updateMe.toString());
//        tx.begin();
//        updateMe.setDepartment(Department.CLOTHING);
//        tx.commit();
//        
//        Product compareMe = em.find(Product.class, updateMe.getProductID());
//
//        assertEquals(Department.CLOTHING, compareMe.getDepartment());
//        
//        tx.begin();
//        em.remove(updateMe);
//        tx.commit();
//        em.close();
//       
//    }
//
//    @Test
//    public void deleteTest(){
//        Object dMe = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :NAME").setParameter("NAME", "a").getSingleResult();
//        System.out.println("deleteTest1: " +((Product)dMe).toString());
//        
//        Product deleteMe = ((Product)dMe);
//        System.out.println("deleteTest2: " +deleteMe.toString());
//
//        assertNotNull(deleteMe.getProductID());
//
//        tx.begin();
//        em.remove(deleteMe);
//        tx.commit();
//        
//        Product doIReallyExistOrAmIDeleted = em.find(Product.class, deleteMe.getProductID());
//        assertNull(doIReallyExistOrAmIDeleted);
//        
//    }
    
}
