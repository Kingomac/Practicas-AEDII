package arbolbinario;

/**
 *
 * @author Mario
 */
public class EnlazadoArbolBinario<E> extends ArbolBinario<E> {

    private NodoBinario<E> nodo;

    public EnlazadoArbolBinario() {
        nodo = null;
    }

    public EnlazadoArbolBinario(E raiz, EnlazadoArbolBinario<E> hijoIzq, EnlazadoArbolBinario<E> hijoDer) {
        nodo = new NodoBinario<>(raiz, hijoIzq.nodo, hijoDer.nodo);
    }

    private EnlazadoArbolBinario(NodoBinario<E> nodo) {
        this.nodo = nodo;
    }

    @Override
    public boolean esVacio() {
        return nodo == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        return nodo.getRaiz();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        if (nodo.getHijoIzq() == null) {
            return new EnlazadoArbolBinario<>();
        }
        return new EnlazadoArbolBinario<>(nodo.getHijoIzq());
    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        if (nodo.getHijoDer() == null) {
            return new EnlazadoArbolBinario<>();
        }
        return new EnlazadoArbolBinario<>(nodo.getHijoDer());
    }

    @Override
    public boolean esta(E elemento) {
        if (esVacio()) {
            return false;
        }
        if (nodo.getRaiz().equals(elemento)) {
            return true;
        }
        return hijoDer().esta(elemento) || hijoIzq().esta(elemento);
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        nodo.setRaiz(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if (hi == null) {
            throw new NullPointerException();
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        nodo.setHijoIzq(((EnlazadoArbolBinario) hi).nodo);
    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if (hd == null) {
            throw new NullPointerException();
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        nodo.setHijoDer(((EnlazadoArbolBinario) hd).nodo);
    }

    @Override
    public void suprimir() {
        nodo = null;
    }
}
