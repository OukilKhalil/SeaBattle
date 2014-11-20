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
public class Joueur {
    
    private Grille grille;
    private Navire navires[];

    public Joueur() {
        grille = new Grille();
        navires = new Navire[5];
        initialisationNav();
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Navire getNavires() {
        return navires[SeaBattle.getNavEnCours()];
    }
    
    public Navire getNavires(int i) {
        return navires[i];
    }

    public void setNavires(Navire navire, int i) {
        this.navires[i] = navire;
    }
    
    public void initialisationNav(){
        
        navires[0] = new PorteAvions();
        navires[1] = new SousMarin();
        navires[2] = new Cuirasses();
        navires[3] = new Cuirasses();
        navires[4] = new Zodiac();
        
    }
}
