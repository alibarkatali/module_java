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
public class Coordinate {
    /**
     * Valeur de la longitude
     */
    private float longitude;    // axe x
    
    /**
     * Valeur de la latitude
     */
    private float latitude;     // axe y
    
    /**
     * Constructeur d'une position
     * @param x
     *          Position en longitude
     * @param y 
     *          Position en latitude
     */
    public Coordinate(float x, float y){
        this.longitude = x;
        this.latitude = y;
    }

    /**
     * Permet de recuperer la valeur de la longitude
     * @return the longitude
     *          Retourne la valeur de la longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Permet de modifier la valeur de la longitude
     * @param longitude the longitude to set
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Permet de recuperer la valeur de la latitude
     * @return the latitude
     *          Retourne la valeur de la latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * ¨Permet de modifier la valeur de la latitude
     * @param latitude the latitude to set
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
