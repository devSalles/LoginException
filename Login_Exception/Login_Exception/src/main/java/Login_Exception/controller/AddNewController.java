package Login_Exception.controller;

import Login_Exception.dto.UserDTO;
import Login_Exception.service.AddNewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AddNewController {

    private final AddNewService addNewService;

    public AddNewController(AddNewService addNewService) {
        this.addNewService = addNewService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNew(@RequestBody UserDTO userDTO)
    {
        this.addNewService.addNew(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado");
    }
}
