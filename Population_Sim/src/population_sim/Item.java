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
public class Item {
    /**
     * Type d'item, soit un stand, soit une publicité
     */
    private Kind_Items kind;
    /**
     * Proprietaire de l'item
     */
    private String owner;
    /**
     * position de l'item
     */
    private Coordinate location;
    /**
     * rayon d'influence de l'item
     */
    private float influence;
    /**
     * Constructeur par defaut de la classe item
     * @param kind
     *              Type de l'item
     * @param owner
     *              Proprietaire de l'item
     * @param location
     *              Position de l'item (Coordinate)
     * @param influence 
     *              Rayon d'ingluence de l'item
     */
    public Item (Kind_Items kind, String owner, Coordinate location, float influence){
        this.kind = kind;
        this.owner = owner;
        this.location = location;
        this.influence = influence;
    }
    
    /**
     * Constructeur de la classe item
     * @param kind
     *          Type de l'item
     * @param owner
     *          Proprietaire de l'item
     * @param longitude
     *          Position en x de l'item
     * @param latitude
     *          Position en y de l'item
     * @param influence 
     *          Rayon d'influence de l'item
     */
    public Item (Kind_Items kind, String owner, float longitude, float latitude, float influence){
        this.kind = kind;
        this.owner = owner;
        this.influence = influence;
        this.location = new Coordinate(longitude,latitude);
    }

    /**
     * @return the kind
     */
    public Kind_Items getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(Kind_Items kind) {
        this.kind = kind;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
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

    /**
     * @return the influence
     */
    public float getInfluence() {
        return influence;
    }

    /**
     * @param influence the influence to set
     */
    public void setInfluence(float influence) {
        this.influence = influence;
    }
    
    
}
