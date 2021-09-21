package repaso;

/**
 *
 * @author Mario
 */
public class Repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int square(int n) {
        if (n == 0) {
            return 0;
        }
        return square(n - 1) + 2 * n - 1;
    }

    /**
     *
     * @param n
     * @return
     */
    public static int sumDigits(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sumDigits(n / 10);
    }

    /*
    public static int mcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return mcd(a - b, b);
        }
        return mcd(a, b - a);
    }*/
    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    public static String invert(String palabra) {
        if (palabra.length() == 1) {
            return palabra;
        }
        return palabra.charAt(palabra.length() - 1) + invert(palabra.substring(0, palabra.length() - 1));
    }

    /**
     * [1, 2, 3]
     *
     * 1 + [2,3] * + 2 + 3
     *
     * @param arr
     * @return
     */
    public static int sumArray(int[] arr) {
        return sumArray(arr, 0);
    }

    private static int sumArray(int[] arr, int pos) {
        if (pos >= arr.length) {
            return 0;
        }
        return arr[pos] + sumArray(arr, pos + 1);
    }

    public static void invertArray(int[] arr) {
        invertArray(arr, 0);
    }

    private static void invertArray(int arr[], int inicio) {
        int fin = arr.length - 1 - inicio;
        if (inicio < fin) {
            int a = arr[inicio];
            arr[inicio] = arr[fin];
            arr[fin] = a;
            invertArray(arr, inicio + 1);
        }
    }

    public static int minimum(int[] arr) {
        return minimum(arr, 0, arr[0]);
    }

    private static int minimum(int[] arr, int pos, int min) {
        if (arr.length >= pos) {
            return min;
        }
        if (arr[pos] < min) {
            return minimum(arr, pos + 1, arr[pos]);
        }
        return minimum(arr, pos + 1, min);
    }
}
