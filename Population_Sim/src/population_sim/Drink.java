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
public class Drink {
    /**
     * nom de la boisson
     */
    private String name;
    /**
     * prix de la boisson
     */
    private float price;
    /**
     * contient de l'alcool
     */
    private Boolean hasAlcohol;
    /**
     * boisson froide
     */
    private Boolean isCold;
    
    /**
     * Constructeur de la classe boisson
     * @param name
     * @param price
     * @param hasAlcohol
     * @param isCold 
     */
    public Drink(String name, float price, Boolean hasAlcohol, Boolean isCold){
        this.name = name;
        this.price = price;
        this.hasAlcohol = hasAlcohol;
        this.isCold = isCold;
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
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the hasAlcohol
     */
    public Boolean getHasAlcohol() {
        return hasAlcohol;
    }

    /**
     * @param hasAlcohol the hasAlcohol to set
     */
    public void setHasAlcohol(Boolean hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

    /**
     * @return the isCold
     */
    public Boolean getIsCold() {
        return isCold;
    }

    /**
     * @param isCold the isCold to set
     */
    public void setIsCold(Boolean isCold) {
        this.isCold = isCold;
    }
}
