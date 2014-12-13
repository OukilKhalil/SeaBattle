/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import mod.CaseGrille;
import mod.Grille;
import mod.Joueur;
import mod.Navire;
import vue.CaseBtn;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class JoueurCont {
    
    public static void tirer(int x, int y){
        Joueur joueur = SeaBattle.getPartie().getJoueur();
        
        CaseBtn cb = SeaBattle.getPartie().getJoueur().getGrille().getVue().getCaseBtn(Integer.parseInt(String.valueOf(x)+String.valueOf(y)));
        cb.setPadding(Insets.EMPTY);
        if(joueur.getGrille().getCasGrille(x, y).getEtat().equals("Plein")){
            cb.setExplosion();
            cb.setStyle("");
            cb.setText("");
            for (int i = 0; i < 5; i++) {
                Navire nav  = joueur.getNavires(i);
                if(nav.getCases().contains(new CaseGrille("Plein", x, y))){
                    nav.setPartie_touchee(nav.getPartie_touchee()+1);
                }
            }
            if (SeaBattle.getPartie().getJouEnCours() == 0) {
                SeaBattle.getPartie().setJouEnCours();
                SeaBattle.getPartie().setJouEnCours();
            }
        }
        else{
            cb.setEmpty();
            cb.setStyle("");
            SeaBattle.getPartie().setJouEnCours();
        }
        
        joueur.getGrille().getCasGrille(x, y).setEtat("Tirer");
        cb.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            
                        }
                    });
    }
    
    public static void placerAuto(){
        
        Joueur joueur = SeaBattle.getPartie().getJoueur();
                
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int nbr = rand.nextInt(2 - 1 + 1) + 1;
            char pos = nbr == 2 ? 'H' : 'V';
            joueur.getNavires(i).setPosition(String.valueOf(pos));
            int xy[] = xy();
            while (cases(xy[0], xy[1], i).length==0) {
                xy = xy();
            }
            
            joueur.getNavires(i).setCoordonneeX(xy[0]);
            joueur.getNavires(i).setCoordonneeY(xy[1]);
            
            SeaBattle.setNavEnCours(i);
            if(SeaBattle.getPartie().getJouEnCours() == 0)
                joueur.getGrille().getVue().select(Integer.parseInt(String.valueOf(xy[0])+String.valueOf(xy[1])));
            
            Navire n = SeaBattle.getPartie().getJoueur().getNavires(i);
            System.out.println(n.getType()+"   "+n.getCoordonneeX()+":"+n.getCoordonneeY()+"   "+n.getPosition());
        }
    }
    
    private static int[] xy(){
        
        int tab[] = new int[2];

        Random rand = new Random();
        tab[0] = rand.nextInt(10);
        tab[1] = rand.nextInt(10);

        return tab;
    }
    
    public static int[] cases(int x, int y,int i){
        
        String pos = SeaBattle.getPartie().getJoueur().getNavires(i).getPosition();
        int taille = SeaBattle.getPartie().getJoueur().getNavires(i).getTaille();
        Grille grille = SeaBattle.getPartie().getJoueur().getGrille();
        int tab[] = new int[taille];
        
        if(pos.equals("V")){
            if(taille+y > 10){
                return new int[0];
            }
            for (int j = y; j < y+taille; j++) {
                if (SeaBattle.getPartie().getJoueur().getGrille().getCasGrille(x, j).getEtat().equals("Plein")) {
                    return new int[0];
                }
                tab[j-y] = j;
            }
            for (int j = y; j < y+taille; j++) {
                grille.getCasGrille(x, j).setEtat("Plein");
            }
            
        }
        else{
            if(taille+x > 10){
                return new int[0];
            }
            for (int j = x; j < x+taille; j++) {
                if (SeaBattle.getPartie().getJoueur().getGrille().getCasGrille(j, y).getEtat().equals("Plein")) {
                    return new int[0];
                }
                tab[j-x] = j;
            }
            for (int j = x; j < x+taille; j++) {
                grille.getCasGrille(j, y).setEtat("Plein");
            }
        }
        return tab;
    }
}
