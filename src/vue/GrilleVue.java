/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import con.SelectCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author ueve
 */
public class GrilleVue extends GridPane{
    
    private static Button buttons [] = new Button[100];

    public GrilleVue() {
        intialisationBtn();
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String x = Integer.toString(i) + Integer.toString(j);
                add(buttons[Integer.parseInt(x)], i, j);
            }
        }
    }
    
    
    
    public void intialisationBtn(){
        for (int i = 0; i < 100; i++) {
            buttons [i] = new Button("  ");
            final int code = i;
            buttons [i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        /*Button btn = (Button)event.getSource();
                        btn.setDefaultButton(true);*/
                        SelectCase.selectioner(code);
                    }
                });
        }
    }
    
    public static void selectCase(int x){
        buttons[x].setStyle("-fx-base: #b6e7c9;");
    }
}
