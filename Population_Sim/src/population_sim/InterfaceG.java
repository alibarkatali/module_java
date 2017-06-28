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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeDate;

/**
 *
 * @author matthieu
 */
public class InterfaceG extends Application {
    public static Region region = new Region();
    private Label hour;
    private Label metrology;
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        ColumnConstraints column4 = new ColumnConstraints();
        column1.setPercentWidth(25);
        column2.setPercentWidth(25);
        column3.setPercentWidth(25);
        column4.setPercentWidth(25);
        gridPane.setVisible(true);
        gridPane.getColumnConstraints().addAll(column1,column2,column3,column4);
        Label metrologyLabel = new Label ("Metrology : ");
        Label hourLabel = new Label ("Hours :");
        setMetrology(new Label());
        setHour(new Label());
        gridPane.add(metrologyLabel, 0, 0);
        gridPane.add(getMetrology(),1,0);
        gridPane.add(hourLabel,2,0);
        gridPane.add(getHour(),3,0);
        
        GridPane gridPane2 = new GridPane();
        ColumnConstraints column5 = new ColumnConstraints();
        ColumnConstraints column6 = new ColumnConstraints();
        column5.setPercentWidth(75);
        column6.setPercentWidth(25);
        gridPane2.getColumnConstraints().addAll(column5,column6);
        gridPane2.setVisible(true);
        
        /*
        TreeItem <String> playerList = new TreeItem <String> ("Player");
        for(int i = 0 ; i < region.getListPlayer().size() ; i++){
            TreeItem <String> playerInfo = new TreeItem <String> (region.getListPlayer().get(i).getName());
            playerList.setExpanded(true);
            TreeItem <String> playerPos = new TreeItem <String> ("position");
            playerPos.getChildren().addAll(
                new TreeItem <String> ("longitude : " + region.getListPlayer().get(i).getListItem().get(0).getLocation().getLongitude()),
                new TreeItem <String> ("latitude : " + region.getListPlayer().get(i).getListItem().get(0).getLocation().getLatitude())
            );
            TreeItem <String> adPos = new TreeItem <String> ("ad");
            int nbAd = region.getListPlayer().get(i).getListItem().size() ;
            for(int j = 0 ; j < nbAd ; j++){
                if(region.getListPlayer().get(i).getListItem().get(j).getKind() == Kind_Items.AD){
                    TreeItem <String> pub = new TreeItem <String> ("pub " + j);
                    pub.getChildren().addAll(
                            new TreeItem <String> ("longitude"),
                            new TreeItem <String> ("latitude")
                    );
                    adPos.getChildren().addAll(pub);
                }
            }
            playerInfo.getChildren().addAll(
                    new TreeItem <String> ("budget : " + region.getListPlayer().get(i).getCash()),
                    new TreeItem <String> ("sales : " + region.getListPlayer().get(i).getSales()),
                    new TreeItem <String> ("profit : " + region.getListPlayer().get(i).getProfit())
            );
            TreeItem <String> drinkInfo = new TreeItem < String> ("Drink Info");
            drinkInfo.getChildren().addAll(
                new TreeItem <String> ("nom : "),
                new TreeItem <String> ("prix : "),
                new TreeItem <String> ("alcohol : "),
                new TreeItem <String> ("froid : ")
            );
            playerInfo.getChildren().addAll(playerPos);
            playerInfo.getChildren().addAll(adPos);
            playerInfo.getChildren().addAll(drinkInfo);
            playerList.getChildren().addAll(playerInfo);
        }
        TreeView <String> tree = new TreeView <String> (playerList);
        tree.setVisible(true);
        gridPane2.add(tree,1,2);
        */
        
        ComboBox <String> cmb = new ComboBox<String>();
        System.out.println("size : " + InterfaceG.region.getListPlayer().size());
        
        cmb.setVisible(true);
        gridPane2.add(cmb, 1, 2);
        
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        root.getChildren().add(gridPane2);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Lemonade :: Face / Off");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void changeHour(String hour){
        getHour().setText(hour);
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
}
