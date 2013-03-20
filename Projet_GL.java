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
        
        ArrayList<Noeud> personnes = new ArrayList(), donnees = new ArrayList();        
        
        
        File fichier = new File("Arbre.txt");
        InputStream is; 
        String chaine;
        
        is = new FileInputStream(fichier);
        
        InputStreamReader isr = new InputStreamReader(is);
        try (BufferedReader br = new BufferedReader(isr)) {
            String ligne;
            
            while ((chaine = br.readLine()) != null){
                decoupe(chaine, donnees);  
            }
        }

        analyse(donnees, personnes);
        
//        System.out.println("");
//        for (int i=0 ; i < personnes.size() ; i++){
//            System.out.println(personnes.get(i).getNom());
//        }
    }
    
    public static ArrayList analyse(ArrayList tab, ArrayList pers){
        
        if (tab.isEmpty()){
            return pers;
        }
        
        String chaine, lien, attribut;
        int pos, lienDir, attributVal; //lienDir <-- = -1, -- = 0, --> = 1;
        ArrayList att = new ArrayList();
        
        //lire nom 1
        chaine = tab.get(0).toString();
        pos = chaine.indexOf("<--") < 0 ? chaine.indexOf("--") : chaine.indexOf("<--");
        //System.out.print(chaine.substring(0, pos).trim());
        pers = addNoeud(pers, chaine.substring(0, pos).trim());
               
        // lire nom 2
        pos = chaine.indexOf("-->") < 0 ? chaine.indexOf("--", chaine.indexOf("--")+2)+2 : chaine.indexOf("-->")+3;
        //System.out.print(" " + chaine.substring(pos).trim());
        pers = addNoeud(pers, chaine.substring(pos).trim());
        
        //lire lien        
        lien = chaine.substring(chaine.indexOf("--")+2, chaine.indexOf("[")).trim();
        
        
        //lire attribut
        att = buildAtt(chaine.substring(chaine.indexOf("[")+1), att);
  
        
        // check sens 
        if (!(chaine.indexOf("-->") < 0)){
            lienDir = 1;
        }
        else if(!(chaine.indexOf("<--") < 0)){
            lienDir = -1;
        }
        else{
            lienDir = 0;
        }

        
        
        
        tab.remove(0);
        
        return analyse(tab, pers);
        
    }
    
    public static ArrayList buildAtt(String chaine, ArrayList tab){

        if(chaine.indexOf(",") < 0){
            tab.add(new Attribut(chaine.substring(0, chaine.indexOf("=")).trim(), chaine.substring(chaine.indexOf("=")+1, chaine.indexOf("]")).trim()));
            return tab;
        }
        
        tab.add(new Attribut(chaine.substring(0, chaine.indexOf("=")).trim(), chaine.substring(chaine.indexOf("=")+1, chaine.indexOf(",")).trim()));
        return buildAtt(chaine.substring(chaine.indexOf(",")+1), tab);
    }
    
    public static ArrayList addNoeud(ArrayList tab, String nom){
        
        if (search(tab, nom) != -1){
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

    public static int search(ArrayList tab, String nom){
        
        for (int i = 0 ; i < tab.size() ; i++){
            if (((Noeud) tab.get(i)).getNom().equals(nom)) {
                return i;
            }
        }
        
        return -1;
        
    }
            
            
}
