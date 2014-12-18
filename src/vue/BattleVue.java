/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import con.JoueurCont;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mod.Configuration;
import mod.Grille;

/**
 *
 * @author ueve
 */
public class BattleVue extends Stage{
    
    private GrilleVue grilleVueJ1;
    private GrilleVue grilleVueJ2;
    

    public BattleVue(GrilleVue gv) {
        this.grilleVueJ2 = Accueil.getPartie().getJoueur(1).getGrille().getVue();
        if (!Configuration.getModePartie().equals("MultiJoueur")) {
            this.grilleVueJ1 = gv;
        }
        else{
            this.grilleVueJ1 = Accueil.getPartie().getJoueur(0).getGrille().getVue();
        }
        BorderPane tour = new BorderPane();
        
        grilleVueJ2.rotDroit();
        tour.setLeft(grilleVueJ1.getLbl());
        tour.setRight(grilleVueJ2.getLbl());
        
        BorderPane pan = new BorderPane();
        
        pan.setLeft(grilleVueJ1);
        pan.setRight(grilleVueJ2);
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                final int x = i;
                final int y = j;
                grilleVueJ2.getCaseBtn(Integer.parseInt(String.valueOf(i)+String.valueOf(j))).setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            if (Accueil.getPartie().getJouEnCours() == 1) {
                                JoueurCont.tirer(x, y);
                            }
                        }
                    });
            }
        }
        
        pan.setCenter(tour);
        if (Configuration.getModePartie().equals("MultiJoueur")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    final int x = i;
                    final int y = j;
                    grilleVueJ1.getCaseBtn(Integer.parseInt(String.valueOf(i)+String.valueOf(j))).setOnMouseClicked(new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent me) {
                                if (Accueil.getPartie().getJouEnCours() == 0) {
                                    JoueurCont.tirer(x, y);
                                }
                            }
                        });
                }
        }
        }
 
        Grille grille = Accueil.getPartie().getJoueur(1).getGrille();
        if (!Configuration.getModePartie().equals("MultiJoueur")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (grille.getCasGrille(j, i).getEtat().equals("Plein")) {
                        grilleVueJ2.getCaseBtn(Integer.parseInt(String.valueOf(j)+String.valueOf(i))).setStyle("-fx-base: #FFAB00;");
                    }
                }
            }
        }
        Scene scene = new Scene(pan);
        setTitle("Sea Battle");
        setScene(scene);
        show();
    }
    
    
}
