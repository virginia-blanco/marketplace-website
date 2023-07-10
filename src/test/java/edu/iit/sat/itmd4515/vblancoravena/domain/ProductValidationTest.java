/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

import java.util.Set;
import javax.validation.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author virginiablancoravena
 */
public class ProductValidationTest {
    private static Validator validator;
 /**
 *
 * Get the validator from the validation package one time, at class
 * initialization before any test methods fire
 */
    
    @BeforeAll
    public static void beforeAll(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @BeforeEach
    public void beforeEach(){
    }
    //String code,String name,String continent,String region,Double surfaceArea,int indepYear,Integer population,double lifeExpectancy,double GNP,double GNPOld,String localName,String governmentForm,String headOfState,int capital,String code2

    @Test
    public void nameIsBlanck(){

        Product test = new Product();
        test.setName("");
        test.setPrice(1.1);
        test.setMarketplace("ESP");
        test.setDepartment(Department.FOOD_GLOCERY);
        
        validator.validate(test);
        
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(test);
        for (ConstraintViolation<Product> constraintViolation: constraintViolations){
                    System.out.println(constraintViolation.toString());
                }
        assertEquals(1, constraintViolations.size());
        assertEquals("Name is required",constraintViolations.iterator().next().getMessage());
    }

    public void priceIsPositive(){
        Product test = new Product();
        test.setName("a");
        test.setPrice(-1.1);
        test.setMarketplace("ESP");
        test.setDepartment(Department.FOOD_GLOCERY);
        
        validator.validate(test);
        
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(test);

        assertEquals(1, constraintViolations.size());
        assertEquals("debe ser menor que 0",constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void priceIsNull(){

        Product test = new Product();
        test.setName("a");
        test.setMarketplace("ESP");
        test.setDepartment(Department.FOOD_GLOCERY);
        
        validator.validate(test);
        
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(test);

        assertEquals(1, constraintViolations.size());
        assertEquals("Price is required",constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void marketplaceIDIsBlanck(){

        Product test = new Product();
        test.setName("a");
        test.setPrice(1.1);
        test.setDepartment(Department.FOOD_GLOCERY);
        
        validator.validate(test);
        
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(test);

        assertEquals(1, constraintViolations.size());
        assertEquals("Marketplace is required",constraintViolations.iterator().next().getMessage());
    }    
    
    @AfterEach
    public void afterEach(){
    }
    
    @AfterAll
    public static void afterAll(){
    }
}
