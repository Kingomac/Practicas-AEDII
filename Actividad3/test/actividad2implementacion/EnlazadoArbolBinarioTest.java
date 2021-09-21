/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2implementacion;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author kingo
 */
public class EnlazadoArbolBinarioTest {

    public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) throws ArbolVacioExcepcion {
        if (a.esVacio() || b.esVacio()) {
            return a.esVacio() && b.esVacio();
        } else {
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(),
                    b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        }
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    EnlazadoArbolBinario<Integer> vacio;
    EnlazadoArbolBinario<Integer> hoja1;
    EnlazadoArbolBinario<Integer> hoja2;
    EnlazadoArbolBinario<Integer> hoja3;
    EnlazadoArbolBinario<Integer> nodo1;
    EnlazadoArbolBinario<Integer> raiz;

    @Before
    public void setUpClass() {
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
    public void esVacio() {
        System.out.println("Test 'esVacio' for an empty tree");
        ArbolBinario<Integer> instance = new EnlazadoArbolBinario();
        boolean expResult = true;
        boolean result = instance.esVacio();
        assertEquals(result, expResult);
    }

    @Test
    public void testEsVacioFalse() {
        System.out.println("Test 'esVacio' for a non-empty tree");
        ArbolBinario<Integer> instance = hoja1;
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of raiz method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testRaiz() {
        System.out.println("Test 'raiz' with a non-empty element");
        ArbolBinario<Integer> instance = hoja1;
        Integer expResult = 3;
        Integer result = instance.raiz();
        assertEquals(expResult, result);
    }

    @Test
    public void testRaizVacio() {
        System.out.println("Test 'raiz' with empty element");
        exception.expect(ArbolVacioExcepcion.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] raiz: Arbol vacio"));
        ArbolBinario<Integer> instance = vacio;
        instance.raiz();
    }

    /**
     * Test of esta method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEsta() {
        System.out.println("Test 'esta' when element is contained in the tree");
        Integer elemento = 4;
        ArbolBinario<Integer> instance = raiz;
        boolean expResult = true;
        boolean result = instance.esta(elemento);
        assertEquals(result, expResult);
    }

    @Test
    public void testEstaFalse() {
        System.out.println("Test 'esta' method when element is not contained in the tree");
        Integer elemento = 2;
        ArbolBinario<Integer> instance = raiz;
        boolean expResult = false;
        boolean result = instance.esta(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Test of hijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testHijoIzqEmpty() {
        System.out.println("Test 'HijoIzq' for an empty tree");
        exception.expect(ArbolVacioExcepcion.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] hijoIzq: Arbol vacio"));
        ArbolBinario<Integer> instance = vacio;
        instance.hijoIzq();
    }

    @Test
    public void testHijoIzqTrue() {
        System.out.println("Test 'HijoIzq' when a tree contains a non-empty left-child");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = nodo1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertTrue(identicos(result, expResult));
    }

    /**
     * Tests of hijoDer method, of class EnlazadoArbolBinario.
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testHijoDerEmpty() {
        System.out.println("Test 'HijoDer' for an empty tree");
        exception.expect(ArbolVacioExcepcion.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] hijoDer: Arbol vacio"));
        ArbolBinario<Integer> instance = vacio;
        instance.hijoDer();
    }

    @Test
    public void testHijoDerTrue() {
        System.out.println("Test 'HijoDer' when the left-child is available");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja3;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertTrue(identicos(expResult, result));
    }

    /**
     * Tests of setRaiz method, of class EnlazadoArbolBinario.
     */
    @Test //(expected=ArbolVacioExcepcion.class)
    public void testSetRaizEmpty() {
        System.out.println("Test 'setRaiz' when root is empty");
        exception.expect(ArbolVacioExcepcion.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] raiz: Arbol vacio"));
        Integer elemRaiz = 2;
        ArbolBinario<Integer> instance = vacio;
        instance.setRaiz(elemRaiz);
    }

    @Test
    public void testSetRaizTrue() {
        System.out.println("Test 'setRaiz' for a non-empty tree");
        Integer elemRaiz = 5;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertTrue(identicos(instance, hoja2));
    }

    /**
     * Tests of setHijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSetHijoIzqEmpty() {
        System.out.println("Test 'setHijoIzq' for an empty tree");
        exception.expect(ArbolVacioExcepcion.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] hijoIzq: Arbol vacio"));
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoIzq(hijo);
    }

    @Test
    public void testSetHijoIzqNull() {
        System.out.println("Test 'setHijoIzq' when subtree is null");
        exception.expect(NullPointerException.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] hi: valor nulo"));
        ArbolBinario<Integer> hijo = null;
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoIzq(hijo);
    }

    @Test
    public void testSetHijoIzqTrue() {
        System.out.println("Test 'setHijoIzq' when tree is non-empty");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7,
                new EnlazadoArbolBinario<>(3, vacio, vacio), vacio);
        instance.setHijoIzq(hijo);
        assertTrue(identicos(instance, expResult));
    }

    /**
     * Tests of setHijoDer method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSetHijoDerEmpty() {
        System.out.println("Test 'setHijoDer' when tree is empty");
        exception.expect(ArbolVacioExcepcion.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] hijoDer: Arbol vacio"));
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoDer(hijo);
    }

    @Test
    public void testSetHijoDerNull() {
        System.out.println("Test 'setHijoDer' when subtree is null");
        exception.expect(NullPointerException.class);
        //exception.expectMessage(CoreMatchers.containsString("[ERROR] hd: valor nulo"));
        ArbolBinario<Integer> hijo = null;
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoDer(hijo);
    }

    @Test
    public void testSetHijoDerTrue() {
        System.out.println("Test 'setHijoDer' when tree is non-empty");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7, vacio,
                new EnlazadoArbolBinario<>(3, vacio, vacio));
        instance.setHijoDer(hijo);
        assertTrue(identicos(instance, expResult));
    }

    /**
     * Test of suprimir method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSuprimir() {
        System.out.println("Test 'suprimir' method");
        ArbolBinario<Integer> instance = raiz;
        instance.suprimir();
        assertTrue(identicos(instance, vacio));
    }

}
