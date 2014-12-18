/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mod.Configuration;
import mod.Ordinateur;
import mod.Partie;

/**
 *
 * @author ueve
 */
public class Accueil extends Application {
    
    private static Partie partie;
    
    @Override
    public void start(Stage primaryStage) {
        
        partie = new Partie();
        partie.getOrdinateur().placer();
        partie.setJouEnCours(0);
       
        String image = getClass().getResource("/ressources/icons/back.jpg").toExternalForm();
        
        final StackPane optionsPane = new StackPane();
        
        final VBox modeVbox = new VBox();
        final VBox typeVbox = new VBox();
        HBox hbox = new HBox();
        hbox.setSpacing(70);
        hbox.setAlignment(Pos.CENTER);
        ImageView imPlay = new ImageView(new Image(getClass().getResourceAsStream("/ressources/icons/play.png")));
        imPlay.setFitHeight(100);
        imPlay.setFitWidth(100);
        Label play = new Label("", imPlay);
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            optionsPane.setVisible(true);
                        }
                    });
        ImageView imCharger = new ImageView(new Image(getClass().getResourceAsStream("/ressources/icons/charger.png")));
        imCharger.setFitHeight(100);
        imCharger.setFitWidth(100);
        Label charger = new Label("", imCharger);
        ImageView imInfo = new ImageView(new Image(getClass().getResourceAsStream("/ressources/icons/info.png")));
        imInfo.setFitHeight(100);
        imInfo.setFitWidth(100);
        Label info = new Label("", imInfo);
        
        hbox.getChildren().addAll(play, charger, info);
        
        BorderPane panneau = new BorderPane();
        panneau.setBottom(hbox);
        
        
        Button demo = new Button("Demo");
        demo.setPrefHeight(80);
        demo.setPrefWidth(300);
        demo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setModePartie("Demo");
                            InitialisationVue iv = new InitialisationVue();
                            partie.setJoueurs(0, new Ordinateur());
                            Ordinateur o = (Ordinateur)(partie.getJoueur(0));
                            o.placer();
                            BattleVue bv = new BattleVue(o.getGrille().getVue());
                            iv.hide();
                            modeVbox.getScene().getWindow().hide();
                                partie.setJouEnCours();
                        }
                    });
        Button unVsCpu = new Button("Joueur Vs CPU");
        unVsCpu.setPrefHeight(80);
        unVsCpu.setPrefWidth(300);
        unVsCpu.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            InitialisationVue iv = new InitialisationVue();
                            modeVbox.getScene().getWindow().hide();
                        }
                    });
        Button multi = new Button("MultiJoueur");
        multi.setPrefHeight(80);
        multi.setPrefWidth(300);
        multi.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setModePartie("MultiJoueur");
                            InitialisationVue iv = new InitialisationVue();
                            modeVbox.getScene().getWindow().hide();
                        }
                    });
        Button bn = new Button("Bataille Navale");
        bn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Configuration.setTypePartie("Bataille Navale");
                            typeVbox.setVisible(false);
                            modeVbox.setVisible(true);
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
                            typeVbox.setVisible(false);
                            modeVbox.setVisible(true);
                        }
                    });
        Button oa = new Button("Opération Artillerie");
        oa.setPrefHeight(50);
        oa.setPrefWidth(300);
        Button ar = new Button("Alerte Rouge");
        ar.setPrefHeight(50);
        ar.setPrefWidth(300);
        
        typeVbox.getChildren().addAll(bn, mr, oa, ar);
        typeVbox.setAlignment(Pos.CENTER);
        typeVbox.setSpacing(20);
        
        modeVbox.getChildren().addAll(demo, unVsCpu, multi);
        modeVbox.setAlignment(Pos.CENTER);
        modeVbox.setSpacing(50);
        modeVbox.setVisible(false);
        
        optionsPane.getChildren().addAll(typeVbox, modeVbox);
        optionsPane.setVisible(false);
        
        panneau.setCenter(optionsPane);
        StackPane root = new StackPane(panneau);
        root.setStyle("-fx-background-image: url('" + image + "');-fx-background-position: center center;-fx-background-repeat: stretch;");
        
        Scene scene = new Scene(root, 1200, 700);
        
        primaryStage.setTitle("SEA BATTLE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Partie getPartie() {
        return partie;
    }
}
