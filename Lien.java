/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_gl;

import java.util.ArrayList;

/**
 *
 * @author Edicius
 */
public class Lien {
    
    private String nom;
    private Noeud depart;
    private Noeud arrivee;
    private ArrayList<Attribut> attribut;
    private Boolean visite;
    


    
    public Lien(String nom, Noeud depart, Noeud arrivee, ArrayList<Attribut> attribut) {
        this.nom = nom;
        this.depart = depart;
        this.arrivee = arrivee;
        this.attribut = attribut;
        this.visite = false;
    }

    public Boolean getVisite() {
        return visite;
    }
    
public String getNom() {
        return nom;
    }
        
    public void setVisite(Boolean visite) {
        this.visite = visite;
    }

    public Noeud getDepart() {
        return depart;
    }

    public Noeud getArrivee() {
        return arrivee;
    }
}

}
