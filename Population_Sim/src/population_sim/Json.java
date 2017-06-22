/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;
import org.json.*;
/**
 *
 * @author matthieu
 */
public class Json {
    
    /**
     * Parse le string serialisé en json pour recuperer plusieurs informations.
     * @param json_serial
     *          Le string représentant le json
     */
    public void getMapParser (String json_serial){
      
    }
    
    /**
     * Parse le string serialisé en json pour recuperer l'info sur la meteo
     * @param json_serial
     * @return metrology
     *          Le string correspondant a la meteo du jour          
     */
    public static String getMetrologyParser (String json_serial){
        JSONObject json = new JSONObject (json_serial);
        String metrology = json.getJSONObject("weather").getString("weather");
        
        System.out.println("metrology : " + metrology);
        
        return metrology;
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
    public static String jsonPostSales (String player, String itemName, int itemQuantity){
        String jsonToSend = "{\"sales\":{\"player\":\"" + player + "\",\"item\":\""+ itemName + "\",\"quantity\":" + itemQuantity +"}}";
        return jsonToSend;
    }
    
}
