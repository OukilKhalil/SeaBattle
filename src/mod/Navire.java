/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

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
    
    public Navire() {
        this.coordonneeX = 0;
        this.coordonneeY = 0;
        this.taille = 0;
        this.partie_touchee = 0;
        this.type = "INCONNU";
        this.position = "INCONNU";
    }

    public Navire(int coordonneeX, int coordonneeY, int taille, String type, String position) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.taille = taille;
        this.partie_touchee = 0;
        this.type = type;
        this.position = position;
    }

    public int getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public int getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY = coordonneeY;
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
    }
    
    
    
    
}
