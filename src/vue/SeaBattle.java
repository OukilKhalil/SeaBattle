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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
    
    
    private static Partie partie;
    private GrilleVue grille;
    private InitialisationVue initialisationVue;
    private static int navEnCours;
    private static Navire navires [] = new Navire[5];
    
    @Override
    public void start(Stage primaryStage) {
        partie = new Partie();
        
        initialisationNav();
        
        BorderPane paneau = new BorderPane();
        BorderPane affichage = new BorderPane();
        grille = new GrilleVue();
        
        initialisationVue = new InitialisationVue();
        
        final Stage primary = primaryStage;
        affichage.setTop(initialisationVue);
        Button rein = new Button("Reinésialiser");
        rein.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        start(primary);
                    }
                });
        affichage.setBottom(rein);
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

    public static Partie getPartie() {
        return partie;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
