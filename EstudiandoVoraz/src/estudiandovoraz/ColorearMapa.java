/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiandovoraz;

import grafo.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mapa.HashMap;
import mapa.Map;

/**
 *
 * @author kingo
 */
public class ColorearMapa {

    private static final String[] colores = {"rojo", "azul", "verde", "amarillo"};
    private static Grafo<Integer, Integer> g1;

    private static final Vertice<Integer> uno = new Vertice<>(1);
    private static final Vertice<Integer> dos = new Vertice<>(2);
    private static final Vertice<Integer> tres = new Vertice<>(3);
    private static final Vertice<Integer> cuatro = new Vertice<>(4);
    private static final Vertice<Integer> cinco = new Vertice<>(5);
    private static final Vertice<Integer> seis = new Vertice<>(6);

    public static void main(String[] args) {

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

        Map<Vertice<Integer>, String> resultado = ColorearMapa.colorearMapa(g1, colores);
        Map<Vertice<Integer>, String> expResult = new HashMap<>();
        expResult.insertar(uno, "rojo");
        expResult.insertar(dos, "azul");
        expResult.insertar(tres, "rojo");
        expResult.insertar(cuatro, "amarillo");
        expResult.insertar(cinco, "azul");
        expResult.insertar(seis, "verde");

        System.out.println("Resultado");
        EstudiandoVoraz.imprimirMap(resultado);
        System.out.println("Expected");
        EstudiandoVoraz.imprimirMap(expResult);

        Map<Vertice<Integer>, String> resultado2 = ColorearMapa.colorearMapa(g1, colores);
        Map<Vertice<Integer>, String> expResult2 = new HashMap<>();
        expResult2.insertar(uno, "rojo");
        expResult2.insertar(dos, "azul");
        expResult2.insertar(tres, "amarillo");
        expResult2.insertar(cuatro, "rojo");
        expResult2.insertar(cinco, "azul");
        expResult2.insertar(seis, "verde");

        System.out.println("Resultado");
        EstudiandoVoraz.imprimirMap(resultado2);
        System.out.println("Expected");
        EstudiandoVoraz.imprimirMap(expResult2);
    }

    public static <E> Map<Vertice<E>, String> colorearMapa(Grafo<E, Integer> g, String[] colores) {

        Iterator<Vertice<E>> itVert = g.vertices();
        Map<Vertice<E>, String> solucion = new HashMap<>();

        while (itVert.hasNext()) {
            Vertice<E> vertice = itVert.next();
            Iterator<Vertice<E>> itAdyc = g.adyacentes(vertice);
            List<String> coloresAdyacentes = new ArrayList<>(colores.length / 2);
            while (itAdyc.hasNext()) {
                Vertice<E> adyacente = itAdyc.next();
                String colorAdyc = solucion.get(adyacente);
                if (colorAdyc != null) {
                    coloresAdyacentes.add(colorAdyc);
                }
            }
            int colorSeleccionado = 0;
            while (colorSeleccionado < colores.length && coloresAdyacentes.contains(colores[colorSeleccionado])) {
                colorSeleccionado++;
            }
            if (colorSeleccionado >= colores.length) {
                throw new RuntimeException("El teorema de los 4 colores no se cumple. F");
            }
            solucion.insertar(vertice, colores[colorSeleccionado]);
        }

        return solucion;
    }
}
