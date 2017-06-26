/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
/**
 *
 * @author matthieu
 */
public class Simulation {
    private Hashtable probMap;
    
    public Simulation(){
        this.probMap = new Hashtable();
        probMap.put("thunderstorm",0.0);
        probMap.put("rainy",0.15);
        probMap.put("cloudy",0.3);
        probMap.put("sunny",0.75);
        probMap.put("heatwave",1.0);
    }
    
    public void createAndPlaceBot(int nbBot,Region region){
        /* Creation de la population*/
        region.getListPop().clear();
        for(int i = 0 ; i < nbBot ; i++){
            float x = (float) (5.0 + (Math.random() * (10.0 - 5.0))); // (min + (Math.random() * (10.0 - 5.0)) 
            float y = (float) (5.0 + (Math.random() * (10.0 - 5.0)));
            region.getListPop().add(new Population(new Coordinate(x,y)));
        }
        System.out.println("distance : " + checkDistanceBetweenStandAndBot(region.getListPlayer().get(0).getListItem().get(0),region.getListPop().get(0)));
        
    }

    public float checkDistanceBetweenStandAndBot(Item stand, Population bot){
        float deltaLong =(float) Math.pow((stand.getLocation().getLongitude()+bot.getLocation().getLongitude()),2); //changer par la fonction ²
        float deltaLat = (float) Math.pow((stand.getLocation().getLatitude()+bot.getLocation().getLatitude()),2);
        float distance = (float) Math.sqrt(deltaLong + deltaLat);
        return distance;
    }
    
    public void simulate_game(Region region){
        ArrayList <Player> player = region.getListPlayer();
        ArrayList <Population> pop = region.getListPop();
        HashMap <Player, Integer> dispatchBot = new HashMap();
        
        for(int i = 0 ; i < pop.size() ; i++){
            float bestDistance = Float.MAX_VALUE;
            Player saveBestPlayer = null;
            for(int j = 0 ; j < player.size() ; j++ ){
                Item stand = player.get(j).getListItem().get(0);
                Population bot = pop.get(i);
                float distance = checkDistanceBetweenStandAndBot(stand, bot);
                if(distance < bestDistance){
                    bestDistance = distance;
                    saveBestPlayer = player.get(j);
                }
                if (dispatchBot.containsKey(saveBestPlayer)){
                    dispatchBot.replace(saveBestPlayer, dispatchBot.get(saveBestPlayer)+1);
                }else{
                    dispatchBot.put(saveBestPlayer, 1);
                }
            }
        }
        /*float prob = (float) getProbMap().get(region.getMetrology());
        HashMap <Player, Integer> venteTheorique = new HashMap();
        for (int i = 0 ; i < dispatchBot.size() ; i++){
            int nbBotAtStand = dispatchBot.get(i);
            for (int j = 0 ; j < nbBotAtStand ; j++){
                float achete = (float) Math.random();
                if(achete < prob){
                    if(venteTheorique.containsKey(player.get(i))){
                        venteTheorique.replace(player.get(i), venteTheorique.get(i)+1);
                    }else{
                        
                    }
                }
            }
        }*/
    }
    
    /**
     * @return the probMap
     */
    public Hashtable getProbMap() {
        return probMap;
    }

    /**
     * @param probMap the probMap to set
     */
    public void setProbMap(Hashtable probMap) {
        this.probMap = probMap;
    }
}
