package com.mycompany.tqshw;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;


/**
 *
 * @author danie
 */
public class CurrencyCalculatorTest {
    
    private CurrencyCalculator instance;
    
    public CurrencyCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(){
        instance = new CurrencyCalculator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convert method, of class CurrencyCalculator.
     */
    @org.junit.Test
    public void testConvert() {
        System.out.println("--Unit Testing Currency Conversion--");
        String from = "USD";
        double amount = 0.5;
        String to = "GBP";
        double expResult = 0.35809383443871284;
        double result = instance.convert(from, amount, to);
        assertEquals(expResult, result,0.1);        
    }
}
