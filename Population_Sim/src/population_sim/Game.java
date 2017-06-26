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
    public static void getMapParser (String json_serial, Region region){
        ArrayList name_player = new ArrayList();
        try{
            JSONObject obj = new JSONObject(json_serial);
            System.out.println(obj);
            //Recuperation de chaque "type" principaux (region,ranking,itemsbyPlayers,playerInfo,drinksByPlayer)
            JSONObject json_region = obj.getJSONObject("map").getJSONObject("region");
            JSONArray json_ranking = obj.getJSONObject("map").getJSONArray("ranking");
            JSONObject json_itemsByPlayer = obj.getJSONObject("map").getJSONObject("itemsByPlayer");
            JSONObject json_playerInfo = obj.getJSONObject("map").getJSONObject("playerInfo");
            JSONObject json_drinksByPlayer = obj.getJSONObject("map").getJSONObject("drinksByPlayer");
            
            for(int i = 0 ; i < json_ranking.length() ; i++){
                System.out.println(json_ranking.getString(i));
                name_player.add(json_ranking.getString(i));
                
                Player player = new Player();
                region.getListPlayer().add(player);
                
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
                   region.getListPlayer().get(i).getListItem().add(newItem);
                }
                
                //drinksByPlayer
                JSONArray drinksByPlayerArray = json_drinksByPlayer.getJSONArray(name);
                for (int j = 0 ; j < drinksByPlayerArray.length() ; j++){
                    String nameDrink = drinksByPlayerArray.getJSONObject(j).getString("name");
                    float price = (float) drinksByPlayerArray.getJSONObject(j).getDouble("price");
                    boolean hasAlcohol = drinksByPlayerArray.getJSONObject(j).getBoolean("hasAlcohol");
                    boolean isCold = drinksByPlayerArray.getJSONObject(j).getBoolean("isCold");
                    Drink drinksByPlayer = new Drink(nameDrink,price,hasAlcohol,isCold);
                    region.getListPlayer().get(i).getDrink().add(drinksByPlayer);
                }
            }
            
            //region
            float latitude = (float) json_region.getJSONObject("center").getDouble("latitude");
            float longitude = (float) json_region.getJSONObject("center").getDouble("longitude");
            float latitudeSpan = (float) json_region.getJSONObject("span").getDouble("latitudeSpan");
            float longitudeSpan = (float) json_region.getJSONObject("span").getDouble("longitudeSpan");
            
            region.setCenter(new Coordinate(longitude,longitude));
            region.setSpan(new Coordinate(longitudeSpan,latitudeSpan));
                    
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
    public static void getMetrologyParser (String json_serial, Region region){
        JSONObject json = new JSONObject (json_serial);
        String metrology = json.getJSONObject("weather").getString("weather");
        
        System.out.println("metrology : " + metrology);
        region.setMetrology(metrology);
    }
    
    /**
     * Serialise un string au format json pour la requete POST sales
     * @param player
     *          pseudonyme du joueur
     * @param itemName
     *          nom de la boisson
     * @param itemQuantity
     *          nombre de boisson vendu
     * @return 
     *          retourne le string representant le json
     */
    public static JSONObject jsonPostSales (String player, String itemName, int itemQuantity){
        JSONObject jsonToSend = new JSONObject();// "{\"sales\":{\"player\":\"" + player + "\",\"item\":\""+ itemName + "\",\"quantity\":" + itemQuantity +"}}";
        JSONObject sales = new JSONObject();
        sales.put("name", player);
        sales.put("item", itemName);
        sales.put("quantity", itemQuantity);
        jsonToSend.put("sales", sales);
        return jsonToSend;
    }
    
}

