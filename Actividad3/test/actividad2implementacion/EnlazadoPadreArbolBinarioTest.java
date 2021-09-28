/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2implementacion;

import org.hamcrest.CoreMatchers;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author pavon
 */
public class EnlazadoPadreArbolBinarioTest {

    public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (!a.esVacio() && !b.esVacio()) {
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        } else {
            return a.esVacio() && b.esVacio();
        }
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    EnlazadoPadreArbolBinario<Integer> vacio;
    EnlazadoPadreArbolBinario<Integer> hoja1;
    EnlazadoPadreArbolBinario<Integer> hoja2;
    EnlazadoPadreArbolBinario<Integer> hoja3;
    EnlazadoPadreArbolBinario<Integer> nodo1;
    EnlazadoPadreArbolBinario<Integer> raiz;

    @Before
    public void setUp() throws Exception {
        vacio = new EnlazadoPadreArbolBinario<>();
        hoja1 = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        hoja2 = new EnlazadoPadreArbolBinario<>(5, vacio, vacio);
        hoja3 = new EnlazadoPadreArbolBinario<>(7, vacio, vacio);
        nodo1 = new EnlazadoPadreArbolBinario<>(6, hoja1, hoja2);
        raiz = new EnlazadoPadreArbolBinario<>(4, nodo1, hoja3);
    }

    /**
     * Test of esVacio method, of class EnlazadoPadreArbolBinario.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        ArbolBinario<Integer> instance = new EnlazadoPadreArbolBinario();
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
     * Test of raiz method, of class EnlazadoPadreArbolBinario.
     */
    @Test
    public void testRaiz() {
        System.out.println("raiz");
        ArbolBinario<Integer> instance = hoja1;
        Integer expResult = 3;
        Integer result = instance.raiz();
        assertEquals(expResult, result);
    }

    @Test //(expected=ArbolVacioExcepcion.class)
    public void testRaizVacio() {
        System.out.println("raiz");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("raiz: Árbol vacío"));
        ArbolBinario<Integer> instance = vacio;
        Integer result = instance.raiz();
    }

    /**
     * Test of esta method, of class EnlazadoPadreArbolBinario.
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
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testHijoIzq() {
        System.out.println("hijoIzq");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("hijoIzq: Árbol vacío"));
        ArbolBinario<Integer> instance = vacio;
        ArbolBinario result = instance.hijoIzq();
    }

    @Test
    public void testHijoIzqTrue() {
        System.out.println("hijoIzq");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = nodo1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertTrue(identicos(expResult, result));
    }

    @Test
    public void testHijoIzqFalse() {
        System.out.println("hijoIzq");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertFalse(identicos(instance, result));
    }

    /**
     * Test of hijoDer method, of class EnlazadoPadreArbolBinario.
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testHijoDer() {
        System.out.println("hijoDer");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("hijoDer: Árbol vacío"));
        ArbolBinario<Integer> instance = vacio;
        ArbolBinario result = instance.hijoDer();
    }

    @Test
    public void testHijoDerTrue() {
        System.out.println("hijoDer");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja3;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertTrue(identicos(expResult, result));
    }

    @Test
    public void testHijoDerFalse() {
        System.out.println("hijoDer");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja1;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertFalse(identicos(instance, result));
    }

    /**
     * Test of padre method, of class EnlazadoPadreArbolBinario. Es un método
     * que no está en la interface
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testPadreVacio() {
        System.out.println("padre");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("padre: Árbol vacío"));
        EnlazadoPadreArbolBinario<Integer> instance = (EnlazadoPadreArbolBinario) vacio;
        instance.getPadre();
    }

    @Test //(expected=ArbolVacioExcepcion.class)
    public void testPadreRaiz() {
        System.out.println("padre");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("padre: Árbol vacío"));
        EnlazadoPadreArbolBinario<Integer> instance = (EnlazadoPadreArbolBinario) raiz;
        ArbolBinario<Integer> result = instance.getPadre();
        assertTrue(identicos(instance, result));
    }

    @Test
    public void testPadreTrue() {
        System.out.println("padre");
        EnlazadoPadreArbolBinario<Integer> instance = (EnlazadoPadreArbolBinario) nodo1;
        ArbolBinario<Integer> expResult = raiz;
        ArbolBinario<Integer> result = instance.getPadre();
        assertTrue(identicos(expResult, result));
    }

    @Test
    public void testPadreFalse() {
        System.out.println("padre");
        EnlazadoPadreArbolBinario<Integer> instance = (EnlazadoPadreArbolBinario) hoja3;
        ArbolBinario<Integer> expResult = raiz;
        ArbolBinario<Integer> result = instance.getPadre();
        assertFalse(identicos(instance, result));
    }

    /**
     * Test of setRaiz method, of class EnlazadoPadreArbolBinario.
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testSetRaiz() {
        System.out.println("setRaiz");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("raiz: Árbol vacío"));
        Integer elemRaiz = 2;
        ArbolBinario<Integer> instance = vacio;
        instance.setRaiz(elemRaiz);
    }

    @Test
    public void testSetRaizTrue() {
        System.out.println("setRaiz");
        Integer elemRaiz = 5;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertTrue(identicos(instance, hoja2));
    }

    @Test
    public void testSetRaizFalse() {
        System.out.println("setRaiz");
        Integer elemRaiz = 4;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertFalse(identicos(instance, hoja2));
    }

    /**
     * Test of setHijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testSetHijoIzq() {
        System.out.println("setHijoIzq");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("setHijoIzq: Árbol vacío"));
        ArbolBinario<Integer> hijo = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoIzq(hijo);
    }

    @Test
    public void testSetHijoIzqTrue() {
        System.out.println("setHijoIzq");
        ArbolBinario<Integer> hijo = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoPadreArbolBinario<>(7, new EnlazadoPadreArbolBinario<>(3, vacio, vacio), vacio);
        instance.setHijoIzq(hijo);
        assertTrue(identicos(instance, expResult));
    }

    @Test
    public void testSetHijoIzqFalse() {
        System.out.println("setHijoIzq");
        ArbolBinario<Integer> hijo = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = new EnlazadoPadreArbolBinario<>(7, new EnlazadoPadreArbolBinario<>(3, vacio, vacio), vacio);
        instance.setHijoIzq(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of setHijoDer method, of class EnlazadoPadreArbolBinario.
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testSetHijoDer() {
        System.out.println("setHijoDer");
        exception.expect(ArbolVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("setHijoDer: Árbol vacío"));
        ArbolBinario<Integer> hijo = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoDer(hijo);
    }

    @Test
    public void testSetHijoDerTrue() {
        System.out.println("setHijoDer");
        ArbolBinario<Integer> hijo = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoPadreArbolBinario<>(7, vacio, new EnlazadoPadreArbolBinario<>(3, vacio, vacio));
        instance.setHijoDer(hijo);
        assertTrue(identicos(instance, expResult));
    }

    @Test
    public void testSetHijoDerFalse() {
        System.out.println("setHijoDer");
        ArbolBinario<Integer> hijo = new EnlazadoPadreArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = new EnlazadoPadreArbolBinario<>(7, new EnlazadoPadreArbolBinario<>(3, vacio, vacio), vacio);
        instance.setHijoDer(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of suprimir method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSuprimir() {
        System.out.println("suprimir");
        ArbolBinario<Integer> instance = raiz;
        instance.suprimir();
        assertTrue(identicos(instance, vacio));
    }

}
