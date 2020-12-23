package exceptions;

public class NoSuchFilterOptionException extends Exception {
    public NoSuchFilterOptionException() {
    }

    public NoSuchFilterOptionException(String message) {
        super(message);
    }

    public NoSuchFilterOptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchFilterOptionException(Throwable cause) {
        super(cause);
    }
}
