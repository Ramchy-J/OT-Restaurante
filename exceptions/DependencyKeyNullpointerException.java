package exceptions;

public class DependencyKeyNullpointerException extends Exception {
    public DependencyKeyNullpointerException() {
        super("Key Cannot be null");
    }
}
