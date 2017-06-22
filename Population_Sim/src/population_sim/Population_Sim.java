/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import static population_sim.Communication.getHtml;
import static population_sim.Communication.postHtml;

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
        
        /**
         * Test pour la communication Get et Post
         */
        String urlToRead = "http://fast-wave-77815.herokuapp.com/metrology";
        String urlToPost = "http://httpbin.org/post";
        String dataPost = "Test";
        
        System.out.println(getHtml(urlToRead));
        System.out.println("\n");
        postHtml(urlToPost,dataPost);
    }
    
}
