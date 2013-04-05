/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet_gl.*;

/**
 *
 * @author yann
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
     * Test of Largeur method, of class Arbre.
     */
    @Test
    public void testLargeur1() {
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList attribut = new ArrayList();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n4, n5, attribut);
        
        ArrayList Visite = new ArrayList();
        ArrayList noeudVisite = new ArrayList();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        noeudVisite.add(n5);
        
        ArrayList t1 = new ArrayList();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList t2 = new ArrayList();
        t2.add(l4);
        
        ArrayList t3 = new ArrayList();
        t3.add(l5);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        n4.setLienSortant(t3);
        
        Arbre instance = new Arbre();
        ArrayList expResult = noeudVisite;
        ArrayList result = instance.Largeur(n1, Visite, -1);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testLargeur2() {
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList attribut = new ArrayList();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n3, n5, attribut);
        
        ArrayList Visite = new ArrayList();
        ArrayList noeudVisite = new ArrayList();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        //noeudVisite.add(n5);
        
        ArrayList t1 = new ArrayList();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList t2 = new ArrayList();
        t2.add(l5);
        t2.add(l4);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        
        Arbre instance = new Arbre();
        ArrayList expResult = noeudVisite;
        ArrayList result = instance.Largeur(n1, Visite, 1);
        
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
        
        ArrayList attribut = new ArrayList();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n3, n5, attribut);
        
        ArrayList Visite = new ArrayList();
        Visite.add(n1);
        n1.setVisite(true);
        
        ArrayList noeudVisite = new ArrayList();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        noeudVisite.add(n5);
        
        ArrayList t1 = new ArrayList();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList t2 = new ArrayList();
        t2.add(l5);
        t2.add(l4);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        
        Arbre instance = new Arbre();
        ArrayList expResult = noeudVisite;
        ArrayList result = instance.parcourLargeurNoeud(n1, Visite, -1);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testParcourLargeurRelation() {
        
        Noeud n1 = new Noeud("bob");
        Noeud n2 = new Noeud("sam");
        Noeud n3 = new Noeud("eli");
        Noeud n4 = new Noeud("lea");
        Noeud n5 = new Noeud("jue");
        
        ArrayList attribut = new ArrayList();
        Lien l1 = new Lien("a", n1, n2, attribut);
        Lien l2 = new Lien("b", n1, n3, attribut);
        Lien l3 = new Lien("c", n1, n4, attribut);
        Lien l4 = new Lien("d", n3, n4, attribut);
        Lien l5 = new Lien("e", n3, n5, attribut);
        
        ArrayList Visite = new ArrayList();
        Visite.add(n1);
        n1.setVisite(true);
        
        ArrayList noeudVisite = new ArrayList();
        noeudVisite.add(n1);
        noeudVisite.add(n2);
        noeudVisite.add(n3);
        noeudVisite.add(n4);
        noeudVisite.add(n5);
        noeudVisite.add(n4);
        
        ArrayList t1 = new ArrayList();
        t1.add(l1);
        t1.add(l2);
        t1.add(l3);
        
        ArrayList t2 = new ArrayList();
        t2.add(l5);
        t2.add(l4);
        
        n1.setLienSortant(t1);
        n3.setLienSortant(t2);
        
        Arbre instance = new Arbre();
        ArrayList expResult = noeudVisite;
        ArrayList result = instance.parcourLargeurRelation(n1, Visite, -1);
            
        assertEquals(expResult, result);
    }
}
