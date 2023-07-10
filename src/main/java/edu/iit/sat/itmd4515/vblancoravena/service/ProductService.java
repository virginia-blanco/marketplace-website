/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.service;

import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.domain.Seller;
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
public class ProductService extends AbstractService<Product> {

    public ProductService() {
        super(Product.class);

    }
    private static final Logger LOG = Logger.getLogger(ProductService.class.getName());
        
    @Override
    public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public void saveProductForSeller(Product product, Seller seller) {
        em.persist(product);

        Seller managedSellerReference = em.getReference(Seller.class, seller.getId());

        managedSellerReference.addProduct(product);
        em.merge(managedSellerReference);
    }
    
    public Seller updateProduct(Product product, Seller seller) {
        LOG.info("Inside ProductService.updateProduct with product "+ product.toString());
        
        LOG.info("Inside ProductService.updateProduct with seller "+ seller.toString());
        Product managedProductReference = em.getReference(Product.class, product.getId());
        Seller managedSellerReference = em.getReference(Seller.class, seller.getId());
        
        
        for(Product p : managedSellerReference.getProducts()){
        LOG.info("************************************************Inside ProductService.updateProduct with managedSellerReference product list "+ p.toString()+ " ************************************************");
        }
        
        if (!managedProductReference.getName().equals(product.getName())) {
            managedProductReference.setName(product.getName());
        }
        
        if (!managedProductReference.getPrice().equals(product.getPrice())) {
            managedProductReference.setPrice(product.getPrice());
        }
        
        if (!managedProductReference.getMarketplace().equals(product.getMarketplace())) {
            managedProductReference.setMarketplace(product.getMarketplace());
        }
        
        if (!managedProductReference.getDepartment().equals(product.getDepartment())) {
            managedProductReference.setDepartment(product.getDepartment());
        }
        
        managedSellerReference.updateProduct(managedProductReference);
        em.merge(managedProductReference);
        em.merge(managedSellerReference);

        return managedSellerReference;

    }
    public void deleteProduct(Product product) {
        Product managedProductReference = em.getReference(Product.class, product.getId());
        
        em.remove(em.merge(managedProductReference));
    }
}
