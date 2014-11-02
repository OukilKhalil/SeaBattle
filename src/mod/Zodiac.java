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
public class Zodiac extends Navire{

    public Zodiac() {
        super(0, 0, 2, "Zodiac", "H");
    }

    public Zodiac(int coordonneeX, int coordonneeY, String position) {
        super(coordonneeX, coordonneeY, 2, "Zodiac", position);
    }
    
    
}
