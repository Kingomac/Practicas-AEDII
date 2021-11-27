/*
 */
package estudiandografos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author kingo
 */
public class EstudiandoGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        Vertice<Integer> v5 = new Vertice<>(5);
        Vertice<Integer> v6 = new Vertice<>(6);
        Vertice<Integer> v7 = new Vertice<>(7);
        ListaAdyacencia<Integer, Integer> g = new ListaAdyacencia();
        g.insertarArco(new Arco(v1, v2, 0));
        g.insertarArco(new Arco(v3, v1, 0));
        g.insertarArco(new Arco(v1, v4, 0));
        g.insertarArco(new Arco(v2, v4, 0));
        g.insertarArco(new Arco(v4, v3, 0));
        g.insertarArco(new Arco(v2, v3, 0));
        g.insertarArco(new Arco(v2, v6, 0));
        g.insertarArco(new Arco(v6, v5, 0));
        g.insertarArco(new Arco(v5, v7, 0));
        g.insertarArco(new Arco(v7, v6, 0));
        //g.insertarVertice(v7);
        //System.out.println(g.estaVertice(v7));
        recorridoAnchura(g, v1);
        for (Arco a : g.arcos()) {
            System.out.println(a);
        }
        System.out.println(g.indiceVertice(v2));
    }

    public static <E, T> void recorridoAnchura(Grafo<E, T> g, Vertice<E> v) {
        Queue<Vertice<E>> porVisitar = new LinkedList<>();
        List<Vertice<E>> visitados = new LinkedList<>();
        porVisitar.add(v);
        do {
            Vertice<E> actual = porVisitar.remove();
            if (!visitados.contains(actual)) {
                Iterator<Vertice<E>> it = g.adyacentes(actual).iterator();
                System.out.print(actual.getEtiqueta() + ", ");
                visitados.add(actual);
                while (it.hasNext()) {
                    Vertice<E> i = it.next();
                    porVisitar.add(i);
                }
            }
        } while (!porVisitar.isEmpty());
    }

    public static <E, T> void recorridoProfundidad(Grafo<E, T> g, Vertice<E> v) {
        recorridoProfundidad(g, v, new LinkedList<>());
    }

    public static <E, T> void recorridoProfundidad(Grafo<E, T> g, Vertice<E> v, List<Vertice<E>> visitados) {
        Iterator<Vertice<E>> itAd = g.adyacentes(v).iterator();
        System.out.print(v.getEtiqueta() + ", ");
        visitados.add(v);
        while (itAd.hasNext()) {
            Vertice<E> i = itAd.next();
            if (!visitados.contains(i)) {
                recorridoProfundidad(g, i, visitados);
            }
        }
    }

    public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g, Vertice<E> v) {
        List<Vertice<E>> toret = new LinkedList<>();
        Iterator<Arco<E, T>> it = g.arcos().iterator();
        while (it.hasNext()) {
            Arco<E, T> a = it.next();
            if (a.getDestino().equals(v)) {
                toret.add(a.getOrigen());
            }
        }
        return toret.iterator();
    }

    public static <E, T> boolean sumidero(Grafo<E, T> g, Vertice<E> v) {
        Iterator<Arco<E, T>> it = g.arcos().iterator();
        int contArcos = 0;
        while (it.hasNext()) {
            Arco<E, T> a = it.next();
            if (a.getOrigen().equals(v)) {
                return false;
            }
            if (a.getDestino().equals(v)) {
                contArcos++;
            }
        }
        Iterator<Vertice<E>> itV = g.vertices().iterator();
        int numV = 0;
        while (itV.hasNext()) {
            itV.next();
            numV++;
        }

        return contArcos == numV - 1;
    }

    public static <E, T> boolean regular(Grafo<E, T> g) {
        int numAdy = -1;
        Iterator<Vertice<E>> it = g.vertices().iterator();
        while (it.hasNext()) {
            Vertice<E> v = it.next();
            Iterator<Arco<E, T>> itA = g.arcos().iterator();
            int n = 0;
            while (itA.hasNext()) {
                Arco<E, T> a = itA.next();
                if (a.getOrigen().equals(v) && !a.getOrigen().equals(a.getDestino())) {
                    n++;
                }
            }
            if (numAdy == -1) {
                numAdy = n;
            }
            if (n != numAdy) {
                return false;
            }
        }
        return true;
    }

    public static <E, T> boolean hayCaminoEntreDos(Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2) {
        Iterator<Arco<E, T>> it = g.arcos().iterator();
        while (it.hasNext()) {
            Arco<E, T> a = it.next();
            if ((a.getOrigen().equals(v1) && a.getDestino().equals(v2)) || (a.getOrigen().equals(v2) && a.getDestino().equals(v1))) {
                return true;
            }
        }
        return false;
    }

    public static <E, T> boolean esCiclo(Grafo<E, T> g, List<Vertice<E>> vertices) {
        // Comprobar que son distintos entre
        for (int i = 1; i < vertices.size() - 1; i++) {
            for (int j = 1; j < vertices.size() - 1; j++) {
                if (i != j && vertices.get(i).equals(vertices.get(j))) {
                    return false;
                }
            }
        }
        //
        if (!vertices.get(0).equals(vertices.get(vertices.size() - 1))) {
            return false;
        }
        for (int i = 0; i < vertices.size() - 1; i++) {
            Iterator<Arco<E, T>> it = g.arcos().iterator();
            boolean seguir = false;
            while (it.hasNext() && !seguir) {
                Arco<E, T> a = it.next();
                if (a.getOrigen().equals(vertices.get(i)) && a.getDestino().equals(vertices.get(i + 1))) {
                    seguir = true;
                }
            }
            if (!seguir) {
                return false;
            }
        }
        return true;
    }

    public static <E, T> Vertice<E> esArborescencia2(Grafo<E, T> g) {
        Map<Vertice<E>, Integer> mapa = new HashMap<>();
        Iterator<Arco<E, T>> itA = g.arcos().iterator();
        while (itA.hasNext()) {
            Arco<E, T> a = itA.next();
            if (mapa.get(a.getOrigen()) == null) {
                mapa.put(a.getOrigen(), 0);
            }
            mapa.put(a.getOrigen(), mapa.get(a.getOrigen()) + 1);
        }

        Iterator<Vertice<E>> itV = g.vertices().iterator();
        int n = 0;
        while (itV.hasNext()) {
            itV.next();
            n++;
        }

        for (var p : mapa.entrySet()) {
            if (p.getValue().equals(n - 1)) {
                return p.getKey();
            }
        }
        return null;
    }

    public static <E, T> Vertice<E> esArborescencia(Grafo<E, T> g) {
        Iterator<Vertice<E>> itV = g.vertices().iterator();
        int num = contarIt(g.vertices().iterator()) - 1;
        while (itV.hasNext()) {
            Vertice<E> v = itV.next();
            if (contarIt(g.adyacentes(v).iterator()) == num) {
                return v;
            }
        }
        return null;
    }

    public static <E> int contarIt(Iterator<E> it) {
        int cont = 0;
        while (it.hasNext()) {
            it.next();
            cont++;
        }
        return cont;
    }

    public static <E, T> List<Vertice<E>> aislados(Grafo<E, T> g) {
        List<Vertice<E>> toret = new LinkedList<>();
        List<Vertice<E>> conArcos = new LinkedList<>();
        Iterator<Arco<E, T>> itA = g.arcos().iterator();
        while (itA.hasNext()) {
            Arco<E, T> a = itA.next();
            if (!conArcos.contains(a.getOrigen())) {
                conArcos.add(a.getOrigen());
            }
            if (!conArcos.contains(a.getDestino())) {
                conArcos.add(a.getDestino());
            }
        }
        Iterator<Vertice<E>> itV = g.vertices().iterator();
        while (itV.hasNext()) {
            Vertice<E> v = itV.next();
            if (!conArcos.contains(v)) {
                toret.add(v);
            }
        }
        return toret;
    }

    public static <E, T> List<Vertice<E>> aislados2(Grafo<E, T> g) {
        List<Vertice<E>> toret = new LinkedList<>();
        Iterator<Vertice<E>> itV = g.vertices().iterator();
        while (itV.hasNext()) {
            Vertice<E> v = itV.next();
            Iterator<Vertice<E>> itAd = g.adyacentes(v).iterator();
            if (!itAd.hasNext()) {
                toret.add(v);
            }
        }
        return toret;
    }

}
