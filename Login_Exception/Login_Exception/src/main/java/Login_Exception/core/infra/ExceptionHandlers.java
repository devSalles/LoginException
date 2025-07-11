package Login_Exception.core.infra;

import Login_Exception.core.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    //Exceção para validação de email, senha e CPF
    @ExceptionHandler(InputValidationExceptions.class)
    public ResponseEntity<MessageRestError> handlerValidationException(InputValidationExceptions exception)
    {
        MessageRestError messageRestError= new MessageRestError(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageRestError);
    }

    //Exceção para ID não encontrado
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MessageRestError> idNotFoundHandler(IdNotFoundException exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    //Exceção para banco de dados vazio
    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<MessageRestError> emptyListHandler(EmptyListException exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    //Exceção Global para erros inesperado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageRestError> GlobalException(Exception exception)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno, teste novamente mais tarde");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageRestError);
    }
}
