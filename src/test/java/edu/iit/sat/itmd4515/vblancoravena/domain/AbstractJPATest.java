/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import java.util.logging.Logger;
import javax.persistence.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author virginiablancoravena
 */
public class AbstractJPATest {
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @BeforeEach
    public void beforeEach(){
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
//     @Test
//    public void createTest(){
//    }

    @AfterEach
    public void afterEach(){

    }
    
    @AfterAll
    public static void afterAll(){
        emf.close();
    }
}
