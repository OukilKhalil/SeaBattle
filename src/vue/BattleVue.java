/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
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
    private static ProgressBar pb[];
    
    

    public BattleVue(GrilleVue gv) {
        
        this.grilleVueJ2 = Accueil.getPartie().getJoueur(1).getGrille().getVue();
        if (!Configuration.getModePartie().equals("MultiJoueur")) {
            this.grilleVueJ1 = gv;
        }
        else{
            this.grilleVueJ1 = Accueil.getPartie().getJoueur(0).getGrille().getVue();
        }
        BorderPane tour = new BorderPane();
        BorderPane left = new BorderPane();
        BorderPane right = new BorderPane();
        
        pb = new ProgressBar[2];
        pb[0] = new ProgressBar(1);
        pb[0].setPrefSize(500, 40);
        pb[1] = new ProgressBar(1);
        pb[1].setPrefSize(500, 40);
        
        left.setTop(pb[0]);
        right.setTop(pb[1]);
        
        
        grilleVueJ2.rotDroit();
        
        tour.setLeft(grilleVueJ1.getLbl());
        tour.setRight(grilleVueJ2.getLbl());
        
        BorderPane pan = new BorderPane();
        
        left.setBottom(grilleVueJ1);
        right.setBottom(grilleVueJ2);
        pan.setLeft(left);
        pan.setRight(right);
        
        grilleVueJ2.setModeNrml();
        
        pan.setCenter(tour);
        
        if (Configuration.getModePartie().equals("MultiJoueur")) {
            grilleVueJ1.setModeNrml();
        }
 
        if (Configuration.getTypePartie().equals("Opération Artillerie")) {
            grilleVueJ2.setTypeArt();
            if (Configuration.getModePartie().equals("MultiJoueur")) {
                grilleVueJ1.setTypeArt();
            }
        }
        else if (Configuration.getTypePartie().equals("Alerte Rouge")) {
            grilleVueJ2.setTypeAR();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    grilleVueJ2.getCaseBtn(99).requestFocus();
                }
            });
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
    
    public static void decrementer(int i){
        pb[i].setProgress(pb[i].getProgress()-0.059);
    }
}
