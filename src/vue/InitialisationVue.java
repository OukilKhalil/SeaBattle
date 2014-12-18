/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import con.JoueurCont;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mod.Configuration;

/**
 *
 * @author badr
 */
public class InitialisationVue extends Stage {
    
    
    
    private static NavirePaneVue navirePaneVue;
    private static int navEnCours;
    private static BorderPane paneau;
    private static BorderPane affichage;
    private static StackPane root;
    
    public InitialisationVue() {
        
        if (!Configuration.getModePartie().equals("MultiJoueur")) {
            Accueil.getPartie().setJouEnCours(1);
            Accueil.getPartie().getOrdinateur().placer();
            Accueil.getPartie().setJouEnCours(0);
        }
        
        paneau = new BorderPane();
        affichage = new BorderPane();
        final GrilleVue grilleVue = Accueil.getPartie().getJoueur().getGrille().getVue();
        
        navirePaneVue = new NavirePaneVue();
        
        affichage.setTop(navirePaneVue);
        Button rein = new Button("Reinésialiser");
        rein.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Accueil.getPartie().getJoueur().getGrille().getVue().youpi();
                    }
                });
        Button auto = new Button("AUTO");
        auto.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        actualiser();
                        JoueurCont.placerAuto();
                    }
                });
        Button go = new Button("SeaBattle");
        go.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if ((!Configuration.getModePartie().equals("MultiJoueur")) || Accueil.getPartie().getJouEnCours() == 1) {
                            BattleVue bv = new BattleVue(Accueil.getPartie().getJoueur(0).getGrille().getVue());
                            Accueil.getPartie().setJouEnCours();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        }
                        else{
                            Accueil.getPartie().setJouEnCours();
                            InitialisationVue iv = new InitialisationVue();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        }
                        System.out.println(Accueil.getPartie().getJouEnCours());
                    }
                });
        VBox vbox = new VBox(auto, rein, go);
        affichage.setBottom(vbox);
        
        paneau.setLeft(grilleVue);
        paneau.setRight(affichage);
        
        root = new StackPane();
        root.getChildren().add(paneau);
        
        Scene scene = new Scene(root);
        
        setTitle("Sea Battle");
        setScene(scene);
        show();
    }

    public static int getNavEnCours() {
        return navEnCours;
    }

    public static void setNavEnCours(int navEnCours) {
        InitialisationVue.navEnCours = navEnCours;
    }

    public static void actualiser(){
        navirePaneVue = new NavirePaneVue();
        affichage.setTop(navirePaneVue);
        Accueil.getPartie().getJoueur().getGrille().setVue(new GrilleVue());
        paneau.setLeft(Accueil.getPartie().getJoueur().getGrille().getVue());
    }

    public static NavirePaneVue getNavirePaneVue() {
        return navirePaneVue;
    }

    public static void setNavirePaneVue(NavirePaneVue navirePaneVue) {
        InitialisationVue.navirePaneVue = navirePaneVue;
    }
    
}
