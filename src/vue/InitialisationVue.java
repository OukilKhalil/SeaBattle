/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author ueve
 */
public class InitialisationVue extends FlowPane {

    private ImageView navires[];
    private Label navireslbl[];
    public InitialisationVue() {
        setPadding(new Insets(5, 0, 5, 0));
        setVgap(4);
        setHgap(4);
        setPrefWrapLength(274); // preferred width allows for two columns
        setStyle("-fx-background-color: DAE6F3;");
        navireslbl = new Label[5];
        navires = new ImageView[5];
        for (int i = 0; i < 5; i++) {
            navires[i] = new ImageView(new Image(getClass().getResourceAsStream("/ressources/icons/n" + (i + 1) + ".png")));
            final int x = i;
            navireslbl[i] = new Label("",navires[i]);
            navireslbl[i].setPrefSize(135.00, 135.00);
            navireslbl[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //desactiverNav(x);
                    SeaBattle.setNavEnCours(x);
                    rotateImage(x);
                }
            });
            getChildren().add(navireslbl[i]);
        }
    }

    public void rotateImage(int i) {
        if (navires[i].getRotate() == 0) {
            navires[i].setRotate(-90);
            SeaBattle.getNavires().setPosition("V");
        } else {
            navires[i].setRotate(0);
            SeaBattle.getNavires().setPosition("H");
        }
    }
    
    public void desactiverNav(int i){
        for (int j = 0; j < 5; j++) {
            if(j != i){
                navireslbl[j].setDisable(true);
            }
        }
    }
}
