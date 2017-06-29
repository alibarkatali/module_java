/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;
import java.util.ArrayList;
import org.json.*;
/**
 *
 * @author matthieu
 */
public class Game {
    /**
     * Parse le string serialisé en json pour recuperer plusieurs informations.
     * @param json_serial
     *          Le string représentant le json
     * @param region
     * 
     * @return 
     */
    public static void getMapParser (String json_serial){
        ArrayList name_player = new ArrayList();
        InterfaceG.getRegion().getListPlayer().clear();
        InterfaceG.getRegion().getListPop().clear();
        try{
            JSONObject obj = new JSONObject(json_serial);
            //Recuperation de chaque "type" principaux (region,ranking,itemsbyPlayers,playerInfo,drinksByPlayer)
            JSONObject json_region = obj.getJSONObject("map").getJSONObject("region");
            JSONArray json_ranking = obj.getJSONObject("map").getJSONArray("ranking");
            JSONObject json_itemsByPlayer = obj.getJSONObject("map").getJSONObject("itemsByPlayer");
            JSONObject json_playerInfo = obj.getJSONObject("map").getJSONObject("playerInfo");
            JSONObject json_drinksByPlayer = obj.getJSONObject("map").getJSONObject("drinksByPlayer");
            
            for(int i = 0 ; i < json_ranking.length() ; i++){
                name_player.add(json_ranking.getString(i));
                
                Player player = new Player();
                InterfaceG.getRegion().getListPlayer().add(player);
                
                //playerInfo
                String name = name_player.get(i).toString();
                float cash =(float) json_playerInfo.getJSONObject(name).getDouble("cash");
                float profit =(float) json_playerInfo.getJSONObject(name).getDouble("profit") ;
                int sales = (int) json_playerInfo.getJSONObject(name).getInt("sales");
                
                JSONArray drinksOfferedJArray = json_playerInfo.getJSONObject(name).getJSONArray("drinksOffered");
                for(int j = 0 ; j < drinksOfferedJArray.length() ; j++){
                    String name_drink = drinksOfferedJArray.getJSONObject(j).getString("name");
                    float price = (float) drinksOfferedJArray.getJSONObject(j).getDouble("price");
                    boolean hasAlcohol = drinksOfferedJArray.getJSONObject(j).getBoolean("hasAlcohol");
                    boolean isCold = drinksOfferedJArray.getJSONObject(j).getBoolean("isCold");
                    Drink drinkOffered = new Drink(name_drink,price,hasAlcohol,isCold);
                    player.getDrinkOffered().add(drinkOffered);
                }
                player.setCash(cash);
                player.setName(name);
                player.setProfit(profit);
                player.setSales(sales);
                
                //itemsByPlayer
                
                JSONArray itemsByPlayerArray = json_itemsByPlayer.getJSONArray(name);
                for (int j = 0 ; j < itemsByPlayerArray.length() ; j++){
                    String kind_Item = itemsByPlayerArray.getJSONObject(j).getString("kind");
                    Kind_Items kind;
                    if(kind_Item.equals("STAND") || kind_Item.equals("stand")){
                        kind = Kind_Items.STAND;
                    }else{
                        kind = Kind_Items.AD;
                    }
                   float influence =(float) itemsByPlayerArray.getJSONObject(j).getDouble("influence");
                   float latitude = (float) itemsByPlayerArray.getJSONObject(j).getJSONObject("location").getDouble("latitude");
                   float longitude = (float) itemsByPlayerArray.getJSONObject(j).getJSONObject("location").getDouble("longitude");
                   Coordinate location = new Coordinate(longitude,latitude);
                   Item newItem = new Item(kind, name, location, influence);
                   InterfaceG.getRegion().getListPlayer().get(i).getListItem().add(newItem);
                }
                
                //drinksByPlayer
                JSONArray drinksByPlayerArray = json_drinksByPlayer.getJSONArray(name);
                for (int j = 0 ; j < drinksByPlayerArray.length() ; j++){
                    String nameDrink = drinksByPlayerArray.getJSONObject(j).getString("name");
                    float price = (float) drinksByPlayerArray.getJSONObject(j).getDouble("price");
                    boolean hasAlcohol = drinksByPlayerArray.getJSONObject(j).getBoolean("hasAlcohol");
                    boolean isCold = drinksByPlayerArray.getJSONObject(j).getBoolean("isCold");
                    Drink drinksByPlayer = new Drink(nameDrink,price,hasAlcohol,isCold);
                    InterfaceG.getRegion().getListPlayer().get(i).getDrink().add(drinksByPlayer);
                }
            }
            
            //region
            float latitude = (float) json_region.getJSONObject("center").getDouble("latitude");
            float longitude = (float) json_region.getJSONObject("center").getDouble("longitude");
            float latitudeSpan = (float) json_region.getJSONObject("span").getDouble("latitudeSpan");
            float longitudeSpan = (float) json_region.getJSONObject("span").getDouble("longitudeSpan");
            
            InterfaceG.getRegion().setCenter(new Coordinate(longitude,latitude));
            InterfaceG.getRegion().setSpan(new Coordinate(longitudeSpan,latitudeSpan));
                    
        }   catch( Exception ex){
            ex.printStackTrace();
        }     
    }
    
    /**
     * Parse le string serialisé en json pour recuperer l'info sur la meteo
     * @param json_serial
     * @return metrology
     *          Le string correspondant a la meteo du jour          
     */
    public static void getMetrologyParser (String json_serial){
        JSONObject obj = new JSONObject (json_serial);
        JSONArray json_weather_array = obj.getJSONArray("weather");
        int json_timestamp = obj.getInt("timestamp");
        System.out.println("timestamps : " + json_timestamp);
        InterfaceG.getRegion().setTimestamp(json_timestamp);
        for (int i = 0 ; i < json_weather_array.length() ; i++){
            if (json_weather_array.getJSONObject(i).getInt("dfn") == 0){
                InterfaceG.getRegion().setMetrology(json_weather_array.getJSONObject(i).get("weather").toString());
            }
        }        
        //System.out.println("metrology : " + region.getMetrology());
    }    
}

