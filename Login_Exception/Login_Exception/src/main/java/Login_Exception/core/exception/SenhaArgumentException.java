package Login_Exception.core.exception;

public class SenhaArgumentException extends InputValidationExceptions {
    public SenhaArgumentException(String message) {
        super(message);
    }

    public SenhaArgumentException() {
        super("Formato de senha inválido");
    }
}
