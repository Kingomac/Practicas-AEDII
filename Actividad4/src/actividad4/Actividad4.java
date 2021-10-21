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
        /*Heap heapPrueba = new Heap();
        heapPrueba.introducir(18);
        heapPrueba.introducir(19);
        heapPrueba.introducir(20);
        heapPrueba.arreglarHeap();
        try {
            //heapPrueba.suprimirMax();
            System.out.println(heapPrueba.recuperarMax());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
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

    public static <E extends Comparable<E>> void heapSort(int[] arr) {
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < arr.length; i++) {
            heap.insertar(arr[i]);
        }
        heap.arreglarHeap();
        for (int i = 0; i < arr.length; i++) {
            try {
                arr[i] = heap.suprimirMax();
            } catch (HeapVacioExcepcion ex) {
                break;
            }
        }
    }

}
