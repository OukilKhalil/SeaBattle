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
public class Cuirasses extends Navire{

    public Cuirasses() {
        super(0, 0, 3, "Cuirasses", "V");
    }

    public Cuirasses(int coordonneeX, int coordonneeY, String position) {
        super(coordonneeX, coordonneeY, 3, "Cuirasses", position);
    }
    
    
}
