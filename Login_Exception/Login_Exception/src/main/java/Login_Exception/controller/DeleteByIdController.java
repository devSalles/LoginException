package Login_Exception.controller;

import Login_Exception.service.DeleteAllService;
import Login_Exception.service.DeleteByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DeleteByIdController {

    private final DeleteByIdService delete;

    public DeleteByIdController(DeleteByIdService delete) {
        this.delete = delete;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id)
    {
        Boolean userDel = this.delete.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado");
    }
}
