package arbolgeneral;

/**
 *
 * @author Mario
 */
public class ArbolGeneral<E> {

    public static final ArbolGeneral VACIO = new ArbolGeneral<>();

    private NodoGeneral<E> nodo;

    public ArbolGeneral() {
        nodo = null;
    }

    public ArbolGeneral(E elemRaiz, ArbolGeneral<E>... hijos) throws NullPointerException {
        if (hijos.length == 0) {
            throw new NullPointerException();
        }
        nodo = new NodoGeneral<>(elemRaiz, hijos[0].nodo, null);

        for (int i = 0; i < hijos.length - 1; i++) {
            hijoMasDer().nodo.setDer(hijos[i + 1].nodo);
        }
    }

    private ArbolGeneral(NodoGeneral<E> nodo) {
        this.nodo = nodo;
    }

    public boolean esVacio() {
        return nodo == null;
    }

    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        return nodo.getRaiz();
    }

    public ArbolGeneral<E> hijoMasIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        return new ArbolGeneral<>(nodo.getHijo());
    }

    public ArbolGeneral<E> hijoMasDer() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        NodoGeneral actual = nodo.getHijo();
        while (actual.getHermano() != null) {
            actual = actual.getHermano();
        }
        return new ArbolGeneral<>(actual);
    }

    public ArbolGeneral<E> hermanoDer() {
        return new ArbolGeneral<>(nodo.getHermano());
    }

    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        nodo.setRaiz(elemRaiz);
    }

    public void setHijo(ArbolGeneral<E> hijo) throws ArbolVacioExcepcion, NullPointerException {
        if (hijo == null) {
            throw new NullPointerException();
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        if (hijoMasDer() == hijoMasIzq() && hijoMasIzq().esVacio()) {
            nodo.setDer(hijo.nodo);
        } else {
            hijoMasDer().nodo.setDer(hijo.nodo);
        }
    }

    public void suprimir() {
        nodo = null;
    }
}
