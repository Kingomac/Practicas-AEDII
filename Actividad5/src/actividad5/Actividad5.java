package actividad5;

import arbolGeneral.*;

/**
 *
 * @author Mario
 */
public class Actividad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ArbolGeneral vacio = new ArbolGeneral();
        ArbolGeneral<Integer> hoja1 = new ArbolGeneral<>(2, vacio);
        ArbolGeneral<Integer> hoja2 = new ArbolGeneral<>(4, vacio);
        ArbolGeneral<Integer> hoja3 = new ArbolGeneral<>(-5, vacio);
        ArbolGeneral<Integer> m1 = new ArbolGeneral<>(32, hoja1);
        ArbolGeneral<Integer> m2 = new ArbolGeneral<>(7, hoja2, hoja3);
        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(1, m1, m2);

        //List<ArbolGeneral>
        ArbolGeneral actual = raiz;
        while (actual != null) {

        }*/
    }

    public static <E extends ArbolGeneral<Integer>> int sumaNodos(E a) {
        if (a.esVacio()) {
            return 0;
        }
        E actual = (E) a.hijoMasIzq();
        int suma = a.raiz();
        while (!actual.esVacio()) {
            suma += sumaNodos(actual);
            actual = (E) actual.hermanoDer();
        }
        return suma;
    }

    public static <E> boolean igualEstructura(ArbolGeneral<E> a, ArbolGeneral<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (!a.esVacio() && !b.esVacio()) {
            ArbolGeneral<E> actualA = a.hijoMasIzq();
            ArbolGeneral<E> actualB = b.hijoMasIzq();
            boolean toret = true;
            while (!actualA.esVacio() && !actualB.esVacio() && toret) {
                toret = igualEstructura(actualA, actualB);
                actualA = actualA.hermanoDer();
                actualB = actualB.hermanoDer();
            }
            if ((actualA.esVacio() && !actualB.esVacio()) || (!actualA.esVacio() && actualB.esVacio())) {
                return false;
            }
            return toret;
        }
        return false;
    }

    public static <E> boolean arbolDosTres(ArbolGeneral<E> a) {
        if (a.esVacio()) {
            return true;
        }
        ArbolGeneral<E> actual = a.hijoMasIzq();
        int cont = 0;
        while (!actual.esVacio()) {
            if (cont > 3 || !arbolDosTres(actual)) {
                return false;
            }
            cont++;
            actual = actual.hermanoDer();
        }
        return cont == 2 || cont == 3 || cont == 0;
    }

    public static <E extends Comparable<E>> boolean esSeleccion(ArbolGeneral<E> a) {
        if (a.esVacio() || a.hijoMasIzq().esVacio()) {
            return true;
        }
        E menor = a.hijoMasIzq().raiz();
        for (ArbolGeneral<E> actual = a.hijoMasIzq().hermanoDer(); !actual.esVacio(); actual = actual.hermanoDer()) {
            if (menor.compareTo(actual.raiz()) == 1) {
                menor = actual.raiz();
            }
            if (!esSeleccion(actual)) {
                return false;
            }
        }
        return menor.equals(a.raiz());
    }

    public static <E> int nivel(ArbolGeneral<E> a, E el) {
        return nivel(a, el, 0);
    }

    private static <E> int nivel(ArbolGeneral<E> a, E el, int nivel) {
        if (a.esVacio()) {
            return -1;
        }
        if (a.raiz().equals(el)) {
            return nivel;
        }
        for (ArbolGeneral<E> actual = a.hijoMasIzq(); !actual.esVacio(); actual = actual.hermanoDer()) {
            if (actual.raiz().equals(el)) {
                return nivel;
            }
            //int nivelHijo = nivel(a, el, nivel + 1);
            //if (nivelHijo != -1) {
            //    return nivelHijo;
            //}
        }
        return -1;
    }

}
