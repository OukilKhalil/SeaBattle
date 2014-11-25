/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;

/**
 *
 * @author ueve
 */
public class InitialisationVue extends FlowPane {

    private  ImageView navires[];
    private  Label navireslbl[];
    private RotateTransition rt;
    private  boolean selected;
    private  int navCreers;
    
    public InitialisationVue() {
        setPadding(new Insets(5, 0, 5, 0));
        setVgap(4);
        setHgap(4);
        setPrefWrapLength(274); // preferred width allows for two columns
        setStyle("-fx-background-color: DAE6F3;");
        setSelected(false);
        navCreers = 0;
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
                    setSelected(true);
                }
            });
            
 
            getChildren().add(navireslbl[i]);
        }
        
    }

    public void rotateImage(int i) {
        if (SeaBattle.getPartie().getJoueur().getNavires().getPosition().equals("H")) {
            rt = new RotateTransition(Duration.millis(1000), navireslbl[i]);
             rt.setByAngle(-90);
             rt.setAutoReverse(true);
             rt.play();
            SeaBattle.getPartie().getJoueur().getNavires().setPosition("V");
            
            
        } else {
            rt = new RotateTransition(Duration.millis(1000), navireslbl[i]);
             rt.setByAngle(90);
             rt.setAutoReverse(true);
             rt.play();
            SeaBattle.getPartie().getJoueur().getNavires().setPosition("H");
        }
    }
    
    public void desactiverNav(int i){
        for (int j = 0; j < 5; j++) {
            if(j != i){
                navireslbl[j].setDisable(true);
            }
        }
    }
    
    public  Label getLblEnCours(){
        return navireslbl[SeaBattle.getNavEnCours()];
    }

    public  ImageView getNavEnCours(){
        return navires[SeaBattle.getNavEnCours()];
    }
    
    public  boolean isSelected() {
        return selected;
    }

    public  void setSelected(boolean selecte) {
        selected = selecte;
        if (!selecte) {
            navCreers++;
            if (navCreers == 5) {
                BattleVue bv = new BattleVue();
                ((Node)(this)).getScene().getWindow().hide();
            }
        }
        
    }
    
    
}
