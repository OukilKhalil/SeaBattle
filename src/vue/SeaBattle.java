/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import con.SelectCase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mod.Cuirasses;
import mod.Navire;
import mod.PorteAvions;
import mod.SousMarin;
import mod.Zodiac;

/**
 *
 * @author badr
 */
public class SeaBattle extends Application {
    
    private static Button buttons [] = new Button[100];
    private Navire navEnCours;
    
    @Override
    public void start(Stage primaryStage) {
        /*Grille.intialisation();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        
        GridPane grid = new GridPane();
        intialisationBtn();
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String x = Integer.toString(i) + Integer.toString(j);
                grid.add(buttons[Integer.parseInt(x)], i, j);
            }
        }
        
        
        BorderPane paneau = new BorderPane();
        BorderPane affichage = new BorderPane();
        FlowPane navire = bouttonNavires();
        
        Label point = new Label("Case : ");
        
        affichage.setTop(navire);
        affichage.setBottom(point);
        paneau.setLeft(grid);
        paneau.setRight(affichage);
        
        StackPane root = new StackPane();
        root.getChildren().add(paneau);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Sea Battle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void intialisationBtn(){
        for (int i = 0; i < 100; i++) {
            buttons [i] = new Button("  ");
            final int code = i;
            buttons [i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        /*Button btn = (Button)event.getSource();
                        btn.setDefaultButton(true);*/
                        System.out.println(navEnCours.getType()+"  "+navEnCours.getPosition());
                        SelectCase.selectioner(code,navEnCours.getTaille());
                    }
                });
        }
    }
    
    public static void selectCase(int x){
        buttons[x].setStyle("-fx-base: #b6e7c9;");
    }
    
    public FlowPane bouttonNavires(){
        FlowPane navire = new FlowPane();
        Button porAvBtn = new Button("Porte-Avions(5)");
        porAvBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(navEnCours != null){
                            if(navEnCours.getClass().toString().equals("class mod.PorteAvions")){
                                if(navEnCours.getPosition().equals("V"))
                                    navEnCours.setPosition("H");
                                else navEnCours.setPosition("V");
                            }
                        }
                        
                        else navEnCours = new PorteAvions();
                    }
                });
        Button souMaBtn = new Button("Sous Marine(4)");
        souMaBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        navEnCours = new SousMarin();
                    }
                });
        Button cui1Btn = new Button("Cuirasses 1(3)");
        cui1Btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        navEnCours = new Cuirasses();
                    }
                });
        Button cui2Btn = new Button("Cuirasses 2(3)");
        cui2Btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        navEnCours = new Cuirasses();
                    }
                });
        Button zodBtn = new Button("Zodiac(2)");
        zodBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        navEnCours = new Zodiac();
                    }
                });
        navire.getChildren().add(porAvBtn);
        navire.getChildren().add(souMaBtn);
        navire.getChildren().add(cui1Btn);
        navire.getChildren().add(cui2Btn);
        navire.getChildren().add(zodBtn);
        return navire;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
