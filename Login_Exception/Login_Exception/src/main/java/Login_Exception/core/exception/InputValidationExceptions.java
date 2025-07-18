package Login_Exception.core.exception;

// exceção base para centralizar validações de entrada
public class InputValidationExceptions extends RuntimeException {
    public InputValidationExceptions(String message) {
        super(message);
    }
}
