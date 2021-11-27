package actv9;

import java.util.Iterator;
import lista.*;
import mapa.HashMap;
import mapa.Map;

/**
 *
 * @author Mario
 */
public class Esquemas {

    public static Map<Integer, Integer> darCambio(int importeDevolver, Map<Integer, Integer> mapCanti) {
        Map<Integer, Integer> cambio = new HashMap<>();
        Map<Integer, Integer> copia = new HashMap<>();
        while (importeDevolver > 0 && mapCanti.tamaño() > 0) {
            int mayorBillete = mayor(mapCanti);
            copia.insertar(mayorBillete, mapCanti.get(mayorBillete));

            int cantidad = 0;
            int disponible = mapCanti.get(mayorBillete);
            while ((importeDevolver - (cantidad + 1) * mayorBillete) >= 0 && disponible > 0) {
                cantidad++;
                disponible--;
            }

            importeDevolver -= mayorBillete * cantidad;
            cambio.insertar(mayorBillete, cantidad);

            mapCanti.eliminar(mayorBillete);
        }

        Iterator<Integer> itCopia = copia.getClaves();
        while (itCopia.hasNext()) {
            int i = itCopia.next();
            mapCanti.insertar(i, copia.get(i));
        }

        return cambio;
    }

    private static <E extends Comparable<E>, T> E mayor(Map<E, T> m) {
        Iterator<E> it = m.getClaves();
        if (!it.hasNext()) {
            return null;
        }
        E mayor = it.next();
        while (it.hasNext()) {
            E clave = it.next();
            if (mayor.compareTo(clave) < 0) {
                mayor = clave;
            }
        }
        return mayor;
    }

    public static Lista<String> llenarCDVoraz(int capacidadMaxima, Map<String, Integer> espacioProgramas) {
        /*List<String> claves = new ArrayList<>();
        Iterator<String> it = espacioProgramas.getClaves();
        while (it.hasNext()) {
            claves.add(it.next());
        }

        for (int i = 0; i < claves.size(); i++) {
            for (int j = 0; j < claves.size(); j++) {
                if (i != j) {
                    int duracion = espacioProgramas.get(claves.get(i));
                    while (duracion < capacidadMaxima) {
                        duracion += espacioProgramas.get(claves.get(j));
                    }
                }
            }
        }*/
        return new ListaEnlazada<>();
    }

}
