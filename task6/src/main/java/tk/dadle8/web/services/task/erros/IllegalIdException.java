package tk.dadle8.web.services.task.erros;

public class IllegalIdException extends Exception {

    private static final long serialVersionUID = -1433904102690971687L;

    public static IllegalIdException DEFAULT_INSTANCE = new IllegalIdException("Object not found in DataBase");

    public IllegalIdException(String message) {
        super(message);
    }
}
