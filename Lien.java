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
    }

    public String getNom() {
        return nom;
    }
    
    
    
    public static ArrayList buildAtt(String chaine, ArrayList tab){

        if(chaine.indexOf(",") < 0){
            tab.add(new Attribut(chaine.substring(0, chaine.indexOf("=")).trim(), chaine.substring(chaine.indexOf("=")+1, chaine.indexOf("]")).trim()));
            return tab;
        }
        
        tab.add(new Attribut(chaine.substring(0, chaine.indexOf("=")).trim(), chaine.substring(chaine.indexOf("=")+1, chaine.indexOf(",")).trim()));
        return buildAtt(chaine.substring(chaine.indexOf(",")+1), tab);
    }
    
}
