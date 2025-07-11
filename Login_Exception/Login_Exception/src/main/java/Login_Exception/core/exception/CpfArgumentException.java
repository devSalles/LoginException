package Login_Exception.core.exception;

public class CpfArgumentException extends InputValidationExceptions {
    public CpfArgumentException(String message) {
        super(message);
    }

    public CpfArgumentException() {
        super("Formato de CPF inválido");
    }
}
