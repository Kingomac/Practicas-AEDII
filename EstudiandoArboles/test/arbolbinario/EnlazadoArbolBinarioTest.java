/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import arbolbinario.ArbolBinario;
import arbolbinario.ArbolVacioExcepcion;
import arbolbinario.EnlazadoArbolBinario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author kingo
 */
public class EnlazadoArbolBinarioTest {
    
     EnlazadoArbolBinario<Integer> vacio; 
     EnlazadoArbolBinario<Integer> hoja1;
     EnlazadoArbolBinario<Integer> hoja2;
     EnlazadoArbolBinario<Integer> hoja3;
     EnlazadoArbolBinario<Integer> nodo1; 
     EnlazadoArbolBinario<Integer> raiz;	
    
    public static <E> boolean identicos (ArbolBinario<E> a, ArbolBinario<E> b) throws ArbolVacioExcepcion {
        if (!a.esVacio() && !b.esVacio())
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        else return a.esVacio() && b.esVacio();
    }
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp() throws Exception {
        vacio = new EnlazadoArbolBinario<>();
        hoja1 = new EnlazadoArbolBinario<>(3, vacio, vacio);
        hoja2 = new EnlazadoArbolBinario<>(5, vacio, vacio);
        hoja3 = new EnlazadoArbolBinario<>(7, vacio, vacio);
        nodo1 = new EnlazadoArbolBinario<>(6, hoja1, hoja2); 
        raiz = new EnlazadoArbolBinario<>(4, nodo1, hoja3);	
    }
     

    /**
     * Test of esVacio method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        ArbolBinario<Integer> instance = new EnlazadoArbolBinario();
        boolean expResult = true;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }
@Test
    public void testEsVacioFalse() {
        System.out.println("esVacio false");
        ArbolBinario<Integer> instance = hoja1;
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }
    /**
     * Test of raiz method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testRaiz() throws ArbolVacioExcepcion {
        System.out.println("raiz");
        ArbolBinario<Integer> instance = hoja1;
        Integer expResult = 3;
        Integer result = instance.raiz();
        assertEquals(expResult, result);
    }
    @Test(expected=ArbolVacioExcepcion.class)
    public void testRaizVacio() throws ArbolVacioExcepcion {
        System.out.println("raiz");
        ArbolBinario<Integer> instance = vacio;
        Integer result = instance.raiz();
    }

    /**
     * Test of esta method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEsta() {
        System.out.println("esta");
        Integer elemento = 4;
        ArbolBinario<Integer> instance = raiz;
        boolean expResult = true;
        boolean result = instance.esta(elemento);
        assertEquals(expResult, result);
    }
    @Test 
    public void testEstaFalse() {
        System.out.println("no esta");
        Integer elemento = 2;
        ArbolBinario<Integer> instance = raiz;
        boolean expResult = false;
        boolean result = instance.esta(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Test of hijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testHijoIzq() throws ArbolVacioExcepcion {
        System.out.println("hijoIzq");
        ArbolBinario<Integer> instance = vacio;
        ArbolBinario result = instance.hijoIzq();
    }
    @Test 
    public void testHijoIzqTrue() throws ArbolVacioExcepcion {
        System.out.println("hijoIzq");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = nodo1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertTrue(identicos(expResult,result));
    }
    @Test 
    public void testHijoIzqFalse() throws ArbolVacioExcepcion {
        System.out.println("hijoIzq");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertFalse(identicos(instance,result));
    }

    /**
     * Test of hijoDer method, of class EnlazadoArbolBinario.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testHijoDer() throws ArbolVacioExcepcion {
        System.out.println("hijoDer");
        ArbolBinario<Integer> instance = vacio;
        ArbolBinario result = instance.hijoDer();
    }
    @Test 
    public void testHijoDerTrue() throws ArbolVacioExcepcion {
        System.out.println("hijoDer");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja3;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertTrue(identicos(expResult,result));
    }
    @Test 
    public void testHijoDerFalse() throws ArbolVacioExcepcion {
        System.out.println("hijoDer");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja1;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertFalse(identicos(instance,result));
    }

     /* Test of padre method, of class EnlazadoPadreArbolBinario. Es un método que no está en la interface
     */
//    @Test //(expected=ArbolVacioExcepcion.class)
//    public void testgetPadreVacio() {
//        System.out.println("padre");
//        exception.expect(ArbolVacioExcepcion.class);
//        exception.expectMessage(CoreMatchers.containsString("padre: Árbol vacío"));
//        ArbolBinario<Integer> instance = vacio;
//        instance.getPadre(hoja1);
//    }
//    @Test //(expected=ArbolVacioExcepcion.class)
//    public void testPadreRaiz() {
//        System.out.println("padre");
//        exception.expect(ArbolVacioExcepcion.class);
//        exception.expectMessage(CoreMatchers.containsString("padre: Árbol vacío"));
//        ArbolBinario<Integer> instance = raiz;
//        instance.getPadre(vacio);
//    }
//    @Test 
//    public void testPadreTrue() {
//        System.out.println("padre");
//        ArbolBinario<Integer> instance = raiz;
//        ArbolBinario<Integer> expResult = new solactividad3.EnlazadoPadreArbolBinario<>();
//        ArbolBinario<Integer> result = instance.getPadre(raiz);
//        assertTrue(identicos(expResult,result));
//    }
//    @Test 
//    public void testPadreTrue2() {
//        System.out.println("padre");
//        ArbolBinario<Integer> instance = raiz;
//        ArbolBinario<Integer> expResult = raiz;
//        ArbolBinario<Integer> result = instance.getPadre(nodo1);
//        assertTrue(identicos(expResult,result));
//    }
//    @Test 
//    public void testPadreFalse() {
//        System.out.println("padre");
//        ArbolBinario<Integer> instance = raiz;
//        ArbolBinario<Integer> expResult = nodo1;
//        ArbolBinario<Integer> result = raiz.getPadre(hoja3);
//        assertFalse(identicos(expResult,result));
//    }

    /**
     * Test of setRaiz method, of class EnlazadoArbolBinario.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testSetRaiz() throws ArbolVacioExcepcion {
        System.out.println("setRaiz");
        Integer elemRaiz = 2;
        ArbolBinario<Integer> instance = vacio;
        instance.setRaiz(elemRaiz);
    }
    @Test 
    public void testSetRaizTrue() throws ArbolVacioExcepcion {
        System.out.println("setRaiz");
        Integer elemRaiz = 5;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertTrue(identicos(instance,hoja2));
    }
    @Test 
    public void testSetRaizFalse() throws ArbolVacioExcepcion {
        System.out.println("setRaiz");
        Integer elemRaiz = 4;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertFalse(identicos(instance,hoja2));
    }

    /**
     * Test of setHijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testSetHijoIzq() throws ArbolVacioExcepcion {
        System.out.println("setHijoIzq");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3,vacio,vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoIzq(hijo);
    }
    @Test 
    public void testSetHijoIzqTrue() throws ArbolVacioExcepcion {
        System.out.println("setHijoIzq");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3,vacio,vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7,new EnlazadoArbolBinario<>(3,vacio,vacio),vacio);
        instance.setHijoIzq(hijo);
        assertTrue(identicos(instance, expResult));
    }
    @Test 
    public void testSetHijoIzqFalse() throws ArbolVacioExcepcion {
        System.out.println("setHijoIzq");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3,vacio,vacio);
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7,new EnlazadoArbolBinario<>(3,vacio,vacio),vacio);
        instance.setHijoIzq(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of setHijoDer method, of class EnlazadoArbolBinario.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testSetHijoDer() throws ArbolVacioExcepcion {
        System.out.println("setHijoDer");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3,vacio,vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoDer(hijo);
    }
    @Test 
    public void testSetHijoDerTrue() throws ArbolVacioExcepcion {
        System.out.println("setHijoDer");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3,vacio,vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7, vacio, new EnlazadoArbolBinario<>(3,vacio,vacio));
        instance.setHijoDer(hijo);
        assertTrue(identicos(instance, expResult));
    }
    @Test 
    public void testSetHijoDerFalse() throws ArbolVacioExcepcion {
        System.out.println("setHijoDer");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3,vacio,vacio);
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7,new EnlazadoArbolBinario<>(3,vacio,vacio),vacio);
        instance.setHijoDer(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of suprimir method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSuprimir() throws ArbolVacioExcepcion {
        System.out.println("suprimir");
        ArbolBinario<Integer> instance = raiz;
        instance.suprimir();
        assertTrue(identicos(instance,vacio));
    }
    
}
