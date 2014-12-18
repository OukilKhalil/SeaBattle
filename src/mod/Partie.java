/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import con.OrdinateurCont;
import vue.Accueil;
import static vue.InitialisationVue.actualiser;

/**
 *
 * @author ueve
 */
public class Partie {
    
    private Joueur joueurs[] = new Joueur[2];
    private int jouEnCours;
    private boolean terminee;

    public Partie() {
        joueurs[0] = new Joueur();
        joueurs[1] = new Ordinateur();
        jouEnCours = 0;
        terminee = false;
    }
    
    public Joueur getJoueur(int i) {
        return joueurs[i];
    }

    public Joueur getJoueur() {
        return joueurs[getJouEnCours()];
    }

    public void setJoueurs(int i, Joueur joueurs) {
        this.joueurs[i] = joueurs;
    }
    
    
    public Ordinateur getOrdinateur() {
        return (Ordinateur) joueurs[1];
    }
    
    public  int getJouEnCours() {
        return jouEnCours;
    }

    public void setJouEnCours(int jouEnCours) {
        this.jouEnCours = jouEnCours;
    }

    public void setJouEnCours() {
        if (jouEnCours == 0) {
            jouEnCours = 1;
            Accueil.getPartie().getJoueur(0).getGrille().getVue().getLbl().setDisable(true);
            Accueil.getPartie().getJoueur(1).getGrille().getVue().getLbl().setDisable(false);
            if(Configuration.getModePartie().equals("Demo"))
                OrdinateurCont.tirer();
        }
        else{
            jouEnCours = 0;
            Accueil.getPartie().getJoueur(1).getGrille().getVue().getLbl().setDisable(true);
            Accueil.getPartie().getJoueur(0).getGrille().getVue().getLbl().setDisable(false);
            if(!Configuration.getModePartie().equals("MultiJoueur"))
                OrdinateurCont.tirer();
            //long t = System.currentTimeMillis();
            //while(System.currentTimeMillis()<t+1000);
        }
    }

    public boolean isTerminee() {
        return terminee;
    }

    public void setTerminee(boolean terminee) {
        this.terminee = terminee;
    }
    
    public void jouSuivant(){
        actualiser();
    }
}
