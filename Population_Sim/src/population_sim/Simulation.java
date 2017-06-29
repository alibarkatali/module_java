/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.*;
import static population_sim.Communication.postHtml;
 /*
 * @author matthieu
 */
public class Simulation {
    private HashMap <String,Double> probMap;
    
    public Simulation(){
        this.probMap = new HashMap();
        probMap.put("thunderstorm",0.0);
        probMap.put("rainy",0.15);
        probMap.put("cloudy",0.3);
        probMap.put("sunny",0.75);
        probMap.put("heatwave",1.0);
    }
    
    public void createAndPlaceBot(int nbBot){
        /* Creation de la population*/
        InterfaceG.getRegion().getListPop().clear();
        for(int i = 0 ; i < nbBot ; i++){
            float x = (float) (0.0 + (Math.random() * (InterfaceG.getRegion().getSpan().getLongitude() - 0.0))); // (min + (Math.random() * (10.0 - 5.0)) 
            float y = (float) (0.0 + (Math.random() * (InterfaceG.getRegion().getSpan().getLatitude() - 0.0)));
            InterfaceG.getRegion().getListPop().add(new Population(new Coordinate(x,y)));
        }
    }

    
    
    public float checkDistanceBetweenStandAndBot(Item stand, Population bot){
        float deltaLong =(float) Math.pow((stand.getLocation().getLongitude()+bot.getLocation().getLongitude()),2); //changer par la fonction ²
        float deltaLat = (float) Math.pow((stand.getLocation().getLatitude()+bot.getLocation().getLatitude()),2);
        float distance = (float) Math.sqrt(deltaLong + deltaLat);
        return distance;
    }
    
    @SuppressWarnings("empty-statement")
    public void simulate_game(String urlToSendPost) throws Exception{
        ArrayList <Player> player = InterfaceG.getRegion().getListPlayer();
        ArrayList <Population> pop = InterfaceG.getRegion().getListPop();
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
            }
            if (dispatchBot.containsKey(saveBestPlayer)){
                dispatchBot.replace(saveBestPlayer, dispatchBot.get(saveBestPlayer)+1);
            }else{
                dispatchBot.put(saveBestPlayer, 1);
            }
        }
        System.out.println("size dispatchBot : " + dispatchBot.size());
        System.out.println("---nb bot a chaque stand---");
        for(Map.Entry<Player,Integer> entry : dispatchBot.entrySet()){
            Player key = entry.getKey();
            System.out.println("name : " + key.getName() + " nb bot : " + dispatchBot.get(key));
        }
        
        Double prob = (Double) getProbMap().get(InterfaceG.getRegion().getMetrology());
        //System.out.println("prob :" + prob );
        HashMap <Player, Integer> venteTheorique = new HashMap();
        for (Map.Entry<Player,Integer> entry : dispatchBot.entrySet()){
            Player key = entry.getKey();
            //System.out.println("name player : " + key.getName());
            //System.out.println("nb de bot au stand : " + dispatchBot.get(key));
            int nbBotAtStand = dispatchBot.get(key);
            for (int j = 0 ; j < nbBotAtStand ; j++){
                float achete = (float) Math.random();
                System.out.println("proba : " + prob + " rand : " + achete);
                if(achete < prob){
                    if(venteTheorique.containsKey(key)){
                        venteTheorique.replace(key, venteTheorique.get(key)+1);
                    }else{
                        venteTheorique.put(key,1);
                    }
                }
            }
        }
        System.out.println("---POST---");
        JSONObject jsonToSend = new JSONObject();
        ArrayList <JSONObject> arrayJson = new ArrayList();
        for (int i = 0 ; i < player.size() ; i ++){
            //System.out.println("name player : " + player.get(i).getName());
            String namePlayer = player.get(i).getName();
            String nameItem = "";
            int quantity = 0;
            if(!player.get(i).getDrinkOffered().isEmpty()){
                //System.out.println("rien a vendre");
                nameItem = player.get(i).getDrinkOffered().get(0).getName();
            }
            if(venteTheorique.get(player.get(i)) != null){
                quantity = venteTheorique.get(player.get(i));
            }
            JSONObject sales = new JSONObject();
            sales.put("name",namePlayer);
            sales.put("item",nameItem);
            sales.put("quantity",quantity);
            arrayJson.add(sales);
        }
        JSONArray arraySales = new JSONArray();
        for(int i = 0 ; i < arrayJson.size() ; i++){
            arraySales.put(arrayJson.get(i));
        }
        JSONObject jsonTosend = new JSONObject();
        jsonToSend.put("sales",arraySales);
        postHtml(urlToSendPost,jsonToSend);
    }
    
    /**
     * @return the probMap
     */
    public HashMap getProbMap() {
        return probMap;
    }

    /**
     * @param probMap the probMap to set
     */
    public void setProbMap(HashMap probMap) {
        this.probMap = probMap;
    }
}
