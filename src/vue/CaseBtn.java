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
import javafx.scene.input.MouseEvent;
import mod.Navire;

/**
 *
 * @author ueve
 */
public class CaseBtn extends Button {

    private int numero;
    public CaseBtn(int num) {
        super();
        numero = num;
        setPrefSize(50.0, 50.0);
        final int n = num;
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GrilleVue.select(n);
                SelectCase.selectioner(n);
            }
        });
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GrilleVue.focusCases(n);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GrilleVue.difocusCases(n);
            }
        });
    }
    
    public int nextLineV(Integer x){
        if(x < 10) return 10;
        String val = x.toString();
        int line =Integer.parseInt(val.substring(0, 1))*10;
        return line+10;
    }
    
    public int nextLineH(Integer x){
        if(x < 10) return x+90;
        String val = x.toString();
        int line =Integer.parseInt(val.substring(1, 2))+90;
        return line+10;
    }
    
    
}
