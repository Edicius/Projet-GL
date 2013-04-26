package projet_gl;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Fonctions restantes a tester : 
 * ouvertureFichier
 * analyse
 * afficherGraphe
 * nextInt  
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/


/**
 *	Voici l'ensemble des fonction testees avec l'outil JUnit : 
 *	- analyse (retourne faux)
 *	- addNoeud
 *  - decoupe
 *  - search
 *  
 */
public class Projet_GLTest {
    
    public Projet_GLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of analyse method, of class Projet_GL.
     */
    @Test
    public void testAnalyse() {
        ArrayList<Noeud> tab = null;
        ArrayList<Noeud> pers = null;
        ArrayList<Noeud> expResult = null;
        ArrayList<Noeud> result = Projet_GL.analyse(tab, pers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNoeud method, of class Projet_GL.
     */
    @Test
    public void testAddNoeud() {
        ArrayList<Noeud> tab = new ArrayList<Noeud>();
        String nom = "MonNoeud";
        ArrayList<Noeud> expResult = new ArrayList<Noeud>();
        
        expResult.add(new Noeud("MonNoeud"));
        expResult.add(new Noeud("MonNoeud2"));
        expResult.add(new Noeud("MonNoeud3"));
        
        Projet_GL.addNoeud(tab, nom);
        Projet_GL.addNoeud(tab, "MonNoeud2");
        Projet_GL.addNoeud(tab, "MonNoeud3");
        Projet_GL.addNoeud(tab, nom);
        ArrayList<Noeud> result = tab;
        
        int j=0;
        if (result.size() == expResult.size()){
            for (int i = 0 ; i < result.size() ; i++){
                if(((Noeud)result.get(i)).getNom().equals(((Noeud)expResult.get(i)).getNom())){
                    j++;
                }
            }
        }
        assertEquals(3, j);
    }

    /**
     * Test of decoupe method, of class Projet_GL.
     */
    @Test
    public void testDecoupe() {
        String s = "(blablabla coucou, ok    mh)(bonjour ok salut)   (oui c'est sur!)";
        ArrayList<String> tableau = new ArrayList<String>();
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("blablabla coucou, ok    mh");
        expResult.add("bonjour ok salut");
        expResult.add("oui c'est sur!");
        ArrayList<String> result = Projet_GL.decoupe(s, tableau);
        assertEquals(expResult, result);                
    }

    /**
     * Test of search method, of class Projet_GL.
     */
    @Test
    public void testSearch() {
        //System.out.println("search");
        ArrayList<Noeud> tab = new ArrayList<Noeud>();
        String nom = "Bob";
        
        tab.add(new Noeud("Coucou"));
        tab.add(new Noeud("bob"));
        tab.add(new Noeud(nom));
        tab.add(new Noeud("Mh"));
        Noeud expResult = (Noeud)tab.get(2);
        Noeud result = Projet_GL.search(tab, nom);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class Projet_GL.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Projet_GL.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ouvertureFichier method, of class Projet_GL.
     */
    @Test
    public void testOuvertureFichier() throws Exception {
        System.out.println("ouvertureFichier");
        File expResult = new File("C:\\Users\\Standard\\Documents\\NetBeansProjects\\Projet_GL\\Arbre.txt");
        File result = Projet_GL.ouvertureFichier();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of menuTraitement method, of class Projet_GL.
     */
    @Test
    public void testMenuTraitement() {
        System.out.println("menuTraitement");
        File fichier = null;
        Projet_GL.menuTraitement(fichier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lireNom method, of class Projet_GL.
     */
    @Test //lien gauche droite
    public void testLireNom() {
        //System.out.println("lireNom");
        ArrayList pers = new ArrayList();
        String chaine = "Anna --employee_of[Role=Developer,hired=Mar 06]--> BigCo";        
        ArrayList result = Projet_GL.lireNom(pers, chaine);
        
        String expResult = "AnnaBigCo";
        String aTester = result.get(0).toString() + result.get(1).toString();
        assertEquals(expResult, aTester);
        
    }
    
    @Test //lien droite gauche
    public void testLireNom2() {
        ArrayList pers = new ArrayList();
        String chaine = "Barbara <--friend[since=2011]-- Anna";        
        ArrayList result = Projet_GL.lireNom(pers, chaine);
        
        String expResult = "BarbaraAnna";
        String aTester = result.get(0).toString() + result.get(1).toString();
        assertEquals(expResult, aTester);
    }
    @Test //lien à double sens
    public void testLireNom3() {
        ArrayList pers = new ArrayList();
        String chaine = "Pierre Jean --friend[since=2011]-- Jill";        
        ArrayList result = Projet_GL.lireNom(pers, chaine);
        
        String expResult = "Pierre JeanJill";
        String aTester = result.get(0).toString() + result.get(1).toString();
        assertEquals(expResult, aTester);
    }

    /**
     * Test of afficherGraphe method, of class Projet_GL.
     */
    @Test
    public void testAfficherGraphe() {
        System.out.println("afficherGraphe");
        ArrayList<Noeud> tab = null;
        Projet_GL.afficherGraphe(tab);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextInt method, of class Projet_GL.
     */
    @Test
    public void testNextInt() {
        System.out.println("nextInt");
        int min = 0;
        int max = 0;
        int expResult = 0;
        int result = Projet_GL.nextInt(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
