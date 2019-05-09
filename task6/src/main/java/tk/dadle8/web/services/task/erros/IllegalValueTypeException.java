package tk.dadle8.web.services.task.erros;

public class IllegalValueTypeException extends Exception {

    private static final long serialVersionUID = 4150427579018972533L;

    public static IllegalValueTypeException DEFAULT_INSTANCE = new IllegalValueTypeException("Can't parse value");

    public IllegalValueTypeException(String message) {
        super(message);
    }
}
