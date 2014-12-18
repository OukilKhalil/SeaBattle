/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mod.Partie;

/**
 *
 * @author ueve
 */
public class Accueil extends Application {
    
    private static Partie partie;
    private static final VBox modeVbox = new ModePaneVue();
    private static final VBox typeVbox = new TypePaneVue();
    private static final StackPane optionsPane = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {
        
        partie = new Partie();
        
        String image = getClass().getResource("/ressources/icons/back.jpg").toExternalForm();
        
        HBox menu = new MenuPaneVue();
        
        BorderPane panneau = new BorderPane();
        
        panneau.setBottom(menu);
        
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

    public static VBox getModeVbox() {
        return modeVbox;
    }

    public static VBox getTypeVbox() {
        return typeVbox;
    }

    public static StackPane getOptionsPane() {
        return optionsPane;
    }
    
    
}
