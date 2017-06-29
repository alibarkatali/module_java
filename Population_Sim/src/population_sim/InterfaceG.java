/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import java.awt.Canvas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author matthieu
 */
public class InterfaceG extends Application {
    static Region region = new Region();
    private static int cartX = 800;
    private static int cartY = 700;
    public static Label hour = new Label();
    public static Label metrology = new Label();
    private static Label cash = new Label();
    private static Label profit = new Label();
    private static Label sales = new Label();
    private static Label ranking = new Label();
    private static ComboBox <String> cmb = new ComboBox <String>();
    private static Canvas canvas = new Canvas();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPaneInfoGame = new GridPane();
        GridPane gridPaneInfoPlayer = new GridPane();
        
        ColumnConstraints colConstInfoGame = new ColumnConstraints(getCartX()/4);
        ColumnConstraints colConstrInfoGame2 = new ColumnConstraints(getCartX()/4);
        gridPaneInfoGame.getColumnConstraints().addAll(colConstInfoGame,colConstrInfoGame2);
        //gridPaneInfoGame.getRowConstraints().add(rowConstInfoGame);
        
        RowConstraints rowConstInfoPlayer = new RowConstraints(getCartY()/8);
        RowConstraints rowConstInfoPlayer2 = new RowConstraints(7*getCartY()/8);
        gridPaneInfoPlayer.getRowConstraints().addAll(rowConstInfoPlayer,rowConstInfoPlayer2);
        ColumnConstraints colConstInfoPlayer = new ColumnConstraints(getCartX());
        gridPaneInfoPlayer.getColumnConstraints().add(colConstInfoPlayer);
        
        Label metrologyLabel = new Label ("Metrology : ");
        Label hourLabel = new Label ("Hours :");
        gridPaneInfoGame.setConstraints(metrologyLabel,0,0);
        gridPaneInfoGame.setConstraints(metrology,1,0);
        gridPaneInfoGame.setConstraints(hourLabel,0,1);
        gridPaneInfoGame.setConstraints(hour,1,1);
        
        Label cashLabel = new Label ("cash : ");
        Label profitLabel = new Label ("profit: ");
        Label salesLabel = new Label("sales : ");
        Label rankingLabel = new Label("ranking : ");
        gridPaneInfoPlayer.setConstraints(rankingLabel, 1, 2);
        gridPaneInfoPlayer.setConstraints(ranking,2,2);
        gridPaneInfoPlayer.setConstraints(cashLabel,1,3);
        gridPaneInfoPlayer.setConstraints(cash,2,3);
        gridPaneInfoPlayer.setConstraints(profitLabel,1,4);
        gridPaneInfoPlayer.setConstraints(profit,2,4);
        gridPaneInfoPlayer.setConstraints(salesLabel,1,5);
        gridPaneInfoPlayer.setConstraints(sales,2,5);
        
        
        
        gridPaneInfoGame.getChildren().addAll(metrologyLabel,metrology,hourLabel,hour);
        gridPaneInfoPlayer.getChildren().addAll(rankingLabel,ranking,cashLabel,cash,profitLabel,profit,salesLabel,sales);
        
        System.out.println("size : " + InterfaceG.region.getListPlayer().size());
        for (int i = 0 ; i < InterfaceG.region.getListPlayer().size() ; i ++){
            cmb.getItems().add(InterfaceG.region.getListPlayer().get(i).getName().toString());
        }
        
        gridPaneInfoPlayer.setConstraints(cmb, 1, 0);
        gridPaneInfoPlayer.getChildren().add(cmb);
        
                
        StackPane root = new StackPane();
        root.getChildren().add(gridPaneInfoGame);
        root.getChildren().add(gridPaneInfoPlayer);
        
        Scene scene = new Scene(root, getCartX(), getCartY());
        
        primaryStage.setTitle("Lemonade :: Face / Off");
        primaryStage.setScene(scene);
        
        ThreadIG threadIg = new ThreadIG();
        threadIg.start();
            
        primaryStage.show();
    }
    
    public static void changeHour(int hour){
        int hourDisplay = hour % 24;
        String display = Integer.toString(hourDisplay);
        InterfaceG.hour.setText(Integer.toString(hourDisplay));
    }
    
    public static void changeMetrology (String metrology){
        InterfaceG.metrology.setText(metrology);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadSimu thread = new ThreadSimu();
        thread.start();
        Thread.sleep(125000);
        launch(args);
    }  

    /**
     * @return the hour
     */
    public static Label getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(Label hour) {
        this.hour = hour;
    }

    /**
     * @return the metrology
     */
    public static Label getMetrology() {
        return metrology;
    }

    /**
     * @param metrology the metrology to set
     */
    public void setMetrology(Label metrology) {
        this.metrology = metrology;
    }

    /**
     * @return the region
     */
    public static Region getRegion() {
        return region;
    }

    /**
     * @param aRegion the region to set
     */
    public static void setRegion(Region aRegion) {
        region = aRegion;
    }
    
    /**
     * @return the cash
     */
    public static Label getCash() {
        return cash;
    }

    /**
     * @param aCash the cash to set
     */
    public static void setCash(Label aCash) {
        cash = aCash;
    }

    /**
     * @return the profit
     */
    public static Label getProfit() {
        return profit;
    }

    /**
     * @param aProfit the profit to set
     */
    public static void setProfit(Label aProfit) {
        profit = aProfit;
    }

    /**
     * @return the sales
     */
    public static Label getSales() {
        return sales;
    }

    /**
     * @param aSales the sales to set
     */
    public static void setSales(Label aSales) {
        sales = aSales;
    }

    /**
     * @return the cartX
     */
    public static int getCartX() {
        return cartX;
    }

    /**
     * @param aCartX the cartX to set
     */
    public static void setCartX(int aCartX) {
        cartX = aCartX;
    }

    /**
     * @return the cartY
     */
    public static int getCartY() {
        return cartY;
    }

    /**
     * @param aCartY the cartY to set
     */
    public static void setCartY(int aCartY) {
        cartY = aCartY;
    }
    
    private class ThreadIG extends Thread{
        ThreadIG(){
            
        }
        
        public void run(){
            while(true){
                Platform.runLater(()->{
                    InterfaceG.metrology.setText(InterfaceG.region.getMetrology());
                    int hourDisplay = InterfaceG.region.getTimestamp() % 24;
                    String display = Integer.toString(hourDisplay);
                    InterfaceG.hour.setText(display+"h");
                    
                    for (int i = 0 ; i<InterfaceG.region.getListPlayer().size() ; i++){
                        if(InterfaceG.region.getListPlayer().get(i).getName().equals(InterfaceG.cmb.getValue())){
                            cash.setText(Integer.toString((int) InterfaceG.region.getListPlayer().get(i).getCash()));
                            profit.setText(Integer.toString((int) InterfaceG.region.getListPlayer().get(i).getProfit()));
                            sales.setText(Integer.toString(InterfaceG.region.getListPlayer().get(i).getSales()));
                            ranking.setText(Integer.toString(i+1));
                        }
                    }
                });
                try {
                Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(InterfaceG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
