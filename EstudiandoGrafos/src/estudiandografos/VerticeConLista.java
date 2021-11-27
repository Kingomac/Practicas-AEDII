package estudiandografos;

import java.util.List;

/**
 *
 * @author Mario
 */
public class VerticeConLista<E, T> {

    private Vertice<E> verticeOrigen;
    private List<VerticeAdyacente<E, T>> listAdyc;

    public VerticeConLista(Vertice<E> verticeOrigen, List<VerticeAdyacente<E, T>> listAdyc) {
        this.verticeOrigen = verticeOrigen;
        this.listAdyc = listAdyc;
    }

    public Vertice<E> getVertice() {
        return verticeOrigen;
    }

    public List<VerticeAdyacente<E, T>> getAdyc() {
        return listAdyc;
    }

}
