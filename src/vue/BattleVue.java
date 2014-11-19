/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.EventType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author ueve
 */
public class BattleVue extends BorderPane{
    
    private GrilleVue grilleJ1;
    private GrilleVue grilleJ2;

    public BattleVue() {
        this.grilleJ1 = new GrilleVue();
        this.grilleJ2 = new GrilleVue();
        Label lbl = new Label("<      >");
        
        setLeft(grilleJ1);
        setRight(grilleJ2);
        setCenter(lbl);
        
    }
    
    
}
