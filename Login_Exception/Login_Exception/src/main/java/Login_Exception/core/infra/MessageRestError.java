package Login_Exception.core.infra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

//Classe usada para passar a mensagem de exceção
@Getter
@Setter
@NoArgsConstructor
public class MessageRestError {

    HttpStatus status;
    String message;
    LocalDateTime timeStamp;


    public MessageRestError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
