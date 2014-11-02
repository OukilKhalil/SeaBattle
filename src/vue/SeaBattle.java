/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mod.Cuirasses;
import mod.Navire;
import mod.Partie;
import mod.PorteAvions;
import mod.SousMarin;
import mod.Zodiac;

/**
 *
 * @author badr
 */
public class SeaBattle extends Application {
    
    
    private Partie partie;
    private GrilleVue grille;
    private InitialisationVue initialisationVue;
    private static int navEnCours;
    private static Navire navires [] = new Navire[5];
    
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
        
        
        initialisationNav();
        
        BorderPane paneau = new BorderPane();
        BorderPane affichage = new BorderPane();
        grille = new GrilleVue();
        initialisationVue = new InitialisationVue();
        
        Label point = new Label("Case : ");
        
        affichage.setTop(initialisationVue);
        affichage.setBottom(point);
        paneau.setLeft(grille);
        paneau.setRight(affichage);
        
        StackPane root = new StackPane();
        root.getChildren().add(paneau);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Sea Battle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void initialisationNav(){
        
        navires[0] = new PorteAvions();
        navires[1] = new SousMarin();
        navires[2] = new Cuirasses();
        navires[3] = new Cuirasses();
        navires[4] = new Zodiac();
        
    }

    public static int getNavEnCours() {
        return navEnCours;
    }

    public static void setNavEnCours(int navEnCours) {
        SeaBattle.navEnCours = navEnCours;
    }

    public static Navire getNavires() {
        return navires[navEnCours];
    }
    
    
    
    /*public FlowPane bouttonNavires(){
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
