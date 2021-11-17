/*
 */
package actividad7;

import grafo.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Actividad7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g, Vertice<E> v) {
        List<Vertice<E>> toret = new LinkedList<>();
        Iterator<Arco<E, T>> itA = g.arcos();
        while (itA.hasNext()) {
            Arco<E, T> a = itA.next();
            if (a.getDestino().equals(v)) {
                toret.add(a.getOrigen());
            }
        }
        return toret.iterator();
    }

    public static <E, T> boolean esSumidero(Grafo<E, T> g, Vertice<E> v) {
        Iterator<Vertice<E>> itV = g.adyacentes(v);
        if (itV.hasNext()) {
            return false;
        }
        return numeroDe(g.vertices()) - 1 == numeroDe(predecesores(g, v));
    }

    public static <E, T> boolean esRegular(Grafo<E, T> g) {
        if (g.esVacio()) {
            return true;
        }
        Iterator<Vertice<E>> itV = g.vertices();
        Vertice<E> v = itV.next();
        int num = numeroDe(g.adyacentes(v));
        while (itV.hasNext()) {
            v = itV.next();
            int cont = numeroDe(g.adyacentes(v));
            if (cont != num) {
                return false;
            }
        }
        return true;
    }

    public static <E> int numeroDe(Iterator<E> i) {
        int cont = 0;
        while (i.hasNext()) {
            i.next();
            cont++;
        }
        return cont;
    }

    public static <E, T> boolean hayCamino(Grafo<E, T> g, Vertice<E> origen, Vertice<E> destino) {
        return hayCamino(g, origen, destino, new LinkedList<>());
    }

    public static <E, T> boolean hayCamino(Grafo<E, T> g, Vertice<E> origen, Vertice<E> destino, List<Vertice<E>> visitados) {
        if (origen.equals(destino)) {
            return true;
        }

        visitados.add(origen);
        Iterator<Vertice<E>> itV = g.adyacentes(origen);
        while (itV.hasNext()) {
            Vertice<E> v = itV.next();
            if (!visitados.contains(v) && hayCamino(g, v, destino, visitados)) {
                return true;
            }
        }
        return false;
    }
}
