package estudiandografos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ListaAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConLista<E, T>> listVertices;
    private int numVertices;

    public ListaAdyacencia() {
        listVertices = new LinkedList<>();
        numVertices = 0;
    }

    @Override
    public boolean esVacio() {
        return numVertices == 0;
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        for (VerticeConLista<E, T> i : listVertices) {
            if (i.getVertice().equals(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        for (VerticeConLista<E, T> i : listVertices) {
            if (a.getOrigen().equals(i.getVertice())) {
                for (VerticeAdyacente<E, T> j : i.getAdyc()) {
                    if (j.getVerticeDestino().equals(a.getDestino()) && j.getEtiquetaArco().equals(a.getEtiqueta())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Iterable<Vertice<E>> vertices() {
        List<Vertice<E>> toret = new LinkedList<>();
        for (VerticeConLista<E, T> v : listVertices) {
            toret.add(v.getVertice());
        }
        return toret;
    }

    @Override
    public Iterable<Arco<E, T>> arcos() {
        List<Arco<E, T>> toret = new LinkedList<>();
        for (VerticeConLista<E, T> i : listVertices) {
            for (VerticeAdyacente j : i.getAdyc()) {
                toret.add(new Arco(i.getVertice(), j.getVerticeDestino(), j.getEtiquetaArco()));
            }
        }
        return toret;
    }

    @Override
    public Iterable<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> toret = new LinkedList<>();
        for (VerticeAdyacente<E, T> a : listVertices.get(indiceVertice(v)).getAdyc()) {
            toret.add(a.getVerticeDestino());
        }
        return toret;
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        listVertices.add(new VerticeConLista<>(v, new LinkedList<>()));
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        if (!estaVertice(a.getOrigen())) {
            insertarVertice(a.getOrigen());
        }
        if (!estaVertice(a.getDestino())) {
            insertarVertice(a.getDestino());
        }
        listVertices.get(indiceVertice(a.getOrigen())).getAdyc().add(new VerticeAdyacente<>(a.getDestino(), a.getEtiqueta()));
        /*for (VerticeConLista<E, T> v : listVertices) {
            if (v.getVertice().equals(a.getOrigen())) {
                v.getAdyc().add(new VerticeAdyacente<>(a.getDestino(), a.getEtiqueta()));
            }
        }*/
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        listVertices.remove(indiceVertice(v));
    }

    private int indiceVertice(Vertice<E> v) {
        int i = 0;
        while (i < listVertices.size() && !listVertices.get(i).getVertice().equals(v)) {
            i++;
        }
        return i;
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
        List<VerticeAdyacente<E, T>> lista = listVertices.get(indiceVertice(a.getOrigen())).getAdyc();
        int i = 0;
        while (i < lista.size() && !lista.get(i).getVerticeDestino().equals(a.getDestino()) && !lista.get(i).getEtiquetaArco().equals(a.getEtiqueta())) {
            i++;
        }
        if (i < lista.size()) {
            lista.remove(i);
        }
    }

}
