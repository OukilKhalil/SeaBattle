/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

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
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Navire getNavires(int i) {
        return navires[i];
    }

    public void setNavires(Navire navire, int i) {
        this.navires[i] = navire;
    }
    
    
}
