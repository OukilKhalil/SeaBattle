/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import java.util.Random;
import mod.Grille;
import mod.Navire;
import vue.GrilleVue;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class OrdinateurCont {
    
    
    
    public static void placer(){
        
        GrilleVue gv = new GrilleVue();
        for (int i = 0; i < 5; i++) {
            int cases[];
            Random rand = new Random();
            int nbr = rand.nextInt(2 - 1 + 1) + 1;
            char pos = nbr == 2 ? 'H' : 'V';
            SeaBattle.getPartie().getOrdinateur().getNavires(i).setPosition(String.valueOf(pos));
            int xy[] = xy();
            while (cases(xy[0], xy[1], i).length==0) {
                xy = xy();
            }
            
            SeaBattle.getPartie().getOrdinateur().getNavires(i).setCoordonneeX(xy[0]);
            SeaBattle.getPartie().getOrdinateur().getNavires(i).setCoordonneeY(xy[1]);
            
            Navire n = SeaBattle.getPartie().getOrdinateur().getNavires(i);
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
        
        String pos = SeaBattle.getPartie().getOrdinateur().getNavires(i).getPosition();
        int taille = SeaBattle.getPartie().getOrdinateur().getNavires(i).getTaille();
        Grille grille = SeaBattle.getPartie().getOrdinateur().getGrille();
        int tab[] = new int[taille];
        
        if(pos.equals("V")){
            if(taille+y > 10){
                return new int[0];
            }
            for (int j = y; j < y+taille; j++) {
                if (SeaBattle.getPartie().getOrdinateur().getGrille().getCasGrille(x, y).getEtat().equals("Plein")) {
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
                if (grille.getCasGrille(x, y).getEtat().equals("Plein")) {
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
