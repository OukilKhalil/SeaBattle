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
public class PorteAvions extends Navire{

    public PorteAvions() {
        super(0, 0, 5, "Porte-Avions", "V");
    }

    public PorteAvions(int coordonneeX, int coordonneeY, String position) {
        super(coordonneeX, coordonneeY, 5, "Porte-Avions", position);
    }
    
    
}
