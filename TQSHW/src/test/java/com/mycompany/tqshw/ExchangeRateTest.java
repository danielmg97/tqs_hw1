package com.mycompany.tqshw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import static org.junit.Assert.assertEquals;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ExchangeRateTest {
    
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(ExchangeRate.class.getPackage());
    }

    @Test
    public void testGetText() throws Exception {
        System.out.println("--Integration Testing My API--");
        URL url = new URL("http://localhost:8080/TQSHW/webresources/rates/USD/10/EUR");
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String result = br.readLine();
        String expected = "10 USD -> 8.21827744904668 EUR";
        assertEquals(expected,result);
    }
}