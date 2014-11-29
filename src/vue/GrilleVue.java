/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import mod.Navire;

/**
 *
 * @author ueve
 */
public class GrilleVue extends GridPane{
    
    private  CaseBtn caseBtn [] = new CaseBtn[100];

    public GrilleVue() {
        
        for (int i = 0; i < 100; i++) {
            caseBtn [i] = new CaseBtn(i);
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String x = Integer.toString(i) + Integer.toString(j);
                add(caseBtn[Integer.parseInt(x)], i, j);
            }
        }
    }
    
    public void select(int x){
        
        int cases[] = new int[cases(x).length];
        cases = cases(x);
        for (int i = 0; i < cases.length; i++) {
            ImageView im = new ImageView(new Image(GrilleVue.class.getResourceAsStream("/ressources/icons/n"+(SeaBattle.getNavEnCours()+1)+"/" + (i + 1) + ".png")));
            im.setFitHeight(50.0);
            im.setFitWidth(50.0);
            caseBtn[cases[i]].setGraphic(im);
            if (SeaBattle.getPartie().getJoueur(0).getNavires().getPosition().equals("V")) {
                caseBtn[cases[i]].setRotate(90);
            }
            caseBtn[cases[i]].setStyle("");
            caseBtn[cases[i]].setText("");
            caseBtn[cases[i]].setPadding(Insets.EMPTY);
            SeaBattle.getInitialisationVue().getLblEnCours().setDisable(true);
        }
        
    }
    
    public void focusCases(int x){
        
        int cases[] = new int[cases(x).length];
        cases = cases(x);
        if(cases.length == 0){
            caseBtn[x].setDisable(true);
        }
        else{
            for (int i = 0; i < cases.length; i++) {
            if(!caseBtn[cases[i]].getStyle().equals("-fx-base: #b6aaa9;"))
                caseBtn[cases[i]].setFocus();
            }
        }
    }
    
    public void UnfocusCases(int x){
        
        int cases[] = new int[cases(x).length];
        cases = cases(x);
        if(cases.length == 0){
            caseBtn[x].setDisable(false);
        }
        else{
            for (int i = 0; i < cases.length; i++) {
                if(caseBtn[cases[i]].getStyle().equals("-fx-base: #b6e7c9;"))
                    caseBtn[cases[i]].setUnFocus();
            }
        }
    }
    
    public int[] cases(int x){
        
        Navire nav = SeaBattle.getPartie().getJoueur(0).getNavires();
        int t = nav.getTaille();
        int tab[] = new int[t];
        if(nav.getPosition().equals("V")){
            if (x+t <= caseBtn[x].nextLineV(x)) {
                for (int i = x; i < x+t; i++) {
                    if (caseBtn[i].getText().equals("")) {
                        return new int[0];
                    }
                    tab[i-x]= i;
                }
                return tab;
            }
        }
        else{
            if (x+t*10 <= caseBtn[x].nextLineH(x)) {
                for (int i = x, j=0; i < x+t*10; i=i+10,j++) {
                    if (caseBtn[i].getText().equals("")) {
                        return new int[0];
                    }
                    tab[j]= i;
                }
                return tab;
            }
        }
        return new int[0];
    }

    public CaseBtn getCaseBtn(int i) {
        return caseBtn[i];
    }  
    
}
