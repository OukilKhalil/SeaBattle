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
    
    public int procheCible(CaseGrille cg){
        
        int x = cg.getX(), y = cg.getY();
        
        int max = Math.max(10-x,10-y);
        max = Math.max(max, x);
        max = Math.max(max, y);
        
        for (int i = 1; i < max; i++) {
            
            if(x+i < 10)
            {
                if(getCasGrille(x+i, y).getEtat().equals("Plein"))
                    return i;
            }
            if(y+i < 10){
                if(getCasGrille(x, y+i).getEtat().equals("Plein"))
                    return i;
            }
            if(x-i >= 0){
                if(getCasGrille(x-i, y).getEtat().equals("Plein"))
                    return i;
            }
            if(y-i >= 0){
                if(getCasGrille(x, y-i).getEtat().equals("Plein"))
                    return i;
            }
        }
        return 99;
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