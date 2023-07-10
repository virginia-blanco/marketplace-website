/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.service;

import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.domain.Seller;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author virginiablancoravena
 */
@Named
@Stateless 
public class SellerService{
    
    @PersistenceContext(name="itmd4515PU")
    private EntityManager em;
    
    public SellerService(){
     }
    
    public void create(Seller seller){
        em.persist(seller);
    }
    public Seller read(Long id){
        return em.find(Seller.class, id);
    }
    public void update(Seller seller){
        em.merge(seller);
    }
    public void delete(Seller seller){
        em.remove(em.merge(seller));
    }
    public List<Seller> findAll(){
        return em.createNamedQuery("Seller.findAll", Seller.class).getResultList();
    }
 
    public Seller findByUsername(String username){
        return em
                .createNamedQuery("Seller.findByUsername", Seller.class)
                .setParameter("username", username)
                .getSingleResult();
    } 
    public void deleteProduct(Seller seller, Product product){
        Seller managedSellerReference = em.getReference(Seller.class, seller.getId());
        Product managedProductReference = em.getReference(Product.class, product.getId());
        managedSellerReference.removeProduct(managedProductReference);
        em.merge(managedSellerReference);
    } 
}
