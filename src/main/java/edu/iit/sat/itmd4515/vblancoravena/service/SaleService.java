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
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author virginiablancoravena
 */
@Named
@Stateless
public class SaleService extends AbstractService<Sale> {

    private static final Logger LOG = Logger.getLogger(SaleService.class.getName());

    
    
    public SaleService() {
        super(Sale.class);

    }

    @Override
    public List<Sale> findAll() {
        return em.createNamedQuery("Sale.findAll", Sale.class).getResultList();
    }

    public void saveSaleForBuyerAndProduct(Sale sale, Buyer buyer, Product product) {
        LOG.info("Inside SaleService.saveSaleForBuyerAndProduct with buyer " + buyer.toString());
        LOG.info("Inside SaleService.saveSaleForBuyerAndProduct with product " + product.toString());
        Buyer managedBuyerReference = em.getReference(Buyer.class, buyer.getId());
        Product managedProductReference = em.getReference(Product.class, product.getId());
        LOG.info("Inside SaleService.saveSaleForBuyerAndProduct with managedBuyerReference " + managedBuyerReference.toString());
        LOG.info("Inside SaleService.saveSaleForBuyerAndProduct with managedProductReference " + managedProductReference.toString());
        sale.addThisSaletoBuyerandProduct(managedBuyerReference, managedProductReference); 
        em.persist(sale);
        
        em.merge(managedBuyerReference);
        em.merge(managedProductReference);
    }
    
    

    public void giveSaleRate(Sale sale) {
        LOG.info("Inside SaleService.giveSaleRate with " + sale.toString());

        Sale managedSaleReference = em.getReference(Sale.class, sale.getId());
        
        Product managedProductReference = em.getReference(Product.class, managedSaleReference.getProduct().getId());

        managedSaleReference.setRate(sale.getRate());

        managedProductReference.updateSales(managedSaleReference);

        em.merge(managedSaleReference);
        em.merge(managedProductReference);
    }
    
        
    public List<Sale> findByProduct(Long productId ){
        LOG.info("Inside SaleService.findByProduct with productId: " + productId);
        return em
                .createNamedQuery("Sale.findByProduct", Sale.class)
                .setParameter("productId", productId)
                .getResultList();
    }
    
    public void deleteProduct(List<Sale> sales){
        for (Sale sale: sales) {
            this.delete(sale);
        }
    }
    
}
