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

    /*public E suprimirMax() throws HeapVacioExcepcion {
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
    }*/
    public E suprimirMax() throws HeapVacioExcepcion {
        if (esVacio()) {
            throw new HeapVacioExcepcion("ERROR: HEAP is empty");
        }
        E e = arr.get(1);
        E ultimo = arr.remove(arr.size() - 1);
        if (arr.size() > 1) {
            arr.set(1, ultimo);
            hundir(1);
        }
        return e;
    }

    /**
     * Se ejecuta al suprimir para reordenar el heap dándole la posición 1, pero
     * se podría hacer para cualquiera 😎 Va hacia abajo comparando los hijos y
     * compara los 3 valores
     *
     * @param pos
     */
    public void hundir2(int pos) {
        boolean tieneHijoIzq = 2 * pos < arr.size() && arr.get(2 * pos) != null;
        boolean tieneHijoDer = 2 * pos + 1 < arr.size() && arr.get(2 * pos + 1) != null;
        while ((tieneHijoIzq || tieneHijoDer)) {
            int posHijoMayor;
            if (tieneHijoIzq && tieneHijoDer) {
                posHijoMayor = arr.get(2 * pos).compareTo(arr.get(2 * pos + 1)) == 1 ? 2 * pos : 2 * pos + 1;
            } else if (tieneHijoIzq) {
                posHijoMayor = 2 * pos;
            } else {
                posHijoMayor = 2 * pos + 1;
            }
            if (posHijoMayor < arr.size()) {
                if (arr.get(pos).compareTo(arr.get(posHijoMayor)) == -1) {
                    intercambiar(pos, posHijoMayor);
                    pos = posHijoMayor;
                } else {
                    break;
                }
            } else {
                break;
            }
            tieneHijoIzq = 2 * pos < arr.size() && arr.get(2 * pos) != null;
            tieneHijoDer = 2 * pos + 1 < arr.size() && arr.get(2 * pos + 1) != null;
        }
    }

    /**
     * Versión de la profe
     *
     * @param posPadre
     */
    public void hundir(int posPadre) {
        int posHijo = posPadre * 2;
        boolean continuar = true;
        while (continuar && posHijo < arr.size()) {
            if (posHijo < arr.size() - 1 && arr.get(posHijo).compareTo(arr.get(posHijo + 1)) == -1) {
                posHijo++;
            }
            if (arr.get(posPadre).compareTo(arr.get(posHijo)) == -1) {
                intercambiar(posPadre, posHijo);
                posHijo = posPadre * 2;
            } else {
                continuar = false;
            }
        }
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

    /**
     * Arregla el heap haciendo un recorrido por niveles empezando por abajo
     */
    /*public void arreglarHeap() {
        int pivPos = arr.size() - 1;
        while (pivPos / 2 > 0) {
            if (arr.get(pivPos).compareTo(arr.get(pivPos / 2)) == 1) {
                intercambiar(pivPos, pivPos / 2);
            }
            pivPos--;
        }

    }*/
    public void arreglarHeap() {
        /*if (esVacio()) {
            throw new HeapVacioExcepcion("ERROR: HEAP vacío");
        }*/
        int posPiv = (arr.size() - 1) / 2;
        while (posPiv / 2 > 0) {
            hundir(posPiv);
            posPiv /= 2;
        }

        for (int padre = (arr.size() - 1) / 2; padre > 0; padre--) {
            hundir(padre);
        }

        /*int posPiv = 1;
        while (posPiv < arr.size()) {
            hundir(posPiv);
            posPiv++;
        }*/
    }
}
