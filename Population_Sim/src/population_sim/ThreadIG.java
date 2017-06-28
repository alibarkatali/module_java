 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import java.util.logging.Level;
import java.util.logging.Logger;
import static population_sim.Communication.getHtml;
import static population_sim.Game.getMapParser;
import static population_sim.Game.getMetrologyParser;

/**
 *
 * @author matthieu
 */
public class ThreadIG extends Thread {
    ThreadIG(){

    }

    public void run(){
        String urlToReadMetrology = "http://fast-wave-77815.herokuapp.com/metrology";
        String urlToReadMap = "http://fast-wave-77815.herokuapp.com/map"; 
        String urlToPostSales = "http://fast-wave-77815.herokuapp.com/sales";
        /**
         * Test pour la communication Get et Post
         */
        Simulation simu = new Simulation();
        while(true){
            try {
                getMetrologyParser(getHtml(urlToReadMetrology));
            } catch (Exception ex) {
                Logger.getLogger(ThreadIG.class.getName()).log(Level.SEVERE, null, ex);
            } 
            if(InterfaceG.region.getTimestamp()%24 == 23){
                try {
                    simu.createAndPlaceBot(100);
                    simu.simulate_game();
                } catch (Exception ex) {
                    Logger.getLogger(ThreadIG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (InterfaceG.region.getTimestamp()%24 == 0){
                try {
                    getMapParser(getHtml(urlToReadMap));
                } catch (Exception ex) {
                    Logger.getLogger(ThreadIG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadIG.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}