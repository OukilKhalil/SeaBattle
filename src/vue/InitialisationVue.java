/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author ueve
 */
public class InitialisationVue extends FlowPane {

    public InitialisationVue() {
        setPadding(new Insets(5, 0, 5, 0));
        setVgap(4);
        setHgap(4);
        setPrefWrapLength(410); // preferred width allows for two columns
        setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[11];
        for (int i=0; i<10; i++) {
            pages[i] = new ImageView(new Image(getClass().getResourceAsStream("/ressources/icons/"+(i+1)+".png")));
            getChildren().add(pages[i]);
        }
    }
    
    
}
