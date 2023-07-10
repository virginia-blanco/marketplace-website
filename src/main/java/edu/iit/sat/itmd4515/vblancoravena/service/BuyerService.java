/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.service;

import edu.iit.sat.itmd4515.vblancoravena.domain.Buyer;
import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.domain.Sale;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author virginiablancoravena
 */
@Named
@Stateless 
public class BuyerService extends AbstractService<Buyer>{
    public BuyerService(){
        super(Buyer.class);
        
     }
    
    @Override
    public List<Buyer> findAll() {
        return em.createNamedQuery("Buyer.findAll", Buyer.class).getResultList();
    }
    public Buyer findByUsername(String username){
        return em
                .createNamedQuery("Buyer.findByUsername", Buyer.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
