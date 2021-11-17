package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {

    private List<List<Par<K, V>>> tabla;
    private int capacidad;

    HashMap() {
        this(1000);
    }

    HashMap(int capacidad) throws IllegalArgumentException {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: capacidad negativa");
        }
        this.capacidad = capacidad;
        tabla = new ArrayList<>(capacidad);
    }

    @Override
    public boolean esVacio() {
        return tabla.isEmpty();
    }

    @Override
    public boolean estaClave(K clave) throws NullPointerException {
        if (clave == null) {
            throw new NullPointerException("ERROR");
        } else {
            for (List<Par<K, V>> l : tabla) {
                for (Par<K, V> p : l) {
                    if (p.getClave().equals(clave)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public boolean estaValor(V valor) throws NullPointerException {
        if (valor == null) {
            throw new NullPointerException("ERROR");
        } else {
            for (List<Par<K, V>> l : tabla) {
                for (Par<K, V> p : l) {
                    if (p.getValor().equals(valor)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public V obtener(K clave) throws NullPointerException {
        if (clave == null) {
            throw new NullPointerException("ERROR");
        } else {
            for (List<Par<K, V>> l : tabla) {
                for (Par<K, V> p : l) {
                    if (p.getClave().equals(clave)) {
                        return p.getValor();
                    }
                }
            }
            return null;
        }
    }

    @Override
    public V suprimir(K clave) throws NullPointerException {
        if (clave == null) {
            throw new NullPointerException("ERROR");
        } else {
            for (List<Par<K, V>> l : tabla) {
                for (Par<K, V> p : l) {
                    if (p.getClave().equals(clave)) {
                        tabla.remove(p);
                        return p.getValor();
                    }
                }
            }
            return null;
        }
    }

    @Override
    public void vaciar() {
        tabla.clear();
    }

    @Override
    public void insertar(K clave, V valor) throws NullPointerException {
        if (clave == null || valor == null) {
            throw new NullPointerException();
        }
        int hash = funcionHash(clave);
        while (tabla.size() <= hash) {
            tabla.add(new ArrayList<>());
        }

        tabla.get(hash).add(new Par(clave, valor));
    }

    @Override
    public int tamanho() {
        int cont = 0;
        for (List<Par<K, V>> l : tabla) {
            cont += l.size();
        }
        return cont;
    }

    @Override
    public Iterator<K> getClaves() {
        List<K> toret = new LinkedList<>();
        for (List<Par<K, V>> l : tabla) {
            for (Par<K, V> p : l) {
                toret.add(p.getClave());
            }
        }
        return toret.iterator();
    }

    @Override
    public Iterator<V> getValores() {
        List<V> toret = new LinkedList<>();
        for (List<Par<K, V>> l : tabla) {
            for (Par<K, V> p : l) {
                toret.add(p.getValor());
            }
        }
        return toret.iterator();
    }

    @Override
    public Iterator<Par<K, V>> getEntradas() {
        List<Par<K, V>> toret = new LinkedList<>();
        for (List<Par<K, V>> l : tabla) {
            toret.addAll(l);
        }
        return toret.iterator();
    }

    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

}
