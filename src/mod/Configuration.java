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
public class Configuration {
    
    private static String typePartie = "Bataille navale";
    private static String modePartie = "Joueur Vs CPU";

    public static String getTypePartie() {
        return typePartie;
    }

    public static void setTypePartie(String typePartie) {
        Configuration.typePartie = typePartie;
    }

    public static String getModePartie() {
        return modePartie;
    }

    public static void setModePartie(String modePartie) {
        Configuration.modePartie = modePartie;
    }
    
    
}
