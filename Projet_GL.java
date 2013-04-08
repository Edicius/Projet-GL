/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_gl;

import java.io.*;
import java.util.*;

/**
 *
 * @author Edicius
 */
public class Projet_GL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ArrayList<Noeud> personnes = new ArrayList<Noeud>(), donnees = new ArrayList<Noeud>();        
        
        
        File fichier = new File("Arbre.txt");
        InputStream is; 
        String chaine;
        
        is = new FileInputStream(fichier);
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
            
        while ((chaine = br.readLine()) != null){
            decoupe(chaine, donnees);  
        }
        
        
        analyse(donnees, personnes);
        
        afficherGraphe(personnes);
        
        ArrayList<Noeud> parcours = new ArrayList<Noeud>();
        ArrayList<Noeud> parcoursSorti;
        int niv=4;
        parcoursSorti = Arbre.parcoursProfondeur(personnes,personnes.get(0), parcours, niv );
        for(int i=0;i<parcoursSorti.size();i++){
        	System.out.println(parcoursSorti.get(i).getNom());
        }
        
        br.close();
        
    }
    
    
    // RM : PRECISER LE TYPE DES ARRAYLISTS
    public static ArrayList analyse(ArrayList tab, ArrayList pers){
        
        if (tab.isEmpty()){
            return pers;
        }
        
        String chaine, chaine2, lien, nom1, nom2;
        int pos; //lienDir <-- = -1, -- = 0, --> = 1;
        ArrayList att = new ArrayList();
        Lien link;
        Noeud n1, n2;
        
        //lire nom 1
        chaine = tab.get(0).toString();
        pos = chaine.indexOf("<--") < 0 ? chaine.indexOf("--") : chaine.indexOf("<--");
        nom1 = chaine.substring(0, pos).trim();
        pers = addNoeud(pers, nom1);
               
        // lire nom 2
        pos = chaine.indexOf("-->") < 0 ? chaine.indexOf("--", chaine.indexOf("--")+2)+2 : chaine.indexOf("-->")+3;
        nom2 = chaine.substring(pos).trim();
        pers = addNoeud(pers, nom2);
        
        ArrayList<Lien> tmp;           
        n1 = search(pers, nom1);
        n2 = search(pers, nom2);
        chaine2 = chaine;
        
        while(chaine.indexOf("[") != -1){
            //lire lien        
            if (chaine.indexOf("--") != -1 && chaine.indexOf("--") < chaine.indexOf("[")){
                lien = chaine.substring(chaine.indexOf("--")+2, chaine.indexOf("[")).trim();
            }
            else{
                lien = chaine.substring(0, chaine.indexOf("[")).trim();
            }
            //lire attribut
            att = new ArrayList();
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
    
    public static void afficherGraphe(ArrayList tab){
        
        Noeud n;        
        
        for (int i = 0 ; i < tab.size() ; i++){
            n = ((Noeud)tab.get(i));
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
    

    
    public static ArrayList addNoeud(ArrayList tab, String nom){
        
        if (search(tab, nom) != null){
            return tab;
        }
        tab.add(new Noeud(nom));
        return tab;
        
        
    }
    
    public static ArrayList decoupe(String s, ArrayList tableau){
        
        if (s.indexOf("(") == -1){
            return tableau;
        }
        tableau.add(s.substring(s.indexOf("(")+1, s.indexOf(")")));
        
        return decoupe(s.substring(s.indexOf(")")+1), tableau);
    }

    public static Noeud search(ArrayList tab, String nom){
        
        for (int i = 0 ; i < tab.size() ; i++){
            if (((Noeud) tab.get(i)).getNom().equals(nom)) {
                return (Noeud) tab.get(i);
            }
        }
        
        return null;
        
    }
            
            
}
