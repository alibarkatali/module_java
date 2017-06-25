/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import static population_sim.Communication.getHtml;
import static population_sim.Communication.postHtml;
import static population_sim.Game.getMetrologyParser;
import static population_sim.Game.jsonPostSales;
import static population_sim.Game.getMapParser;

/**
 *
 * @author matthieu
 */
public class Population_Sim {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Region region = new Region();
        
        /* Creation de la population*/
        
        /*for(int i = 0 ; i < 1000 ; i++){
            float x = (float) (5.0 + (Math.random() * (10.0 - 5.0))); 
            float y = (float) (5.0 + (Math.random() * (10.0 - 5.0)));
            Coordinate location = new Coordinate(x,y);
            Population bot = new Population(location);
            region.getListPop().add(bot);
        }*/
        
        /**
         * Test pour la communication Get et Post
         */
        String urlToReadMetrology = "http://fast-wave-77815.herokuapp.com/metrology";
        String urlToReadMap = "http://fast-wave-77815.herokuapp.com/map";
        String urlToPostSales = "http://fast-wave-77815.herokuapp.com/sales";
        String urlToPostTest = "http://httpbin.org/post";
 
        //postHtml(urlToPostTest,jsonPostSales("matthieu","the",10));
        
        String result = getHtml(urlToReadMetrology);
        getMetrologyParser(result);
        //System.out.println(result);
        
        String result2 = getHtml(urlToReadMap);
        getMapParser(result2,region);
        //System.out.println(result2);
    }
    
}
