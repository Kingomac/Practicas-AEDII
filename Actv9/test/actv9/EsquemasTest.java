/*
 */
package actv9;

import java.util.Iterator;
import lista.*;
import mapa.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kingo
 */
public class EsquemasTest {

    private static Map<String, Integer> cantidades;
    private static Map<String, Integer> volumenes;
    private static Map<String, Integer> pesos;
    private static Map<Integer, Integer> can;
    private static Map<String, Integer> programas;

    private static void rellenarMapas() {
        cantidades = new HashMap<>();
        cantidades.insertar("Coche", 5);
        cantidades.insertar("Muñeca", 4);

        volumenes = new HashMap<>();
        volumenes.insertar("Coche", 10);
        volumenes.insertar("Muñeca", 20);

        pesos = new HashMap<>();
        pesos.insertar("Coche", 20);
        pesos.insertar("Muñeca", 30);

        can = new HashMap<>();
        can.insertar(200, 10);
        can.insertar(500, 10);

        programas = new HashMap<>();
        programas.insertar("p1", 10);
        programas.insertar("p2", 3);
        programas.insertar("p3", 5);
        programas.insertar("p4", 3);
        programas.insertar("p5", 3);

    }

    private static <E, F> boolean mapasIguales(Map<E, F> m1, Map<E, F> m2) {
        if (m1.tamaño() == m2.tamaño()) {
            Iterator<E> itr = m1.getClaves();
            while (itr.hasNext()) {
                E clave = itr.next();
                if (m1.get(clave) == null || !m1.get(clave).equals(m2.get(clave))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static <E> boolean listasIguales(Lista<E> m1, Lista<E> m2) {
        if (m1.tamaño() == m2.tamaño()) {
            Iterator<E> itr = m1.iteradorLista();
            while (itr.hasNext()) {
                E clave = itr.next();
                if (!m2.contiene(clave)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Before
    public void setUp() throws Exception {
        rellenarMapas();
    }

    /**
     * Test of darCambio method, of class Esquemas.
     */
    @Test
    public void testDarCambio_int_Map() {
        System.out.println("darCambio Voraz");
        Map<Integer, Integer> mapaActual = Esquemas.darCambio(1200, can);
        Map<Integer, Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar(200, 1);
        mapaEsperado.insertar(500, 2);

        boolean result = mapasIguales(mapaActual, mapaEsperado);

        assertTrue(result);
    }

    /**
     * Test of llenarMochila method, of class Esquemas.
     */
    @Test
    public void testLlenarMochila_3args() {
        System.out.println("llenarMochila");
        Map<String, Integer> mapaActual = Esquemas.llenarMochila(55, cantidades, volumenes);

        Map<String, Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar("Coche", 1);
        mapaEsperado.insertar("Muñeca", 2);

        boolean result = mapasIguales(mapaActual, mapaEsperado);

        assertTrue(result);
    }

    /**
     * Test of llenarMochila method, of class Esquemas.
     */
    @Test
    public void testLlenarMochila_5args() {
        System.out.println("llenarMochila 2");
        Map<String, Integer> mapaActual = Esquemas.llenarMochila(55, 50, cantidades, volumenes, pesos);

        Map<String, Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar("Coche", 1);
        mapaEsperado.insertar("Muñeca", 1);

        boolean result = mapasIguales(mapaActual, mapaEsperado);

        assertTrue(result);
    }

    /**
     * Test of llenarCD_Voraz method, of class Esquemas.
     */
    @Test
    public void testLlenarCD_Voraz() {
        System.out.println("llenarCD_Voraz");
        int capacidadMaxima = 21;
        Lista<String> expResult = new ListaEnlazada<>();
        expResult.insertarPrincipio("p1");
        expResult.insertarPrincipio("p3");
        expResult.insertarPrincipio("p2");
        expResult.insertarPrincipio("p4");
        Lista<String> result = Esquemas.llenarCDVoraz(capacidadMaxima, programas);

        boolean toRet = listasIguales(expResult, result);
        assertTrue(toRet);

    }
}
