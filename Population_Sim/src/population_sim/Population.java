/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

/**
 *
 * @author matthieu
 */
public class Population {
    
    /**
     * Position du bot
     */
    private Coordinate location;
    
    /**
     * Constructeur de la classe population
     * @param location 
     *          position avec la classe Coordination
     */
    public Population (Coordinate location){
        this.location = location;
    }
    
    /**
     * Constructeur de la classe population
     * @param longitude
     *          Position en x 
     * @param latitude 
     *          Position en y
     */
    public Population (float longitude, float latitude){
        this.location = new Coordinate (longitude,latitude);
    }

    /**
     * @return the location
     */
    public Coordinate getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Coordinate location) {
        this.location = location;
    }
    
    
}
