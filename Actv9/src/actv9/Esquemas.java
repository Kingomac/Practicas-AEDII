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
    
    public static List<String> llenarCDVoraz(int capMax, Map<String, Integer> programas) {
        List<String> claves = listaClaves(programas);
        List<String> solucion = new LinkedList<>();
        int i = 0;
        final int n = (int) Math.pow(2, claves.size());
        int c = 0;
        while (i < n && c < capMax) {
            String caso = Integer.toBinaryString(i);
            int c2 = 0;
            List<String> temp = new LinkedList<>();
            for (int j = 0; j < caso.length(); j++) {
                if (caso.charAt(j) == '1') {
                    temp.add(claves.get(j));
                    c2 += programas.get(claves.get(j));
                }
            }
            if (c2 <= capMax && c2 > c) {
                c = c2;
                solucion = temp;
            }
            i++;
        }
        return solucion;
    }

    private static <E, T> List<E> listaClaves(Map<E, T> m) {
        List<E> l = new LinkedList<>();
        for (E e : m.keySet()) {
            l.add(e);
        }
        return l;
    }

}
