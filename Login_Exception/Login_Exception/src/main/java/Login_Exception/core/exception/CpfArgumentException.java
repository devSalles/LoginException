package Login_Exception.core.exception;

public class CpfArgumentException extends RuntimeException {
    public CpfArgumentException(String message) {
        super(message);
    }

    public CpfArgumentException() {
        super("Formato de CPF inválido");
    }
}
