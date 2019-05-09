package tk.dadle8.web.erros;

public class IllegalValueTypeException extends Exception {

    public static IllegalValueTypeException DEFAULT_INSTANCE = new IllegalValueTypeException("Can't parse value");

    public IllegalValueTypeException(String message) {
        super(message);
    }
}
