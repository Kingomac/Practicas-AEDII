package actividad4;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Heap<E extends Comparable<E>> {

    private ArrayList<E> arr;

    public Heap() {
        arr = new ArrayList<>();
        arr.add(null);
    }

    public boolean esVacio() {
        return arr.size() == 1;
    }

    public E recuperarMax() throws HeapVacioExcepcion {
        if (esVacio()) {
            throw new HeapVacioExcepcion("ERROR: HEAP is empty");
        }
        return arr.get(1);
    }

    public E suprimirMax2() throws HeapVacioExcepcion {
        if (esVacio()) {
            throw new HeapVacioExcepcion("ERROR: HEAP is empty");
        }
        int pivPos = 1;
        E el = arr.get(pivPos);
        while (pivPos + 2 < arr.size()) {
            if (arr.get(pivPos + 1).compareTo(arr.get(pivPos + 2)) == 1) {
                arr.set(pivPos, arr.get(pivPos + 1));
                pivPos = pivPos + 1;
            } else {
                arr.set(pivPos, arr.get(pivPos + 2));
                pivPos = pivPos + 2;
            }
        }
        arr.remove(pivPos);
        return el;
    }

    public E suprimirMax() throws HeapVacioExcepcion {
        if (esVacio()) {
            throw new HeapVacioExcepcion();
        }
        int posPiv = 1;
        E el = arr.get(posPiv);

        while (2 * posPiv + 1 < arr.size()) {
            int hijoMayor = arr.get(2 * posPiv).compareTo(arr.get(2 * posPiv + 1)) == 1 ? 2 * posPiv : 2 * posPiv + 1;
            int posibleCambio = arr.get(hijoMayor).compareTo(arr.get(arr.size() - 1)) == 1 ? hijoMayor : arr.size() - 1;
            if (arr.get(posPiv).compareTo(arr.get(posibleCambio)) == -1) {
                intercambiar(posPiv, posibleCambio);
            }
            posPiv++;
        }
        arr.remove(posPiv);
        return el;
    }

    public E suprimirMaxProfe() throws HeapVacioExcepcion {
        if (esVacio()) {
            throw new HeapVacioExcepcion();
        }
        E e = arr.get(1);
        arr.set(1, arr.remove(arr.size() - 1));
        hundir(1);
        return e;
    }

    public void hundir(int pos) {

    }

    public void insertar(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("ERROR: Element is null");
        }
        arr.add(e);
        int ePos = arr.size() - 1;
        while (ePos / 2 > 0 && e.compareTo(arr.get(ePos / 2)) == 1) {
            intercambiar(ePos, ePos / 2);
            ePos /= 2;
        }
    }

    private void intercambiar(int pos1, int pos2) {
        E temp = arr.get(pos1);
        arr.set(pos1, arr.get(pos2));
        arr.set(pos2, temp);
    }

    public void anular() {
        arr.clear();
        arr.add(null);
    }

    public void introducir(E e) {
        arr.add(e);
    }

    public void arreglarHeap() {
        int pivPos = arr.size() - 1;
        while (pivPos / 2 > 0) {
            if (arr.get(pivPos).compareTo(arr.get(pivPos / 2)) == 1) {
                intercambiar(pivPos, pivPos / 2);
            }
            pivPos--;
        }

    }
}
