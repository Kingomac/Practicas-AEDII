/*
 */
package actv9;

import grafo.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mapa.*;

/**
 *
 * @author kingo
 */
public class Actv9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static <E> Map<Vertice<E>, String> colorearMapa(Grafo<E, Integer> g, String[] colores) {
        Map<Vertice<E>, String> mapaColores = new HashMap<>(); // Crear mapa a devolver
        Iterator<Vertice<E>> it = g.vertices();
        while (it.hasNext()) { // Iterar sobre los vértices que serían los paises
            Vertice<E> v = it.next();
            Iterator<Vertice<E>> itAdyc = g.adyacentes(v); // Comprobar colores de paises adyacentes
            List<String> coloresUtilizados = new ArrayList<>();
            while (itAdyc.hasNext()) {
                Vertice<E> vAdyc = itAdyc.next();
                String color = mapaColores.get(vAdyc);
                if (color != null) {
                    coloresUtilizados.add(color);
                }
            }
            int i = 0;
            while (i < colores.length && coloresUtilizados.contains(colores[i])) { // Obtener índice del primer color disponible
                i++;
            }
            mapaColores.insertar(v, colores[i]);
        }
        return mapaColores;
    }

    public static <E> Map<Vertice<E>, String> colorearMapaProfe(Grafo<E, Integer> g, String[] colores) {
        Map<Vertice<E>, String> mapaColores = new HashMap<>();
        Iterator<Vertice<E>> itv = g.vertices();
        while (itv.hasNext()) {
            Vertice<E> vActual = itv.next();
            String colorAdecuado = selecionarColor(mapaColores, vActual, g, colores);
            mapaColores.insertar(vActual, colorAdecuado);
        }
        return mapaColores;
    }

    private static <E> String selecionarColor(Map<Vertice<E>, String> mapaColores, Vertice<E> v, Grafo<E, Integer> g, String[] colores) {
        int i = 0;
        String color = "";
        boolean colorAsignado = false;
        while (i < colores.length && !colorAsignado) {
            color = colores[i];
            colorAsignado = true;
            Iterator<Vertice<E>> itAdyc = g.adyacentes(v);

            while (itAdyc.hasNext()) {
                Vertice<E> vAdyc = itAdyc.next();
                if (mapaColores.get(vAdyc) != null && mapaColores.get(vAdyc).equals(color)) {
                    i++;
                    colorAsignado = false;
                }
            }
        }
        return color;
    }

}
