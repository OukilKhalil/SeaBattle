/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import con.OrdinateurCont;
import java.util.Random;
import vue.GrilleVue;

/**
 *
 * @author ueve
 */
public class Ordinateur extends Joueur{

    public Ordinateur() {
        super();
        placer();
    }
    
    public void tirer(){
        
    }
    
    public void placer(){
       OrdinateurCont.placer();
    }
    
  
}
