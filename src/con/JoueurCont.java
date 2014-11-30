/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mod.CaseGrille;
import mod.Joueur;
import mod.Navire;
import vue.CaseBtn;
import vue.GrilleVue;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class JoueurCont {
    
    public static void tirer(int x, int y){
        Joueur joueur = SeaBattle.getPartie().getJoueur();
        ImageView im = new ImageView(new Image(GrilleVue.class.getResourceAsStream("/ressources/icons/explosion.png")));
        im.setFitHeight(50.0);
        im.setFitWidth(50.0);
        ImageView im2 = new ImageView(new Image(GrilleVue.class.getResourceAsStream("/ressources/icons/empty.png")));
        im2.setFitHeight(50.0);
        im2.setFitWidth(50.0);
        CaseBtn cb = SeaBattle.getPartie().getJoueur().getGrille().getVue().getCaseBtn(Integer.parseInt(String.valueOf(x)+String.valueOf(y)));
        cb.setPadding(Insets.EMPTY);
        if(joueur.getGrille().getCasGrille(x, y).getEtat().equals("Plein")){
            cb.setGraphic(im);
            cb.setStyle("");
            cb.setText("");
            for (int i = 0; i < 5; i++) {
                Navire nav  = joueur.getNavires(i);
                if(nav.getCases().contains(new CaseGrille("Plein", x, y))){
                    nav.setPartie_touchee(nav.getPartie_touchee()+1);
                }
            }
        }
        else{
            cb.setGraphic(im2);
            cb.setStyle("");
            cb.setText("");
        }
        joueur.getGrille().getCasGrille(x, y).setEtat("Tirer");
        cb.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            
                        }
                    });
        
        SeaBattle.getPartie().setJouEnCours();
    }
}
