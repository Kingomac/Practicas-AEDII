package arbolgeneral;

/**
 *
 * @author Mario
 */
public class NodoGeneral<E> {

    private E raiz;
    private NodoGeneral<E> hijo;
    private NodoGeneral<E> hermano;

    public NodoGeneral(E raiz, NodoGeneral<E> hijo, NodoGeneral<E> hermano) {
        this.raiz = raiz;
        this.hijo = hijo;
        this.hermano = hermano;
    }

    public E getRaiz() {
        return raiz;
    }

    public void setRaiz(E raiz) {
        this.raiz = raiz;
    }

    public NodoGeneral<E> getHijo() {
        return hijo;
    }

    public void setIzq(NodoGeneral<E> hijo) {
        this.hijo = hijo;
    }

    public NodoGeneral<E> getHermano() {
        return hermano;
    }

    public void setDer(NodoGeneral<E> hermano) {
        this.hermano = hermano;
    }
}
