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
public class Noeud {
    
    private String nom;
    private ArrayList<Lien> lienSortant;
    private ArrayList<Lien> lienEntrant;
    private Boolean visite;

    public Noeud(String nom) {
        this.nom = nom;
        this.lienEntrant = new ArrayList<Lien>();
        this.lienSortant = new ArrayList<Lien>();
        this.visite = false;
    }

    public Boolean getVisite() {
        return visite;
    }

    public void setVisite(Boolean visite) {
        this.visite = visite;
    }
    
    
    public String getNom(){
        return nom;        
    }

    public void setLienSortant(ArrayList<Lien> lienSortant) {        
        this.lienSortant = lienSortant;
    }

    public void setLienEntrant(ArrayList<Lien> lienEntrant) {
        this.lienEntrant = lienEntrant;
    }

    public ArrayList<Lien> getLienSortant() {
        return lienSortant;
    }

    public ArrayList<Lien> getLienEntrant() {
        return lienEntrant;
    }
    

    
}
