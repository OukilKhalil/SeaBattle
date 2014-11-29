/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import con.JoueurCont;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        this.grilleVueJ2 = SeaBattle.getPartie().getJoueur(1).getGrille().getVue();
        this.grilleVueJ1 = gv;
        BorderPane tour = new BorderPane();
        ImageView im1 = new ImageView(new Image(GrilleVue.class.getResourceAsStream("/ressources/icons/fleche5.png")));
        im1.setRotate(180.0);
        im1.setFitHeight(50.0);
        im1.setFitWidth(50.0);
        Label lbl1 = new Label("", im1);
        ImageView im2 = new ImageView(new Image(GrilleVue.class.getResourceAsStream("/ressources/icons/fleche5.png")));
        im2.setRotate(360.0);
        im2.setFitHeight(50.0);
        im2.setFitWidth(50.0);
        Label lbl2 = new Label("", im2);
        
        lbl1.setDisable(true);
        

        lbl1.setPrefHeight(500.0);
        lbl2.setPrefHeight(500.0);
        tour.setLeft(lbl1);
        tour.setRight(lbl2);
        
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
        
        Grille grille = SeaBattle.getPartie().getOrdinateur().getGrille();
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
