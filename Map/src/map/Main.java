package map;

import grafo.Arco;
import grafo.Grafo;
import grafo.ListaAdyacencia;
import grafo.Vertice;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    public static Grafo<String, Integer> construirGrafo(List<String> palabras) {
        HashMap<String, List<String>> map = new HashMap();

        for (String p : palabras) {
            for (int i = 0; i < p.length(); i++) {
                String clave = generarClave(i, p);
                if (map.obtener(clave) == null) {
                    map.insertar(generarClave(i, p), new LinkedList<>());
                }
                map.obtener(clave).add(p);
            }
        }

        Grafo<String, Integer> toret = new ListaAdyacencia<>();
        // Crear vértices para cada palabra
        for (String p : palabras) {
            Vertice<String> v = new Vertice<>(p);
            toret.insertarVertice(v);
        }
        // Crear arcos para las palabras
        Iterator<List<String>> it = map.getValores();
        while (it.hasNext()) {
            List<String> clavesGeneradas = it.next();
            for (String valor : clavesGeneradas) {
                Vertice<String> vert = new Vertice<>(valor);
                // Para cada valor de la lista de claves generadas se crea un
                // arco entre ese valor y el resto de valores de la misma lista
                // de claves generadas
                for (String valor2 : clavesGeneradas) {
                    Vertice<String> vert2 = new Vertice<>(valor2);
                    if (!vert.equals(vert2)) {
                        toret.insertarArco(new Arco<>(vert, vert2, 0));
                    }
                }
            }
        }
        return toret;
    }

    /**
     *
     * @param i posicion del carácter a sustituir
     * @param p palabra
     * @return
     */
    private static String generarClave(int i, String p) {
        StringBuilder clave = new StringBuilder(p);
        clave.setCharAt(i, '_');
        return clave.toString();
    }

}
