/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package estudiandovoraz;

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
public class EstudiandoVorazTest {

    private static Grafo<Integer, Integer> g1;

    private static Vertice<Integer> uno = new Vertice<Integer>(1);
    private static Vertice<Integer> dos = new Vertice<Integer>(2);
    private static Vertice<Integer> tres = new Vertice<Integer>(3);
    private static Vertice<Integer> cuatro = new Vertice<Integer>(4);
    private static Vertice<Integer> cinco = new Vertice<Integer>(5);
    private static Vertice<Integer> seis = new Vertice<Integer>(6);

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
        // Añado los arcos en el otro sentido, hace falta para el problema del viajante
        g1.insertarArco(new Arco<>(dos, uno, 3));
        g1.insertarArco(new Arco<>(seis, uno, 5));
        g1.insertarArco(new Arco<>(tres, dos, 7));
        g1.insertarArco(new Arco<>(seis, dos, 10));
        g1.insertarArco(new Arco<>(tres, seis, 8));
        g1.insertarArco(new Arco<>(cuatro, seis, 2));
        g1.insertarArco(new Arco<>(cuatro, tres, 5));
        g1.insertarArco(new Arco<>(cinco, tres, 1));
        g1.insertarArco(new Arco<>(cinco, cuatro, 6));
    }

    private <E, T> boolean grafosIguales(Grafo<E, T> g1, Grafo<E, T> g2) {
        Iterator<Arco<E, T>> arc = g1.arcos();

        while (arc.hasNext()) {
            Iterator<Arco<E, T>> arcExpected = g2.arcos();
            boolean continuar = true;
            Arco<E, T> a1 = arc.next();
            Vertice<E> w1 = a1.getDestino();
            Vertice<E> v1 = a1.getOrigen();

            while (arcExpected.hasNext() && continuar) {
                Arco<E, T> a2 = arcExpected.next();
                Vertice<E> w2 = a1.getDestino();
                Vertice<E> v2 = a1.getOrigen();

                if (a1.getEtiqueta().equals(a2.getEtiqueta()) && w1.equals(w2) && v1.equals(v2)) {
                    continuar = false;
                }
            }

            if (continuar) {
                return false;
            }
        }

        // Se comprueba en el otro sentido para garantizar que tienen exactamente los mismos arcos y no más
        arc = g2.arcos();

        while (arc.hasNext()) {
            Iterator<Arco<E, T>> arcActual = g1.arcos();
            boolean continuar = true;
            Arco<E, T> a1 = arc.next();
            Vertice<E> w1 = a1.getDestino();
            Vertice<E> v1 = a1.getOrigen();

            while (arcActual.hasNext() && continuar) {
                Arco<E, T> a2 = arcActual.next();
                Vertice<E> w2 = a1.getDestino();
                Vertice<E> v2 = a1.getOrigen();

                if (a1.getEtiqueta().equals(a2.getEtiqueta()) && w1.equals(w2) && v1.equals(v2)) {
                    continuar = false;
                }
            }

            if (continuar) {
                return false;
            }
        }

        return true;

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

    @Before
    public void setUp() throws Exception {
        rellenarGrafoG();
    }

    /**
     * Test of viajante method, of class Esquemas.
     */
    @Test
    public void testViajante() {
        System.out.println("viajante");
        Grafo<Integer, Integer> grafoActual = EstudiandoVoraz.viajante(g1, uno);
        Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<>();

        Vertice<Integer> v1 = new Vertice<Integer>(1);
        Vertice<Integer> v2 = new Vertice<Integer>(2);
        Vertice<Integer> v3 = new Vertice<Integer>(3);
        Vertice<Integer> v4 = new Vertice<Integer>(4);
        Vertice<Integer> v5 = new Vertice<Integer>(5);
        Vertice<Integer> v6 = new Vertice<Integer>(6);

        grafoEsperado.insertarArco(new Arco<>(v1, v2, 3));
        grafoEsperado.insertarArco(new Arco<>(v2, v3, 7));
        grafoEsperado.insertarArco(new Arco<>(v3, v5, 1));
        grafoEsperado.insertarArco(new Arco<>(v5, v4, 6));
        grafoEsperado.insertarArco(new Arco<>(v4, v6, 2));

        System.out.println("INPUT");
        imprimirGrafo(g1);
        System.out.println("GRAFO ACTUAL");
        imprimirGrafo(grafoActual);
        System.out.println("GRAFO ESPERADO");
        imprimirGrafo(grafoEsperado);

        boolean result = grafosIguales(grafoActual, grafoEsperado);
        assertTrue(result);
    }

    private static <E, T> void imprimirGrafo(Grafo<E, T> g) {
        Iterator<Arco<E, T>> it = g.arcos();
        while (it.hasNext()) {
            Arco a = it.next();
            System.out.format("%s - %s -> %s%n", a.getOrigen(), a.getEtiqueta(), a.getDestino());
        }
    }
//
//    /**
//     * Test of prim method, of class Esquemas.
//     */
//    @Test
//    public void testPrim() {
//        System.out.println("prim");
//        Grafo<Integer, Integer> grafoActual = EstudiandoVoraz.prim(g1, seis);
//        Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<>();
//
//        Vertice<Integer> v1 = new Vertice<Integer>(1);
//        Vertice<Integer> v2 = new Vertice<Integer>(2);
//        Vertice<Integer> v3 = new Vertice<Integer>(3);
//        Vertice<Integer> v4 = new Vertice<Integer>(4);
//        Vertice<Integer> v5 = new Vertice<Integer>(5);
//        Vertice<Integer> v6 = new Vertice<Integer>(6);
//
//        grafoEsperado.insertarArco(new Arco<>(v6, v4, 2));
//        grafoEsperado.insertarArco(new Arco<>(v6, v1, 5));
//        grafoEsperado.insertarArco(new Arco<>(v1, v2, 3));
//        grafoEsperado.insertarArco(new Arco<>(v4, v3, 5));
//        grafoEsperado.insertarArco(new Arco<>(v3, v5, 1));
//
//        boolean result = grafosIguales(grafoActual,grafoEsperado);
//        assertTrue(result);
//    }
//
//    @Test
//    public void testDijkstra() {
//        System.out.println("dijkstra");
//        Map<Vertice<Integer>, Integer> grafoActual = EstudiandoVoraz.dijkstra(g1, uno);
//	Map<Vertice<Integer>, Integer> expResult= new HashMap<>();
//        expResult.insertar(uno, 0);
//        expResult.insertar(dos, 3);
//        expResult.insertar(tres, 10);
//        expResult.insertar(cuatro, 7);
//        expResult.insertar(cinco, 11);
//        expResult.insertar(seis, 5);
//        boolean eq = mapasIguales(grafoActual, expResult);
//        assertTrue(eq);
//    }
}
