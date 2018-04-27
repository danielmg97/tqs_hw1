package com.mycompany.tqshw;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Singleton
public class ExchangeRateService {
    
    private final Map<String,Double> ratesCache = new HashMap<>();
    
    public ExchangeRateService(){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml").openStream()); //banco central europeu
            NodeList nList = doc.getElementsByTagName("Cube");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode.hasAttributes()) {
                    Element eElement = (Element) nNode;
                    if(!eElement.hasAttribute("time")){
                        String key = eElement.getAttribute("currency");
                        String value = eElement.getAttribute("rate");
                        double val = Double.parseDouble(value);
                        ratesCache.put(key, val);
                    }
                }
            }
            ratesCache.put("EUR", 1.0);
        }catch(Exception e){
        }
    }
    
    public Map<String,Double> getRatesCache(){
        return ratesCache;
    }
}
