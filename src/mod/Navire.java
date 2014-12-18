/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import con.NavireCont;
import java.util.Iterator;
import java.util.Vector;
import vue.Accueil;

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
    protected Vector<CaseGrille> cases;

    public Navire(int coordonneeX, int coordonneeY, int taille, String type, String position) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.taille = taille;
        this.partie_touchee = 0;
        this.type = type;
        this.position = position;
        cases = new Vector<CaseGrille>();
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
            NavireCont.couler(this);
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

    public Vector<CaseGrille> getCases() {
        return cases;
    }

    public void setCases(Vector<CaseGrille> cases) {
        this.cases = cases;
    }
    
    public void actuCord(){
        cases = new Vector<CaseGrille>();
        if(position.equals("V")){
            for (int i = 0; i < taille; i++) {
                CaseGrille cg = new CaseGrille("Plein", coordonneeX, coordonneeY+i);
                cases.add(cg);
            }
        }
        else{
            for (int i = 0; i < taille; i++) {
                CaseGrille cg = new CaseGrille("Plein", coordonneeX+i, coordonneeY);
                cases.add(cg);
            }
        }
    }
}
