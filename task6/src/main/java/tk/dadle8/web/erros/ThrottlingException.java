package tk.dadle8.web.erros;

public class ThrottlingException extends Exception {

    public static ThrottlingException DEFAULT_INSTANCE = new ThrottlingException("Too many requests");

    public ThrottlingException(String message) {
        super(message);
    }
}
