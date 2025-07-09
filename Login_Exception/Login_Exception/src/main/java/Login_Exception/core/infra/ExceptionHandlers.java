package Login_Exception.core.infra;

import Login_Exception.core.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageRestError> GlobalException(Exception exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno, teste novamente mais tarde");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageRestError);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MessageRestError> idNotFoundHandler(IdNotFoundException exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    @ExceptionHandler(EmailArgumentException.class)
    public ResponseEntity<MessageRestError> ArgumentInvalid(EmailArgumentException exception)
    {
        MessageRestError messageRestError= new MessageRestError(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageRestError);
    }

    @ExceptionHandler(SenhaArgumentException.class)
    public ResponseEntity<MessageRestError> senhaArgumentInvalid(SenhaArgumentException exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageRestError);
    }

    @ExceptionHandler(CpfArgumentException.class)
    public ResponseEntity<MessageRestError> CPFArgumentInvalid(CpfArgumentException exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageRestError);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<MessageRestError> emptyListHandler(EmptyListException exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }
}
