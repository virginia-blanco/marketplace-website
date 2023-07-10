/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.web;

import edu.iit.sat.itmd4515.vblancoravena.domain.Department;
import edu.iit.sat.itmd4515.vblancoravena.domain.Seller;
import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.service.ProductService;
import edu.iit.sat.itmd4515.vblancoravena.service.SellerService;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author virginiablancoravena
 */
@Named
@RequestScoped
public class SellerNewProductController {

    private static final Logger LOG = Logger.getLogger(SellerNewProductController.class.getName());

    private Product product;

    @EJB
    private ProductService productSvc;
    @Inject
    SellerWelcomeController sellerWelcomeController;

    public SellerNewProductController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("ProductController.postConstruct");
        product = new Product();
    }

    //helper method
    public Department[] getAllDeparments() {
        return Department.values();

    }
    //Action methods

    public String saveProduct() {

        LOG.info("Inside saveProduct with " + this.product.toString());
        Seller s = sellerWelcomeController.getSeller();
        productSvc.saveProductForSeller(product, sellerWelcomeController.getSeller());
        s.addProduct(this.product);
        sellerWelcomeController.setSeller(s);
//        return "/seller/createProductConfirmation.xhtml";
        return "/seller/welcome.xhtml";
    }

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

}
