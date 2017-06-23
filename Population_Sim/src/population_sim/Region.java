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
public class Region {
    
    private Coordinate center;
    private Coordinate span;
    private ArrayList <Player> listPlayer = new ArrayList();
    private ArrayList <Population> listPop = new ArrayList();
    /**
     * Constructeur par defaut de la classe Region
     * @param center
     *          Coordonnée du centre de la map
     * @param span
     *          Coordonnée
     */
    public Region(Coordinate center, Coordinate span){
        this.center = center;
        this.span = span;
    }

    public Region(){
        
    }
    
    /**
     * @return the center
     */
    public Coordinate getCenter() {
        return center;
    }

    /**
     * @param center the center to set
     */
    public void setCenter(Coordinate center) {
        this.center = center;
    }

    /**
     * @return the span
     */
    public Coordinate getSpan() {
        return span;
    }

    /**
     * @param span the span to set
     */
    public void setSpan(Coordinate span) {
        this.span = span;
    }

    /**
     * @return the listPlayer
     */
    public ArrayList <Player> getListPlayer() {
        return listPlayer;
    }

    /**
     * @return the listPop
     */
    public ArrayList <Population> getListPop() {
        return listPop;
    }
}
