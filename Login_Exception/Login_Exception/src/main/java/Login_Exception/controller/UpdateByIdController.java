package Login_Exception.controller;

import Login_Exception.dto.UserDTO;
import Login_Exception.service.UpdateByIdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UpdateByIdController {

    private final UpdateByIdService updateByIdService;

    public UpdateByIdController(UpdateByIdService updateByIdService) {
        this.updateByIdService = updateByIdService;
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO)
    {
        this.updateByIdService.updateById(id,userDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado");
    }
}
