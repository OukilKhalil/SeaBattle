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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mod.Joueur;
import mod.Partie;

/**
 *
 * @author badr
 */
public class SeaBattle extends Application {
    
    
    private static Partie partie;
    private static InitialisationVue initialisationVue;
    private static int navEnCours;
    private static BorderPane paneau;
    private static BorderPane affichage;
    private static StackPane root;
    
    @Override
    public void start(Stage primaryStage) {
        partie = new Partie();
        
        paneau = new BorderPane();
        affichage = new BorderPane();
        final GrilleVue grilleVue = SeaBattle.getPartie().getJoueur(0).getGrille().getVue();
        
        initialisationVue = new InitialisationVue();
        
        affichage.setTop(initialisationVue);
        Button rein = new Button("Reinésialiser");
        rein.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        BattleVue bv = new BattleVue(grilleVue);
                        //actualiser();
                    }
                });
        affichage.setBottom(rein);
        paneau.setLeft(grilleVue);
        paneau.setRight(affichage);
        
        
        
        root = new StackPane();
        root.getChildren().add(paneau);
        partie.getOrdinateur().placer();
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Sea Battle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static int getNavEnCours() {
        return navEnCours;
    }

    public static void setNavEnCours(int navEnCours) {
        SeaBattle.navEnCours = navEnCours;
    }


    public static Partie getPartie() {
        return partie;
    }

    public static void actualiser(){
        initialisationVue = new InitialisationVue();
        affichage.setTop(initialisationVue);
        SeaBattle.getPartie().getJoueur(0).getGrille().setVue(new GrilleVue());
        paneau.setLeft(SeaBattle.getPartie().getJoueur(0).getGrille().getVue());
    }

    public static InitialisationVue getInitialisationVue() {
        return initialisationVue;
    }

    public static void setInitialisationVue(InitialisationVue initialisationVue) {
        SeaBattle.initialisationVue = initialisationVue;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
