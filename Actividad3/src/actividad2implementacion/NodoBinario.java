package actividad2implementacion;

/**
 *
 * @author Mario
 */
public class NodoBinario<E> {

    private E raiz;
    private NodoBinario<E> izquierda;
    private NodoBinario<E> derecha;

    public NodoBinario(E raiz, NodoBinario<E> izquierda, NodoBinario<E> derecha) {
        this.raiz = raiz;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public E getRaiz() {
        return raiz;
    }

    public void setRaiz(E raiz) {
        this.raiz = raiz;
    }

    public NodoBinario<E> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoBinario<E> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoBinario<E> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoBinario<E> derecha) {
        this.derecha = derecha;
    }

}
