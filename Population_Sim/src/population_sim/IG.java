/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population_sim;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author matthieu
 */
public class IG extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        GridPane gridPane = new GridPane();
        Label metrology = new Label ("Metrology : ");
        Label day = new Label ("Days # ");
        Label hour = new Label ("Hours :");
        
        gridPane.add(metrology, 0, 0);
        gridPane.add(day,1,0);
        gridPane.add(hour,2,0);
        
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Lemonade :: Face / Off");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
