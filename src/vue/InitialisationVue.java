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
        
        paneau = new BorderPane();
        affichage = new BorderPane();
        final GrilleVue grilleVue = Accueil.getPartie().getJoueur(0).getGrille().getVue();
        
        navirePaneVue = new NavirePaneVue();
        
        affichage.setTop(navirePaneVue);
        Button rein = new Button("Reinésialiser");
        rein.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        actualiser();
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
        Button go = new Button("To The Battle");
        go.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        BattleVue bv = new BattleVue(Accueil.getPartie().getJoueur().getGrille().getVue());
                        Accueil.getPartie().setJouEnCours();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
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
        Accueil.getPartie().getJoueur(0).getGrille().setVue(new GrilleVue());
        paneau.setLeft(Accueil.getPartie().getJoueur(0).getGrille().getVue());
    }

    public static NavirePaneVue getNavirePaneVue() {
        return navirePaneVue;
    }

    public static void setNavirePaneVue(NavirePaneVue navirePaneVue) {
        InitialisationVue.navirePaneVue = navirePaneVue;
    }
    
}
