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
    /**
     * Coordonée du centre de la carte
     */
    private Coordinate center;
    /**
     * Coordonnée max de la carte
     */
    private Coordinate span;
    /**
     * liste des joueurs contenu dans la map
     */
    private ArrayList <Player> listPlayer = new ArrayList();
    /**
     * liste de la population contenu dans la map
     */
    private ArrayList <Population> listPop = new ArrayList();
    /**
     * temps du jour
     */
    private String metrology;
    /**
     * heure du jeu
     */
    private int timestamp;
    
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

    /**
     * constructeur par defaut
     */
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

    /**
     * @return the metrology
     */
    public String getMetrology() {
        return metrology;
    }

    /**
     * @param metrology the metrology to set
     */
    public void setMetrology(String metrology) {
        this.metrology = metrology;
    }

    /**
     * @return the timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
