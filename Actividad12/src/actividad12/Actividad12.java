package actividad12;

public class Actividad12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static int seleccionRapida(int[] array, int k_menor, int i, int j) {
        int indicePivote = buscaPivote(array, i, j);
        int pivote = array[indicePivote];
        intercambiar(array, indicePivote, j);
        int numElemsIzq = particion(array, i, j, pivote);

        if (k_menor <= numElemsIzq) {
            return seleccionRapida(array, k_menor, i, numElemsIzq - 1);
        }
        if (k_menor == numElemsIzq) {
            return pivote;
        }
        return seleccionRapida(array, k_menor, numElemsIzq, j);
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

    public static int buscarPosK(int[] v, int inicio, int fin) {
        int posMedio = (inicio + fin) / 2;
        int posMedioMas = posMedio + 1;

        if (posMedioMas > fin) { // el problema no se puede reducir más
            return posMedio;
        }
        if (posMedio > posMedioMas) {
            return buscarPosK(v, posMedioMas + 1, fin);
        }
        if (posMedio < posMedioMas) {
            return buscarPosK(v, inicio, posMedio - 1);
        }
        return -1;
    }

    public static int buscarPosK2(int[] v, int inicio, int fin) {
        int medio = (inicio + fin) / 2;
        if (medio == 0 || medio == v.length - 1) {
            return -1;
        }
        if (v[medio - 1] > v[medio] && v[medio + 1] < v[medio]) {
            return buscarPosK2(v, medio + 1, fin);
        }
        if (v[medio - 1] < v[medio] && v[medio + 1] > v[medio]) {
            return buscarPosK2(v, inicio, medio);
        }
        return medio;
    }

}
