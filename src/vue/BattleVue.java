/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author ueve
 */
public class BattleVue extends Stage{
    
    private GrilleVue grilleJ1;
    private GrilleVue grilleJ2;

    public BattleVue() {
        this.grilleJ1 = new GrilleVue();
        this.grilleJ2 = new GrilleVue();
        
        Label lbl = new Label("<      >");
        BorderPane pan = new BorderPane();
        
        pan.setLeft(grilleJ1);
        pan.setRight(grilleJ2);
        pan.setCenter(lbl);
        
        Scene scene = new Scene(pan);
        setTitle("Sea Battle");
        setScene(scene);
        show();
    }
    
    
}
