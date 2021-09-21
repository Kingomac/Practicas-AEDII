package actividad2;

import arbolBinario.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Actividad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    public static boolean completo(ArbolBinario arbol) {
        if (arbol.esVacio()) {
            return true;
        }
        try {
            if (arbol.hijoDer().esVacio() && !arbol.hijoIzq().esVacio() || !arbol.hijoDer().esVacio() && arbol.hijoIzq().esVacio()) {
                return false;
            }
            return completo(arbol.hijoDer()) && completo(arbol.hijoIzq());
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean identicos(ArbolBinario a, ArbolBinario b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (a.esVacio() || b.esVacio()) {
            return false;
        }
        if (a.raiz() != b.raiz()) {
            return false;
        }
        return identicos(a.hijoDer(), b.hijoDer()) && identicos(a.hijoIzq(), b.hijoIzq());
    }

    public static int contarNivel(ArbolBinario arbol, int nivel) {
        if (arbol.esVacio()) {
            return 0;
        }
        if (nivel <= 0) {
            return 1;
        } else {
            return contarNivel(arbol.hijoDer(), nivel - 1) + contarNivel(arbol.hijoIzq(), nivel - 1);
        }
    }

    public static List<Integer> nodosNivel(ArbolBinario arbol, int nivel) {
        List<Integer> toret = new LinkedList<>();
        for (int i = 0; i < nivel; i++) {
            int num = nodosNivelUnico(arbol, i);
            if (num > 0) {
                toret.add(num);
            }
        }
        return toret;
    }

    public static int nodosNivelUnico(ArbolBinario arbol, int nivel) {
        if (arbol.esVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return nodosNivelUnico(arbol.hijoDer(), nivel - 1) + nodosNivelUnico(arbol.hijoIzq(), nivel - 1);
    }

    public static ArbolBinario eliminarHojas(ArbolBinario arbol) {
        if (arbol.esVacio()) {
            return new EnlazadoArbolBinario();
        }
        if (arbol.hijoDer().esVacio() && arbol.hijoIzq().esVacio()) {
            return new EnlazadoArbolBinario();
        }
        return new EnlazadoArbolBinario(arbol.raiz(), eliminarHojas(arbol.hijoIzq()), eliminarHojas(arbol.hijoDer()));
    }

    public static int altura(ArbolBinario arbol) {
        if (arbol.esVacio()) {
            return -1;
        }
        int altDer = 1 + altura(arbol.hijoDer());
        int altIzq = 1 + altura(arbol.hijoIzq());
        return Integer.max(altIzq, altDer);
    }

    public static boolean mismaForma(ArbolBinario a, ArbolBinario b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (a.esVacio() || b.esVacio()) {
            return false;
        }
        return mismaForma(a.hijoDer(), b.hijoDer()) && mismaForma(a.hijoIzq(), b.hijoIzq());
    }

    public static <E extends Comparable<E>> boolean arbolSeleccion(ArbolBinario<E> arbol) {
        if (arbol.esVacio()) {
            return true;
        }
        if (!arbol.hijoDer().esVacio() && !arbol.hijoIzq().esVacio()) {
            if (arbol.hijoDer().raiz().compareTo(arbol.hijoIzq().raiz()) == -1) {
                return arbol.raiz().equals(arbol.hijoDer().raiz()) && arbolSeleccion(arbol.hijoDer()) && arbolSeleccion(arbol.hijoIzq());
            } else {
                return arbol.raiz().equals(arbol.hijoIzq().raiz()) && arbolSeleccion(arbol.hijoDer()) && arbolSeleccion(arbol.hijoIzq());
            }
        }
        return true;
    }

    public static boolean esCamino(ArbolBinario a, String camino) {
        if (a.esVacio() || camino.isEmpty()) {
            return camino.isEmpty();
        }
        if (a.raiz().equals(camino.charAt(0))) {
            return esCamino(a.hijoDer(), camino.substring(1)) || esCamino(a.hijoIzq(), camino.substring(1));
        }
        return false;
    }

    public static ArbolBinario copiaHastaNivel(ArbolBinario a, int nivel) {
        if (a.esVacio()) {
            return new EnlazadoArbolBinario();
        }
        if (nivel >= 0) {
            return new EnlazadoArbolBinario(a.raiz(), copiaHastaNivel(a.hijoIzq(), nivel - 1), copiaHastaNivel(a.hijoDer(), nivel - 1));
        } else {
            return new EnlazadoArbolBinario();
        }
    }

}
