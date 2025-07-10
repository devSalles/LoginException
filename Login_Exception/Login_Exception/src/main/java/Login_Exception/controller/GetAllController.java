package Login_Exception.controller;

import Login_Exception.model.UserModel;
import Login_Exception.service.GetAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class GetAllController {

    private final GetAllService getAllService;

    public GetAllController(GetAllService getAllService) {
        this.getAllService = getAllService;
    }

    @GetMapping("/todos")
    public ResponseEntity<Object> getAll()
    {
        List<UserModel> userModel = this.getAllService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }
}
