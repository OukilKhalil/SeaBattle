/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import vue.GrilleVue;

/**
 *
 * @author badr
 */
public class Grille {
    
    private CaseGrille grille[][] = new CaseGrille[10][10];
    private GrilleVue vue = new GrilleVue();

    public Grille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new CaseGrille("Vide",i,j);
            }
        }
    }

    public CaseGrille getCasGrille(int i, int j) {
        return grille[i][j];
    }

    public GrilleVue getVue() {
        return vue;
    }

    public void setVue(GrilleVue vue) {
        this.vue = vue;
    }
    
    
}