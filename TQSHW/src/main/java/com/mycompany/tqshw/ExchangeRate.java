package com.mycompany.tqshw;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author danie
 */
@Path("rates")
public class ExchangeRate {
    private final CurrencyCalculator rates;
    
    public ExchangeRate() {
        rates = new CurrencyCalculator();
    }
    
    @GET
    @Path("{from}/{amount}/{to}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRates(@PathParam("from") String from,@PathParam("amount") String amount, @PathParam("to") String to) {
        double value = 0;
        try{
            value = rates.convert(from, Double.parseDouble(amount), to);
        }catch(RuntimeException e){
            System.err.println("Currency is not available.");
        }        
        return amount+" "+from+" -> "+value+" "+to;
    }
}
