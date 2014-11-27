/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.util.Iterator;
import java.util.Vector;
import vue.SeaBattle;

/**
 *
 * @author badr
 */
public abstract class Navire {
    
    protected int coordonneeX;
    protected int coordonneeY;
    protected int taille;
    protected int partie_touchee;
    protected String type;
    protected String position;
    protected Vector<Point> cases;
    
    
    public Navire(int coordonneeX, int coordonneeY, int taille, String type, String position) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.taille = taille;
        this.partie_touchee = 0;
        this.type = type;
        this.position = position;
        cases = new Vector<Point>();
    }

    public int getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
        actuCord();
    }

    public int getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY = coordonneeY;
        actuCord();
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPartie_touchee() {
        return partie_touchee;
    }

    public void setPartie_touchee(int partie_touchee) {
        this.partie_touchee = partie_touchee;
        if(this.partie_touchee == this.taille){
            System.out.println("Couler :/ !!!");
            SeaBattle.getPartie().getJoueur().setNavireRestants(SeaBattle.getPartie().getJoueur().getNavireRestants()-1);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        actuCord();
    }

    public Vector<Point> getCases() {
        return cases;
    }

    public void setCases(Vector<Point> cases) {
        this.cases = cases;
    }
    
    public void actuCord(){
        cases = new Vector<Point>();
        if(position.equals("V")){
            for (int i = 0; i < taille; i++) {
                Point p = new Point(coordonneeX, coordonneeY+i);
                cases.add(p);
            }
        }
        else{
            for (int i = 0; i < taille; i++) {
                Point p = new Point(coordonneeX+i, coordonneeY);
                cases.add(p);
            }
        }
    }
}
