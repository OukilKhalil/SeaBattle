/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import vue.SeaBattle;
import static vue.SeaBattle.actualiser;

/**
 *
 * @author ueve
 */
public class Partie {
    
    private Joueur joueurs[] = new Joueur[2];
    private String etape;
    private int jouEnCours = 1;

    public Partie() {
        joueurs[0] = new Joueur();
        joueurs[1] = new Ordinateur();
        etape = "Selection";
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

    public  void setJouEnCours(int jouEnCours) {
        this.jouEnCours = jouEnCours;
    }
    
    public void jouSuivant(){
        actualiser();
        jouEnCours = 1;
    }
}
