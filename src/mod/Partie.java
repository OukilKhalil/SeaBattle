/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author ueve
 */
public class Partie {
    
    private Joueur joueur1;
    private Joueur joueur2;
    private String etape;
    private Navire navEnCours;

    public Partie() {
        joueur1 = new Joueur();
        etape = "Selection";
    }
    
    
}
