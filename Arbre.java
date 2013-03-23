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
    public ArrayList Largeur (Noeud noeud, ArrayList noeudVisite){
        noeudVisite.add(noeud);
        noeud.setVisite(true);
        return noeudVisite;
    }
    
    // Parcour en largeur de l'arbre, attention il faut appeler la méthode Largeur, jamais celle-ci directement, 
    // sinon on pourra être amené à visiter deux fois le noeud de départ
    public ArrayList parcourLargeur (Noeud noeud, ArrayList noeudVisite){
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
        
        // Appel les noeuds visités 
        for (int i=noeudVisite.size()-noeud_ajoute ; i<noeudVisite.size() ; i++){
            noeudVisite = parcourLargeur((Noeud)noeudVisite.get(i), noeudVisite);
        }
        
        return noeudVisite;
    }
}


