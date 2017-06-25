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
    private float cash;
    private float profit;
    private int sales;
    private ArrayList <Drink> drinkOffered = new ArrayList();
    private ArrayList <Drink> drink = new ArrayList();
    private ArrayList <Item> listItem = new ArrayList();
    /**
     * Constructeur par defaut de la classe Player
     * @param name
     *          Nom du joueur
     * @param location 
     *          Position du joueur
     */
    public Player (String name,float cash,float profit,int sales,Drink drinkOffered){
        this.name = name;
        this.cash = cash;
        this.profit = profit;
        this.sales = sales;
    }
    
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
