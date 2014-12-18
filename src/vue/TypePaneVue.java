/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mod.Configuration;

/**
 *
 * @author ueve
 */
public class TypePaneVue extends VBox{

    public TypePaneVue() {
        
        Button bn = new Button("Bataille Navale");
        bn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setTypePartie("Bataille Navale");
                            setVisible(false);
                            Accueil.getModeVbox().setVisible(true);
                        }
                    });
        bn.setPrefHeight(50);
        bn.setPrefWidth(300);
        Button mr = new Button("Mission Radar");
        mr.setPrefHeight(50);
        mr.setPrefWidth(300);
        mr.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setTypePartie("Mission Radar");
                            setVisible(false);
                            Accueil.getModeVbox().setVisible(true);
                        }
                    });
        Button oa = new Button("Opération Artillerie");
        oa.setPrefHeight(50);
        oa.setPrefWidth(300);
        Button ar = new Button("Alerte Rouge");
        ar.setPrefHeight(50);
        ar.setPrefWidth(300);
        
        getChildren().addAll(bn, mr, oa, ar);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }    
}
