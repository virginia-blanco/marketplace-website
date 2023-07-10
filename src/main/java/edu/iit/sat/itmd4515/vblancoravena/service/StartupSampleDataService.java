/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.service;

import edu.iit.sat.itmd4515.vblancoravena.domain.Buyer;
import edu.iit.sat.itmd4515.vblancoravena.domain.Department;
import edu.iit.sat.itmd4515.vblancoravena.domain.Product;
import edu.iit.sat.itmd4515.vblancoravena.domain.Sale;
import edu.iit.sat.itmd4515.vblancoravena.domain.Seller;
import edu.iit.sat.itmd4515.vblancoravena.security.Group;
import edu.iit.sat.itmd4515.vblancoravena.security.GroupService;
import edu.iit.sat.itmd4515.vblancoravena.security.User;
import edu.iit.sat.itmd4515.vblancoravena.security.UserService;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author virginiablancoravena
 */
@Startup
@Singleton
public class StartupSampleDataService {

    private static final Logger LOG = Logger.getLogger(StartupSampleDataService.class.getName());

    //rather than invoking em directly, we will use our service classes in the code that calls our services
//    @PersistenceContext(name="itmd4515PU")
//    private EntityManager em;
    @EJB
    private SellerService sellerSvc;
    @EJB
    private ProductService productSvc;
    @EJB
    private BuyerService buyerSvc;
    @EJB
    private SaleService saleSvc;
    @EJB
    private UserService userSvc;
    @EJB
    private GroupService groupSvc;

    public StartupSampleDataService() {
    }

    @PostConstruct
    private void postConstruct() {
        //app never instantiating this class
        //never calling StartupSampleDataService foo == StartupSampleDataService(); payara container do that,
        // so we should not rely on the contructor because we don't construct the instance
        LOG.info("Inside the StartupSampleDataService.postConstruct method");
        
        Group buyerGroup = new Group("BUYER_GROUP", "It represents buyers in the identity store");
        Group sellerGroup = new Group("SELLER_GROUP", "It represents sellers in the identity store");
        Group adminGroup = new Group("ADMIN_GROUP", "It represents system administrators in the identity store");

        User admin = new User("admin", "admin", true);
        admin.addGroup(adminGroup);

        User userBuyer1 = new User("userBuyer1", "userBuyer1", true);
        userBuyer1.addGroup(buyerGroup);

        User userBuyer2 = new User("userBuyer2", "userBuyer2", true);
        userBuyer2.addGroup(buyerGroup);

        User userBuyer3 = new User("userBuyer3", "userBuyer3", true);
        userBuyer3.addGroup(buyerGroup);
        
        
        User userSeller1 = new User("userSeller1", "userSeller1", true);
        userSeller1.addGroup(sellerGroup);
        userSeller1.addGroup(adminGroup);

        User userSeller2 = new User("userSeller2", "userSeller2", true);
        userSeller2.addGroup(sellerGroup);
        
        User userSeller3 = new User("userSeller3", "userSeller3", true);
        userSeller3.addGroup(sellerGroup);
        userSeller3.addGroup(buyerGroup);
        
        User userSeller4 = new User("userSeller4", "userSeller4", true);
        userSeller4.addGroup(sellerGroup);
        userSeller4.addGroup(buyerGroup);
        
        User userSeller5 = new User("userSeller5", "userSeller5", true);
        userSeller5.addGroup(sellerGroup);

        User userSeller6 = new User("userSeller6", "userSeller6", true);
        userSeller6.addGroup(sellerGroup);
        
        groupSvc.create(buyerGroup);
        groupSvc.create(sellerGroup);
        groupSvc.create(adminGroup);

        userSvc.create(admin);
        
        userSvc.create(userBuyer1);
        userSvc.create(userBuyer2);
        userSvc.create(userBuyer3);
        
        userSvc.create(userSeller1);
        userSvc.create(userSeller2);
        userSvc.create(userSeller3);
        userSvc.create(userSeller4);
        userSvc.create(userSeller5);
        userSvc.create(userSeller6);


        //entity transaction no longer needed because the Startup Singleton Bean -> the method is transactional
        Seller seller1 = new Seller("Oliver", "Twist", LocalDate.of(1837, 2, 1), "oliver_twist@gmail.com", "123 Fake Street, London, Uk");
        Seller seller2 = new Seller("Bart", "Simpson", LocalDate.of(1981, 2, 23), "bart_simpson@gmail.com", "742 Evergreen Terrace, Sprindfield, IL, US");
        Seller seller3 = new Seller("Ash", "Ketchum", LocalDate.of(1987, 5, 22), "ash_ketchum@gmail.com", "123 Pallet Town, Pokemon World");
        Seller seller4 = new Seller("Pedro", "Sanchez", LocalDate.of(1972, 2, 29), "pedro_sanchez@president.com", "Moncloa Palace, Madrid, Spain");
        Seller seller5 = new Seller("Antonio", "Banderas", LocalDate.of(1960, 8, 10), "antonio_banderas@actor.com", "C/ Larios 30, Malaga, Spain");
        Seller seller6 = new Seller("Laura", "Pausini", LocalDate.of(1974, 5, 16), "lauus@singer.com", "Colosseum, Rome, Italy");


        seller1.setUser(userSeller1);
        seller2.setUser(userSeller2);
        seller3.setUser(userSeller3);
        seller4.setUser(userSeller4);
        seller5.setUser(userSeller5);
        seller6.setUser(userSeller6);
        
        Product product1 = new Product("Felix Felicis", 6.9, "GBR", Department.FOOD_GLOCERY);
        Product product2 = new Product("Golden Snitch", 17.9, "GBR", Department.SPORTS_OUTDOORS);
        Product product3 = new Product("Pokeball", 15.9, "JPN", Department.GAMES);
        Product product4 = new Product("Football", 20.9, "USA", Department.SPORTS_OUTDOORS);
        Product product5 = new Product("Sangria", 3.9, "ESP", Department.FOOD_GLOCERY);
        Product product6 = new Product("Bow Tie", 30.9, "ITA", Department.CLOTHING);

        seller1.addProduct(product1);
        seller1.addProduct(product2);
        seller3.addProduct(product3);
        seller2.addProduct(product4);
        seller4.addProduct(product5);
        seller5.addProduct(product5);
        seller6.addProduct(product6);

        Buyer buyer1 = new Buyer("Ratatouille", "TheMouse", LocalDate.of(2007, 2, 4), "rati@mouse.com", "Rue de Croissant, 75001 Paris, France");
        Buyer buyer2 = new Buyer("Robin", "Scherbatsky", LocalDate.of(1980, 7, 23), "r_scherbatsky@eporter.com", "327 Maple St, Toronto, Canada");
        Buyer buyer3 = new Buyer("Miley", "Cyrus", LocalDate.of(1992, 11, 23), "m_demaki@singer.com", "30 Beach St, Malibu, CA, US");

        
        buyer1.setUser(userBuyer1);
        buyer2.setUser(userBuyer2);
        buyer3.setUser(userBuyer3);
        
        Buyer buyer4 = new Buyer("Ash", "Ketchum", LocalDate.of(1987, 5, 22), "ash_ketchum@gmail.com", "123 Pallet Town, Pokemon World");
        Buyer buyer5 = new Buyer("Pedro", "Sanchez", LocalDate.of(1972, 2, 29), "pedro_sanchez@president.com", "Moncloa Palace, Madrid, Spain");

        buyer4.setUser(userSeller3);
        buyer5.setUser(userSeller4);

        
       
        Sale sale1 = new Sale(4);
        sale1.addThisSaletoBuyerandProduct(buyer1,product1);
        
        
        Sale sale2 = new Sale(5);
        sale2.addThisSaletoBuyerandProduct(buyer2,product1);

        Sale sale3 = new Sale(5);
        sale3.addThisSaletoBuyerandProduct(buyer3,product1);

        Sale sale4 = new Sale(3);
        sale4.addThisSaletoBuyerandProduct(buyer3,product3);

        Sale sale5 = new Sale(4);
        sale5.addThisSaletoBuyerandProduct(buyer2,product4);

        Sale sale6 = new Sale(2);
        sale6.addThisSaletoBuyerandProduct(buyer3,product4);

        Sale sale7 = new Sale(5);
        sale7.addThisSaletoBuyerandProduct(buyer1,product5);

        Sale sale8 = new Sale(4);
        sale8.addThisSaletoBuyerandProduct(buyer1,product6);

//        em.persist(seller1);
//        em.persist(seller2);
        sellerSvc.create(seller1);
        sellerSvc.create(seller2);
        sellerSvc.create(seller3);
        sellerSvc.create(seller4);
        sellerSvc.create(seller5);
        sellerSvc.create(seller6);

        
        productSvc.create(product1);
       
        productSvc.create(product2);
        productSvc.create(product3);
        productSvc.create(product4);
        productSvc.create(product5);
        productSvc.create(product6);

        buyerSvc.create(buyer1);
        buyerSvc.create(buyer2);
        buyerSvc.create(buyer3);
        buyerSvc.create(buyer4);
        buyerSvc.create(buyer5);

        saleSvc.create(sale1);
        saleSvc.create(sale2);
        saleSvc.create(sale3);
        saleSvc.create(sale4);
        saleSvc.create(sale5);
        saleSvc.create(sale6);
        saleSvc.create(sale7);
        saleSvc.create(sale8);

        for (Seller seller : sellerSvc.findAll()) {
            LOG.info("Seller ============> " + seller.toString());
            for (Product product : seller.getProducts()) {
                LOG.info("\t Product ============> " + product.toString());
            }
        }

        for (Buyer buyer : buyerSvc.findAll()) {
            LOG.info("Buyer ============> " + buyer.toString());
            for (Sale sale : buyer.getSales()) {
                LOG.info("\t Sale ============> " + sale.toString());
                LOG.info("\t\t Product ============> " + sale.getProduct().toString());
            }
        }
    }

}
