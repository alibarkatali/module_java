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
     * @return the name_Player
     */
    public String getName_Player() {
        return name_Player;
    }

    /**
     * @param name_Player the name_Player to set
     */
    public void setName_Player(String name_Player) {
        this.name_Player = name_Player;
    }

    /**
     * @return the name_Drink
     */
    public String getName_Drink() {
        return name_Drink;
    }

    /**
     * @param name_Drink the name_Drink to set
     */
    public void setName_Drink(String name_Drink) {
        this.name_Drink = name_Drink;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * Nom du joueur qui a vendu cette boisson
     */
    private String name_Player;
    /**
     * Nom de la boisson
     */
    private String name_Drink;
    /**
     * Quantité vendu
     */
    private int quantity;
    
    /**
     * Constructeur de l'objet drink
     * @param name_Player
     * @param name_Drink
     * @param quantity 
     */
    public Drink(String name_Player, String name_Drink,int quantity){
        this.name_Player = name_Player;
        this.name_Drink = name_Drink;
        this.quantity = quantity;
    }
}
