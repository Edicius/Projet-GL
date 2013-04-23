package projet_gl;

import java.util.ArrayList;

/**
 *Cette graphe noeud represente les elements du reseau social.
 *Ils sont caracterises par un nom, une liste de lien entrant et sortant, ainsi qu'un booleen indiquant s'il a deja ete visite
 * 
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
