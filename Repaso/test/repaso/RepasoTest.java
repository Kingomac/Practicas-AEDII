/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kingo
 */
public class RepasoTest {

    @Test
    public void testFactorial() {
        System.out.println("Compute the factorial of 4");
        int num = 4;
        long expResult = 24;
        assertEquals(expResult, Repaso.factorial(num));
    }

    @Test
    public void testSquare() {
        System.out.println("Compute the square number of 5");
        int num = 5;
        int expResult = 25;
        assertEquals(expResult, Repaso.square(num));
    }

    @Test
    public void testSumDigits() {
        System.out.println("Summate the digits of 1111");
        int num = 1111;
        int expResult = 4;
        assertEquals(expResult, Repaso.sumDigits(num));
    }

    @Test
    public void testMcd() {
        System.out.println("Compute Greatest Common Factor of 22 and 12");
        int num1 = 22;
        int num2 = 12;
        int expResult = 2;
        assertEquals(expResult, Repaso.mcd(num1, num2));
    }

    @Test
    public void testInvert() {
        System.out.println("Reverse the word 'ejemplo'");
        String str = "ejemplo";
        String expResult = "olpmeje";
        assertEquals(expResult, Repaso.invert(str));
    }

    @Test
    public void testSumArray() {
        System.out.println("Sum the elements of {2, 4, 6, 8}");
        int[] input = {2, 4, 6, 8};
        int expResult = 20;
        assertEquals(expResult, Repaso.sumArray(input));
    }

    @Test
    public void testInvertArray() {
        System.out.println("Reverse the elements of {2, 4, 6, 8}");
        int[] input = {2, 4, 6, 8};
        int[] expResult = {8, 6, 4, 2};
        Repaso.invertArray(input);
        assertArrayEquals(input, expResult);
    }

    @Test
    public void testMinimum() {
        System.out.println("Identifies the lowest value for {4, 3, 6, 2, 8}");
        int[] input = {4, 3, 6, 2, 8};
        int expResult = 2;
        assertEquals(expResult, Repaso.minimum(input));
    }
    /*
    @Test
    public void testBinaryFound() {
        System.out.println("Searchs 1.1 using binary search over {1.1, 2.2, 3.3, 4.4, 5.5}");
        double[] input = {1.1, 2.2, 3.3, 4.4, 5.5};
        double elem = 3.3;
        int expResult = 3;
        assertEquals(expResult, Repaso.binary(input, elem));
    }

    @Test
    public void testBinaryMissing() {
        System.out.println("Searchs 0.0 using binary search over {1.1, 2.2, 3.3, 4.4, 5.5}");
        double[] input = {1.1, 2.2, 3.3, 4.4, 5.5};
        double elem = 0.0;
        int expResult = -1;
        assertEquals(expResult, Repaso.binary(input, elem));
    }

    @Test
    public void testCopyStack() {
        System.out.println("Copies the content of a Stack into a new one");
        Stack input = new Stack <>();
        input.addAll(Arrays.asList(new String[]{"AEDII","Actividad","Uno"}));
        Stack expResult = Repaso.copyStack(input);
        assertEquals(input, expResult);
    }
     */
}
