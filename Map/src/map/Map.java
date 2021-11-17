package map;

import java.util.Iterator;

public interface Map<K, V> {
    // Declaración de tipos: Map, boolean, int
    // Características: almacena una colección de pares(clave, valor) cuya clave no
    // puede estar duplicada y a la que se le pueden asignar varios valores. Los
    // elementos son modificables.

    //public Map();
    // Produce un mapa vacío
    public boolean esVacio();
    // Produce: verdadero si está vacío y falso si no lo está

    public boolean estaClave(K clave) throws NullPointerException;
    // Produce: si la clave es null lanza la excepción NullPointerException, si no, busca
    // la clave y devuelve verdadero si está, sino falso.

    public boolean estaValor(V valor) throws NullPointerException;
    // Produce: si valor es null lanza NullPointerException, sino busca un valor y devuelve verdadero si está, sino falso.

    public V obtener(K clave) throws NullPointerException;
    // Produce: si la clave es null lanza la excepción NullPointerException, si el elemento no está devuelve null si no, devuelve el valor que // se corresponde con la clave.

    public V suprimir(K clave) throws NullPointerException;
    // Modifica: this
    // Produce: si la clave es null lanza la excepción NullPointerException, si el elemento
    // no existe devuelve null, si no elimina la clave y su valor en el mapa, devuelve el
    // valor de la clave.

    public void vaciar();
    // Modifica: this
    // Produce: elimina todas las parejas clave/valor del mapa.

    public void insertar(K clave, V valor) throws NullPointerException;
    // Modifica: this
    // Produce: si la clave o el valor es null lanza la excepción NullPointerException crea
    // la clave o la sustituye con el nuevo valor.

    public int tamanho();
    // Produce: devuelve el número de pares del mapa

    public Iterator getClaves();
    // Produce: devuelve un iterador con todas las claves del mapa.

    public Iterator getValores();
    // Produce: devuelve un iterador con todas los valores del mapa.

    public Iterator getEntradas();
    // Produce: devuelve un iterador con todas las entradas (clave-valores) del mapa.
}
