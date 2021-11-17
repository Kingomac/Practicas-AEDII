package actv6ej2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Mario
 */
public class Polinomio {

    private Map<Integer, Double> datos;

    public Polinomio() {
        datos = new HashMap<>();
    }

    public int grado() {
        if (datos.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i : datos.keySet()) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public double coeficiente(int n) {
        for (var i : datos.entrySet()) {
            if (i.getKey().equals(n)) {
                return i.getValue();
            }
        }
        return 0;
    }

    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
        if (exponente < 0 || coeficiente == 0) {
            throw new IllegalArgumentException("añadirTermino: IllegalArgumentException");
        }
        try {
            double suma = datos.get(exponente) + coeficiente;
            if (suma != 0) {
                datos.put(exponente, suma);
            } else {
                datos.remove(exponente);
            }
        } catch (NullPointerException ex) {
            datos.put(exponente, coeficiente);
        }
    }

    public void eliminarTermino(int exponente) {
        datos.remove(exponente);
    }

    public Polinomio suma(Polinomio p) {
        Polinomio toret = new Polinomio();
        for (Entry<Integer, Double> i : datos.entrySet()) {
            toret.añadirTermino(i.getKey(), i.getValue());
        }
        for (Entry<Integer, Double> i : p.datos.entrySet()) {
            double ant = toret.coeficiente(i.getKey());
            double suma = ant + i.getValue();
            if (suma != 0) {
                toret.añadirTermino(i.getKey(), i.getValue());
            }
        }
        return toret;
    }

    public Polinomio derivada() {
        Polinomio toret = new Polinomio();
        for (Entry<Integer, Double> i : datos.entrySet()) {
            if (i.getKey() >= 1) {
                toret.añadirTermino(i.getKey() - 1, i.getKey() * i.getValue());
            }
        }
        return toret;
    }

}
