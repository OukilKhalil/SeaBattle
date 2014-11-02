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
import javafx.scene.layout.GridPane;
import mod.Navire;

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
                        SelectCase.selectioner(code);
                    }
                });
            buttons [i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    focusCases(code);
                }
            });
            buttons [i].setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    difocusCases(code);
                }
            });
        }
    }
    
    public static void selectCase(int x){
        buttons[x].setStyle("-fx-base: #b6aaa9;");
        
    }
    
    public void focusCases(int x){
        
        int cases[] = new int[cases(x).length];
        cases = cases(x);
                for (int i = 0; i < cases.length; i++) {
                    if(!buttons[cases[i]].getStyle().equals("-fx-base: #b6aaa9;"))
                        buttons[cases[i]].setStyle("-fx-base: #b6e7c9;");
        }
        
    }
    
    public void difocusCases(int x){
        int cases[] = new int[cases(x).length];
        cases = cases(x);
            for (int i = 0; i < cases.length; i++) {
                if(buttons[cases[i]].getStyle().equals("-fx-base: #b6e7c9;"))
                    buttons[cases[i]].setStyle("");
        }
    
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
    
    public int[] cases(int x){
        Navire nav = SeaBattle.getNavires();
        int t = nav.getTaille();
        int tab[] = new int[t];
        if(nav.getPosition().equals("V")){
            if (x+t <= nextLineV(x)) {
                for (int i = x; i < x+t; i++) {
                    tab[i-x]= i;
                }
                return tab;
            }
        }
        else{
            if (x+t*10 <= nextLineH(x)) {
                for (int i = x, j=0; i < x+t*10; i=i+10,j++) {
                    tab[j]= i;
                }
                return tab;
            }
        }
        
        return new int[0];
    }
}
