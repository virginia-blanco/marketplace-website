/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.web;

import edu.iit.sat.itmd4515.vblancoravena.domain.Department;
import edu.iit.sat.itmd4515.vblancoravena.domain.Seller;
import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.domain.Sale;
import edu.iit.sat.itmd4515.vblancoravena.service.BuyerService;
import edu.iit.sat.itmd4515.vblancoravena.service.ProductService;
import edu.iit.sat.itmd4515.vblancoravena.service.SaleService;
import edu.iit.sat.itmd4515.vblancoravena.service.SellerService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author virginiablancoravena
 */
@Named
@RequestScoped
public class SellerWelcomeController {

    private static final Logger LOG = Logger.getLogger(SellerWelcomeController.class.getName());

    private Seller seller;
    private Product product;
    private Boolean showFacesMessage =false;

    @Inject
    LoginController loginController;
    @Inject
    SellerNewProductController sellerProductController;
    @Inject
    FacesContext facesContext;
    @EJB
    SellerService sellerSvc;
    @EJB
    private ProductService productSvc;
    @EJB
    private SaleService saleSvc;
    @EJB
    private BuyerService buyerSvc;
    
    public SellerWelcomeController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside SellerWelcomeController.postConstruct");
        seller = sellerSvc.findByUsername(loginController.getAuthenticatedUser());
        product = new Product();
        LOG.info("Leaving SellerWelcomeController.postConstruct with" + seller.toString());
    }
   

    public String displayCreateProductPage(Product product){
        this.product=product;
        LOG.info("Inside SellerWelcomeController.displayCreateProductPage with product " + this.product.toString());
        return "/seller/createProduct.xhtml";
    }
    
    public String displayReadProductPage(Product product){
        this.product=product;
        LOG.info("Inside SellerWelcomeController.displayReadProductPage with product " + this.product.toString());
        return "/seller/readProduct.xhtml";
    }
    
    public String displayUpdateProductPage(Product product){
        this.product=product;
        LOG.info("Inside SellerWelcomeController.displayUpdateProductPage with product " + this.product.toString());
        return "/seller/updateProduct.xhtml";
    }
    
    public String displayDeleteProductPage(Product product){
        this.product=product;
        LOG.info("Inside SellerWelcomeController.displayDeleteProductPage with product " + this.product.toString());
        return "/seller/deleteProduct.xhtml";
    }
    
    
    public Department[] getAllDeparments() {
        return Department.values();

    }
    
//    public String executeUpdateProductButton(Product product){
//        this.product=product;
//        LOG.info("Inside SellerWelcomeController.displayUpdateProductPage with product " + this.product.toString());
//        return "/seller/updateProduct.xhtml";
//    }
    
    public String executeUpdateProductButton(){
        LOG.info("Inside SellerWelcomeController.executeUpdateProductButton with product " + this.product.toString());
        
//        facesContext.addMessage(null, new FacesMessage(
//                FacesMessage.SEVERITY_INFO,
//                "Success!",
//                "Product " + this.product.getName() + " updated."));
//        this.showFacesMessage=true;
//        
       this.seller = productSvc.updateProduct(this.product, this.seller);
//       sellerProductController.setProduct(this.product);
        
        return "/seller/welcome.xhtml";
    }
    
    public String executeDeleteProductButton() {
        LOG.info("Inside SellerWelcomeController.deleteProduct with product " + this.product.toString());
        sellerSvc.deleteProduct(this.seller, this.product);
        List<Sale> sales = new ArrayList<>();
        sales = saleSvc.findByProduct(this.product.getId());
        saleSvc.deleteProduct(sales);
        productSvc.deleteProduct(this.product);
        seller.removeProduct(this.product);
        return "/seller/welcome.xhtml";
    }

    /**
     * Get the value of seller
     *
     * @return the value of seller
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Set the value of seller
     *
     * @param seller new value of seller
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
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

    /**
     * Get the value of showFacesMessage
     *
     * @return the value of showFacesMessage
     */
    public Boolean isShowFacesMessage() {
        return showFacesMessage;
    }

    /**
     * Set the value of showFacesMessage
     *
     * @param showFacesMessage new value of showFacesMessage
     */
    public void setShowFacesMessage(Boolean showFacesMessage) {
        this.showFacesMessage = showFacesMessage;
    }

}
