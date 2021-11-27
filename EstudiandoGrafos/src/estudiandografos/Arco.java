package estudiandografos;

/**
 *
 * @author Mario
 */
public class Arco<E, T> {

    private Vertice<E> origen;
    private Vertice<E> destino;
    private T etiqueta;

    public Arco(Vertice<E> origen, Vertice<E> destino, T etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    public Vertice<E> getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice<E> origen) {
        this.origen = origen;
    }

    public Vertice<E> getDestino() {
        return destino;
    }

    public void setDestino(Vertice<E> destino) {
        this.destino = destino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(getOrigen().getEtiqueta().toString());
        toret.append(" -- ").append(getEtiqueta()).append(" -->").append(getDestino().getEtiqueta());
        return toret.toString();
    }

}
