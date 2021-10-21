/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiandoarboles;

import arbolbinario.ArbolBinario;
import arbolbinario.EnlazadoArbolBinario;
import arbolgeneral.ArbolGeneral;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Mario
 */
public class EstudiandoArbolesTest {

    private static final EnlazadoArbolBinario<Integer> vacio = new EnlazadoArbolBinario<>();
    private static final EnlazadoArbolBinario<Integer> hoja1 = new EnlazadoArbolBinario<>(3, vacio, vacio);
    private static final EnlazadoArbolBinario<Integer> hoja11 = new EnlazadoArbolBinario<>(3, vacio, vacio);
    private static final EnlazadoArbolBinario<Integer> hoja2 = new EnlazadoArbolBinario<>(5, vacio, vacio);
    private static final EnlazadoArbolBinario<Integer> hoja3 = new EnlazadoArbolBinario<>(7, vacio, vacio);
    private static final EnlazadoArbolBinario<Integer> nodo1 = new EnlazadoArbolBinario<>(11, hoja1, hoja2);
    private static final EnlazadoArbolBinario<Integer> nodo2 = new EnlazadoArbolBinario<>(3, hoja1, hoja2);
    private static final EnlazadoArbolBinario<Integer> raiz = new EnlazadoArbolBinario<>(7, nodo1, hoja3);
    private static final EnlazadoArbolBinario<Integer> selec = new EnlazadoArbolBinario<>(3, nodo2, hoja3);
    private static final EnlazadoArbolBinario<Integer> degen = new EnlazadoArbolBinario<>(1, new EnlazadoArbolBinario<>(13, vacio, hoja3), vacio);
    private static final EnlazadoArbolBinario<Integer> nodoSinHojas = new EnlazadoArbolBinario<>(11, vacio, vacio);
    private static final EnlazadoArbolBinario<Integer> raizSinHojas = new EnlazadoArbolBinario<>(7, nodoSinHojas, vacio);
    private static final EnlazadoArbolBinario<Integer> raizHasta1 = new EnlazadoArbolBinario<>(7, nodoSinHojas, hoja3);

    private static final EnlazadoArbolBinario<Character> vacioChar = new EnlazadoArbolBinario<>();
    private static final EnlazadoArbolBinario<Character> hoja1Char = new EnlazadoArbolBinario<>('3', vacioChar, vacioChar);
    private static final EnlazadoArbolBinario<Character> hoja2Char = new EnlazadoArbolBinario<>('5', vacioChar, vacioChar);
    private static final EnlazadoArbolBinario<Character> hoja3Char = new EnlazadoArbolBinario<>('2', vacioChar, vacioChar);
    private static final EnlazadoArbolBinario<Character> nodo1Char = new EnlazadoArbolBinario<>('6', hoja1Char, hoja2Char);
    private static final EnlazadoArbolBinario<Character> arbolCamino = new EnlazadoArbolBinario<>('7', nodo1Char, hoja3Char);

    private static ArbolGeneral<Integer> ghoja1 = new ArbolGeneral<>(5, ArbolGeneral.VACIO);
    private static ArbolGeneral<Integer> ghoja1Igual = new ArbolGeneral<>(5, ArbolGeneral.VACIO);
    private static ArbolGeneral<Integer> ghoja2 = new ArbolGeneral<>(3, ArbolGeneral.VACIO);
    private static ArbolGeneral<Integer> ghoja3 = new ArbolGeneral<>(9, ArbolGeneral.VACIO);
    private static ArbolGeneral<Integer> graiz = new ArbolGeneral<>(7, ghoja1, ghoja2, ghoja3);

    /**
     * Ejercicio 1 Test of completo method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioCompleto() {
        System.out.println("completo vacío");
        boolean expResult = true;
        boolean result = EstudiandoArboles.completo(vacio);
        assertEquals(expResult, result);
    }

    @Test
    public void testHojaCompleto() {
        System.out.println("completo hoja");
        boolean expResult = true;
        boolean result = EstudiandoArboles.completo(hoja3);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoCompleto() {
        System.out.println(" no completo");
        boolean expResult = false;
        boolean result = EstudiandoArboles.completo(degen);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompleto() {
        System.out.println("si completo");
        boolean expResult = true;
        boolean result = EstudiandoArboles.completo(raiz);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 2 Test of identicos method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioIdenticos() {
        System.out.println("identicos vacío");
        boolean expResult = true;
        boolean result = EstudiandoArboles.identicos(vacio, new EnlazadoArbolBinario<>());
        assertEquals(expResult, result);
    }

    @Test
    public void testHojaIdenticos() {
        System.out.println("identicos hoja");
        boolean expResult = true;
        boolean result = EstudiandoArboles.identicos(hoja1, hoja11);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoIdenticos() {
        System.out.println("no identicos");
        boolean expResult = false;
        boolean result = EstudiandoArboles.identicos(raiz, selec);
        assertEquals(expResult, result);
    }

    @Test
    public void testIdenticos() {
        System.out.println("identicos");
        boolean expResult = true;
        boolean result = EstudiandoArboles.identicos(raiz, raiz);
        assertEquals(expResult, result);
    }

    @Test
    public void testVacioIdenticosG() {
        System.out.println("identicos vacío");
        boolean expResult = true;
        boolean result = EstudiandoArboles.identicos(ArbolGeneral.VACIO, new ArbolGeneral<>());
        assertEquals(expResult, result);
    }

    @Test
    public void testHojaIdenticosG() {
        System.out.println("identicos hoja");
        boolean expResult = true;
        boolean result = EstudiandoArboles.identicos(ghoja1, ghoja1Igual);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoIdenticosG() {
        System.out.println("no identicos");
        boolean expResult = false;
        boolean result = EstudiandoArboles.identicos(graiz, ghoja1);
        assertEquals(expResult, result);
    }

    @Test
    public void testIdenticosG() {
        System.out.println("identicos");
        boolean expResult = true;
        boolean result = EstudiandoArboles.identicos(graiz, graiz);
        assertEquals(expResult, result);
    }

    /**
     * Test of copia method, of class EstudiandoArboles., tranparencias
     */
    @Test
    public void testVacioCopia() {
        System.out.println("copia vacio");
        ArbolBinario expResult = vacio;
        ArbolBinario result = EstudiandoArboles.copia(vacio);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    @Test
    public void testCopia() {
        System.out.println("copia");
        ArbolGeneral expResult = graiz;
        ArbolGeneral result = EstudiandoArboles.copia(graiz);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    @Test
    public void testVacioCopiaG() {
        System.out.println("copia vacio general");
        var expResult = ArbolGeneral.VACIO;
        ArbolGeneral result = EstudiandoArboles.copia(ArbolGeneral.VACIO);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    @Test
    public void testCopiaG() {
        System.out.println("copia general");
        ArbolBinario expResult = raiz;
        ArbolBinario result = EstudiandoArboles.copia(raiz);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    /**
     * Ejercicio 3 Test of contarNivel method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioContarNivel() {
        System.out.println("contar Nivel vacío");
        int expResult = 0;
        int result = EstudiandoArboles.contarNivel(vacio, 0);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoContarNivel() {
        System.out.println(" no hay nivel");
        int expResult = 0;
        int result = EstudiandoArboles.contarNivel(hoja1, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void testContarNivel() {
        System.out.println("contar Nivel 2");
        int expResult = 2;
        int result = EstudiandoArboles.contarNivel(raiz, 2);
        assertEquals(expResult, result);
    }

//    /**
//     *
//     * Test of nodosNivel method, of class EstudiandoArboles.
//     */
//    @Test
//    public void testVacioNodosNivel() {
//        System.out.println("nodos nivel vacío");
//        List<Integer> expResult = new LinkedList<>();
//        List<Integer> result = EstudiandoArboles.nodosNivel(vacio, 0);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testNodosNivel() {
//        System.out.println(" nodos  nivel");
//        List<Integer> expResult = Arrays.asList(3, 5);
//        List<Integer> result = EstudiandoArboles.nodosNivel(raiz, 2);
//        assertEquals(expResult, result);
//    }
//
    /**
     * Ejercicio 4 Test of eliminarHojas method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioEliminarHojas() {
        System.out.println("eliminar Hojas vacío");
        ArbolBinario expResult = vacio;
        ArbolBinario result = EstudiandoArboles.eliminarHojas(hoja1);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    @Test
    public void testEliminarHojas() {
        System.out.println("eliminarHojas");
        ArbolBinario expResult = raizSinHojas;
        ArbolBinario result = EstudiandoArboles.eliminarHojas(raiz);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    /**
     * Ejercicio 5 Test of altura method, of class EstudiandoArboles.
     */
    @Test
    public void testAlturaVacio() {
        System.out.println("altura vacío");
        int expResult = 0;
        int result = EstudiandoArboles.altura(vacio);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlturaHoja() {
        System.out.println("altura hoja");
        int expResult = 1;
        int result = EstudiandoArboles.altura(hoja1);
        assertEquals(expResult, result);
    }

    @Test
    public void testAltura() {
        System.out.println("altura");
        int expResult = 2;
        int result = EstudiandoArboles.altura(raiz);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 6 Test of mismaForma method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioMismaForma() {
        System.out.println("misma forma vacíos");
        boolean expResult = true;
        boolean result = EstudiandoArboles.mismaForma(vacio, new EnlazadoArbolBinario<>());
        assertEquals(expResult, result);
    }

    @Test
    public void testHojasMismaForma() {
        System.out.println("misma forma hojas");
        boolean expResult = true;
        boolean result = EstudiandoArboles.mismaForma(hoja1, hoja11);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoMismaForma() {
        System.out.println("no misma forma");
        boolean expResult = false;
        boolean result = EstudiandoArboles.mismaForma(raiz, nodo2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMismaForma() {
        System.out.println("mismaForma");
        boolean expResult = true;
        boolean result = EstudiandoArboles.mismaForma(nodo1, nodo2);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 7 Test of arbolSeleccion method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioArbolSeleccion() {
        System.out.println("arbolSeleccionVacio");
        boolean expResult = true;
        boolean result = EstudiandoArboles.arbolSeleccion(vacio);
        assertEquals(expResult, result);

    }

    @Test
    public void testHojaArbolSeleccion() {
        System.out.println("arbolSeleccion hoja");
        boolean expResult = true;
        boolean result = EstudiandoArboles.arbolSeleccion(hoja1);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoArbolSeleccion() {
        System.out.println("arbolSeleccion no");
        boolean expResult = false;
        boolean result = EstudiandoArboles.arbolSeleccion(raiz);
        assertEquals(expResult, result);
    }

    @Test
    public void testArbolSeleccion() {
        System.out.println("arbolSeleccion");
        boolean expResult = true;
        boolean result = EstudiandoArboles.arbolSeleccion(selec);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 8 Test of esCamino method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioEsCamino() {
        System.out.println("esCamino vacio");
        boolean expResult = true;
        boolean result = EstudiandoArboles.esCamino(vacio, "");
        assertEquals(expResult, result);
    }

    @Test
    public void testNoEsCamino() {
        System.out.println("esCamino no");
        boolean expResult = false;
        boolean result = EstudiandoArboles.esCamino(arbolCamino, "5");
        assertEquals(expResult, result);
    }

    @Test
    public void testEsCamino() {
        System.out.println("esCamino");
        boolean expResult = true;
        boolean result = EstudiandoArboles.esCamino(arbolCamino, "763");
        assertEquals(expResult, result);
    }

    @Test
    public void testEsCamino2() {
        System.out.println("esCamino");
        boolean expResult = true;
        boolean result = EstudiandoArboles.esCamino(arbolCamino, "76");
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 9 Test of copiaHastaNivel method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioCopiaHastaNivel() {
        System.out.println("copiaHastaNivel vacio");
        ArbolBinario expResult = vacio;
        ArbolBinario result = EstudiandoArboles.copiaHastaNivel(vacio, 0);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    @Test
    public void testCopiaHastaNivel() {
        System.out.println("copiaHastaNivel");
        ArbolBinario expResult = raizHasta1;
        ArbolBinario result = EstudiandoArboles.copiaHastaNivel(raiz, 1);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    @Test
    public void testSobreCopiaHastaNivel() {
        System.out.println("copiaHastaNivel");
        ArbolBinario expResult = raiz;
        ArbolBinario result = EstudiandoArboles.copiaHastaNivel(raiz, 4);
        boolean eq = EstudiandoArboles.identicos(expResult, result);
        assertTrue(eq);
    }

    /**
     * Ejercicio 10 Test of visualizarPalabras method, of class
     * EstudiandoArboles.
     */
    @Test
    public void testNoVisualizarPalabras() {
        System.out.println("visualizarPalabras");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps); // Esto hace que System.out escriba en "output" en lugar de escribir por consola
        EstudiandoArboles.visualizarPalabras(vacio);
        String written = output.toString(); // Este toString recupera lo  escrito en "output"
        assertEquals("", written);
    }

    @Test
    public void testVisualizarPalabras() {
        System.out.println("visualizarPalabras");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps); // Esto hace que System.out escriba en "output" en lugar de escribir por consola
        EstudiandoArboles.visualizarPalabras(nodo1Char);
        String expected = "63\r\n65\r\n";
        String written = output.toString(); // Este toString recupera lo escrito en "output"
        assertEquals(expected, written);
    }

    /**
     * Ejercicio 11 Test of padre method, of class EstudiandoArboles.
     */
    @Test
    public void testVacioPadre() {
        System.out.println("padre vacío");
        Integer expResult = null;
        Integer result = EstudiandoArboles.padre(vacio, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoPadre() {
        System.out.println("padre no");
        Object expResult = null;
        Object result = EstudiandoArboles.padre(raiz, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void testPadre() {
        System.out.println("padre");
        Object expResult = 11;
        Object result = EstudiandoArboles.padre(raiz, 3);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 12 Test of padre method, of class EstudiandoArboles.
     */
    @Test
    public void testDistanciaVacioFalse() {
        System.out.println("distancia árbol vacío false");
        assertFalse(EstudiandoArboles.distanciaK(vacio, 2, 0));
    }

    @Test
    public void testDistanciaFalse() {
        System.out.println("distancia false");
        assertFalse(EstudiandoArboles.distanciaK(raiz, 5, 1));
    }

    @Test
    public void testDistanciaTrue() {
        System.out.println("distancia true");
        assertTrue(EstudiandoArboles.distanciaK(raiz, 5, 2));
    }
}
