/*
 */
package estudiandografos;

/**
 *
 * @author kingo
 */
public interface Grafo<E, T> {

    public boolean esVacio();

    public boolean estaVertice(Vertice<E> v);

    public boolean estaArco(Arco<E, T> a);

    public Iterable<Vertice<E>> vertices();

    public Iterable<Arco<E, T>> arcos();

    public Iterable<Vertice<E>> adyacentes(Vertice<E> v);

    public void insertarVertice(Vertice<E> v);

    public void insertarArco(Arco<E, T> a);

    public void eliminarVertice(Vertice<E> v);

    public void eliminarArco(Arco<E, T> a);
}
