package heap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Heap<E extends Comparable<E>> {

    List<E> arr;

    public Heap() {
        arr = new ArrayList<>();
        arr.add(null);
    }

    public boolean esVacio() {
        return arr.size() == 1;
    }

    public E recuperarMax() throws HeapVacioException {
        if (esVacio()) {
            throw new HeapVacioException();
        }
        return arr.get(1);
    }

    public E suprimirMax() throws HeapVacioException {
        if (esVacio()) {
            throw new HeapVacioException();
        }
        E toret = arr.get(1);
        arr.set(1, arr.remove(arr.size() - 1));
        hundir(1);
        return toret;
    }

    public void hundir(int pos) {
        boolean continuar = true;
        while (pos * 2 + 1 < arr.size() && continuar) {
            int mayor = arr.get(pos * 2).compareTo(arr.get(pos * 2 + 1)) == 1 ? pos * 2 : pos * 2 + 1;
            if (arr.get(pos).compareTo(arr.get(mayor)) == -1) {
                intercambiar(pos, mayor);
                pos = mayor;
            } else {
                continuar = false;
            }
        }
    }

    public void intercambiar(int pos1, int pos2) {
        E tmp = arr.get(pos1);
        arr.set(pos1, arr.get(pos2));
        arr.set(pos2, tmp);
    }

    public void anular() {
        arr.clear();
        arr.add(null);
    }

    public void insertar(E i) throws IllegalArgumentException {
        if (i == null) {
            throw new IllegalArgumentException();
        }
        int pos = arr.size();
        arr.add(i);
        while (pos / 2 > 0 && arr.get(pos / 2).compareTo(arr.get(pos)) == -1) {
            intercambiar(pos / 2, pos);
            pos /= 2;
        }

    }

    public void introducir(E e) {
        arr.add(e);
    }

    public void arreglarHeap() {
//        int pos = arr.size() - 1;
//        while (pos / 2 > 0) {
//            hundir(pos / 2);
//            pos--;
//        }
        int pivPos = arr.size() - 1;
        while (pivPos / 2 > 0) {
            if (arr.get(pivPos).compareTo(arr.get(pivPos / 2)) == 1) {
                intercambiar(pivPos, pivPos / 2);
            }
            pivPos--;
        }
    }
}
