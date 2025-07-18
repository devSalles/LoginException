package Login_Exception.controller;

import Login_Exception.dto.UserDTO;
import Login_Exception.model.UserModel;
import Login_Exception.service.UserCRUDService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    private final UserCRUDService userCRUDService;

    public UserCRUDController(UserCRUDService userCRUDService) {
        this.userCRUDService = userCRUDService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNew(@RequestBody UserDTO userDTO)
    {
        this.userCRUDService.addNew(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO)
    {
        this.userCRUDService.updateById(id,userDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado");
    }

    @GetMapping("/destaque/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id)
    {
        UserModel userModel = this.userCRUDService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }

    @GetMapping("/todos")
    public ResponseEntity<Object> getAll()
    {
        List<UserModel> userModel = this.userCRUDService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id)
    {
        this.userCRUDService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteAll()
    {
        this.userCRUDService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todos os registros foram deletado");
    }

}
