package com.mycompany.tqshw;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author danie
 */
public class ExchangeRateServiceTest {
    private ExchangeRateService instance;
    public ExchangeRateServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ExchangeRateService();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadExchangeRates method, of class ExchangeRateService.
     */
    @org.junit.Test
    public void testLoadExchangeRates() {
        System.out.println("--Unit Testing Loading Exchange Rates--");
        Map <String,Double> map = instance.getRatesCache();
        assertEquals(33, map.size()); //32 currencies + 1 EUR itself (EUR is the reference) 
        for(String k : map.keySet()){
            assertNotEquals(map.get(k), null);
        }
    }
    
}
