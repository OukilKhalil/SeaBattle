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
        this.grilleVueJ1 = gv;
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
                            JoueurCont.tirer(x, y);
                        }
                    });
            }
        }
        pan.setCenter(tour);
        
        Grille grille = Accueil.getPartie().getOrdinateur().getGrille();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grille.getCasGrille(j, i).getEtat().equals("Plein")) {
                    grilleVueJ2.getCaseBtn(Integer.parseInt(String.valueOf(j)+String.valueOf(i))).setStyle("-fx-base: #FFAB00;");
                }
            }
            System.out.println();
        }
        Scene scene = new Scene(pan);
        setTitle("Sea Battle");
        setScene(scene);
        show();
    }
    
    
}
