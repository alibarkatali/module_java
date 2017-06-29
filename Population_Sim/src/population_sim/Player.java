/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import java.util.ArrayList;

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
     * budget
     */
    private float cash;
    /**
     * profit au fil du temps
     */
    private float profit;
    /**
     * nombre de vente depuis le debut du jeu
     */
    private int sales;
    /**
     * liste de boisson que le joueur vend aujourd'hui
     */
    private ArrayList <Drink> drinkOffered = new ArrayList();
    /**
     * liste de boisson que le joueur peut vendre
     */
    private ArrayList <Drink> drink = new ArrayList();
    /**
     * liste de stand et des pub du joueur
     */
    private ArrayList <Item> listItem = new ArrayList();
    /**
     * Constructeur par defaut de la classe Player
     * @param name
     *          Nom du joueur
     * @param cash
     *          Budget du joueur
     * @param profit
     *          profit du joueur
     * @param sales
     *          Vente du joueur
     */
    public Player (String name,float cash,float profit,int sales){
        this.name = name;
        this.cash = cash;
        this.profit = profit;
        this.sales = sales;
    }
    
    /**
     * Constructeur par defaut
     */
    public Player (){
        
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
     * @return the cash
     */
    public float getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(float cash) {
        this.cash = cash;
    }

    /**
     * @return the profit
     */
    public float getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(float profit) {
        this.profit = profit;
    }

    /**
     * @return the sales
     */
    public int getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * @return the listItem
     */
    public ArrayList <Item> getListItem() {
        return listItem;
    }

    /**
     * @param listItem the listItem to set
     */
    public void setListItem(ArrayList <Item> listItem) {
        this.listItem = listItem;
    }

    /**
     * @param drinkOffered the drinkOffered to set
     */
    public void setDrinkOffered(ArrayList <Drink> drinkOffered) {
        this.drinkOffered = drinkOffered;
    }
    
    public ArrayList <Drink> getDrinkOffered (){
        return drinkOffered;
    }

    /**
     * @return the drink
     */
    public ArrayList <Drink> getDrink() {
        return drink;
    }

    /**
     * @param drink the drink to set
     */
    public void setDrink(ArrayList <Drink> drink) {
        this.drink = drink;
    }
    
}
