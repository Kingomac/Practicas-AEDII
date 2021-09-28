package actividad2implementacion;

/**
 *
 * @author Mario
 */
public class NodoBinarioPadre<E> {

    private E raiz;
    private NodoBinarioPadre<E> izquierda;
    private NodoBinarioPadre<E> derecha;
    private NodoBinarioPadre<E> padre;

    public NodoBinarioPadre(E raiz, NodoBinarioPadre<E> izquierda, NodoBinarioPadre<E> derecha) {
        this.raiz = raiz;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public NodoBinarioPadre(E raiz, NodoBinarioPadre<E> izquierda, NodoBinarioPadre<E> derecha, NodoBinarioPadre<E> padre) {
        this(raiz, izquierda, derecha);
        this.padre = padre;
    }

    public E getRaiz() {
        return raiz;
    }

    public void setRaiz(E raiz) {
        this.raiz = raiz;
    }

    public NodoBinarioPadre<E> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoBinarioPadre<E> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoBinarioPadre<E> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoBinarioPadre<E> derecha) {
        this.derecha = derecha;
    }

    public NodoBinarioPadre<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoBinarioPadre<E> padre) {
        this.padre = padre;
    }

}
