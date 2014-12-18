/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author ueve
 */
public class MenuPaneVue extends HBox{

    public MenuPaneVue() {

        setSpacing(70);
        setAlignment(Pos.CENTER);
        ImageView imPlay = new ImageView(new Image(getClass().getResourceAsStream("/ressources/icons/play.png")));
        imPlay.setFitHeight(100);
        imPlay.setFitWidth(100);
        Label play = new Label("", imPlay);
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            Accueil.getOptionsPane().setVisible(true);
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
        
        getChildren().addAll(play, charger, info);
    }
    
    
}
