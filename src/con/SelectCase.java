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
import vue.Accueil;

/**
 *
 * @author ueve
 */
public class SelectCase {
    
    public static void selectioner(int x , int y){
        
        Accueil.getPartie().getJoueur().getNavires().setCoordonneeX(x);
        Accueil.getPartie().getJoueur().getNavires().setCoordonneeY(y);
        selectionerCrille();
        
        Navire n = Accueil.getPartie().getJoueur().getNavires();
        System.out.println(n.getType()+"   "+n.getCoordonneeX()+":"+n.getCoordonneeY()+"   "+n.getPosition());
    }
    
    
    public static void selectionerCrille(){
        Iterator<CaseGrille> it = Accueil.getPartie().getJoueur().getNavires().getCases().iterator();
        Grille grille = Accueil.getPartie().getJoueur().getGrille();
        while (it.hasNext()) {
            CaseGrille cg = it.next();
            grille.getCasGrille(cg.getX(), cg.getY()).setEtat("Plein");
        }
    }
}
