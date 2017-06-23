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
        /**
         * Test pour la communication Get et Post
         */
        String urlToReadMetrology = "http://fast-wave-77815.herokuapp.com/metrology";
        String urlToReadMap = "http://fast-wave-77815.herokuapp.com/map";
        String urlToPostSales = "http://fast-wave-77815.herokuapp.com/sales";
        String urlToPostTest = "http://httpbin.org/post";
 
        postHtml(urlToPostTest,jsonPostSales("matthieu","the",10));
        
        String result = getHtml(urlToReadMetrology);
        getMetrologyParser(result);
        //System.out.println(result);
        
        String result2 = getHtml(urlToReadMap);
        getMapParser(result2);
        System.out.println(result2);
    }

    private static void getMapParser(String result2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
