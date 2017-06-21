/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/**
 *
 * @author matthieu
 */
public class Communication {

    public Communication (){
        
    }
    
    public static String getHtml (String urlToRead) throws Exception{
        StringBuilder result = new StringBuilder();
        URL  url = new URL (urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        
        while((line = rd.readLine()) != null){
            result.append(line);
        }
        rd.close();
        
        return result.toString();
    }
    
    public static void postHtml (String urlToPost,String data) throws Exception{
        
        // Création de l'objet connexion
        URL url = new URL(urlToPost);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        wr.close();

        // Pour recuperer la reponse du serveur
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
                System.out.println(line);
        }

        rd.close();
    }
}
