/*
 */
package actividad10;

import java.util.Arrays;
import java.util.Iterator;
import lista.*;
import mapa.*;

/**
 *
 * @author kingo
 */
public class Actividad10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] v = new int[]{3, 5, 2, 10};
        int[] s = new int[v.length];
        System.out.println(subconjunto(v, s, 15, 0));
        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(s));
    }

    public static boolean llenarCDVueltaAtras(int capacidadCD, Map<String, Integer> programas, Lista<String> CD) {
        boolean objetivo = false;
        Iterator<String> itProgramas = programas.getClaves();
        while (itProgramas.hasNext() && !objetivo) {
            String program = itProgramas.next();
            int capacProgram = programas.get(program);

            if (capacidadCD >= capacProgram) {
                programas.eliminar(program);
                CD.insertarPrincipio(program);

                if (capacProgram == capacidadCD) {
                    objetivo = true;
                } else {
                    objetivo = llenarCDVueltaAtras(capacidadCD - capacProgram, programas, CD);
                    if (!objetivo) {
                        programas.insertar(program, capacProgram);
                        CD.suprimir(program);
                    }
                }
            }
        }
        return objetivo;
    }

    public static boolean subconjunto(int[] vector, int[] solucion, int resultado, int i) {
        boolean objetivo = false;

        while (i < vector.length && !objetivo) {
            if (resultado - vector[i] >= 0) {
                solucion[i] = 1;
                if (resultado - vector[i] == 0) {
                    objetivo = true;
                } else {
                    objetivo = subconjunto(vector, solucion, resultado - vector[i], i + 1);
                    if (!objetivo) {
                        for (int j = 0; j < vector.length; j++) {
                            solucion[j] = 0;
                        }
                    }
                }
            }

            i++;
        }

        return objetivo;
    }

}
