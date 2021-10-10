/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4;

import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author kingo
 */
public class HeapTest {

    Heap<Integer> heapVacio;
    Heap<Integer> heapPrueba;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        heapVacio = new Heap<>();
        heapPrueba = new Heap<>();
        heapPrueba.insertar(14);
        heapPrueba.insertar(6);
        heapPrueba.insertar(5);
        heapPrueba.insertar(8);
        heapPrueba.insertar(1);
        heapPrueba.insertar(3);
        heapPrueba.insertar(12);
        heapPrueba.insertar(9);
        heapPrueba.insertar(7);
        heapPrueba.insertar(13);
        heapPrueba.insertar(2);
    }

    @Test
    public void testEsVacio() {
        System.out.println("Test 'esVacio' method");
        boolean expResult = true;
        boolean result = heapVacio.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test for recuperar method, of class Heap.
     */
    @Test
    public void testRecuperarVacio() throws HeapVacioExcepcion {
        System.out.println("Test 'recuperarMax' for empty heap");
        exception.expect(HeapVacioExcepcion.class);
        exception.expectMessage(CoreMatchers.containsString("ERROR: HEAP is empty"));
        heapVacio.recuperarMax();
    }

    @Test
    public void testRecuperar() throws HeapVacioExcepcion {
        System.out.println("Test 'recuperarMax' for non-empty heap");
        Integer result = heapPrueba.recuperarMax();
        Integer expResult = 14;
        assertEquals(expResult, result);
    }

    /**
     * Test for suprimir method, of class Heap.
     */
    @Test
    public void testSuprimirVacio() throws HeapVacioExcepcion {
        System.out.println("Test 'suprimirMax' for empty heap");
        exception.expect(HeapVacioExcepcion.class);
        exception.expectMessage("ERROR: HEAP is empty");
        heapVacio.suprimirMax();
    }

    @Test
    public void testSuprimir() throws HeapVacioExcepcion {
        System.out.println("Test 'suprimirMax' for non-empty heap");
        Integer expResult = 12;
        heapPrueba.suprimirMax();
        heapPrueba.suprimirMax();
        Integer result = heapPrueba.suprimirMax();
        assertEquals(expResult, result);
    }

    /**
     * Tests for insertar method of class Heap.
     */
    @Test
    public void testInsertarVacio() throws HeapVacioExcepcion {
        System.out.println("Test 'insertar' for empty heap");
        Integer e = 1;
        heapVacio.insertar(e);
        Integer result = heapVacio.recuperarMax();
        assertEquals(e, result);
    }

    @Test
    public void testInsertar() throws HeapVacioExcepcion {
        System.out.println("Test 'insertar' for non-empty heap");
        Integer e = 15;
        heapPrueba.insertar(e);
        Integer result = heapPrueba.recuperarMax();
        assertEquals(e, result);
    }

    @Test
    public void testInsertarFail() {
        System.out.println("Test 'insertar' when elements is not valid");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ERROR: Element is null");
        heapVacio.insertar(null);
    }

    /**
     * Test of introducir method, of class Heap.
     */
    @Test
    public void testIntroducirVacio() throws HeapVacioExcepcion {
        System.out.println("Test 'introducir' for empty heap");
        Integer e = 1;
        heapVacio.introducir(e);
        Integer result = heapVacio.recuperarMax();
        assertEquals(e, result);
    }

    @Test
    public void testIntroducir() throws HeapVacioExcepcion {
        System.out.println("Test 'introducir' from non-empty heap");
        Integer e = 14;
        heapPrueba.introducir(15);
        Integer result = heapPrueba.recuperarMax();
        assertEquals(e, result);
    }

    /**
     * Test of arreglarHeap method, of class Heap.
     */
    @Test
    public void testArreglarHeap() throws HeapVacioExcepcion {
        System.out.println("Test 'arreglarHeap'");
        heapPrueba.introducir(18);
        heapPrueba.introducir(19);
        heapPrueba.introducir(20);
        heapPrueba.arreglarHeap();
        Integer result = heapPrueba.recuperarMax();
        Integer e = 20;
        assertEquals(e, result);
    }
}
