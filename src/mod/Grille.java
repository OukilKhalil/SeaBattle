/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author badr
 */
public class Grille {
    
    private Case_Grille grille[][] = new Case_Grille[10][10];

    public Grille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case_Grille();
            }
        }
    }

    public Case_Grille getCasGrille(int i, int j) {
        return grille[i][j];
    }
}