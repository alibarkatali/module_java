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
public class Player {
    
    /**
     * nom du joueur
     */
    private String name;
    /**
     * localisation du joueur (== a celui de son stand)
     */
    private Coordinate location;
    
    /*
    private float cash;
    private float profit;
    */
    
    /**
     * Constructeur par defaut de la classe Player
     * @param name
     *          Nom du joueur
     * @param localion 
     *          Position du joueur
     */
    public Player (String name, Coordinate localion){
        this.name = name;
        this.location = location;
    }
    
    /**
     * Construceut de la classe Player (avec longitude et latitude)
     * @param name
     *          Nom du joueur
     * @param longitude
     *          Position du joueur en x
     * @param latitude 
     *          Position du joueur en y 
     */
    public Player (String name, float longitude, float latitude){
        this.name = name;
        this.location = new Coordinate(longitude,latitude);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
