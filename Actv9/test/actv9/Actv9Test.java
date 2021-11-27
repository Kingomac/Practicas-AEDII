/*
 */
package actv9;

import grafo.*;
import java.util.Iterator;
import mapa.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kingo
 */
public class Actv9Test {

    private static final String[] colores = {"rojo", "azul", "verde", "amarillo"};
    private static Grafo<Integer, Integer> g1;

    private static final Vertice<Integer> uno = new Vertice<>(1);
    private static final Vertice<Integer> dos = new Vertice<>(2);
    private static final Vertice<Integer> tres = new Vertice<>(3);
    private static final Vertice<Integer> cuatro = new Vertice<>(4);
    private static final Vertice<Integer> cinco = new Vertice<>(5);
    private static final Vertice<Integer> seis = new Vertice<>(6);

    private static void rellenarGrafoG() {
        g1 = new ListaAdyacencia<>();
        g1.insertarArco(new Arco<>(uno, dos, 3));
        g1.insertarArco(new Arco<>(uno, seis, 5));
        g1.insertarArco(new Arco<>(dos, tres, 7));
        g1.insertarArco(new Arco<>(dos, seis, 10));
        g1.insertarArco(new Arco<>(seis, tres, 8));
        g1.insertarArco(new Arco<>(seis, cuatro, 2));
        g1.insertarArco(new Arco<>(tres, cuatro, 5));
        g1.insertarArco(new Arco<>(tres, cinco, 1));
        g1.insertarArco(new Arco<>(cuatro, cinco, 6));
        g1.insertarArco(new Arco<>(dos, cuatro, 6));

        g1.insertarArco(new Arco<>(dos, uno, 3));
        g1.insertarArco(new Arco<>(seis, uno, 5));
        g1.insertarArco(new Arco<>(tres, dos, 7));
        g1.insertarArco(new Arco<>(seis, dos, 10));
        g1.insertarArco(new Arco<>(tres, seis, 8));
        g1.insertarArco(new Arco<>(cuatro, seis, 2));
        g1.insertarArco(new Arco<>(cuatro, tres, 5));
        g1.insertarArco(new Arco<>(cinco, tres, 1));
        g1.insertarArco(new Arco<>(cinco, cuatro, 6));
        g1.insertarArco(new Arco<>(cuatro, dos, 6));
    }

    private static <E, T> boolean mapasIguales(Map<Vertice<E>, T> m1, Map<Vertice<E>, T> m2) {
        if (m1.tamaño() == m2.tamaño()) {
            Iterator<Vertice<E>> itr = m1.getClaves();
            while (itr.hasNext()) {
                Vertice<E> clave = itr.next();
                if (m1.get(clave) == null || !m1.get(clave).equals(m2.get(clave))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Before
    public void setUp() throws Exception {
        rellenarGrafoG();
    }

    @Test
    public void colorearMapaTest() {
        System.out.println("colorearMapaTrue");
        Map<Vertice<Integer>, String> grafoActual = Actv9.colorearMapa(g1, colores);
        Map<Vertice<Integer>, String> expResult = new HashMap<>();
        expResult.insertar(uno, "rojo");
        expResult.insertar(dos, "azul");
        expResult.insertar(tres, "rojo");
        expResult.insertar(cuatro, "amarillo");
        expResult.insertar(cinco, "azul");
        expResult.insertar(seis, "verde");
        boolean eq = mapasIguales(grafoActual, expResult);
        assertTrue(eq);
    }

    @Test
    public void colorearMapaTestFalse() {
        System.out.println("colorearMapaFalse");
        Map<Vertice<Integer>, String> grafoActual = Actv9.colorearMapa(g1, colores);
        Map<Vertice<Integer>, String> expResult = new HashMap<>();
        expResult.insertar(uno, "rojo");
        expResult.insertar(dos, "azul");
        expResult.insertar(tres, "amarillo");
        expResult.insertar(cuatro, "rojo");
        expResult.insertar(cinco, "azul");
        expResult.insertar(seis, "verde");
        boolean eq = mapasIguales(grafoActual, expResult);
        assertFalse(eq);
    }
}
