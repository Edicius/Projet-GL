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
 * @author Edicius
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
        System.out.println("analyse");
        ArrayList tab = null;
        ArrayList pers = null;
        ArrayList expResult = null;
        ArrayList result = Projet_GL.analyse(tab, pers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNoeud method, of class Projet_GL.
     */
    @Test
    public void testAddNoeud() {
        //System.out.println("addNoeud");
        ArrayList tab = new ArrayList();
        String nom = "MonNoeud";
        ArrayList expResult = new ArrayList();
        
        expResult.add(new Noeud("MonNoeud"));
        expResult.add(new Noeud("MonNoeud2"));
        expResult.add(new Noeud("MonNoeud3"));
        
        Projet_GL.addNoeud(tab, nom);
        Projet_GL.addNoeud(tab, "MonNoeud2");
        Projet_GL.addNoeud(tab, "MonNoeud3");
        Projet_GL.addNoeud(tab, nom);
        ArrayList result = tab;
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
        //System.out.println("decoupe");
        String s = "(blablabla coucou, ok    mh)(bonjour ok salut)   (oui c'est sur!)";
        ArrayList tableau = new ArrayList();
        ArrayList expResult = new ArrayList();
        expResult.add("blablabla coucou, ok    mh");
        expResult.add("bonjour ok salut");
        expResult.add("oui c'est sur!");
        ArrayList result = Projet_GL.decoupe(s, tableau);
        assertEquals(expResult, result);                
    }

    /**
     * Test of search method, of class Projet_GL.
     */
    @Test
    public void testSearch() {
        //System.out.println("search");
        ArrayList<Noeud> tab = new ArrayList();
        String nom = "Bob";
        
        tab.add(new Noeud("Coucou"));
        tab.add(new Noeud("bob"));
        tab.add(new Noeud(nom));
        tab.add(new Noeud("Mh"));
        Noeud expResult = (Noeud)tab.get(2);
        Noeud result = Projet_GL.search(tab, nom);
        assertEquals(expResult, result);
    }
}
