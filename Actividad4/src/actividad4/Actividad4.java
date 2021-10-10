package actividad4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Actividad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(54, Integer.MIN_VALUE, 1, 33, 12, 6, 90, -2, 0, 0, Integer.MAX_VALUE));
        System.out.println("Sin ordenar: " + lista);
        heapSort(lista);
        System.out.println("Ordenado: " + lista);
    }

    public static <E extends Comparable<E>> void heapSort(List<E> arr) {
        Heap<E> heap = new Heap();
        while (!arr.isEmpty()) {
            heap.introducir(arr.remove(0));
        }
        heap.arreglarHeap();
        while (!heap.esVacio()) {
            try {
                arr.add(heap.suprimirMax());
            } catch (HeapVacioExcepcion ex) {
                System.err.println("ERROR: " + ex.getMessage());
                break;
            }
        }
    }

}
