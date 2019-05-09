package tk.dadle8.web.erros;

public class IllegalIdException extends Exception {

    public static IllegalIdException DEFAULT_INSTANCE = new IllegalIdException("Object not found in DataBase");

    public IllegalIdException(String message) {
        super(message);
    }
}
