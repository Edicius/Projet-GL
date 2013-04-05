/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_gl;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Standard
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
    public void testLargeur() {
        System.out.println("Largeur");
        Noeud noeud = null;
        ArrayList noeudVisite = null;
        Arbre instance = new Arbre();
        ArrayList expResult = null;
        ArrayList result = instance.Largeur(noeud, noeudVisite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcourLargeur method, of class Arbre.
     */
    @Test
    public void testParcourLargeur() {
        System.out.println("parcourLargeur");
        Noeud noeud = null;
        ArrayList noeudVisite = null;
        Arbre instance = new Arbre();
        ArrayList expResult = null;
        ArrayList result = instance.parcourLargeur(noeud, noeudVisite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
