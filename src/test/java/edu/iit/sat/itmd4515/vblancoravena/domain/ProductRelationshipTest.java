/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author virginiablancoravena
 */
public class ProductRelationshipTest extends AbstractJPATest{

//    @Test
//    public void testManyToManyBiDirSellerProductRelationship(){
//       
//        Product test_product = new Product("art_product",1.0, "ESP",Department.ART);
//        Seller test_seller = new Seller("seller_name","seller_lastname",LocalDate.of(1997, 3, 19),"seller@seller.com", "1234","Madrid, Spain");
//        System.out.println("product: " + test_product.toString());
//        System.out.println("seller: " + test_seller.toString());
//        
//        //example 2 nothing happends
//        //test_product.getSellers().add(test_seller);
//        
//        //example 3. When it is the owning side works
////        test_seller.getProducts().add(test_product);
//        
//        //solo data en el owning:
////        System.out.println("Navingating the relationship from the owing side" + test_seller.getProducts().toString());
////        System.out.println("Navingating the relationship from the inverse side" + test_product.getSellers().toString());
//        
//        
//        //example 4. 
////        test_seller.getProducts().add(test_product);
////        test_product.getSellers().add(test_seller);
//
//        test_seller.addProduct(test_product);
//        
//        
//        tx.begin();
//        em.persist(test_product);
//        em.persist(test_seller);
//        tx.commit();
//        
//        System.out.println("Navingating the relationship from the owing side" + test_seller.getProducts().toString());
//        System.out.println("Navingating the relationship from the inverse side" + test_product.getSellers().toString());
//        
//        //assert success
//        assertTrue(test_seller.getProducts().size() == 1);
//        assertTrue(test_product.getSellers().size() == 1);
//        
//        
//        tx.begin();
//        test_seller.removeProduct(test_product);
//        em.remove(test_product);
//        em.remove(test_seller);
//        tx.commit();
//
//        System.out.println("Navigating the relationship from the owning side" + test_seller.getProducts().toString());
//        System.out.println("Navigating the relationship from the inverse side" + test_product.getSellers().toString());
//    }
    
//    @Test
//    public void testManyToOneUniDirSaleProductRelationship(){
//        
//        //(Long buyerID, Long productID, Integer rate) 
//        Buyer test_buyer = new Buyer("buyer_name","buyer_lastname",LocalDate.of(1997, 3, 19),"buyer@buyer.com", "1234","Madrid, Spain");
//        Sale test_sale1 = new Sale(2);
//        Product test_product1 = new Product("art_product1",1.0, "ESP",Department.ART);
//        Sale test_sale2 = new Sale(3);
//        Product test_product2 = new Product("art_product2",1.0, "ESP",Department.ART);
//        
//        test_sale1.setProduct(test_product1);
//        test_sale1.addThisSaletoBuyer(test_buyer);
//        
//        test_sale2.setProduct(test_product2);
//        test_sale2.addThisSaletoBuyer(test_buyer);
//        
//        System.out.println("test_product1: " + test_product1.toString());
//        System.out.println("test_sale1: " + test_sale1.toString());
//        System.out.println("test_product2: " + test_product2.toString());
//        System.out.println("test_sale2: " + test_sale2.toString());
//        System.out.println("test_buyer: " + test_buyer.toString());
//        
//        //bi-directional
//        assertTrue(test_buyer.getSales().size() == 2);
//        //unidirectional
//        assertNotNull(test_sale1.getProduct());
//        assertNotNull(test_sale2.getProduct());
//        
//    }
}
