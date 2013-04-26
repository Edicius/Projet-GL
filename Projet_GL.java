package projet_gl;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * Cette methode est la fonction principal du programme et comporte donc le main.
 * Elle comporte aussi les fonctions relative à l'affichage.
 */
public class Projet_GL {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, IOException {        
        File fichier;
        int choix;
    
        while(true){
            System.out.println("1. Ouvrir un fichier");
            System.out.println("2. Quitter");
            System.out.println("");
            System.out.print("Veuillez choisir une action : ");
            choix = nextInt(1, 2);
            
            switch(choix){
                case 1:
                    fichier = ouvertureFichier();
                    menuTraitement(fichier);
                    break;
                    
                case 2:
                    System.exit(0);
            }
            
        }
 
//        ArrayList<Noeud> parcours = new ArrayList<>();
//        ArrayList<Noeud> parcoursSorti;
//        int niv=4;
//        parcoursSorti = Arbre.parcoursProfondeur(personnes,personnes.get(0), parcours, niv );
//        for(int i=0;i<parcoursSorti.size();i++){
//        	System.out.println(parcoursSorti.get(i).getNom());
//        }
    }
    
    /** Méthode ouvertureFichier : 
     * - 
     * - 
     */
    public static File ouvertureFichier() throws IOException{
                
        JFileChooser dialogue = new JFileChooser(new File("."));	
	File fichier = null;

	if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
	    fichier = dialogue.getSelectedFile();	    
	}
        
        return fichier;
        
    }
    
    /** Méthode menuTraitement : 
     * - Prend en entrée un fichier de type File
     * - 
     */
    public static void menuTraitement(File fichier){
                
        int choix;
        ArrayList<Noeud> personnes = new ArrayList<Noeud>();
        ArrayList<Noeud> donnees = new ArrayList<Noeud>();
        
        while(true){
            System.out.println("1. Afficher graphe (texte)");
            System.out.println("2. Afficher graphe (GUI)");
            System.out.println("3. Autre ?");
            System.out.println("4. Retour");
            System.out.println("");
            System.out.print("Veuillez choisir une action à effectuer : ");
            
            choix = nextInt(1, 4);
            
            switch(choix){
                case 1:
                    InputStream is = null; 
                    String chaine;
                    
                    try {
                        is = new FileInputStream(fichier);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Projet_GL.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    
                    try {
                        while ((chaine = br.readLine()) != null){
                            decoupe(chaine, donnees);  
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Projet_GL.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    
                    analyse(donnees, personnes);

                    afficherGraphe(personnes);
                    
                    sousMenu(personnes);
                                        
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Projet_GL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
                case 2:
                    System.out.println("Pas encore implémentée :/");
                    break;
                
                case 3:
                    System.out.println("What else ?");
                    break;
                    
                case 4:
                    return;                    
                    
            }
        }
        
    }
    
    /** Méthode sousmenuTraitement :
     * - une fois le graphe affich� 
     * - pour effectuer l'affichage de l'arbre avec un mode de parcours
     * - choisi par l'utilisateur
     *  * - @personnes: tableau regroupant les personnes
     */
    public static void sousMenu(ArrayList<Noeud> personnes){
    	int ch,niv = 0;
    	boolean ok = false;
    	ArrayList<Noeud> resultat = new ArrayList<Noeud>();
    	ArrayList<Noeud> parcours = new ArrayList<Noeud>();
        
        while(true){
            System.out.println("1. Faire une recherche avec parcours en largeur");
            System.out.println("2. Faire une recherche avec parcours en profondeur");
            System.out.println("3. Retour");
            System.out.println("");
            System.out.print("Veuillez choisir une action à effectuer : ");
            
            ch = nextInt(1, 3);
            
            switch(ch){
            	case 1:
            		while (!ok){
	        			try{
	        				System.out.println("Entrez le niveau de granularit�");
	        				sc = new Scanner(System.in);
	        				niv = sc.nextInt();
	        				ok = true;
	        			}
	        			catch(InputMismatchException e){
	        				System.out.println("Saisie de la granularit� incorrecte.");
	        			}
	        		}
            		resultat = Arbre.largeur(personnes.get(0), parcours, niv );
		            for(int i=0;i<resultat.size();i++){
		            	System.out.println(resultat.get(i).getNom());
		            }
	            case 2: 
	            	while (!ok){
	        			try{
	        				System.out.println("Entrez le niveau de granularit�");
	        				sc = new Scanner(System.in);
	        				niv = sc.nextInt();
	        				ok = true;
	        			}
	        			catch(InputMismatchException e){
	        				System.out.println("Saisie de la granularit� incorrecte.");
	        			}
	        		}
	            	resultat = Arbre.parcoursProfondeur(personnes,personnes.get(0), parcours, niv );
		            for(int i=0;i<resultat.size();i++){
		            	System.out.println(resultat.get(i).getNom());
		            }
		            break;
	            case 3:
	            	return;
            }
        }
    }
    
    /** Méthode analyse : 
     * - Cette fonction crée 0, 1 ou 2 noeuds selon l'existence ou non de ces derniers, puis crée la liste de liens et celle des attributs
     * - Elle repète ces actions pour toutes les entrées du tableau
     * - @tab : tableau contenant toutes les entrées à traiter
     * - @pers: tableau regroupant les personnes
     */
    public static ArrayList<Noeud> analyse(ArrayList tab, ArrayList pers){
        
        if (tab.isEmpty()){
            return pers;
        }
        
        String chaine, lien;
        int pos; //lienDir <-- = -1, -- = 0, --> = 1;
        ArrayList<Attribut> att = new ArrayList<Attribut>();
        ArrayList<String> noms;
        Lien link;
        Noeud n1, n2;
        
        chaine = tab.get(0).toString();
                
        noms = lireNom(pers, chaine);   
        
        n1 = search(pers, noms.get(0).toString());
        n2 = search(pers, noms.get(1).toString());        
        
        while(chaine.indexOf("[") != -1){
            //lire lien        
            if (chaine.indexOf("--") != -1 && chaine.indexOf("--") < chaine.indexOf("[")){
                lien = chaine.substring(chaine.indexOf("--")+2, chaine.indexOf("[")).trim();
            }
            else{
                lien = chaine.substring(0, chaine.indexOf("[")).trim();
            }
            //lire attribut
            att = new ArrayList<Attribut>();
            att = Lien.buildAtt(chaine.substring(chaine.indexOf("[")+1), att);                        
            //création lien
            if (!(chaine.indexOf("-->") < 0)){
                link = new Lien(lien, n1, n2, att);                
                n1.getLienSortant().add(link);
                n2.getLienEntrant().add(link);
                
            }
            else if(!(chaine.indexOf("<--") < 0)){
                link = new Lien(lien, n2, n1, att);                
                n2.getLienSortant().add(link);
                n1.getLienEntrant().add(link);
            }
            else{
                link = new Lien(lien, n1, n2, att);                
                n1.getLienSortant().add(link);
                n2.getLienEntrant().add(link);
                
                Lien link2 = new Lien(lien, n2, n1, att);                
                n2.getLienSortant().add(link2);
                n1.getLienEntrant().add(link2);
                
            }
            
            //MAJ chaine
            chaine = chaine.substring(chaine.indexOf("]")+1);
            if (chaine.indexOf(",")==0){
                chaine = chaine.substring(1);
            }
        }

        tab.remove(0);
        
        return analyse(tab, pers);        
    }
    
    /** Méthode lireNom: 
     * - 
     * -
     */    
    public static ArrayList<String> lireNom(ArrayList pers, String chaine){
        
        String nom1, nom2;
        int pos;
        ArrayList<String> noms = new ArrayList<String>();
        
        //lire nom 1                
        pos = chaine.indexOf("<--") < 0 ? chaine.indexOf("--") : chaine.indexOf("<--");       
        nom1 = chaine.substring(0, pos).trim();
        pers = addNoeud(pers, nom1);

        // lire nom 2
        pos = chaine.indexOf("-->") < 0 ? chaine.indexOf("--", chaine.indexOf("--")+2)+2 : chaine.indexOf("-->")+3;
        nom2 = chaine.substring(pos).trim();
        pers = addNoeud(pers, nom2);
        
        noms.add(nom1);
        noms.add(nom2);
        
        return noms;
        
    }
    
    /** Méthode afficherGraphe : 
     * - Prend en entree une liste de noeud
     * - 
     */
    public static void afficherGraphe(ArrayList<Noeud> tab){
        
        Noeud n;        
        
        for (int i = 0 ; i < tab.size() ; i++){
            n = (tab.get(i));
            System.out.println("\n" + n.getNom());
            System.out.println("\t Liens Entrant");            
            for (int j = 0 ; j < n.getLienEntrant().size() ; j++){
                System.out.println("\t\t" + n.getLienEntrant().get(j).getNom());
                for (int k = 0 ; k < n.getLienEntrant().get(j).getAttribut().size() ; k++){
                    System.out.println(n.getLienEntrant().get(j).getAttribut().get(k).getValeur() == null ? 
                            "\t\t\t" + n.getLienEntrant().get(j).getAttribut().get(k).getNom() : 
                            "\t\t\t" + n.getLienEntrant().get(j).getAttribut().get(k).getNom() + " = " + n.getLienEntrant().get(j).getAttribut().get(k).getValeur());
                }
            }
            System.out.println("\t Liens Sortant");
            for (int j = 0 ; j < n.getLienSortant().size() ; j++){
                System.out.println("\t\t" + n.getLienSortant().get(j).getNom());
                for (int k = 0 ; k < n.getLienSortant().get(j).getAttribut().size() ; k++){
                    System.out.println(n.getLienSortant().get(j).getAttribut().get(k).getValeur() == null ? 
                            "\t\t\t" + n.getLienSortant().get(j).getAttribut().get(k).getNom() : 
                            "\t\t\t" + n.getLienSortant().get(j).getAttribut().get(k).getNom() + " = " + n.getLienSortant().get(j).getAttribut().get(k).getValeur());
                }
            }
        }
        
    }
    

    /** Méthode addNoeud : 
     * - 
     * - 
     */
    public static ArrayList<Noeud> addNoeud(ArrayList<Noeud> tab, String nom){
        
        if (search(tab, nom) != null){
            return tab;
        }
        tab.add(new Noeud(nom));
        return tab;
        
        
    }
    
    /** Méthode decoupe : 
     * - découpe le fichier à analyser en fonction des ( ) et les rentre dans un tableau
     * - 
     */
    public static ArrayList decoupe(String s, ArrayList tableau){
        
        if (s.indexOf("(") == -1){
            return tableau;
        }
        tableau.add(s.substring(s.indexOf("(")+1, s.indexOf(")")));
        
        return decoupe(s.substring(s.indexOf(")")+1), tableau);
    }

    /** Méthode search : 
     * - 
     * - 
     */
    public static Noeud search(ArrayList<Noeud> tab, String nom){
        
        for (int i = 0 ; i < tab.size() ; i++){
            if (((Noeud) tab.get(i)).getNom().equals(nom)) {
                return (Noeud) tab.get(i);
            }
        }
        
        return null;
        
    }
      
    /** Méthode buildAtt : 
     * - Prend en entree un string et une liste d'attribut
     * - 
     */
    public static int nextInt(int min, int max) {
        int choix;

        do {

            try {
                choix = sc.nextInt();
            } catch (InputMismatchException e) {
                choix = -1;
                sc.nextLine();
            }
            if (choix < min || choix > max) {
                choix = -1;
                System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
            }


        } while (choix == -1);
        sc.nextLine();
        return choix;
    }
}
       