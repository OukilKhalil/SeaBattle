/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import con.OrdinateurCont;
import vue.SeaBattle;
import static vue.SeaBattle.actualiser;

/**
 *
 * @author ueve
 */
public class Partie {
    
    private Joueur joueurs[] = new Joueur[2];
    private String etape;
    private int jouEnCours;

    public Partie() {
        joueurs[0] = new Joueur();
        joueurs[1] = new Ordinateur();
        etape = "Selection";
        jouEnCours = 0;
    }
    
    public Joueur getJoueur(int i) {
        return joueurs[i];
    }

    public Joueur getJoueur() {
        return joueurs[getJouEnCours()];
    }
    
    public Ordinateur getOrdinateur() {
        return (Ordinateur) joueurs[1];
    }
    
    public  int getJouEnCours() {
        return jouEnCours;
    }

    public void setJouEnCours() {
        if (jouEnCours == 0) {
            jouEnCours = 1;
            SeaBattle.getPartie().getJoueur(0).getGrille().getVue().getLbl().setDisable(true);
            SeaBattle.getPartie().getJoueur(1).getGrille().getVue().getLbl().setDisable(false);
        }
        else{
            jouEnCours = 0;
            SeaBattle.getPartie().getJoueur(1).getGrille().getVue().getLbl().setDisable(true);
            SeaBattle.getPartie().getJoueur(0).getGrille().getVue().getLbl().setDisable(false);
            OrdinateurCont.tirer();
        }
    }
    
    public void jouSuivant(){
        actualiser();
    }
}
