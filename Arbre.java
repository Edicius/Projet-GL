package projet_gl;

import java.util.ArrayList;

/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Refactorisation possible : 
 *  - Une seule différence entre la fonction parcoursLargeurNoeud et parcoursLargeurRelation (3eme ligne du for)
 *  - Expliquer dans les commentaires le but de chaque fonction
 *  - Corriger les warnings pour les fonctions de parcours
 *  - Changer les noms des fonctions parcoursLien et parcoursLiens, rendre le nom plus explicite
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

/**
 *  La classe Arbre represente l'ensemble du graphe qui est represente par un ensemble de 
 *  noeud.
 */
public class Arbre {
    ArrayList<Noeud> arbre;
    
    /** Méthode largeur : 
     * - Prend en entree un noeud, une liste de noeud et le niveau de parcours a visiter
     * - Renvoie en sortie la liste des noeuds visitees
     */
    public static ArrayList<Noeud> largeur (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcours){
        noeudVisite.add(noeud);
        noeud.setVisite(true);
        parcoursLargeurNoeud (noeud, noeudVisite, nivParcours);
        return noeudVisite;
    }
    
    /**
     * Methode parcoursLargeurNoeud :
     * - Possede les memes entrees et sorties que la fonction largeur
     * - Sert uniquement a la fonction largeur pour effectuer de la recursivite pour eviter de visiter deux fois le noeud de depart
     */
    public static ArrayList<Noeud> parcoursLargeurNoeud (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcours){
        ArrayList<Lien> lien;
        lien = noeud.getLienSortant();
        int noeud_ajoute = 0;
        
        //Parcours les liens sortant du noeud et les ajoute a la liste s'ils ne sont pas deja presents 
        for (int i=0 ; i<lien.size() ; i++){
            if (((Lien)lien.get(i)).getArrivee().getVisite() == false){
                noeudVisite.add((Noeud)lien.get(i).getArrivee());
                lien.get(i).getArrivee().setVisite(true);
                noeud_ajoute ++;
            }
        }
        
        //Tant qu'on n'a pas explorer en profondeur les noeuds souhaites, on continue de les parcourir 
        if (nivParcours != 1){  
            for (int i=noeudVisite.size()-noeud_ajoute ; i<noeudVisite.size() ; i++){
                noeudVisite = parcoursLargeurNoeud((Noeud)noeudVisite.get(i), noeudVisite, --nivParcours);
            }
        }
        return noeudVisite;
    }
    
    /**
     * Méthode parcoursLargeurRelation : 
     * - Prend en entree un noeud, une liste de noeud et le niveau de parcours a visiter
     * - Renvoie en sortie la liste des noeuds visitees
     */
    public ArrayList<Noeud> parcoursLargeurRelation (Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour) {
        ArrayList<Lien> lien;
        lien = noeud.getLienSortant();
        int noeud_ajoute = 0;
        
        //Parcours les liens sortant du noeud et les ajoute a la liste s'ils ne sont pas deja presents 
        for (int i=0 ; i<lien.size() ; i++){
            if (((Lien)lien.get(i)).getVisite() == false){
                noeudVisite.add((Noeud)lien.get(i).getArrivee());
                lien.get(i).setVisite(true);
                noeud_ajoute ++;
            }
        }
        
        //Tant qu'on n'a pas explorer en profondeur les noeuds souhaites, on continue de les parcourir
        if (nivParcour != 1){
            for (int i=noeudVisite.size()-noeud_ajoute ; i<noeudVisite.size() ; i++){
                noeudVisite = parcoursLargeurRelation((Noeud)noeudVisite.get(i), noeudVisite, --nivParcour);
            }
        }
        return noeudVisite;
    }
    
    /**
     * Méthode parcoursProfondeur : 
     * - Prend en entree un noeud, une liste de noeud et le niveau de parcours a visiter
     * - Renvoie en sortie la liste des noeuds visitees
     */
    public static ArrayList<Noeud> parcoursProfondeur(ArrayList<Noeud> listeNoeuds,Noeud noeud, ArrayList<Noeud> noeudVisite, int nivParcour ){
    	resetNoeudVisite(listeNoeuds);
    	noeudVisite = parcoursProfondeurNoeud( noeud, noeudVisite, nivParcour);
    	return noeudVisite;
    }
    
    /**
     * Méthode parcoursProfondeurNoeud : 
     * - Prend en entree un noeud, une liste de noeud et le niveau de parcours a visiter
     * - Renvoie en sortie la liste des noeuds visitees
     * - Sert uniquement a la fonction parcoursProfondeur pour effectuer de la recursivite pour eviter de visiter deux fois le noeud de depart
     */
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
    
    /**
     * Méthode resetNoeudVisite : 
     * - Prend en entree une liste de noeud
     * - Met tous les noeuds visites a false
     */
    public static void resetNoeudVisite(ArrayList<Noeud> noeuds){
    	for(int i=0;i<noeuds.size();i++){
    		noeuds.get(i).setVisite(false);
    	}
    }
    
    /**
     * Méthode parcoursLiens : 
     * - 
     * - 
     */
    public ArrayList<Noeud> parcoursLiens (Noeud noeud, ArrayList lien, ArrayList direction){
        ArrayList<Noeud> listeNoeud = new ArrayList<Noeud>();
        listeNoeud.add(noeud);
        
        for (int i=0 ; i<lien.size() ; i++){
            listeNoeud = parcoursLien(listeNoeud, (String)lien.get(i), (String)direction.get(i));
        }
        
        return listeNoeud;
    }
    
    /**
     * Méthode parcoursLien : 
     * - 
     * - 
     */
    public ArrayList<Noeud> parcoursLien (ArrayList<Noeud> listeNoeud, String lien, String direction){
        ArrayList<Noeud> resultat = new ArrayList<Noeud>();
        
        if (direction.equals("<") || direction.equals("-")){
            resultat.addAll(parcoursAscendant(listeNoeud, lien));
        }
        
        if (direction.equals(">") ||  direction.equals("-")){
            resultat.addAll(parcoursDescendant(listeNoeud, lien));
        }
        
        return resultat;
    }
 
    /**
     * Méthode parcoursAscendant : 
     * - 
     * - 
     */
    public ArrayList<Noeud> parcoursAscendant (ArrayList<Noeud> listeNoeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList<Noeud>();
        
        for (int i =0 ; i<listeNoeud.size() ; i++){
            resultat.addAll(parcoursAscendantNoeud((Noeud)listeNoeud.get(i) ,lien));
        }
        
        return resultat;
    }
  
    /**
     * Méthode parcoursAscendantNoeud : 
     * - 
     * - 
     */
    public ArrayList<Noeud> parcoursAscendantNoeud (Noeud noeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList<Noeud>();
        
        for (int i=0 ; i<noeud.getLienEntrant().size() ; i++){
            if (noeud.getLienEntrant().get(i).getNom().equals(lien)){
                resultat.add(noeud.getLienEntrant().get(i).getDepart());
            }
        }
      
        return resultat;
    }

    /**
     * Méthode parcoursDescendant : 
     * - 
     * - 
     */
    public ArrayList<Noeud> parcoursDescendant (ArrayList<Noeud> listeNoeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList<Noeud>();
        
        for (int i=0 ; i<listeNoeud.size() ; i++){
            resultat.addAll(parcoursDescendantNoeud((Noeud)listeNoeud.get(i), lien));
        }
        
        return resultat;
    }

    
    /**
     * Méthode parcoursDescendantNoeud : 
     * - 
     * - 
     */     
    public ArrayList<Noeud> parcoursDescendantNoeud (Noeud noeud, String lien){
        ArrayList<Noeud> resultat = new ArrayList<Noeud>();
        
        for (int i=0 ; i<noeud.getLienSortant().size() ; i++){
            if (noeud.getLienSortant().get(i).getNom().equals(lien)){
                resultat.add(noeud.getLienSortant().get(i).getArrivee());
            }
        }
        
        return resultat;
    }
}


