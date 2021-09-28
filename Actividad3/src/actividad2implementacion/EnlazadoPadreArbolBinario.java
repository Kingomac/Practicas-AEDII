package actividad2implementacion;

/**
 *
 * @author Mario
 */
public class EnlazadoPadreArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinarioPadre<E> nodo;

    public EnlazadoPadreArbolBinario() {
        nodo = null;
    }

    public EnlazadoPadreArbolBinario(E raiz, EnlazadoPadreArbolBinario izquierda, EnlazadoPadreArbolBinario derecha) throws NullPointerException {
        if (izquierda == null || derecha == null) {
            throw new NullPointerException();
        }
        nodo = new NodoBinarioPadre<>(raiz, izquierda.nodo, derecha.nodo);
        if (izquierda.nodo != null) {
            izquierda.nodo.setPadre(nodo);
        }
        if (derecha.nodo != null) {
            derecha.nodo.setPadre(nodo);
        }
    }

    private EnlazadoPadreArbolBinario(NodoBinarioPadre<E> nodo) {
        this.nodo = nodo;
    }

    @Override
    public boolean esVacio() {
        return nodo == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
        }
        return nodo.getRaiz();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("hijoIzq: Árbol vacío");
        }
        NodoBinarioPadre<E> nodoHijo = nodo.getIzquierda();
        if (nodoHijo != null) {
            return new EnlazadoPadreArbolBinario<>(nodoHijo);
        }
        return new EnlazadoPadreArbolBinario<>();
    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("hijoDer: Árbol vacío");
        }
        NodoBinarioPadre<E> nodoHijo = nodo.getDerecha();
        if (nodoHijo != null) {
            return new EnlazadoPadreArbolBinario<>(nodoHijo);
        }
        return new EnlazadoPadreArbolBinario<>();
    }

    @Override
    public boolean esta(E elemento) {
        if (esVacio()) {
            return false;
        }
        if (raiz().equals(elemento)) {
            return true;
        }
        return hijoIzq().esta(elemento) || hijoDer().esta(elemento);
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
        }
        nodo.setRaiz(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if (hi == null) {
            throw new NullPointerException();
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacío");
        }
        nodo.setIzquierda(((EnlazadoPadreArbolBinario) hi).nodo);
        if (!hi.esVacio()) {
            nodo.getIzquierda().setPadre(nodo);
        }
    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if (hd == null) {
            throw new NullPointerException();
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("setHijoDer: Árbol vacío");
        }
        nodo.setDerecha(((EnlazadoPadreArbolBinario) hd).nodo);
        if (!hd.esVacio()) {
            nodo.getDerecha().setPadre(nodo);
        }
    }

    @Override
    public void suprimir() {
        nodo = null;
    }

    @Override
    public ArbolBinario<E> getPadre(ArbolBinario<E> hijo) throws ArbolVacioExcepcion {
        if (hijo.esVacio()) {
            throw new ArbolVacioExcepcion("padre: Árbol vacío");
        }
        NodoBinarioPadre nodoHijo = ((EnlazadoPadreArbolBinario) hijo).nodo;
        if (nodoHijo.getPadre() == null) {
            throw new ArbolVacioExcepcion("padre: Árbol vacío");
        }
        return new EnlazadoPadreArbolBinario<>(nodoHijo.getPadre());
    }

    public ArbolBinario<E> getPadre() throws ArbolVacioExcepcion {
        return getPadre(this);
    }

    public void setPadre(EnlazadoPadreArbolBinario<E> padre) {
        nodo.setPadre(padre.nodo);
    }

}
