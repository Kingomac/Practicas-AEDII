package actividad11;

public class Actividad11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static boolean colocarReinas(int reina, int[] tablero) {
        for (int columna = 0; columna < 8; columna++) {
            tablero[reina] = columna;
            if (buenSitio(reina, tablero) && (reina == 7 || colocarReinas(reina + 1, tablero))) {
                return true;
            }
        }
        return false;
    }

    public static boolean colocarReinas2(int reina, int[] tablero) {
        boolean objetivo = false;
        int columna = 0;

        while (columna < 8 && !objetivo) {
            tablero[reina] = columna;
            if (buenSitio(reina, tablero)) {
                if (reina == 7) {
                    objetivo = true;
                } else {
                    objetivo = colocarReinas2(reina + 1, tablero);
                }
            }
            columna++;
        }
        return false;
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

    public static boolean ensayar(char[][] laberinto, int fila, int columna) {
        if (laberinto[fila][columna] != ' ') {
            return false;
        }
        laberinto[fila][columna] = 'C';
        if (fila == laberinto.length - 1 && columna == laberinto[0].length - 1) {
            return true;
        }

        if (fila + 1 < laberinto.length && ensayar(laberinto, fila + 1, columna)) {
            return true;
        } else if (columna + 1 < laberinto.length && ensayar(laberinto, fila, columna + 1)) {
            return true;
        } else if (columna - 1 > -1 && ensayar(laberinto, fila, columna - 1)) {
            return true;
        } else if (fila - 1 > -1 && ensayar(laberinto, fila - 1, columna)) {
            return true;
        } else {
            laberinto[fila][columna] = 'I';
            return false;
        }
    }
}
