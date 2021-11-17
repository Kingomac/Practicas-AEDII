package actv6ej2;

import grafo.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mapa.*;

/**
 *
 * @author Mario
 */
public abstract class MapaAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConMap<E, T>> listVertices;

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        for (VerticeConMap vm : listVertices) {
            if (vm.getVertice().equals(v)) {
                return vm.getAdy().getClaves();
            }
        }
        List<Vertice<E>> toret = new LinkedList<>();
        return toret.iterator();
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        for (VerticeConMap vm : listVertices) {
            if (a.getOrigen().equals(vm.getVertice()) && vm.getAdy().get(a.getDestino()) != null && vm.getAdy().get(a.getDestino()).equals(a.getEtiqueta())) {
                return true;
            }
        }

        return false;
    }

    public class VerticeConMap<E, T> {

        private Vertice<E> origen;    // vértice del grafo
        private Map<Vertice<E>, T> mapAdy;  // mapa de adyacentes del vértice origen

        VerticeConMap(Vertice<E> v) {
            origen = v;
            mapAdy = new HashMap<>();
        }

        Vertice<E> getVertice() {
            return origen;
        }

        Map<Vertice<E>, T> getAdy() {
            return mapAdy;
        }
    }
}
