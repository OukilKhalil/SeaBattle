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
import mod.Joueur;
import mod.Ordinateur;

/**
 *
 * @author ueve
 */
public class ModePaneVue extends VBox{

    public ModePaneVue() {
        Button demo = new Button("Demo");
        demo.setPrefHeight(80);
        demo.setPrefWidth(300);
        demo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setModePartie("Demo");
                            InitialisationVue iv = new InitialisationVue();
                            Accueil.getPartie().setJoueurs(0, new Ordinateur());
                            Ordinateur o = (Ordinateur)(Accueil.getPartie().getJoueur(0));
                            o.placer();
                            BattleVue bv = new BattleVue(o.getGrille().getVue());
                            iv.hide();
                            getScene().getWindow().hide();
                            Accueil.getPartie().setJouEnCours();
                        }
                    });
        Button unVsCpu = new Button("Joueur Vs CPU");
        unVsCpu.setPrefHeight(80);
        unVsCpu.setPrefWidth(300);
        unVsCpu.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            InitialisationVue iv = new InitialisationVue();
                            getScene().getWindow().hide();
                        }
                    });
        Button multi = new Button("MultiJoueur");
        multi.setPrefHeight(80);
        multi.setPrefWidth(300);
        multi.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setModePartie("MultiJoueur");
                            InitialisationVue iv = new InitialisationVue();
                            Accueil.getPartie().setJoueurs(1, new Joueur());
                            getScene().getWindow().hide();
                        }
                    });
        
        getChildren().addAll(demo, unVsCpu, multi);
        setAlignment(Pos.CENTER);
        setSpacing(50);
        setVisible(false);
    }
}
