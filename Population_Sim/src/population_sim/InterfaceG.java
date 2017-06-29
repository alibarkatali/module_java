/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeDate;

/**
 *
 * @author matthieu
 */
public class InterfaceG extends Application {
    static Region region = new Region();
    public static Label hour = new Label();
    public static Label metrology = new Label();
    private static Label cash = new Label();
    private static Label profit = new Label();
    private static Label sales = new Label();
    private static int cartX = 800;
    private static int cartY = 700;
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
        gridPaneInfoPlayer.setConstraints(cashLabel,0,2);
        gridPaneInfoPlayer.setConstraints(cash,1,2);
        
        gridPaneInfoGame.getChildren().addAll(metrologyLabel,metrology,hourLabel,hour);
        gridPaneInfoPlayer.getChildren().addAll(cashLabel, getCash());
        
        ComboBox <String> cmb = new ComboBox<String>();
        //cmb.getItems().add("coucou");
        //cmb.getItems().add("test");
        
        
        System.out.println("size : " + InterfaceG.region.getListPlayer().size());
        for (int i = 0 ; i < InterfaceG.region.getListPlayer().size() ; i ++){
            cmb.getItems().add(InterfaceG.region.getListPlayer().get(i).getName().toString());
        }/**/
        
        cmb.setOnAction((event)->{
            System.out.println(cmb.getValue());
        });
        
        gridPaneInfoPlayer.setConstraints(cmb, 1, 0);
        gridPaneInfoPlayer.getChildren().addAll(cmb);
        
        
        //cmb.setVisible(true);
        
        //gridPaneInfoGame.setGridLinesVisible(true);
        gridPaneInfoPlayer.setGridLinesVisible(true);
        
        StackPane root = new StackPane();
        root.getChildren().add(gridPaneInfoGame);
        root.getChildren().add(gridPaneInfoPlayer);
        
        Scene scene = new Scene(root, getCartX(), getCartY());
        
        primaryStage.setTitle("Lemonade :: Face / Off");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void changeHour(int hour){
        int hourDisplay = hour % 24;
        String display = Integer.toString(hourDisplay);
        getHour().setText(display);
    }
    
    public void changeMetrology (String metrology){
        getMetrology().setText(metrology);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadIG thread = new ThreadIG();
        thread.start();
        Thread.sleep(5000);
        launch(args);
    }  

    /**
     * @return the hour
     */
    public Label getHour() {
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
    public Label getMetrology() {
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
}
