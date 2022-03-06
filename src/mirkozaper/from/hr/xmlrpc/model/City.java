/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirkozaper.from.hr.xmlrpc.model;

/**
 *
 * @author mirko
 */
public class City {
    private final String name;
    private final float temperature;

    public City(String name, float temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public float getTemperature() {
        return temperature;
    }
    
}
