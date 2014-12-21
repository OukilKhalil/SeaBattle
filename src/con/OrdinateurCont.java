/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import java.util.Random;
import mod.CaseGrille;
import mod.Grille;
import vue.Accueil;

/**
 *
 * @author ueve
 */
public class OrdinateurCont {
    
    private static CaseGrille derniereCase = null;
    private static int dirEnCours = 0;
    
    public static synchronized void tirer(){
        
        Grille grille = Accueil.getPartie().getJoueur().getGrille();
        if(derniereCase != null){
            String direction[] = {"G", "D", "H" , "B"};
            
            switch (direction[dirEnCours]) {
                case "G":
                    if(derniereCase.getX()-1 >= 0){
                        if(!grille.getCasGrille(derniereCase.getX()-1, derniereCase.getY()).getEtat().equals("Tirer")){
                            JoueurCont.tirer(derniereCase.getX()-1, derniereCase.getY());
                            break;
                        }
                        else{
                            dirEnCours = 1;
                        }
                    }
                    else{
                            dirEnCours = 1;
                    }
                case "D":
                    if(derniereCase.getX()+1 <= 10){
                        if(!grille.getCasGrille(derniereCase.getX()-+1, derniereCase.getY()).getEtat().equals("Tirer")){
                            JoueurCont.tirer(derniereCase.getX()+1, derniereCase.getY());
                            break;
                        }
                        else{
                            dirEnCours = 2;
                        }
                    }
                    else{
                            dirEnCours = 2;
                    }
                case "H":
                    if(derniereCase.getY()-1 >= 0){
                        if(!grille.getCasGrille(derniereCase.getX(), derniereCase.getY()+1).getEtat().equals("Tirer")){
                            JoueurCont.tirer(derniereCase.getX(), derniereCase.getY()+1);
                            break;
                        }
                        else{
                            dirEnCours = 3;
                        }
                    }
                    else{
                            dirEnCours = 3; 
                    }
                case "B":
                    if(derniereCase.getY()+1 <= 10){
                        if(!grille.getCasGrille(derniereCase.getX(), derniereCase.getY()-1).getEtat().equals("Tirer")){
                            JoueurCont.tirer(derniereCase.getX(), derniereCase.getY()-1 );
                            break;
                        }
                        else{
                            dirEnCours = 0;
                        }
                    }
                    else{
                            dirEnCours = 0;
                    }
                default:
                    throw new AssertionError();
            }
        }
        
        
        int xy[] = new int[2];
        xy = xy();
        while(grille.getCasGrille(xy[0], xy[1]).getEtat().equals("Tirer")){
            xy = xy();
        }
        JoueurCont.tirer(xy[0], xy[1]);
    }
    
    private static int[] xy(){
        
        int tab[] = new int[2];

        Random rand = new Random();
        tab[0] = rand.nextInt(10);
        tab[1] = rand.nextInt(10);

        return tab;
    }
 
    public static CaseGrille getDerniereCase() {
        return derniereCase;
    }

    public static void setDerniereCase(CaseGrille derniereCase) {
        OrdinateurCont.derniereCase = derniereCase;
    }

    public static int getDirEnCours() {
        return dirEnCours;
    }

    public static void setDirEnCours(int dirEnCours) {
        OrdinateurCont.dirEnCours = dirEnCours;
    }

}
