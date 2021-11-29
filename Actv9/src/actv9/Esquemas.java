package actv9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

    public static Lista<String> llenarCDVoraz(int capMax, Map<String, Integer> programas) {
        return llenarCDVoraz__MARIO(capMax, programas);
    }

    public static Lista<String> llenarCDVoraz__MARIO(int capMax, Map<String, Integer> programas) {
        List<String> claves = listaClaves(programas);
        Lista<String> solucion = new ListaEnlazada<>();
        int i = 0;
        final int n = (int) Math.pow(2, claves.size());
        int c = 0;
        while (i < n && c < capMax) {
            String caso = Integer.toBinaryString(i);
            int c2 = 0;
            Lista<String> temp = new ListaEnlazada<>();
            for (int j = 0; j < caso.length(); j++) {
                if (caso.charAt(j) == '1') {
                    temp.insertarFinal(claves.get(j));
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
        Iterator<E> it = m.getClaves();
        while (it.hasNext()) {
            E e = it.next();
            l.add(e);
        }
        return l;
    }

    public static Lista<String> llenarCDVoraz__PROFE(int capMax, Map<String, Integer> programas) {
        Lista<String> solucion = new ListaEnlazada<>();
        Map<String, Integer> copia = new HashMap<>();
        boolean objetivo = false;
        int c = 0;
        while (programas.tamaño() > 0 && !objetivo) {
            String progSel = seleccionarMasLargo(programas);
            int capSel = programas.get(progSel);
            if (c + capSel <= capMax) {
                solucion.insertarFinal(progSel);
                copia.insertar(progSel, capSel);
                programas.eliminar(progSel);
                if (c + capSel == capMax) {
                    objetivo = true;
                }
                c += capSel;
            } else {
                copia.insertar(progSel, capSel);
                programas.eliminar(progSel);
            }
        }

        Iterator<String> it = copia.getClaves();
        while (it.hasNext()) {
            String clave = it.next();
            programas.insertar(clave, copia.get(clave));
        }
        return solucion;
    }

    private static <E, T extends Comparable<T>> E seleccionarMasLargo(Map<E, T> m) {
        Iterator<E> it = m.getClaves();
        if (!it.hasNext()) {
            return null;
        }
        E actual = it.next();
        while (it.hasNext()) {
            E e = it.next();
            if (m.get(e).compareTo(m.get(actual)) > 0) {
                actual = e;
            }
        }
        return actual;
    }

    public static Map<String, Integer> llenarMochila(int volumenMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes) {
        Map<String, Integer> solucion = new HashMap<>();
        Map<String, Integer> copiaVolumenes = new HashMap<>();
        boolean objetivo = false;
        int c = 0;
        while (volumenes.tamaño() > 0 && !objetivo) {
            String volSel = seleccionarMasLargo(volumenes);
            int numSel = volumenes.get(volSel);
            if (c + numSel <= volumenMaximo && cantidades.get(volSel) > 0) {
                if (solucion.get(volSel) == null) {
                    copiaVolumenes.insertar(volSel, numSel);
                    solucion.insertar(volSel, 0);
                }
                solucion.insertar(volSel, solucion.get(volSel) + 1);
                c += numSel;
                if (c == volumenMaximo) {
                    objetivo = true;
                }
            } else {
                volumenes.eliminar(volSel);
            }
        }

        Iterator<String> it = solucion.getClaves();
        while (it.hasNext()) {
            String clave = it.next();
            int s = solucion.get(clave);
            cantidades.insertar(clave, cantidades.get(clave) + s);
        }

        it = copiaVolumenes.getClaves();
        while (it.hasNext()) {
            String clave = it.next();
            int s = solucion.get(clave);
            volumenes.insertar(clave, s);
        }

        return solucion;
    }

    public static Map<String, Integer> llenarMochila(int volumenMaximo, int pesoMaximo,
            Map<String, Integer> cantidades, Map<String, Integer> volumenes,
            Map<String, Integer> pesos) {
        Map<String, Integer> solucion = new HashMap<>();
        Map<String, Integer> copiaVolumenes = new HashMap<>();
        boolean objetivo = false;
        int c = 0;
        int p = 0;
        while (volumenes.tamaño() > 0 && !objetivo) {
            String volSel = seleccionarMasLargo(volumenes);
            int numSel = volumenes.get(volSel);
            if (c + numSel <= volumenMaximo && cantidades.get(volSel) > 0 && p + pesos.get(volSel) <= pesoMaximo) {
                if (solucion.get(volSel) == null) {
                    copiaVolumenes.insertar(volSel, numSel);
                    solucion.insertar(volSel, 0);
                }
                solucion.insertar(volSel, solucion.get(volSel) + 1);
                c += numSel;
                p += pesos.get(volSel);
                if (c == volumenMaximo) {
                    objetivo = true;
                }
            } else {
                volumenes.eliminar(volSel);
            }
        }

        Iterator<String> it = solucion.getClaves();
        while (it.hasNext()) {
            String clave = it.next();
            int s = solucion.get(clave);
            cantidades.insertar(clave, cantidades.get(clave) + s);
        }

        it = copiaVolumenes.getClaves();
        while (it.hasNext()) {
            String clave = it.next();
            int s = solucion.get(clave);
            volumenes.insertar(clave, s);
        }

        return solucion;
    }

}
