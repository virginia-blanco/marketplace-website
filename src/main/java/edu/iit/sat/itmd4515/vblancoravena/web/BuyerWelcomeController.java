/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.web;

import edu.iit.sat.itmd4515.vblancoravena.domain.Buyer;
import edu.iit.sat.itmd4515.vblancoravena.service.BuyerService;
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
public class BuyerWelcomeController {

    private static final Logger LOG = Logger.getLogger(BuyerWelcomeController.class.getName());

    private Buyer buyer;

    @Inject
    LoginController loginController;
    @EJB
    BuyerService buyerSvc;

    public BuyerWelcomeController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside BuyerWelcomeController.postConstruct");
        buyer = buyerSvc.findByUsername(loginController.getAuthenticatedUser());
        LOG.info("Leaving BuyerWelcomeController.postConstruct with" + buyer.toString());
    }

    /**
     * Get the value of buyer
     *
     * @return the value of buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Set the value of buyer
     *
     * @param buyer new value of buyer
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

}
