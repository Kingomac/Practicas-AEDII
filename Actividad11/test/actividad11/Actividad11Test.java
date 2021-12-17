/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package actividad11;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kingo
 */
public class Actividad11Test {

    private static char[][] lab
            = {{' ', ' ', ' ', 'X'},
            {' ', ' ', 'X', ' '},
            {' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' '}};

    private static final char[][] LAB
            = {{' ', 'T', ' ', 'X'},
            {' ', ' ', ' ', ' '},
            {' ', 'T', 'X', ' '},
            {' ', 'X', ' ', ' '}};

    private static final char[][] LAB2 = {{'A', 'O', 'O', 'X', 'X'},
    {'D', 'D', 'X', 'O', 'X'},
    {'E', 'A', 'D', 'E', 'X'},
    {'O', 'D', 'O', 'A', 'D'},
    {'O', 'O', 'O', 'A', 'E'}};

    /**
     * Test of colocarReinas method, of class Actividad11.
     */
    @Test
    public void testColocarReinas() {
        System.out.println("colocarReinas");
        int[] tablero = new int[8];
        Actividad11.colocarReinas(0, tablero);
        int[] solEsperada = {0, 4, 7, 5, 2, 6, 1, 3};
        assertArrayEquals(tablero, solEsperada);
    }

    /**
     * Test of ensayar method, of class Actividad11.
     */
    @Test
    public void testEnsayar() {
        System.out.println("ensayar");
        Actividad11.ensayar(lab, 0, 0);

        char[][] solEsperada
                = {{'C', ' ', ' ', 'X'},
                {'C', ' ', 'X', ' '},
                {'C', 'C', 'C', ' '},
                {'I', 'X', 'C', 'C'}};;

        System.out.println("Solución:");
        for (int i = 0; i < lab.length; i++) {
            System.out.println(Arrays.toString(lab[i]));
        }

        System.out.println("Esperada:");
        for (int i = 0; i < lab.length; i++) {
            System.out.println(Arrays.toString(solEsperada[i]));
        }
        assertArrayEquals(lab, solEsperada);
    }
//    @Test
//    public void testEnsayarConTele() {
//        System.out.println("ensayar con tele");
//        Actividad11.ensayar(LAB, 0, 0);
//
//        char [][] solEsperada = {{'C','C',' ','X'},
//                                 {'C','C','C','C'},
//                                 {'C','C','X','C'},
//                                 {'I','X',' ','C'}};
//
//
//        assertArrayEquals(LAB,solEsperada);
//    }
//     @Test
//    public void testEnsayarPalabras() {
//        System.out.println("ensayar palabras");
//        String cadena = "ADE";
//        Actividad11.ensayarPalabras(LAB2, 0, 0,cadena,0);
//
//        char [][] solEsperada = {{' ','O','O','X','X'},
//                               {' ','D','X','O','X'},
//                               {' ',' ',' ',' ','X'},
//                               {'O','D','O',' ',' '},
//                               {'O','O','O','A',' '}};
//
//
//        assertArrayEquals(LAB2,solEsperada);
//    }
}
