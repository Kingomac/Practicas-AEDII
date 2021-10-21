/*
 */
package heap;

/**
 *
 * @author kingo
 */
public class HeapVacioException extends RuntimeException {

    /**
     * Creates a new instance of <code>HeapVacioException</code> without detail
     * message.
     */
    public HeapVacioException() {
    }

    /**
     * Constructs an instance of <code>HeapVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public HeapVacioException(String msg) {
        super(msg);
    }
}
