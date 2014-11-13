/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class Partie {
    
    private Joueur joueurs[] = new Joueur[2];
    private String etape;

    public Partie() {
        joueurs[0] = new Joueur();
        joueurs[1] = new Joueur();
        etape = "Selection";
    }

    public Joueur getJoueur() {
        return joueurs[SeaBattle.getJouEnCours()];
    }
    
    
}
