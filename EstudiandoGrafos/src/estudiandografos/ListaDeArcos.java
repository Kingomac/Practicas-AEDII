package estudiandografos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ListaDeArcos<E, T> implements Grafo<E, T> {

    private List<Vertice<E>> listVertices;
    private List<Arco<E, T>> listArcos;

    public ListaDeArcos() {
        listVertices = new LinkedList<>();
        listArcos = new LinkedList();
    }

    @Override
    public boolean esVacio() {
        return listVertices.isEmpty();
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        return listVertices.contains(v);
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        return listArcos.contains(a);
    }

    @Override
    public Iterable<Vertice<E>> vertices() {
        return listVertices;
    }

    @Override
    public Iterable<Arco<E, T>> arcos() {
        return listArcos;
    }

    @Override
    public Iterable<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> toret = new LinkedList<>();
        for (Arco<E, T> a : listArcos) {
            if (a.getOrigen().equals(v) && !toret.contains(a.getDestino())) {
                toret.add(a.getDestino());
            }
        }
        return toret;
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        listVertices.add(v);
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        listArcos.add(a);
        if (!estaVertice(a.getOrigen())) {
            insertarVertice(a.getOrigen());
        }
        if (!estaVertice(a.getDestino())) {
            insertarVertice(a.getDestino());
        }
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        if (listVertices.remove(v)) {
            for (Arco<E, T> a : listArcos) {
                if (a.getOrigen().equals(v) || a.getDestino().equals(v)) {
                    listArcos.remove(a);
                }
            }
        }
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
        listArcos.remove(a);
    }

}
