package estudiandografos;

/**
 *
 * @author Mario
 */
class VerticeAdyacente<E, T> {

    private Vertice<E> verticeDestino;
    private T etiquetaArco;

    public VerticeAdyacente(Vertice<E> verticeDestino, T etiquetaArco) {
        this.verticeDestino = verticeDestino;
        this.etiquetaArco = etiquetaArco;
    }

    public Vertice<E> getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiquetaArco() {
        return etiquetaArco;
    }

}
