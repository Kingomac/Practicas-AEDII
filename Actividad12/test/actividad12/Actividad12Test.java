/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package actividad12;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kingo
 */
public class Actividad12Test {

    private static int[] selecRapi = {4, 2, 8, 12, 6, 9, 23, 43, 78, 14};
    private static int[] buscaPos = {9, 7, 5, 4, 3, 2, 1, 3, 4, 7};

    /**
     * Test of SeleccionRapida method, of class Actividad12.
     */
    @Test
    public void testSeleccionRapida() {
        System.out.println("SeleccionRapida");
        int sol = Actividad12.seleccionRapida(selecRapi, 5, 0, selecRapi.length - 1);

        assertEquals(sol, 9);
    }

    /**
     * Test of SeleccionRapida method, of class Actividad12.
     */
//@Test
//public void testTorresHanoi() {
//    System.out.println("TorresHanoi");
//    Actividad12.moverDiscos(3,"A","B","C");
//}
    /**
     * Test of buscaPosK method, of class Actividad12.
     */
    @Test
    public void testBuscaPosK() {
        System.out.println("Busca Posición K");
        int sol = Actividad12.buscarPosK2(buscaPos, 0, buscaPos.length - 1);

        assertEquals(sol, 6);
    }

}
