package estudiandoarboles;

import arbolbinario.ArbolBinario;
import arbolbinario.EnlazadoArbolBinario;
import arbolgeneral.ArbolGeneral;
import heap.Heap;
import java.util.List;

/**
 *
 * @author Mario
 */
public class EstudiandoArboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* EnlazadoArbolBinario vacio = new EnlazadoArbolBinario();
        EnlazadoArbolBinario hoja1 = new EnlazadoArbolBinario(5, vacio, vacio);
        EnlazadoArbolBinario hoja2 = new EnlazadoArbolBinario(-1, vacio, vacio);
        EnlazadoArbolBinario hoja3 = new EnlazadoArbolBinario(0, vacio, vacio);
        EnlazadoArbolBinario hoja4 = new EnlazadoArbolBinario(8, vacio, vacio);
        EnlazadoArbolBinario hoja5 = new EnlazadoArbolBinario(3, vacio, vacio);
        EnlazadoArbolBinario m1 = new EnlazadoArbolBinario(3, hoja4, hoja5);
        EnlazadoArbolBinario m2 = new EnlazadoArbolBinario(4, hoja2, hoja3);
        EnlazadoArbolBinario m3 = new EnlazadoArbolBinario(9, hoja1, vacio);
        EnlazadoArbolBinario m4 = new EnlazadoArbolBinario(13, m2, m3);
        EnlazadoArbolBinario raiz = new EnlazadoArbolBinario(7, m1, m4);

        System.out.println(raiz.postorden());*/

//        ArbolGeneral<Integer> vacio = new ArbolGeneral<>();
//        ArbolGeneral<Integer> hoja1 = new ArbolGeneral<>(5, vacio);
//        ArbolGeneral<Integer> hoja2 = new ArbolGeneral<>(4, vacio);
//        ArbolGeneral<Integer> hoja3 = new ArbolGeneral<>(3, vacio);
//        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(8, hoja1, hoja2, hoja3);
//
//        preorden(raiz);
//        System.out.println("");
//        raiz.setHijo(new ArbolGeneral<>(-11, vacio));
//        preorden(raiz);
//        System.out.println("");
        EnlazadoArbolBinario vacio = new EnlazadoArbolBinario();
        EnlazadoArbolBinario hoja1 = new EnlazadoArbolBinario('o', vacio, vacio);
        EnlazadoArbolBinario hoja2 = new EnlazadoArbolBinario('h', vacio, vacio);
        EnlazadoArbolBinario hoja3 = new EnlazadoArbolBinario('l', vacio, vacio);
        EnlazadoArbolBinario hoja4 = new EnlazadoArbolBinario('m', vacio, vacio);
        EnlazadoArbolBinario hoja5 = new EnlazadoArbolBinario('q', vacio, vacio);
        EnlazadoArbolBinario m1 = new EnlazadoArbolBinario('s', hoja4, hoja5);
        EnlazadoArbolBinario m2 = new EnlazadoArbolBinario('o', hoja2, hoja3);
        EnlazadoArbolBinario m3 = new EnlazadoArbolBinario('i', hoja1, vacio);
        EnlazadoArbolBinario m4 = new EnlazadoArbolBinario('d', m2, m3);
        EnlazadoArbolBinario raiz = new EnlazadoArbolBinario('a', m1, m4);

        visualizarPalabras(raiz);

    }

    public static <E extends Comparable<E>> void heapsort(List<E> lista) {
        Heap<E> a = new Heap();
        while (!lista.isEmpty()) {
            a.introducir(lista.remove(0));
        }
        a.arreglarHeap();
        while (!a.esVacio()) {
            lista.add(a.recuperarMax());
        }
    }

    static <E> void preorden(ArbolGeneral<E> a) {
        if (a.esVacio()) {
            return;
        }
        System.out.print(a.raiz() + ", ");
        for (ArbolGeneral<E> actual = a.hijoMasIzq(); !actual.esVacio(); actual = actual.hermanoDer()) {
            preorden(actual); //System.out.println(actual.raiz());
        }
    }

    static boolean completo(ArbolBinario<Integer> a) {
        if (a.esVacio()) {
            return true;
        }
        if ((a.hijoIzq().esVacio() && !a.hijoDer().esVacio()) || (!a.hijoIzq().esVacio() && a.hijoDer().esVacio())) {
            return false;
        }
        return true;
    }

    static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
    }

    public static <E> boolean identicos(ArbolGeneral<E> a, ArbolGeneral<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        ArbolGeneral actualA = a.hijoMasIzq();
        ArbolGeneral actualB = b.hijoMasIzq();
        while (!actualA.esVacio() && !actualB.esVacio()) {

            if (!identicos(actualA, actualB) || !actualA.raiz().equals(actualB.raiz())) {
                return false;
            }

            actualA = actualA.hermanoDer();
            actualB = actualB.hermanoDer();
        }
        return a.raiz().equals(b.raiz());
    }

    static <E> ArbolBinario<E> copia(ArbolBinario<E> a) {
        if (a.esVacio()) {
            return new EnlazadoArbolBinario();
        }
        return new EnlazadoArbolBinario(a.raiz(), (EnlazadoArbolBinario) copia(a.hijoIzq()), (EnlazadoArbolBinario) copia(a.hijoDer()));
    }

    public static <E> ArbolGeneral<E> copia(ArbolGeneral<E> a) {
        if (a.esVacio()) {
            return new ArbolGeneral<>();
        }
        ArbolGeneral<E> toret = new ArbolGeneral<>(a.raiz(), ArbolGeneral.VACIO);
        for (ArbolGeneral<E> actual = a.hijoMasIzq(); !actual.esVacio(); actual = actual.hermanoDer()) {
            //toret.setHijo(copia(actual));
        }
        return toret;
    }

    public static <E> int contarNivel(ArbolBinario<E> a, int nivel) {
        if (a.esVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return contarNivel(a.hijoDer(), nivel - 1) + contarNivel(a.hijoIzq(), nivel - 1);
    }

    public static <E> ArbolBinario<E> eliminarHojas(ArbolBinario<E> a) {
        if (a.esVacio()) {
            return new EnlazadoArbolBinario<>();
        }
        if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
            return new EnlazadoArbolBinario<>();
        }
        return new EnlazadoArbolBinario<>(a.raiz(), (EnlazadoArbolBinario) eliminarHojas(a.hijoIzq()), (EnlazadoArbolBinario) eliminarHojas(a.hijoDer()));
    }

    public static <E> int altura(ArbolBinario<E> a) {
        if (a.esVacio()) {
            return 0;
        }
        int alturaIzq = altura(a.hijoIzq());
        int alturaDer = altura(a.hijoDer());
        return 1 + Integer.max(alturaDer, alturaDer);
    }

    public static <E> boolean mismaForma(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (!a.esVacio() && !b.esVacio()) {
            return mismaForma(a.hijoIzq(), b.hijoIzq()) && mismaForma(a.hijoDer(), b.hijoDer());
        }
        return false;
    }

    static <E> E padre(ArbolBinario<E> a, E el) {
        if (a.esVacio()) {
            return null;
        }
        if (!a.hijoIzq().esVacio()) {
            if (a.hijoIzq().raiz().equals(el)) {
                return a.raiz();
            }
            E busqHI = padre(a.hijoIzq(), el);
            if (busqHI != null) {
                return busqHI;
            }
        }
        if (!a.hijoDer().esVacio()) {
            if (a.hijoDer().raiz().equals(el)) {
                return a.raiz();
            }
            E busqHD = padre(a.hijoDer(), el);
            if (busqHD != null) {
                return busqHD;
            }
        }
        return null;
    }

    static <E> boolean distanciaK(ArbolBinario<E> a, E elem, int k) {
        if (a.esVacio()) {
            return false;
        }
        if (k > 0) {
            return distanciaK(a.hijoIzq(), elem, k - 1) || distanciaK(a.hijoDer(), elem, k - 1);
        }
        return a.raiz().equals(elem);
    }

    static <E> void visualizarPalabras(ArbolBinario<E> a) {
        String palabra = "";
        visualizarPalabras(a, palabra);
    }

    private static <E> void visualizarPalabras(ArbolBinario<E> a, String palabra) {
        if (a.esVacio()) {
            return;
        }
        palabra = palabra + a.raiz();
        if (a.hijoDer().esVacio() && a.hijoIzq().esVacio()) {
            System.out.println(palabra);
            return;
        }
        visualizarPalabras(a.hijoIzq(), palabra);
        visualizarPalabras(a.hijoDer(), palabra);
    }

    static <E> EnlazadoArbolBinario<E> copiaHastaNivel(EnlazadoArbolBinario<E> a, int nivel) {
        if (a.esVacio()) {
            return new EnlazadoArbolBinario<>();
        }
        if (nivel > 0) {
            return new EnlazadoArbolBinario<>(a.raiz(), copiaHastaNivel((EnlazadoArbolBinario<E>) a.hijoIzq(), nivel - 1), copiaHastaNivel((EnlazadoArbolBinario<E>) a.hijoDer(), nivel - 1));
        }
        return new EnlazadoArbolBinario<>(a.raiz(), new EnlazadoArbolBinario<E>(), new EnlazadoArbolBinario<>());
    }

    static <E> boolean esCamino(ArbolBinario<E> a, String str) {
        if (a.esVacio() || str.isEmpty()) {
            return str.isEmpty();
        }
        if (a.raiz().equals(str.charAt(0))) {
            return esCamino(a.hijoIzq(), str.substring(1)) || esCamino(a.hijoDer(), str.substring(1));
        }
        return false;
    }

    static <E extends Comparable<E>> boolean arbolSeleccion(ArbolBinario<E> a) {
        if (a.esVacio() || a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
            return true;
        }

        E menorHijo = null;
        if (!a.hijoIzq().esVacio()) {
            menorHijo = a.hijoIzq().raiz();
        }
        if (!a.hijoDer().esVacio()) {
            if (menorHijo == null) {
                menorHijo = a.hijoDer().raiz();
            } else {
                if (menorHijo.compareTo(a.hijoDer().raiz()) == 1) {
                    menorHijo = a.hijoDer().raiz();
                }
            }
        }
        return a.raiz().equals(menorHijo) && arbolSeleccion(a.hijoIzq()) && arbolSeleccion(a.hijoDer());
    }

}
