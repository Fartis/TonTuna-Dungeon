/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import Modelo.Monstruo;
import Modelo.Personaje;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author farti
 */
public class ControladorBBDDTest {
    
    public ControladorBBDDTest() {
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
     * Test of getSingleton method, of class ControladorBBDD.
     */
    @Test
    public void testGetSingleton() {
        System.out.println("getSingleton");
        ControladorBBDD expResult = null;
        ControladorBBDD result = ControladorBBDD.getSingleton();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarInfoPJ method, of class ControladorBBDD.
     */
    @Test
    public void testGuardarInfoPJ() {
        System.out.println("guardarInfoPJ");
        Personaje pj = null;
        ControladorBBDD instance = null;
        instance.guardarInfoPJ(pj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaPersonajesBase method, of class ControladorBBDD.
     */
    @Test
    public void testListaPersonajesBase() {
        System.out.println("listaPersonajesBase");
        ControladorBBDD instance = null;
        Personaje[] expResult = null;
        Personaje[] result = instance.listaPersonajesBase();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearPJBase method, of class ControladorBBDD.
     */
    @Test
    public void testCrearPJBase() {
        System.out.println("crearPJBase");
        String nombre = "";
        String raza = "";
        ControladorBBDD instance = null;
        Personaje expResult = null;
        Personaje result = instance.crearPJBase(nombre, raza);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArma method, of class ControladorBBDD.
     */
    @Test
    public void testObtenerArma() throws Exception {
        System.out.println("obtenerArma");
        int nivel = 0;
        ControladorBBDD instance = null;
        Arma expResult = null;
        Arma result = instance.obtenerArma(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerObjeto method, of class ControladorBBDD.
     */
    @Test
    public void testObtenerObjeto() throws Exception {
        System.out.println("obtenerObjeto");
        ControladorBBDD instance = null;
        Objeto expResult = null;
        Objeto result = instance.obtenerObjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArmadura method, of class ControladorBBDD.
     */
    @Test
    public void testObtenerArmadura() throws Exception {
        System.out.println("obtenerArmadura");
        int nivel = 0;
        ControladorBBDD instance = null;
        Armadura expResult = null;
        Armadura result = instance.obtenerArmadura(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerMonstruo method, of class ControladorBBDD.
     */
    @Test
    public void testObtenerMonstruo() throws Exception {
        System.out.println("obtenerMonstruo");
        int nivel = 0;
        ControladorBBDD instance = null;
        Monstruo expResult = null;
        Monstruo result = instance.obtenerMonstruo(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
