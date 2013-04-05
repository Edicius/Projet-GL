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

    public ArrayList<Attribut> getAttribut() {
        return attribut;
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
    
    public static ArrayList buildAtt(String chaine, ArrayList tab){

        if((chaine.indexOf(",") == -1 || chaine.indexOf(",") > chaine.indexOf("]")) && (chaine.indexOf("|") == -1 || chaine.indexOf("|") > chaine.indexOf("]"))){
        //pas de virgule avant fermeture crochet
            if (chaine.indexOf("=") != -1){
            //si on a un '='
                tab.add(new Attribut(chaine.substring(0, chaine.indexOf("=")).trim(), chaine.substring(chaine.indexOf("=")+1, chaine.indexOf("]")).trim()));
                return tab;
            }            
            else{
            //ni ',' ni '|' ni '='    
                tab.add(new Attribut(chaine.substring(0, chaine.indexOf("]")).trim(), null));
                return tab;
            }
        }
        //si on trouve un '=' avant ','
        if (chaine.indexOf("=") != -1 && chaine.indexOf("=") < chaine.indexOf(",") && chaine.indexOf(",") < chaine.indexOf("]")){
            tab.add(new Attribut(chaine.substring(0, chaine.indexOf("=")).trim(), chaine.substring(chaine.indexOf("=")+1, chaine.indexOf(",")).trim()));
            return buildAtt(chaine.substring(chaine.indexOf(",")+1), tab);
        }
        else if(chaine.indexOf("|") != -1){
        //si on a un '|'
            tab.add(new Attribut(chaine.substring(0, chaine.indexOf("|")).trim(), null));
            return buildAtt(chaine.substring(chaine.indexOf("|")+1), tab);
        }
        else{
            tab.add(new Attribut(chaine.substring(0, chaine.indexOf(",")).trim(), null));
            return buildAtt(chaine.substring(chaine.indexOf(",")+1), tab);
        }
    }
    
}
