package Login_Exception.core.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException() {
        super("ID não encontrado");
    }
}
