/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;
import java.util.Hashtable;
/**
 *
 * @author matthieu
 */
public class Simulation {
    Hashtable probMap;
    
    public Simulation(){
        probMap.put("thunderstorm",0.0);
        probMap.put("rainy",0.15);
        probMap.put("cloudy",0.3);
        probMap.put("sunny",0.75);
        probMap.put("heatwave",1.0);
    }
}
