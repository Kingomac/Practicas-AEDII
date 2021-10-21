package arbolbinario;

/**
 *
 * @author Mario
 */
public class NodoBinario<E> {
    private E raiz;
    private NodoBinario hijoIzq;
    private NodoBinario hijoDer;

    public NodoBinario(E raiz, NodoBinario hijoIzq, NodoBinario hijoDer) {
        this.raiz = raiz;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    public E getRaiz() {
        return raiz;
    }

    public void setRaiz(E raiz) {
        this.raiz = raiz;
    }

    public NodoBinario getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoBinario hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoBinario getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoBinario hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    
}
