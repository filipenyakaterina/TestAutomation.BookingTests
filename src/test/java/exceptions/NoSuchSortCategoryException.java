package exceptions;

public class NoSuchSortCategoryException extends Exception {
    public NoSuchSortCategoryException() {
    }

    public NoSuchSortCategoryException(String message) {
        super(message);
    }

    public NoSuchSortCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchSortCategoryException(Throwable cause) {
        super(cause);
    }
}
