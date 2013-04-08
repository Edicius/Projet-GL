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
    public ArrayList<Noeud> Largeur (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour){
        noeudVisite.add(noeud);
        noeud.setVisite(true);
        parcourLargeurNoeud (noeud, noeudVisite, nivParcour);
        return noeudVisite;
    }
    
    // Parcour en largeur de l'arbre, attention il faut appeler la méthode Largeur, jamais celle-ci directement, 
    // sinon on pourra être amené à visiter deux fois le noeud de départ
    public ArrayList<Noeud> parcourLargeurNoeud (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour){
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
    
    public ArrayList<Noeud> parcourLargeurRelation (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour) {
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
    
    public static ArrayList<Noeud> parcoursProfondeur(ArrayList<Noeud> listeNoeuds,Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour ){
    	resetNoeudVisite(listeNoeuds);
    	noeudVisite = parcoursProfondeurNoeud( noeud, noeudVisite, nivParcour);
    	return noeudVisite;
    }
    
    public static ArrayList<Noeud> parcoursProfondeurNoeud (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour){
      noeud.setVisite(true);
      noeudVisite.add(noeud);
      ArrayList<Lien> lienSortant;
      lienSortant = noeud.getLienSortant();
      
      for(int i=0;i<lienSortant.size();i++){
    	  if(!lienSortant.get(i).getVisite() && nivParcour-1>0){
    		  noeudVisite = parcoursProfondeurNoeud((Noeud)lienSortant.get(i).getArrivee(), noeudVisite, nivParcour -1);
    	  }
      }
      return noeudVisite;
    }
    
    public static void resetNoeudVisite(ArrayList<Noeud> noeuds){
    	for(int i=0;i<noeuds.size();i++){
    		noeuds.get(i).setVisite(false);
    	}
    }
    
    public ArrayList parcourLiens (Noeud noeud, ArrayList lien, ArrayList direction){
        ArrayList<Noeud> listeNoeud = new ArrayList();
        listeNoeud.add(noeud);
        
        for (int i=0 ; i<lien.size() ; i++){
            listeNoeud = parcourLien(listeNoeud, (String)lien.get(i), (String)direction.get(i));
        }
        
        return listeNoeud;
    }
            
    public ArrayList parcourLien (ArrayList listeNoeud, String lien, String direction){
        ArrayList<Noeud> resultat = new ArrayList();
        
        if (direction.equals("<") || direction.equals("-")){
            resultat.addAll(parcourAscendant(listeNoeud, lien));
        }
        
        if (direction.equals(">") ||  direction.equals("-")){
            resultat.addAll(parcourDescendant(listeNoeud, lien));
        }
        
        return resultat;
    }
            
    public ArrayList parcourAscendant (ArrayList listeNoeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList();
        
        for (int i =0 ; i<listeNoeud.size() ; i++){
            resultat.addAll(parcourAscendantNoeud((Noeud)listeNoeud.get(i) ,lien));
        }
        
        return resultat;
    }
          
    public ArrayList parcourAscendantNoeud (Noeud noeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList();
        
        for (int i=0 ; i<noeud.getLienEntrant().size() ; i++){
            if (noeud.getLienEntrant().get(i).getNom().equals(lien)){
                resultat.add(noeud.getLienEntrant().get(i).getDepart());
            }
        }

        
        
        return resultat;
    }
           
    public ArrayList parcourDescendant (ArrayList listeNoeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList();
        
        for (int i=0 ; i<listeNoeud.size() ; i++){
            resultat.addAll(parcourDescendantNoeud((Noeud)listeNoeud.get(i), lien));
        }
        
        return resultat;
    }

    
         
    public ArrayList parcourDescendantNoeud (Noeud noeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList();
        
        for (int i=0 ; i<noeud.getLienSortant().size() ; i++){
            if (noeud.getLienSortant().get(i).getNom().equals(lien)){
                resultat.add(noeud.getLienSortant().get(i).getArrivee());
            }
        }
        
        return resultat;
    }
}


