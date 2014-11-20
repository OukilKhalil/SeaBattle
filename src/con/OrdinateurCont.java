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
        int xy[] = xy();
        for (int i = 0; i < 5; i++) {
            int cases[];
            int xety = Integer.parseInt(String.valueOf(xy[0])+String.valueOf(xy[1]));
            while (gv.casesOrdi(xety,i).length==0) {
                xety = Integer.parseInt(String.valueOf(xy[0])+String.valueOf(xy[1]));
            }
            
            
            cases = new int[gv.casesOrdi(xety,i).length];
            cases = gv.casesOrdi(xety,i);
            
            
            Random rand = new Random();
            int nbr = rand.nextInt(2 - 1 + 1) + 1;

            char pos = nbr == 2 ? 'H' : 'V';
            
            SeaBattle.getPartie().getOrdinateur().getNavires(i).setCoordonneeX(xy[0]);
            SeaBattle.getPartie().getOrdinateur().getNavires(i).setCoordonneeY(xy[1]);
            SeaBattle.getPartie().getOrdinateur().getNavires(i).setPosition(String.valueOf(pos));
            
            SelectCase.selectionerCrille(xety);
            
            Navire n = SeaBattle.getPartie().getOrdinateur().getNavires(i);
            System.out.println(n.getType()+"   "+n.getCoordonneeX()+":"+n.getCoordonneeY()+"   "+n.getPosition());
        }
        
        
    }
    
    private static int[] xy(){
            int tab[] = new int[2];
            
            tab[0] = (int) Math.random() * 10;
            tab[1] = (int) Math.random() * 10;
            
            return tab;
        }
}
