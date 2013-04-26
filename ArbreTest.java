package projet_gl;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Fonctions restantes a tester : 
 * parcoursProfondeur
 * parcoursProfondeurNoeud
 * resetNoeudVisite
 * parcoursLiens
 * parcoursLien
 * parcoursAscendant
 * parcoursAscendantNoeud
 * parcoursDescendant
 * parcoursDescendantNoeud
 *  
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

/**
 *	Voici l'ensemble des fonction testees avec l'outil JUnit : 
 *	- largeur (2 fois?), en laissant qu'un seul
 *	- parcoursLargeurNoeud
 *	- parcourLargeurRelation
 *  - 
 *  -
 *  -
 *  -
 *  -
 *  
 */

public class ArbreTest {
    
    public ArbreTest() {
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
     * Test1 of Largeur method, of class Arbre.
     */
    @Test
    public void testLargeur1() {
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList<Attribut> attribut = new ArrayList<Attribut>();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n4, n5, attribut);
        
        ArrayList<Noeud> Visite = new ArrayList<Noeud>();
        ArrayList<Noeud> noeudVisite = new ArrayList<Noeud>();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        noeudVisite.add(n5);
        
        ArrayList<Lien> t1 = new ArrayList<Lien>();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList<Lien> t2 = new ArrayList<Lien>();
        t2.add(l4);
        
        ArrayList<Lien> t3 = new ArrayList<Lien>();
        t3.add(l5);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        n4.setLienSortant(t3);
        
        Arbre instance = new Arbre();
        ArrayList<Noeud> expResult = noeudVisite;
        ArrayList<Noeud> result = instance.largeur(n1, Visite, -1);
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test2 of Largeur method, of class Arbre.
     */
    @Test
    public void testLargeur2() {
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList<Attribut> attribut = new ArrayList<Attribut>();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n3, n5, attribut);
        
        ArrayList<Noeud> Visite = new ArrayList<Noeud>();
        ArrayList<Noeud> noeudVisite = new ArrayList<Noeud>();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        
        ArrayList<Lien> t1 = new ArrayList<Lien>();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList<Lien> t2 = new ArrayList<Lien>();
        t2.add(l5);
        t2.add(l4);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        
        Arbre instance = new Arbre();
        ArrayList<Noeud> expResult = noeudVisite;
        ArrayList<Noeud> result = instance.largeur(n1, Visite, 1);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of parcourLargeur method, of class Arbre.
     */
    @Test
    public void testParcourLargeurNoeud() {
        
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList<Attribut> attribut = new ArrayList<Attribut>();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n3, n5, attribut);
        
        ArrayList<Noeud> Visite = new ArrayList<Noeud>();
        Visite.add(n1);
        n1.setVisite(true);
        
        ArrayList<Noeud> noeudVisite = new ArrayList<Noeud>();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        noeudVisite.add(n5);
        
        ArrayList<Lien> t1 = new ArrayList<Lien>();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList<Lien> t2 = new ArrayList<Lien>();
        t2.add(l5);
        t2.add(l4);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        
        Arbre instance = new Arbre();
        ArrayList<Noeud> expResult = noeudVisite;
        ArrayList<Noeud> result = instance.parcoursLargeurNoeud(n1, Visite, -1);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of parcourLargeurRelation method, of class Arbre.
     */
    @Test
    public void testParcourLargeurRelation() {
        
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList<Attribut> attribut = new ArrayList<Attribut>();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n3, n5, attribut);
        
        ArrayList<Noeud> Visite = new ArrayList<Noeud>();
        Visite.add(n1);
        n1.setVisite(true);
        
        ArrayList<Noeud> noeudVisite = new ArrayList<Noeud>();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        noeudVisite.add(n5);
        noeudVisite.add(n4);
        
        ArrayList<Lien> t1 = new ArrayList<Lien>();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList<Lien> t2 = new ArrayList<Lien>();
        t2.add(l5);
        t2.add(l4);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        
        Arbre instance = new Arbre();
        ArrayList<Noeud> expResult = noeudVisite;
        ArrayList<Noeud> result = instance.parcoursLargeurRelation(n1, Visite, -1);
            
        assertEquals(expResult, result);
    }
}
