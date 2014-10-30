/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import vue.GrilleVue;

/**
 *
 * @author ueve
 */
public class SelectCase {
    
    public static void selectioner(int x){
        for (int i = x; i < x+5; i++) {
            GrilleVue.selectCase(i);
        }
        
    }
}
