package arhangel.dim.core.net;


/**
 * Created by eaglesh on 29.04.16.
 */
public class SessionClosedException extends RuntimeException {

    public SessionClosedException() {
        super();
    }

    public SessionClosedException(String message) {
        super(message);
    }

    public SessionClosedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionClosedException(Throwable cause) {
        super(cause);
    }
}
