package arbolbinario;

/**
 *
 * @author Mario
 */
public abstract class ArbolBinario<E> {

    public abstract boolean esVacio();

    public abstract E raiz() throws ArbolVacioExcepcion;

    public abstract ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion;

    public abstract ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion;

    public abstract boolean esta(E elemento);

    public abstract void setRaiz(E elemRaiz) throws ArbolVacioExcepcion;

    public abstract void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException;

    public abstract void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException;

    public abstract void suprimir();

    public <E extends ArbolBinario<E>> String preorden() {
        if (esVacio()) {
            return "";
        }
        StringBuilder toret = new StringBuilder(raiz().toString());
        E hijoIzq = (E) hijoIzq();
        E hijoDer = (E) hijoDer();
        if (!hijoIzq.esVacio()) {
            toret.append(", ").append(hijoIzq.preorden());
        }
        if (!hijoDer.esVacio()) {
            toret.append(", ").append(hijoDer.preorden());
        }
        return toret.toString();
    }

    public <E extends ArbolBinario<E>> String postorden() {
        if (esVacio()) {
            return "";
        }
        StringBuilder toret = new StringBuilder();
        E hijoIzq = (E) hijoIzq();
        E hijoDer = (E) hijoDer();
        if (!hijoIzq().esVacio()) {
            toret.append(hijoIzq.postorden()).append(" ");
        }
        if (!hijoDer().esVacio()) {
            toret.append(hijoDer.postorden()).append(" ");
        }
        toret.append(raiz()).append(" ");
        return toret.toString();
    }

    public <E extends ArbolBinario<E>> String inorden() {
        if (esVacio()) {
            return "";
        }
        StringBuilder toret = new StringBuilder();
        E hijoIzq = (E) hijoIzq();
        E hijoDer = (E) hijoDer();
        if (!hijoIzq().esVacio()) {
            toret.append(hijoIzq.postorden()).append(" ");
        }
        toret.append(raiz()).append(" ");
        if (!hijoDer().esVacio()) {
            toret.append(hijoDer.postorden()).append(" ");
        }
        return toret.toString();
    }

    public <E extends ArbolBinario<E>> String inorden(int cont) {
        if (esVacio()) {
            return "";
        }
        StringBuilder toret = new StringBuilder();
        if (cont == 2) {
            toret.append(raiz()).append(", ");
        }
        E hijoIzq = (E) hijoIzq();
        E hijoDer = (E) hijoDer();
        if (!hijoIzq().esVacio()) {
            toret.append(hijoIzq.inorden(cont + 1)).append(", ");
        }
        if (!hijoDer().esVacio()) {
            toret.append(hijoDer.inorden(cont + 2)).append(", ");
        }
        if (cont != 2) {
            toret.append(raiz()).append(", ");
        }
        return toret.toString();
    }
}
