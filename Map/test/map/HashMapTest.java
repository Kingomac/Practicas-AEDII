/*
 */
package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HashMapTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test//(expected = IllegalArgumentException.class)
    public void testIllegalCapacity() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(CoreMatchers.containsString("ERROR: capacidad negativa"));
        Map hashMap = new HashMap(-5);
    }

    @Test
    public void testTamañoVacio() {
        Map instance = new HashMap();
        int expResult = 0;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    @Test
    public void testTamaño() {
        Map<String, String> instance = new HashMap<>();
        instance.insertar("c1", "v1");
        instance.insertar("c2", "v2");
        int expResult = 2;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAndInsertar() {
        String clave = "clave1";
        String valor = "valor1";
        Map<String, String> instance = new HashMap<>();
        instance.insertar(clave, valor);
        instance.insertar("c2", "v2");
        String expResult = valor;
        String result = instance.obtener(clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNonExistent() {
        Map<String, String> instance = new HashMap<>();
        instance.insertar("c2", "v2");
        String expResult = null;
        String result = instance.obtener("clave1");
        assertEquals(expResult, result);
    }

    public void testEliminar() {
        String clave = "c2";
        String valor = "v2";
        Map<String, String> instance = new HashMap<>();
        instance.insertar(clave, valor);
        String expResult = valor;
        String result = instance.suprimir(clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarNonExistent() {
        String clave = "c2";
        Map<String, String> instance = new HashMap<>();
        String expResult = null;
        String result = instance.suprimir(clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValores() {
        Map<String, String> instance = new HashMap<>();
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        instance.insertar("c1", v1);
        instance.insertar("c2", v2);
        instance.insertar("c3", v3);
        List<String> expResult = new ArrayList<>();
        expResult.add(v1);
        expResult.add(v2);
        expResult.add(v3);
        Iterator<String> it = instance.getValores();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
    }

    /**
     * Cambié este test poque tenía en cuenta el orden del Map cuando no no es
     * una estructura ordenada. Con la modificación solo tiene en cuenta si
     * tienen los mismos elementos
     */
    @Test
    public void testGetClaves() {
        Map<String, String> instance = new HashMap<>();
        String c1 = "c1";
        String c2 = "c2";
        String c3 = "c3";
        instance.insertar(c1, "v1");
        instance.insertar(c2, "v2");
        instance.insertar(c3, "v3");
        List<String> expResult = new ArrayList<>();
        expResult.add(c3);
        expResult.add(c1);
        expResult.add(c2);
        Iterator<String> it = instance.getClaves();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        assertTrue(arrayIgualSinOrden(result, expResult));
    }

    private <E> boolean arrayIgualSinOrden(List<E> a, List<E> b) {
        for (E i : a) {
            if (!b.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
