/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import java.util.Iterator;
import mod.CaseGrille;
import mod.Grille;
import mod.Navire;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class SelectCase {
    
    public static void selectioner(Integer num){
        
        SeaBattle.getPartie().getJoueur().getNavires().setCoordonneeX(cord(num)[0]);
        SeaBattle.getPartie().getJoueur().getNavires().setCoordonneeY(cord(num)[1]);
        selectionerCrille(num);
        
        Navire n = SeaBattle.getPartie().getJoueur().getNavires();
        System.out.println(n.getType()+"   "+n.getCoordonneeX()+":"+n.getCoordonneeY()+"   "+n.getPosition());
    }
    
    
    public static int[] cord(Integer num){
        int tab[] = new int[2];
        if (num <10) {
            tab[0] = 0;
            tab[1] = num;
        }
        else{
            String val = num.toString();
            tab[0] = Integer.parseInt(val.substring(0, 1));
            tab[1] = Integer.parseInt(val.substring(1, 2));
        }
        return tab;
    }
    
    public static void selectionerCrille(Integer num){
        Iterator<CaseGrille> it = SeaBattle.getPartie().getJoueur().getNavires().getCases().iterator();
        Grille grille = SeaBattle.getPartie().getJoueur().getGrille();
        while (it.hasNext()) {
            CaseGrille cg = it.next();
            grille.getCasGrille(cg.getX(), cg.getY()).setEtat("Plein");
        }
    }
}
