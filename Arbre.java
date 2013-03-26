/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_gl;

import java.util.ArrayList;

/**
 *
 * @author Standard
 */
public class Arbre {
    
    ArrayList<Noeud> arbre;
    
    // Méthode du parcour en largeur à appeler
    public ArrayList Largeur (Noeud noeud, ArrayList noeudVisite, int nivParcour){
        noeudVisite.add(noeud);
        noeud.setVisite(true);
        parcourLargeurNoeud (noeud, noeudVisite, nivParcour);
        return noeudVisite;
    }
    
    // Parcour en largeur de l'arbre, attention il faut appeler la méthode Largeur, jamais celle-ci directement, 
    // sinon on pourra être amené à visiter deux fois le noeud de départ
    public ArrayList parcourLargeurNoeud (Noeud noeud, ArrayList noeudVisite, int nivParcour){
        ArrayList<Lien> lien;
        lien = noeud.getLienSortant();
        int noeud_ajoute = 0;
        
        // Parcour les liens sortant du noeud et les ajoute à la liste des noeuds visités si ce n'est pas déjà le cas 
        for (int i=0 ; i<lien.size() ; i++){
            if (((Lien)lien.get(i)).getArrivee().getVisite() == false){
                noeudVisite.add((Noeud)lien.get(i).getArrivee());
                lien.get(i).getArrivee().setVisite(true);
                noeud_ajoute ++;
            }
        }
        
        if (nivParcour != 1){
            // Appel les noeuds visités 
            for (int i=noeudVisite.size()-noeud_ajoute ; i<noeudVisite.size() ; i++){
                noeudVisite = parcourLargeurNoeud((Noeud)noeudVisite.get(i), noeudVisite, --nivParcour);
            }
        }
        return noeudVisite;
    }
    
    public ArrayList parcourLargeurRelation (Noeud noeud, ArrayList noeudVisite, int nivParcour) {
        ArrayList<Lien> lien;
        lien = noeud.getLienSortant();
        int noeud_ajoute = 0;
        
        // Parcour les liens sortant du noeud et les ajoute à la liste des noeuds visités si ce n'est pas déjà le cas 
        for (int i=0 ; i<lien.size() ; i++){
            if (((Lien)lien.get(i)).getVisite() == false){
                noeudVisite.add((Noeud)lien.get(i).getArrivee());
                lien.get(i).setVisite(true);
                noeud_ajoute ++;
            }
        }
        
        if (nivParcour != 1){
            // Appel les noeuds visités 
            for (int i=noeudVisite.size()-noeud_ajoute ; i<noeudVisite.size() ; i++){
                noeudVisite = parcourLargeurRelation((Noeud)noeudVisite.get(i), noeudVisite, --nivParcour);
            }
        }
        return noeudVisite;
    }
}


