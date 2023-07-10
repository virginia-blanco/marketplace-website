/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.web;

import edu.iit.sat.itmd4515.vblancoravena.domain.Buyer;
import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.domain.Sale;
import edu.iit.sat.itmd4515.vblancoravena.service.SaleService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author virginiablancoravena
 */
@Named
@RequestScoped
public class BuyerNewSaleController {

    private static final Logger LOG = Logger.getLogger(BuyerWelcomeController.class.getName());

    private Sale sale;

    @EJB
    private SaleService saleSvc;
    @Inject
    BuyerWelcomeController buyerWelcomeController;

    public BuyerNewSaleController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside BuyerNewSaleController.postConstruct");
        sale = new Sale();
    }

    public String saveSale(Product product) {
        LOG.info("Inside BuyerNewSaleController.saveSale with " + this.sale.toString());
        LOG.info("Inside BuyerNewSaleController.saveSale with " + product.toString());
        saleSvc.saveSaleForBuyerAndProduct(this.sale, buyerWelcomeController.getBuyer(), product);
        return "/buyer/createSaleConfirmation.xhtml";
    }
    
    public String giveSaleRate(Long productID) {
        LOG.info("Inside BuyerNewSaleController.giveSaleRate with " + sale.toString());
        
        saleSvc.giveSaleRate(sale);
        return "/buyer/welcome.xhtml";
    }

    /**
     * Get the value of sale
     *
     * @return the value of sale
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * Set the value of sale
     *
     * @param sale new value of sale
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }
}