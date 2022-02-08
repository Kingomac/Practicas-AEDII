package estudiandovueltaatras;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EstudiandoVueltaAtras {

    private static Map<Integer, Integer> can;

    private static final char[][] LAB2 = {{'A', 'O', 'O', 'X', 'X'},
    {'D', 'D', 'X', 'O', 'X'},
    {'E', 'A', 'D', 'E', 'X'},
    {'O', 'D', 'O', 'A', 'D'},
    {'O', 'O', 'O', 'A', 'E'}};

    public static void main(String[] args) {
//        can = new HashMap<>();
//        can.put(200, 10);
//        can.put(500, 10);
//
//        System.out.println("Cantidades");
//        imprimirMap(can);
//
//        Map<Integer, Integer> mapaActual = new HashMap<>();
//
//        darCambio(2100, can, mapaActual);
//
//        Map<Integer, Integer> mapaEsperado = new HashMap<>();
//        mapaEsperado.put(200, 3);
//        mapaEsperado.put(500, 3);
//
//        System.out.println("OUTPUT");
//        imprimirMap(mapaActual);
//
//        System.out.println("EXPECTED");
//        imprimirMap(mapaEsperado);

//        String cadena = "ADE";
//        ensayarPalabras(LAB2, 0, 0, cadena, 0);
//
//        char[][] solEsperada = {{' ', 'O', 'O', 'X', 'X'},
//        {' ', 'D', 'X', 'O', 'X'},
//        {' ', ' ', ' ', ' ', 'X'},
//        {'O', 'D', 'O', ' ', ' '},
//        {'O', 'O', 'O', 'A', ' '}};
//        System.out.println("Resultado");
//        for (char[] arr : LAB2) {
//            System.out.println(Arrays.toString(arr));
//        }
//
//        System.out.println("Expected");
//        for (char[] arr : solEsperada) {
//            System.out.println(Arrays.toString(arr));
//        }
//        Map<String, Integer> programas = new HashMap<>();
//        programas.put("p1", 10);
//        programas.put("p2", 3);
//        programas.put("p3", 5);
//        programas.put("p4", 3);
//        programas.put("p5", 3);
//
//        int capacidadCD = 21;
//        List<String> S = new LinkedList<>();
//        List<String> expResult = new LinkedList<>();
//        expResult.add("p4");
//        expResult.add("p3");
//        expResult.add("p2");
//        expResult.add("p1");
//        llenarCDVueltaAtras(capacidadCD, programas, S);
//
//        System.out.println("Resultado");
//        System.out.println(S);
//
//        System.out.println("Expected");
//        System.out.println(expResult);
//        char[][] lab = {{' ', ' ', ' ', 'X'},
//        {' ', ' ', 'X', ' '},
//        {' ', ' ', ' ', ' '},
//        {' ', 'X', ' ', ' '}};
//
//        ensayar(lab, 0, 0);
//
//        char[][] solEsperada = {{'C', ' ', ' ', 'X'},
//        {'C', ' ', 'X', ' '},
//        {'C', 'C', 'C', ' '},
//        {'I', 'X', 'C', 'C'}};
//
//        System.out.println("OUTPUT");
//        for (char[] arr : lab) {
//            System.out.println(Arrays.toString(arr));
//        }
//
//        System.out.println("Solución esperada");
//        for (char[] arr : solEsperada) {
//            System.out.println(Arrays.toString(arr));
//        }
//        char[][] LAB
//                = {{' ', 'T', ' ', 'X'},
//                {' ', ' ', ' ', ' '},
//                {' ', 'T', 'X', ' '},
//                {' ', 'X', ' ', ' '}};
//
//        ensayar(LAB, 0, 0);
//
//        char[][] solEsperada = {{'C', 'C', ' ', 'X'},
//        {'C', 'C', 'C', 'C'},
//        {'C', 'C', 'X', 'C'},
//        {'I', 'X', ' ', 'C'}};
//
//        System.out.println("OUTPUT");
//        for (char[] arr : LAB) {
//            System.out.println(Arrays.toString(arr));
//        }
//
//        System.out.println("Solución esperada");
//        for (char[] arr : solEsperada) {
//            System.out.println(Arrays.toString(arr));
//        }
//
//        int[] tablero = new int[8];
//        colocarReinas(0, tablero);
//        int[] solEsperada = {0, 4, 7, 5, 2, 6, 1, 3};
//        System.out.println("Solución");
//        System.out.println(Arrays.toString(tablero));
//        System.out.println("Solución esperada");
//        System.out.println(Arrays.toString(solEsperada));
        final int[] VALORES = {8, 3, 5, 9};
        int[] solucion = new int[VALORES.length];
        int[] expResult = {0, 1, 0, 1};
        subconjunto(VALORES, solucion, 12, 0);

        System.out.println("Solucion");
        System.out.println(Arrays.toString(solucion));
        System.out.println("Expected");
        System.out.println(Arrays.toString(expResult));

    }

    private static <E, T> void imprimirMap(Map<E, T> m) {
        Iterator<E> it = m.keySet().iterator();
        while (it.hasNext()) {
            E clave = it.next();
            System.out.format("%s -> %s%n", clave, m.get(clave));
        }
    }

    public static boolean darCambio(int importeDevolver, Map<Integer, Integer> mapCanti, Map<Integer, Integer> mapSol) {
        boolean objetivo = false;
        Iterator<Integer> it = mapCanti.keySet().iterator();
        while (it.hasNext() && !objetivo) {
            int billete = it.next();

            if (mapCanti.get(billete) > 0 && importeDevolver >= billete) {
                Integer ant = mapSol.get(billete);
                if (ant == null) {
                    ant = 0;
                }
                mapSol.put(billete, ant + 1);

                mapCanti.put(billete, mapCanti.get(billete) - 1);

                if (importeDevolver == billete) {
                    objetivo = true;
                } else {
                    objetivo = darCambio(importeDevolver - billete, mapCanti, mapSol);
                    if (!objetivo) {
                        mapSol.put(billete, mapSol.get(billete) - 1);
                        mapCanti.put(billete, mapCanti.get(billete) + 1);
                    }
                }

            }

        }
        return objetivo;
    }

    public static boolean ensayarPalabras(char[][] laberinto, int columna, int fila, String cadena, int posCad) {
        if (fila < laberinto.length && columna < laberinto[0].length) {
            int prevPos = posCad;
            if (laberinto[fila][columna] == cadena.charAt(posCad)) {
                laberinto[fila][columna] = ' ';
                posCad++;
                if (posCad == cadena.length()) {
                    posCad = 0;
                }
            } else {
                posCad = 0;
                return false;
            }

            if (!(ensayarPalabras(laberinto, columna + 1, fila, cadena, posCad) || ensayarPalabras(laberinto, columna, fila + 1, cadena, posCad))) {
                laberinto[fila][columna] = cadena.charAt(prevPos);
            }
        }
        return true;
    }

    public static boolean llenarCDVueltaAtras(int capacidadMaxima, Map<String, Integer> espacioProgramas, List<String> CD) {
        Iterator<String> it = espacioProgramas.keySet().iterator();
        boolean objetivo = false;

        while (it.hasNext() && !objetivo) {
            String programa = it.next();
            if (CD.contains(programa)) {
                continue;
            }
            int duracion = espacioProgramas.get(programa);
            if (duracion <= capacidadMaxima) {
                CD.add(programa);
                if (duracion == capacidadMaxima) {
                    objetivo = true;
                } else {
                    objetivo = llenarCDVueltaAtras(capacidadMaxima - duracion, espacioProgramas, CD);
                    if (!objetivo) {
                        CD.remove(programa);
                    }
                }

            }
        }

        return objetivo;
    }

    private static class Posicion {

        int fila;
        int columna;

        static Posicion DEFAULT = new Posicion(-1, -1);

        public Posicion(int x, int y) {
            this.fila = x;
            this.columna = y;
        }

    }

    public static boolean ensayar(char[][] laberinto, int columna, int fila) {
        if (fila >= laberinto.length || columna >= laberinto[0].length || laberinto[fila][columna] == 'X') {
            return false;
        }

        boolean tp = laberinto[fila][columna] == 'T';

        laberinto[fila][columna] = 'C';

        if (fila == laberinto.length - 1 && columna == laberinto[0].length - 1) {
            return true;
        }

        boolean objetivo;
        if (tp) {
            Posicion nuevaPos = getPrimerTeleport(laberinto);
            laberinto[nuevaPos.fila][nuevaPos.columna] = ' ';
            objetivo = ensayar(laberinto, nuevaPos.columna, nuevaPos.fila);
        } else {
            objetivo = ensayar(laberinto, columna, fila + 1) || ensayar(laberinto, columna + 1, fila);
        }
        if (!objetivo) {
            laberinto[fila][columna] = 'I';
        }
        return objetivo;
    }

    private static Posicion getPrimerTeleport(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if (laberinto[i][j] == 'T') {
                    return new Posicion(i, j);
                }
            }
        }
        return new Posicion(-1, -1);
    }

    private static boolean buenSitio(int r, int[] tabl) {
//¿Es amenaza colocar la reina “r” en tabl[r], con las anteriores?
        int i;
        for (i = 0; i < r; ++i) {
            if (tabl[i] == tabl[r]) {
                return false;
            }
            if (Math.abs(i - r) == Math.abs(tabl[i] - tabl[r])) {
                return false;
            }
        }
        return true;
    }

    public static boolean colocarReinas(int reina, int[] tablero) {
        int columna = 0;
        while (columna < 8) {
            tablero[reina] = columna;
            if (buenSitio(reina, tablero)) {
                if (reina == 7) {
                    return true;
                } else {
                    return colocarReinas(reina + 1, tablero);
                }
            }
            columna++;
        }
        return false;
    }

    public static boolean subconjunto(int[] vector, int[] solucion, int resultado /* usado para recursividad -> */, int indice) {
        if (resultado == 0) {
            return true;
        }
        if (indice == vector.length || resultado < 0) {
            return false;
        }

        if (subconjunto(vector, solucion, resultado - vector[indice], indice + 1)) {
            solucion[indice] = 1;
            return true;
        } else if (subconjunto(vector, solucion, resultado, indice + 1)) {
            return true;
        }
        return false;
    }
}
