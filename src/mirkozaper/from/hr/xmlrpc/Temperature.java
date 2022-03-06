/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirkozaper.from.hr.xmlrpc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mirkozaper.from.hr.xmlrpc.model.City;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mirko
 */
public class Temperature {
    public float getTemperature(String city){
        List<City> cities=GetCitiesTemperature();
        float rez=0f;
        
        for (City c : cities) {
            if(c.getName().equalsIgnoreCase(city))
            {
                rez=c.getTemperature();
            }
        }
        
        return rez;
    }

    private List<City> GetCitiesTemperature() {
        
        List<City> cities=new ArrayList<>();
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL("https://vrijeme.hr/hrvatska_n.xml").openStream());
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("Grad");
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    String city=e.getElementsByTagName("GradIme").item(0).getTextContent();
                    Element data = (Element)e.getElementsByTagName("Podatci").item(0);
                    float temp = Float.parseFloat(data.getElementsByTagName("Temp").item(0).getTextContent().trim());
                    cities.add(new City(city,temp));
                    System.out.println("");
                }
                
            }
            
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            e.printStackTrace();
        }
        
        
        return cities;
    }
}
