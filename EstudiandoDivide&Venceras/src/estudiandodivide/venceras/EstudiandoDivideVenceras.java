package estudiandodivide.venceras;

import java.util.Arrays;

public class EstudiandoDivideVenceras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int[] selecRapi = {4, 2, 8, 12, 6, 9, 23, 43, 78, 14};
//        int sol = SeleccionRapida(selecRapi, 5, 0, selecRapi.length - 1);
//        System.out.println("INPUT");
//        System.out.println(Arrays.toString(selecRapi));
//        System.out.println("OUTPUT");
//        System.out.println(sol);

//        hanoi(64, "A", "C", "B");
        int[] buscaPos = {9, 7, 5, 4, 3, 2, 1, 3, 4, 7};
        int resultado = buscarK(buscaPos, 0, buscaPos.length - 1);

        System.out.println(Arrays.toString(buscaPos));
        System.out.println(resultado);
    }

    public static int SeleccionRapida(int[] array, int k_menor, int i, int j) {
        if (array.length == 0) {
            return -1;
        }
        if (array.length == 1 || k_menor == 1) {
            return array[0];
        }

        int indPivote = buscaPivote(array, i, j);
        intercambiar(array, indPivote, j);

        int numElemsIzquierda = particion(array, i, j, array[indPivote]);
        if (k_menor <= numElemsIzquierda) {
            return SeleccionRapida(array, k_menor, i, numElemsIzquierda - 1);
        }
        if (k_menor == numElemsIzquierda + 1) {
            return array[indPivote];
        }
        return SeleccionRapida(array, k_menor, numElemsIzquierda, j);
    }

    private static int buscaPivote(int[] aux, int inicio, int fin) {
        int primer = aux[inicio];
        int k = inicio + 1;
        while (k <= fin) {
            if (aux[k] > primer) {
                return k;
            } else if (aux[k] < primer) {
                return inicio;
            } else {
                k++;
            }
        }
        return -1;
    }

    private static int particion(int[] aux, int inicio, int fin, int pivote) {
        int derecha = inicio;
        int izquierda = fin - 1;
        while (derecha <= izquierda) {
            while (aux[derecha] < pivote) {
                derecha++;
            }
            while (aux[izquierda] >= pivote) {
                izquierda--;
            }
            if (derecha < izquierda) {
                intercambiar(aux, derecha, izquierda);
            }
        }

        return derecha;
    }

    private static void intercambiar(int[] aux, int i, int j) {
        int temp = aux[i];
        aux[i] = aux[j];
        aux[j] = temp;
    }

    public static void hanoi(int n, String from, String to, String aux) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.format("Mover disco %d de %s a %s%n", n, from, to);
        hanoi(n - 1, aux, to, from);
    }

    public static int buscarK(int[] arr, int inicio, int fin) {
        if (inicio == fin) {
            return fin;
        }

        int medio = (inicio + fin) / 2;

        if (arr[medio - 1] < arr[medio] && arr[medio] < arr[medio + 1]) {
            return buscarK(arr, inicio, medio - 1);
        }
        if (arr[medio - 1] > arr[medio] && arr[medio] > arr[medio + 1]) {
            return buscarK(arr, medio + 1, fin);
        }
        if (arr[medio - 1] > arr[medio] && arr[medio + 1] > arr[medio]) {
            return medio;
        }
        return -1;
    }

}
