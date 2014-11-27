/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import mod.Joueur;
import mod.Navire;
import mod.Point;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class JoueurCont {
    
    public static void tirer(int x, int y){
        Joueur joueur = SeaBattle.getPartie().getJoueur();
        if(joueur.getGrille().getCasGrille(x, y).getEtat().equals("Plein")){
            for (int i = 0; i < 5; i++) {
                Navire nav  = joueur.getNavires(i);
                if(nav.getCases().contains(new Point(x, y))){
                    nav.setPartie_touchee(nav.getPartie_touchee()+1);
                    System.out.println("Touchéé !!");
                }
                
            }
        }
    }
}
