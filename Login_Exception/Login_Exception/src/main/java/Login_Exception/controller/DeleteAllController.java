package Login_Exception.controller;

import Login_Exception.service.DeleteAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DeleteAllController {

    private final DeleteAllService deleteAllService;

    public DeleteAllController(DeleteAllService deleteAllService) {
        this.deleteAllService = deleteAllService;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteAll()
    {
        this.deleteAllService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todos os registros foram deletado");
    }
}
