package Login_Exception.core.exception;

public class EmailArgumentException extends RuntimeException {
    public EmailArgumentException(String message) {
        super(message);
    }

    public EmailArgumentException() {
        super("Formato de email inválido");
    }
}
