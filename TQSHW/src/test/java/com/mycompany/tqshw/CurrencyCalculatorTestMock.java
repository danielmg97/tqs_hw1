package com.mycompany.tqshw;

import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class CurrencyCalculatorTestMock {
    
    @TestSubject
    CurrencyCalculator calc = new CurrencyCalculator();
    
    @Mock
    ExchangeRateService service;
    
    private CurrencyCalculator instance;
    
    public CurrencyCalculatorTestMock() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        System.out.println("--Test Conversion with Mock for ExchangeRateService--");
        Map <String,Double> mapa = new HashMap <>();
        mapa.put("USD",1.2);
        mapa.put("EUR",1.0);
        EasyMock.expect(service.getRatesCache()).andReturn(mapa);
        EasyMock.replay(service);
        Assert.assertEquals(0.358, instance.convert("USD", 0.5, "GBP"),0.1);        
    }
}
