package estudiandovoraz;

import grafo.Arco;
import grafo.Grafo;
import grafo.ListaAdyacencia;
import grafo.Vertice;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EstudiandoVoraz {

    private static Grafo<Integer, Integer> g1;

    private static Vertice<Integer> uno = new Vertice<Integer>(1);
    private static Vertice<Integer> dos = new Vertice<Integer>(2);
    private static Vertice<Integer> tres = new Vertice<Integer>(3);
    private static Vertice<Integer> cuatro = new Vertice<Integer>(4);
    private static Vertice<Integer> cinco = new Vertice<Integer>(5);
    private static Vertice<Integer> seis = new Vertice<Integer>(6);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        g1 = new ListaAdyacencia<>();
//        g1.insertarArco(new Arco<>(uno, dos, 3));
//        g1.insertarArco(new Arco<>(uno, seis, 5));
//        g1.insertarArco(new Arco<>(dos, tres, 7));
//        g1.insertarArco(new Arco<>(dos, seis, 10));
//        g1.insertarArco(new Arco<>(seis, tres, 8));
//        g1.insertarArco(new Arco<>(seis, cuatro, 2));
//        g1.insertarArco(new Arco<>(tres, cuatro, 5));
//        g1.insertarArco(new Arco<>(tres, cinco, 1));
//        g1.insertarArco(new Arco<>(cuatro, cinco, 6));
//        // Añado los arcos en el otro sentido, hace falta para el problema del viajante
//        g1.insertarArco(new Arco<>(dos, uno, 3));
//        g1.insertarArco(new Arco<>(seis, uno, 5));
//        g1.insertarArco(new Arco<>(tres, dos, 7));
//        g1.insertarArco(new Arco<>(seis, dos, 10));
//        g1.insertarArco(new Arco<>(tres, seis, 8));
//        g1.insertarArco(new Arco<>(cuatro, seis, 2));
//        g1.insertarArco(new Arco<>(cuatro, tres, 5));
//        g1.insertarArco(new Arco<>(cinco, tres, 1));
//        g1.insertarArco(new Arco<>(cinco, cuatro, 6));
//
//        Grafo<Integer, Integer> grafoActual = EstudiandoVoraz.viajante(g1, uno);
//        Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<>();
//
//        Vertice<Integer> v1 = new Vertice<Integer>(1);
//        Vertice<Integer> v2 = new Vertice<Integer>(2);
//        Vertice<Integer> v3 = new Vertice<Integer>(3);
//        Vertice<Integer> v4 = new Vertice<Integer>(4);
//        Vertice<Integer> v5 = new Vertice<Integer>(5);
//        Vertice<Integer> v6 = new Vertice<Integer>(6);
//
//        grafoEsperado.insertarArco(new Arco<>(v1, v2, 3));
//        grafoEsperado.insertarArco(new Arco<>(v2, v3, 7));
//        grafoEsperado.insertarArco(new Arco<>(v3, v5, 1));
//        grafoEsperado.insertarArco(new Arco<>(v5, v4, 6));
//        grafoEsperado.insertarArco(new Arco<>(v4, v6, 2));
//
//        System.out.println("INPUT");
//        imprimirGrafo(g1);
//        System.out.println("GRAFO ACTUAL");
//        imprimirGrafo(grafoActual);
//        System.out.println("GRAFO ESPERADO");
//        imprimirGrafo(grafoEsperado);
        Map<String, Integer> volumenes;
        Map<String, Integer> cantidades;

        cantidades = new HashMap<>();
        cantidades.put("Coche", 5);
        cantidades.put("Muñeca", 4);

        volumenes = new HashMap<>();
        volumenes.put("Coche", 10);
        volumenes.put("Muñeca", 20);

        Map<String, Integer> mapaActual = llenarMochila(55, cantidades, volumenes);

        Map<String, Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.put("Coche", 1);
        mapaEsperado.put("Muñeca", 2);

        System.out.println("Resultado");
        imprimirMap(mapaActual);

        System.out.println("Resultado esperado");
        imprimirMap(mapaEsperado);

    }

    public static <E, T> void imprimirMap(Map<E, T> m) {
        Iterator<E> it = m.keySet().iterator();
        while (it.hasNext()) {
            E clave = it.next();
            System.out.format("%s -> %s%n", clave, m.get(clave));
        }
    }

    public static <E, T> void imprimirMap(mapa.Map<E, T> m) {
        Iterator<E> it = m.getClaves();
        while (it.hasNext()) {
            E clave = it.next();
            System.out.format("%s -> %s%n", clave, m.get(clave));
        }
    }

    public static <E, T> void imprimirGrafo(Grafo<E, T> g) {
        Iterator<Arco<E, T>> it = g.arcos();
        while (it.hasNext()) {
            Arco a = it.next();
            System.out.format("%s - %s -> %s%n", a.getOrigen(), a.getEtiqueta(), a.getDestino());
        }
    }

    public static <E> Grafo<E, Integer> viajante(Grafo<E, Integer> g, Vertice<E> v) {
        Grafo<E, Integer> toret = new ListaAdyacencia<>();
        List<Vertice<E>> porVisitar = getList(g.vertices());
        Vertice<E> actual = v;
        while (porVisitar.size() > 1) {
            porVisitar.remove(actual);
            Iterator<Arco<E, Integer>> itArcos = g.arcos();
            int distancia = Integer.MAX_VALUE;
            Vertice<E> sig = null;
            while (itArcos.hasNext()) {
                Arco<E, Integer> a = itArcos.next();
                if (a.getOrigen().equals(actual) && porVisitar.contains(a.getDestino()) && a.getEtiqueta() < distancia) {
                    distancia = a.getEtiqueta();
                    sig = a.getDestino();
                }
            }
            if (sig == null) {
                throw new RuntimeException("No hay camino xd");
            }
            toret.insertarArco(new Arco<>(actual, sig, distancia));
            actual = sig;
        }
        return toret;
    }

    private static <E> List<E> getList(Iterator<E> it) {
        List<E> toret = new LinkedList<>();
        while (it.hasNext()) {
            toret.add(it.next());
        }
        return toret;
    }

    public static Map<String, Integer> llenarMochila(int volumenMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes) {
        Map<String, Integer> mochila = new HashMap<>();
        int volumenActual = 0;
        Map<String, Integer> copia = new HashMap<>();
        while (volumenActual < volumenMaximo && !volumenes.isEmpty()) {
            String seleccion = getMayor(volumenes);
            int volSel = volumenes.get(seleccion);

            volumenes.remove(seleccion);
            copia.put(seleccion, volSel);

            int restantes = cantidades.get(seleccion);
            mochila.put(seleccion, 0);
            while (volumenActual + volSel < volumenMaximo && restantes > 0) {
                restantes--;
                volumenActual += volSel;
            }

            mochila.put(seleccion, cantidades.get(seleccion) - restantes);
        }

        Iterator<String> it = copia.keySet().iterator();
        while (it.hasNext()) {
            String clave = it.next();
            volumenes.put(clave, copia.get(clave));
        }

        return mochila;
    }

    private static <E, T extends Comparable<T>> E getMayor(Map<E, T> mapa) {
        Iterator<E> it = mapa.keySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        E mayor = it.next();
        while (it.hasNext()) {
            E clave = it.next();
            T valor = mapa.get(clave);
            if (valor.compareTo(mapa.get(mayor)) > 0) {
                mayor = clave;
            }
        }

        return mayor;
    }

    public static Map<String, Integer> llenarMochila(int volumenMaximo, int pesoMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes, Map<String, Integer> pesos) {

    }

}
