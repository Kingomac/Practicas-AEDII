package arbolbinario;

/**
 *
 * @author Mario
 */
public class ArbolVacioExcepcion extends RuntimeException {

    /**
     * Creates a new instance of <code>ArbolVacioExcepcion</code> without detail message.
     */
    public ArbolVacioExcepcion() {
    }


    /**
     * Constructs an instance of <code>ArbolVacioExcepcion</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ArbolVacioExcepcion(String msg) {
        super(msg);
    }
}
